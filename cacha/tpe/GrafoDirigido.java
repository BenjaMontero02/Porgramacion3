import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GrafoDirigido<T> implements Grafo<T> {

    private int cantArcos;
    private HashMap<Integer, ArrayList<Arco<T>>> listVertices;

    public GrafoDirigido(){
        this.listVertices = new HashMap<Integer, ArrayList<Arco<T>>>();
        this.cantArcos = 0;
    }

	@Override
	public void agregarVertice(int verticeId) {
		this.listVertices.put(verticeId, new ArrayList<Arco<T>>());
	}

	@Override
	public void borrarVertice(int verticeId) {

        Iterator<Arco<T>> it = this.obtenerArcos();

        while (it.hasNext()) {
            Arco<T> arco = it.next();
            if(arco.getVerticeDestino() == verticeId) {
                this.borrarArco(arco.getVerticeOrigen(), verticeId);
            }
        }

        this.listVertices.remove(verticeId);

	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        Arco<T> arco = new Arco<T>(verticeId1, verticeId2, etiqueta);
        this.listVertices.get(verticeId1).add(arco);
        this.cantArcos++;
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
		if(this.obtenerArco(verticeId1, verticeId2) != null) {
            return true;
        }else{
            return false;
        }
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
        ArrayList<Arco<T>> vertices = this.listVertices.get(verticeId);
		ArrayList<Integer> adyacentes = new ArrayList<>();

		for (Arco<T> arco : vertices) {
			adyacentes.add(arco.getVerticeDestino());
		}
		return adyacentes.iterator();
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

}