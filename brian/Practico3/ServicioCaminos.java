package brian.Practico3;

import java.util.ArrayList;
import java.util.Iterator;

public class ServicioCaminos {

    private Grafo<?> grafo;
    private ArrayList<ArrayList<Integer>> caminos;

    public ServicioCaminos(Grafo<?> grafo) {
        this.grafo = grafo;
        this.caminos = new ArrayList<ArrayList<Integer>>();
    }

    /*
    Caminos: dado un origen, un destino y un límite “lim” retorna todos los caminos que, partiendo del
    vértice origen, llega al vértice de destino sin pasar por más de “lim” arcos. Aclaración importante: en
    un camino no se puede pasar 2 veces por el mismo arco.
    */

    public ArrayList<ArrayList<Integer>> caminos(Integer origen, Integer destino, Integer lim) {
        this.caminos.clear();
        ArrayList<Integer> camino = new ArrayList<Integer>();
        this.caminos(origen, destino, lim, camino);
        return this.caminos;
    }
    private void caminos(Integer origen,Integer destino, Integer lim, ArrayList<Integer> camino) {
        camino.add(origen);
        if(origen != destino) {
            Iterator<Integer> it = this.grafo.obtenerAdyacentes(origen);
            while(it.hasNext()) {
                int k = it.next();
                if(!camino.contains(k)) {
                    this.caminos(k, destino, lim, camino);
                }
            }
            camino.remove(camino.size()-1);
        }
        else {
            caminos.add(camino);
            System.out.println(caminos);
            camino.remove(camino.size()-1);
        }

    }
}