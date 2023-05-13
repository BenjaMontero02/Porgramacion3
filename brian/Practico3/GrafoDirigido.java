package brian.Practico3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GrafoDirigido<T> implements Grafo<T> {

	private int cantArcos;

	//hash map, contiene un vertice (clave int), y un array de sus arcos
	private HashMap<Integer, ArrayList<Arco<T>>> listVertices;

	public GrafoDirigido() {
		this.cantArcos = 0;
		this.listVertices = new HashMap<Integer, ArrayList<Arco<T>>>();
	}

	@Override
	public void agregarVertice(int verticeId) {
		ArrayList<Arco<T>> arcos = new ArrayList<>();
		this.listVertices.put(verticeId, arcos);
	}

	@Override
	public void borrarVertice(int verticeId) {
		this.listVertices.remove(verticeId);
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		if (this.contieneVertice(verticeId1) && this.contieneVertice(verticeId2)) {
			Arco<T> newArco = new Arco<>(verticeId1, verticeId2, etiqueta);
			this.listVertices.get(verticeId1).add(newArco); 
			// le agrego el arco al vertice origen?
			this.cantArcos++; //actualizo cant arcos
		}

	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		if(this.listVertices.containsKey(verticeId1)) {
			this.listVertices.get(verticeId1).remove(this.obtenerArco(verticeId1, verticeId2));
			this.cantArcos--;
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return this.listVertices.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		return obtenerArco(verticeId1, verticeId2) != null;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		ArrayList<Arco<T>> arcos = this.listVertices.get(verticeId1);
		Arco<T> arcoAux = new Arco<T>(verticeId1, verticeId2, null);
		if(arcos != null && arcos.contains(arcoAux)) {
			return arcos.get(arcos.indexOf(arcoAux));
		}
		return null;
	}

	@Override
	public int cantidadVertices() {
		return this.listVertices.size();
	}

	@Override
	public int cantidadArcos() {
		return this.cantArcos;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		return this.listVertices.keySet().iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		Iterator<Arco<T>> listArcos = this.obtenerArcos(verticeId);
		ArrayList<Integer> adyac = new ArrayList<>();
		while(listArcos.hasNext()) {
			adyac.add(listArcos.next().getVerticeDestino());
		}
		return adyac.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		ArrayList<Arco<T>> nueva = new ArrayList<Arco<T>>();

		for (Map.Entry<Integer, ArrayList<Arco<T>>> entrada : this.listVertices.entrySet()){

			for (Arco<T> arco : entrada.getValue()) {
				nueva.add(arco);
			}
		}

		return nueva.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		return this.listVertices.get(verticeId).iterator();
	}

	public ArrayList<Integer> getLongestRoad(Integer v1, Integer v2) {
		if(this.contieneVertice(v1) && this.contieneVertice(v2)) {
			ArrayList<Integer> solucion = new ArrayList<>();
			ArrayList<Integer> aux = new ArrayList<>();
			return this.getLongestRoad(v1, v2, solucion, aux);
		}
		return null;
	}

	private ArrayList<Integer> getLongestRoad(Integer ubiActual, Integer destino, ArrayList<Integer> solucion, ArrayList<Integer> aux) {
		//me agrego
		aux.add(ubiActual);
		//si no soy destino sigo los pasos habituales
		if(ubiActual != destino) {
			Iterator<Integer> ady = this.obtenerAdyacentes(ubiActual);
			while(ady.hasNext()) {
				int key = ady.next();
				this.getLongestRoad(key, destino, solucion, aux);
				if(aux.contains(destino)) {
					if(solucion.size() < aux.size()) {
						solucion.clear();
						solucion.addAll(aux);
					}
				}
				
			}
		}
		//si soy destino comparo aux con la solucion
		else {
			if(solucion.size() < aux.size()) {
				solucion.clear();
				solucion.addAll(aux);
			}
		}
		//remuevo el ultimo valor del aux antes de retornar
		aux.remove(aux.size()-1);
		return solucion;
	}




	/*
	private ArrayList<Integer> getLongestRoad(Integer ubiActual, Integer destino, ArrayList<Integer> list, ArrayList<Integer> list2, int road) {
		list2.add(ubiActual);
		Iterator<Integer> ady = this.obtenerAdyacentes(ubiActual);
		while(ady.hasNext()) {
			int k = ady.next();
			if(k != destino) {	
				this.getLongestRoad(k, destino, list, list2, road);
				if(list.size() < list2.size()) {
					list.clear();
					list.addAll(list2);
				}
			}
			else {
				list2.add(k);
				if(list.size() > 0  && (list.get(list.size()-1) == 5)&&(list.size() < list2.size())) {
					list.clear();
					list.addAll(list2);
				}
			}
		}
		list2.remove(list2.size()-1);
		return list;
	}
	*/

}