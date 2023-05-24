package cacha.Practico3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ServicioDFS {
    private HashMap<Integer, String> auxHashMap;
	private Grafo<?> grafo;
    private int value = 0;

	public ServicioDFS(Grafo<?> grafo) {
		this.grafo = grafo;
        this.auxHashMap = new HashMap<Integer, String>();
	}

	public List<Integer> dfsForest() {
		// Resolver DFS

        Iterator<Integer> it = this.grafo.obtenerVertices();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        while(it.hasNext()){
            Integer value = it.next();

            this.auxHashMap.put(value, "blanco");
        }

        it = this.grafo.obtenerVertices();

        while(it.hasNext()){
            int key = it.next();
            if(auxHashMap.get(key) == "blanco"){
                this.dfsVisit(key, arr);
            }
        }

		return arr;
	}

    private void dfsVisit(int key, ArrayList<Integer> arr){
        auxHashMap.replace(key, "amarillo");
        arr.add(key);

        Iterator<Integer> it = this.grafo.obtenerAdyacentes(key);

        while(it.hasNext()){
            int value = it.next();
            if(this.auxHashMap.get(value) == "blanco"){
                this.dfsVisit(value, arr);
            }
        }

        auxHashMap.replace(key, "negro");
    }

    public List<Integer> getAllRoadToGrafoFromVertice(Grafo g, int destino){
        ArrayList<Integer> solucion = new ArrayList<Integer>();
        ArrayList<Integer> actual = new ArrayList<Integer>();

        Iterator<Integer> it = g.obtenerVertices();

        while(it.hasNext()){
            int z = it.next();
            if(z != destino){
                getAllRoadToGrafoFromVertice(g, z, destino, solucion, actual);
            }
        }

        return solucion;
    }

    private void getAllRoadToGrafoFromVertice(Grafo g, int vertice, int destino, ArrayList<Integer> solucion, ArrayList<Integer> actual ){
            Iterator<Integer> it = g.obtenerAdyacentes(vertice);
            actual.add(vertice);
            while(it.hasNext()){

                value = it.next();

                if(!solucion.contains(value) && !solucion.contains(vertice)){
                    solucion.add(vertice);
                }else if(value == destino){
                    for (Integer k : actual) {
                        if(!solucion.contains(k)){
                            solucion.add(k);
                        }
                    }
                }else if(!actual.contains(value)){
                    getAllRoadToGrafoFromVertice(g, value, destino, solucion, actual);
                }
            }
            actual.remove(actual.size()-1);
    }
}