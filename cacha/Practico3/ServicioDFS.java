package cacha.Practico3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ServicioDFS {
    private HashMap<Integer, String> auxHashMap;
	private Grafo<?> grafo;

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

    public void dfsVisit(int key, ArrayList<Integer> arr){
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
            getAllRoadToGrafoFromVertice(g, it.next(), destino, solucion, actual);
        }

        return solucion;
    }

    private void getAllRoadToGrafoFromVertice(Grafo g, int vertice, int destino, ArrayList<Integer> solucion, ArrayList<Integer> actual ){
        if(!solucion.contains(vertice)){
            if(actual.contains(vertice)){
                return;
            }else{

                if(vertice != destino){
                    actual.add(vertice);
                    Iterator<Integer> it = g.obtenerAdyacentes(vertice);

                    while(it.hasNext()){
                        getAllRoadToGrafoFromVertice(g, it.next(), destino, solucion, actual);
                    }

                    if(!actual.isEmpty()){
                        actual.remove(actual.size()-1);
                    }
                    return;

                }else if(vertice == destino){
                    //si es igual, entonces agarro la primer posicion del arreglo actual y la inserto en solucion
                    if(!actual.isEmpty()){
                        if(!solucion.contains(actual.get(0))){
                            solucion.add(actual.get(0));
                        }
                        solucion.add(actual.get(actual.size()-1));
                    }
                    return;
                }
            }
        }
    }
}