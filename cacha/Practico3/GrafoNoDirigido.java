package cacha.Practico3;

import java.util.ArrayList;
import java.util.Iterator;

public class GrafoNoDirigido<T> extends GrafoDirigido<T> {

	private ArrayList<ArrayList<Integer>> solucion;

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		super.agregarArco(verticeId1, verticeId2, etiqueta);
		super.agregarArco(verticeId2, verticeId1, etiqueta);
	}
	
	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		super.borrarArco(verticeId1, verticeId2);
		super.borrarArco(verticeId2, verticeId1);
	}
	
	@Override
	public int cantidadArcos() {
		return super.cantidadArcos() / 2;
	}


	public ArrayList getAllRoads(int a, int b, int c, int d){
		this.solucion = new ArrayList<>();

		ArrayList<Integer> actual = new ArrayList<Integer>();

		this.getAllRoads(a, b, c, d, actual);
		return solucion;
	}

	private void getAllRoads(int a, int b, int c, int d, ArrayList<Integer> actual){
		Iterator<Integer> it = this.obtenerAdyacentes(a);
		actual.add(a);

		if(a == b){
			ArrayList<Integer>copia = new ArrayList<Integer>();

			for (Integer integer : actual) {
				copia.add(integer);
			}

			this.solucion.add(copia);
			actual.remove(actual.size()-1);
		}else{
			while(it.hasNext()){
				int k = it.next();
	
				if(a != c && k != d && !actual.contains(k)){
					this.getAllRoads(k, b, c, d, actual);
				}
			}

			actual.remove(actual.size()-1);
		}
	}
}