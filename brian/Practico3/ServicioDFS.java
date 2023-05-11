package brian.Practico3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import brian.Practico3.Grafo;

public class ServicioDFS {

	private Grafo<?> grafo;
	private HashMap<Integer, String> hashMapaux;

	public ServicioDFS(Grafo<?> grafo) {
		this.grafo = grafo;
		this.hashMapaux = new HashMap<>();
	}
	
	public List<Integer> dfsForest() {

		Iterator<Integer> it = grafo.obtenerVertices();
		ArrayList<Integer> recorrido = new ArrayList<>();

		while(it.hasNext()) {
			Integer value = it.next();
			this.hashMapaux.put(value, "blanco");
		}

		it = grafo.obtenerVertices();

		while(it.hasNext()) {
			int k = it.next();
			if(hashMapaux.get(k) == "blanco") {
				this.dfsVisit(k,recorrido);
			}
		}

		return recorrido;
	}

	private void dfsVisit(int k, ArrayList<Integer> arr) {
		hashMapaux.replace(k, "amarillo");
		arr.add(k);
		Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(k);

		while(adyacentes.hasNext()) {
			int i = adyacentes.next(); 
			if(hashMapaux.get(i) == "blanco") {
				this.dfsVisit(i, arr);
			}
		}

		hashMapaux.replace(k, "negro");
	
	}

}
