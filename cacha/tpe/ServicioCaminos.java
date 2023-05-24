import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ServicioCaminos {

	private Grafo<?> grafo;
	private int origen;
	private int destino;
	private int lim;
    private List<List<Integer>> caminos;
	
	public ServicioCaminos(Grafo<?> grafo, int origen, int destino, int lim) {
		this.grafo = grafo;
		this.origen = origen;
		this.destino = destino;
		this.lim = lim;
        this.caminos = new ArrayList<List<Integer>>();
	}

	public List<List<Integer>> caminos() {
		this.caminos.clear();
        ArrayList<Integer> camino = new ArrayList<Integer>();
        this.caminos(origen,camino);
        return this.caminos;
	}

	private void caminos(Integer origen,ArrayList<Integer> camino) {
        camino.add(origen);
        if(origen != destino) {
            Iterator<Integer> it = this.grafo.obtenerAdyacentes(origen);
            while(it.hasNext()) {
                int k = it.next();
                if(!camino.contains(k)) {
                    lim--;
                    if(lim != -1) {
                        this.caminos(k,camino);
                    }
                    lim++;
                }
            }
            camino.remove(camino.size()-1);
        }
        else {
            ArrayList<Integer> aux = new ArrayList<>();
            aux.addAll(camino);
            caminos.add(aux);
            camino.remove(camino.size()-1);
        }

    }

}