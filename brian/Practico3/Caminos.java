package brian.Practico3;

import java.util.ArrayList;
import java.util.Iterator;

public class Caminos {

    private Grafo grafo;
    private ArrayList<Integer> recorrido;

    public Caminos(Grafo grafo) {
        this.grafo=grafo;
        this.recorrido = new ArrayList<>();
    }

    //el camino mas corto entre 2 vertices
    public ArrayList<Integer> getshortestRoad(Integer vOrigen, Integer vDestino) {
        this.recorrido.clear();
        ArrayList<Integer> solucion = new ArrayList<>();
        this.getshortestRoad(vOrigen, vDestino, solucion);

        return  recorrido;
    }

    private void getshortestRoad(Integer vOrigen, Integer vDestino, ArrayList<Integer> solucion) {
		solucion.add(vOrigen);
		if(vOrigen != vDestino) {
			Iterator<Integer> ady = this.obtenerAdyacentes(vOrigen);
			while(ady.hasNext()) {
				int key = ady.next();
				this.getShorestRoad(key, vDestino, solucion);
				if(solucion.contains(vDestino)) {
					if(recorrido.size() < solucion.size()) {
						recorrido.clear();
						recorrido.addAll(aux);
					}
				}
				
			}
		}
		else {
			if(recorrido.size() < solucion.size()) {
				recorrido.clear();
				recorrido.addAll(solucion);
			}
		}
		solucion.remove(solucion.size()-1);
    }
    
}
