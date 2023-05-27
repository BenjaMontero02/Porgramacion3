package brian.Practico3;

import java.util.ArrayList;
import java.util.Iterator;

public class Caminos {

    private Grafo<?> grafo;
    private ArrayList<Integer> recorrido;

    public Caminos(Grafo<?> grafo) {
        this.grafo=grafo;
        this.recorrido = new ArrayList<>();
    }

	//EJERCICIO 7
    //el camino mas corto entre 2 vertices
    public ArrayList<Integer> getShortestRoad(Integer vOrigen, Integer vDestino) {
        this.recorrido.clear();
        ArrayList<Integer> solucion = new ArrayList<>();
        this.getShortestRoad(vOrigen, vDestino, solucion);

        return  recorrido;
    }
    private void getShortestRoad(Integer vOrigen, Integer vDestino, ArrayList<Integer> solucion) {
		solucion.add(vOrigen);
		if(vOrigen != vDestino) {
			Iterator<Integer> ady = grafo.obtenerAdyacentes(vOrigen);
			while(ady.hasNext()) {
				int key = ady.next();
				if(!solucion.contains(key)) {
					this.getShortestRoad(key, vDestino, solucion);
				}
			}
		}
		else {
			if(recorrido.isEmpty()) {
				recorrido.addAll(solucion);
			}
			else {
				if(recorrido.size() > solucion.size()) {
					recorrido.clear();
					recorrido.addAll(solucion);
				}
			}
		}
		solucion.remove(solucion.size()-1);
    }
    
}
