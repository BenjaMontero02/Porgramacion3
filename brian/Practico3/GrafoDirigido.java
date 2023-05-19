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

	public ArrayList<Integer> getLongestRoute(Integer v1, Integer v2) {
		if(this.contieneVertice(v1) && this.contieneVertice(v2)) {
			ArrayList<Integer> solucion = new ArrayList<>();
			ArrayList<Integer> aux = new ArrayList<>();
			return this.getLongestRoute(v1, v2, solucion, aux);
		}
		return null;
	}

	private ArrayList<Integer> getLongestRoute(Integer ubiActual, Integer destino, ArrayList<Integer> solucion, ArrayList<Integer> aux) {
		//me agrego
		aux.add(ubiActual);
		//si no soy destino sigo los pasos habituales
		if(ubiActual != destino) {
			Iterator<Integer> ady = this.obtenerAdyacentes(ubiActual);
			while(ady.hasNext()) {
				int key = ady.next();
				this.getLongestRoute(key, destino, solucion, aux);
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


	//no encontre otra manera que no sea con 3 arrays
	//puedo usar 2 pero deberia recorrer todo el grafo y es costoso en accesos a memoria
	public ArrayList<Integer> routesToVertex(Integer vDestino) {
		if(this.contieneVertice(vDestino)) {
			ArrayList<Integer> solucion = new ArrayList<>();
			ArrayList<Integer> recorrido = new ArrayList<>();
			ArrayList<Integer> listaFinal = new ArrayList<>();
			HashMap<Integer, Boolean> verticesVisitados = new HashMap<>();
			Iterator<Integer> verticeActual = this.obtenerVertices();

			while(verticeActual.hasNext()) {
				Integer value = verticeActual.next();
				verticesVisitados.put(value, false);
			}
			verticeActual = this.obtenerVertices();
			while(verticeActual.hasNext()) {
				int vActual = verticeActual.next();
				if(vActual != vDestino && !recorrido.contains(vActual)) {
					this.routesToVertex(verticesVisitados,solucion,recorrido,vActual,vDestino);
					for (Integer i : recorrido) {
						if(!listaFinal.contains(i)) {
							listaFinal.add(i);
						}
					}
					recorrido.clear();
				}
			}
			return listaFinal;
		}
		return null;
	}

	//si el vertice actual no es el destino, y no esta en el recorrido
	//si de 1 a 4, paso por 5 y por 6, entonces 5 y 6 pueden llegar a 4

	private void routesToVertex(HashMap<Integer,Boolean> vv,ArrayList<Integer> solucion, ArrayList<Integer> recorrido,Integer actual, Integer destino) {
		vv.replace(actual, true);
		if(actual != destino) {
			solucion.add(actual);
			Iterator<Integer> ayd = this.obtenerAdyacentes(actual);
			while(ayd.hasNext() && recorrido.isEmpty()) {
				int k = ayd.next();
				if(vv.get(k) == false) {
					this.routesToVertex(vv,solucion,recorrido, k, destino);
				}
			}
			solucion.remove(solucion.size()-1);
		}
		else {
			Iterator<Integer> verticeActual = this.obtenerVertices();
			while(verticeActual.hasNext()) {
				Integer value = verticeActual.next();
				vv.put(value, false);
			}
			recorrido.addAll(solucion);
		}
	}


	//encuentra una ruta entre 2 vertices, sin pasar por un vertice determinado
	public ArrayList<Integer> getRouteBetweenVertexs(Integer origen, Integer destino, Integer obstacle) {
		if(this.contieneVertice(origen) && this.contieneVertice(destino)) {
			HashMap<Integer, Boolean> verticesVisitados = new HashMap<>();
			this.verticesNotPassed(verticesVisitados);
			ArrayList<Integer> finalRoute = new ArrayList<>();
			ArrayList<Integer> recorrido = new ArrayList<>();
			this.getRouteBetweenVertexs(verticesVisitados,finalRoute,recorrido, origen, destino, obstacle);
			return finalRoute;
		}
		//retorno null si los vertices pasados por parametro no existen en el grafo
		return null;
	}
	private void getRouteBetweenVertexs(HashMap<Integer,Boolean> vv,ArrayList<Integer> finalRoute, ArrayList<Integer> recorrido, Integer vActual, Integer vDest, Integer obstacle) {	
		vv.replace(vActual, true);
		if(vActual != vDest && vActual != obstacle) {
			recorrido.add(vActual);
			Iterator<Integer> ady = this.obtenerAdyacentes(vActual);
			while(ady.hasNext() && finalRoute.isEmpty()) {
				int k = ady.next();
				if(vv.get(k) == false) {
					this.getRouteBetweenVertexs(vv,finalRoute, recorrido, k, vDest, obstacle);
				}
			}
			recorrido.remove(recorrido.size()-1);
		}
		else if (vActual == obstacle) {
		}
		else {
			//si encontre el destino agrego recorrido a la ruta deseada 
			recorrido.add(vActual);
			finalRoute.addAll(recorrido);
		}
	}

	//rellena un hashMap con todos los vertices del grafo y los señala con un false = "no visitado"
	private void verticesNotPassed(HashMap<Integer, Boolean> hash) {
			Iterator<Integer> v = this.obtenerVertices();
			while(v.hasNext()) {
				Integer k = v.next();
				hash.put(k, false);
			}
	}




}
