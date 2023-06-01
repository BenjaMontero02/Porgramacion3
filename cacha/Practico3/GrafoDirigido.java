package cacha.Practico3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GrafoDirigido<T> implements Grafo<T>{

    private int cantArcos;
	private ArrayList<Integer>solucion;

    private HashMap<Integer, ArrayList<Arco<T>>> listVertices;

    public GrafoDirigido(){
        this.listVertices = new HashMap<Integer, ArrayList<Arco<T>>>();
        this.cantArcos = 0;
		this.solucion = new ArrayList<Integer>();
    }

	@Override
	public void agregarVertice(int verticeId) {
		this.listVertices.put(verticeId, new ArrayList<Arco<T>>());
	}

	@Override
	public void borrarVertice(int verticeId) {
		
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

	public ArrayList<Integer> getTheBestRoad(int v1, int v2){
		ArrayList<Integer> camino = new ArrayList<Integer>();
		ArrayList<Integer> aux = new ArrayList<Integer>();

		this.getTheBestRoad(v1, v2, camino, aux);
		
		return camino;
	}

	private ArrayList<Integer> getTheBestRoad(int v1, int v2, ArrayList<Integer> camino, ArrayList<Integer> aux){
			Iterator<Integer> it = this.obtenerAdyacentes(v1);
			aux.add(v1);
			if(it.hasNext()){
				while(it.hasNext()){
					int value = it.next();

					if(value != v2){
						this.getTheBestRoad(value, v2, camino, aux);
					}else{
						aux.add(value);
						if(camino.size() < aux.size()){
							camino.clear();
							camino.addAll(aux);
						}
						aux.remove(aux.size()-1);
						aux.remove(aux.size()-1);
						return camino;
					}
				}
			}else{
				aux.remove(aux.size()-1);
				return camino;
			}
			aux.remove(aux.get(aux.size()-1));
			return camino;
	}

	public ArrayList<Integer> getConexion(int a, int b, int i) {

		ArrayList<Integer>actual = new ArrayList<Integer>();
		solucion.clear();
		this.getConexion(a, b, i, actual);
		return solucion;
	}

	private void getConexion(int a, int b, int i, ArrayList<Integer> actual){
		if(a == b){
			actual.add(a);
			ArrayList<Integer> copia = new ArrayList<Integer>();
			for (Integer x : actual) {
				copia.add(x);
			}
			solucion.addAll(copia);
			return;
		}else if(a == i){
			if(!solucion.isEmpty()){
				actual.clear();
			}
			return;
		}else{
			if(!actual.isEmpty() && actual.get(actual.size()-1) == b){
				return;
			}else{
				actual.add(a);

				Iterator<Integer> it = this.obtenerAdyacentes(a);

				while(it.hasNext()){
					int k = it.next();
					if(k != i && (!actual.isEmpty() && actual.get(actual.size()-1) != b)){
						this.getConexion(k, b, i, actual);
					}
				}

				if(actual.get(actual.size()-1) == b){
					return;
				}else{
					actual.remove(actual.size()-1);
				}
			}
		}
	}

	public ArrayList<Integer> theShortestRoad(int a, int b){
		this.solucion.clear();
		ArrayList<Integer> result = new ArrayList<Integer>();

		this.theShortestRoad(a, b, result);
		return solucion;
	}

	private void theShortestRoad(int a, int b, ArrayList<Integer> result){
		
		if(a != b && !result.contains(a)){
			result.add(a);

			Iterator<Integer> it = this.obtenerAdyacentes(a);
		
			while(it.hasNext()){
				int k = it.next();

				this.theShortestRoad(k, b, result);
			}

			result.remove(result.size()-1);

		}else if(!result.contains(a)){

			result.add(a);

			if(solucion.isEmpty()){
				for (Integer integer : result) {
					solucion.add(integer);
				}

			}else if(result.size() < solucion.size()){
				solucion.clear();
				for (Integer integer : result) {
					solucion.add(integer);
				}
			}

			result.remove(result.size()-1);
		}
	}

}

