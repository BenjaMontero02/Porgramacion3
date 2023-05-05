package cacha.Practico3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GrafoDirigido<T> implements Grafo<T>{

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

        if(this.listVertices.containsKey(verticeId1)){
            this.listVertices.get(verticeId1).remove(this.obtenerArco(verticeId1, verticeId2));
        } 
        this.cantArcos--;
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

        Arco<T> buscado = new Arco(verticeId1, verticeId2, null);

        if(arcos != null && arcos.contains(buscado)){
            return arcos.get(arcos.indexOf(buscado));
        }else{
            return null;
        }

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

	public static void main(String[] args) {
		
		GrafoDirigido gDirigido = new GrafoDirigido<>();

        //agrego vertices
        gDirigido.agregarVertice(1);
        gDirigido.agregarVertice(2);
        gDirigido.agregarVertice(3);
        gDirigido.agregarVertice(4);
        gDirigido.agregarVertice(5);

        //agreo arcos
        gDirigido.agregarArco(1, 2, "k");
        gDirigido.agregarArco(1, 3, "p");
        gDirigido.agregarArco(1, 4, "p");
        gDirigido.agregarArco(3, 4, "p");
        gDirigido.agregarArco(3, 5, "p");
        gDirigido.agregarArco(1, 1, "p");

	}

}
