package brian.Practico3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import brian.Practico3.Grafo;

public class ServicioBFS {

	private Grafo<?> grafo;
	// el value Boolean es visitado = true, no visitado = false
	private HashMap<Integer, Boolean> hashMapAux;
	
	public ServicioBFS(Grafo<?> grafo) {
		this.grafo = grafo;
		this.hashMapAux = new HashMap<>();
	}

	public ArrayList<Integer> bfsForest() {

		Iterator<Integer> it = grafo.obtenerVertices();
		ArrayList<Integer> recorrido = new ArrayList<>();

		while(it.hasNext()) {
			Integer clave = it.next();
			//Marco todos los vertices como no visitados
			this.hashMapAux.put(clave, false);
		}

		//reinicio iterador
		it = grafo.obtenerVertices();

		while(it.hasNext()) {
			int k = it.next();
			// 
			if(!hashMapAux.get(k)) {
				this.bfsVisit(k,recorrido);
			}
		}

		return recorrido;
	}

	private void bfsVisit(int k, ArrayList<Integer> arr) {
		ArrayList<Integer> arrLevels = new ArrayList<>();
		//marco el vertice como visitado y lo agrego a mi arreglo de recorrido
		hashMapAux.replace(k, true);
		arrLevels.add(k);
		Iterator<Integer> adyacentes;

		while(!arrLevels.isEmpty()) {
			//deberia tomar siempre el valor de la primera posicion y luego eliminarlo?
			adyacentes = grafo.obtenerAdyacentes(arrLevels.get(0));
			arr.add(arrLevels.get(0));
			arrLevels.remove(0);
			while(adyacentes.hasNext()) {
				int i = adyacentes.next(); 
				//si el vertice es no visitado lo paso a visitado y lo agreo a la lista
				if(!hashMapAux.get(i)) {
					hashMapAux.replace(i, true);
					arrLevels.add(i);
				}
			}
		}
	
	}
	
}
