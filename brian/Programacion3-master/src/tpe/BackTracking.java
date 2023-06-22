package tpe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class BackTracking {
    
    private HashMap<Integer,Integer> distancia;
    private ArrayList<Integer> solucion;
    private CSVReader datos;
    
    public BackTracking(CSVReader datos) {
        this.distancia = new HashMap<>();
        this.solucion = new ArrayList<Integer>();
        this.datos = datos;
    }

    public int back(Grafo grafo) {
        int result = 0;
        Iterator<Integer> it = grafo.obtenerVertices();
        while (it.hasNext()) {
            Integer v = it.next();
            this.back(grafo,v,result);
        }
        return result;
    }

    private void back(Grafo grafo,Integer orig,int result) {

        if(grafo.cantidadVertices() == solucion.size()) {

        }
        else {
            Iterator<Integer> ady = grafo.obtenerAdyacentes(orig);
            while(ady.hasNext()) {
                Integer k = ady.next();

            }
        }
    }

    //OBTENGO DISTANCIA ENTRE 2 VERTICES
    public Integer distanciaEntreVertices(Integer origen,Integer destino) {
		ArrayList<String[]> lines = datos.readContent(); //CAMBIE EL METODO A PUBLICO POR AHORA
		for (String[] line: lines) {
			Integer o = Integer.parseInt(line[0].trim().substring(1));
			Integer d = Integer.parseInt(line[1].trim().substring(1));
			Integer dist = Integer.parseInt(line[2].trim());
            if(origen == o && destino == d || destino == o && origen == d) { //puede estar al reves (creo jaj)
                return dist; //retorno distancia entre vertices
            }
		}
        
        return null;
		
	}
}
