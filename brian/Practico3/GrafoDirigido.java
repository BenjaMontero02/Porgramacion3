package brian.Practico3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		// TODO Auto-generated method stub
		return null;
	}

}