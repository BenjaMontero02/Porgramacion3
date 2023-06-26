package tpe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Greedy {
    
    private HashMap<Integer,Integer> padre;
    private HashMap<Integer,Integer> distancia;
    private ArrayList<Integer> solucion;
    private Integer sumaDistancias;

    public Greedy() {
        this.distancia = new HashMap<>();
        this.padre = new HashMap<>();
        this.solucion = new ArrayList<Integer>();
    }

    //debe tener metodo usado (Greedy)
    //tuneles construidos (arcos)
    //cant metros a construir
    //costo computacional
    public int resolucionGreedy(Grafo grafo) {

        int distanciaMasCorta = 1000;
        HashMap<Integer,Integer> solucionPadres = new HashMap<>();
        Iterator<Integer> it = grafo.obtenerVertices();

        //hago un dijkstra por cada vertice del grafo para conseguir la mejor solucion
        while(it.hasNext()) {
            Integer v = it.next();
            this.Dijkstra(grafo, v);
            sumaDistancias = this.getSumaDistancias();
            if(sumaDistancias < distanciaMasCorta) {
                distanciaMasCorta = sumaDistancias; //me quedo con la distancia mas corta
                solucionPadres.clear(); //limpio solucion actual y me quedo con la mejor
                solucionPadres.putAll(padre);
            }    
        }

        return distanciaMasCorta; //por ahora retorno esto, cuando retorne 55 es por que consegui la solucion
    }

    //OBTENGO SUMA DE TODAS LAS DISTANCIAS DEL HASH DISTANCIA
    private int getSumaDistancias() {
        int suma = 0;
        for (Integer value : distancia.values()) {
            suma += value;
        }
        return suma;
    }

    private void Dijkstra(Grafo grafo, Integer origen) {

        padre.clear();
        distancia.clear();
        solucion.clear();

        //seteo valores iniciales para distancia y padre de cada vertice
        Iterator<Integer> it = grafo.obtenerVertices();
        while(it.hasNext()) {
            Integer v = it.next();
            padre.put(v, null);
            distancia.put(v, 1000);
        }

        distancia.replace(origen, 0); //seteo distancia desde origen a origen en 0

        while (grafo.cantidadVertices() > solucion.size()) {//(mientras la cant de vertices sea distinta al tamaño de la solucion sigo)
            
            Integer actual = this.seleccionar(grafo); // vertice con menor distancia al origen y aun no considerado
            solucion.add(actual);
            Iterator<Integer> ady = grafo.obtenerAdyacentes(actual);
            while(ady.hasNext()) {
                Integer k = ady.next();
                if(!solucion.contains(k)) { //pregunto si todavia no fue considerado
                    Integer nuevaDistancia = distancia.get(actual) + distanciaEntreVertices(grafo, actual, k); //suma de dist de actual al origen mas dist entre actual y ady
                    if(nuevaDistancia < distancia.get(k)) {
                        distancia.replace(k, nuevaDistancia); //nueva dist de k al origen
                        padre.replace(k, actual); //nuevo padre de k
                    }
                }
            }
        }
    }

    //OBTENGO EL VERTICE CON MENOR DISTANCIA AL ORIGEN, Y AUN NO CONSIDERADO
    private Integer seleccionar(Grafo grafo) {

        int s = 1000; //distancia inicial (HAY QUE CAMBIARLO)
        Integer k = 0;

        //recorro los elementos de distancia y busco el que tenga menor valor y que aun no este en la solucion
        Iterator<Integer> it = grafo.obtenerVertices();
        while(it.hasNext()) {
            Integer v = it.next();
            if(distancia.get(v) < s && !solucion.contains(v)) {
                s = distancia.get(v);  //si dist menor a s y no fue considerada es posible candidato
                k = v;
            }
        }

        return k; //retorno vertice con menor distancia al origen 
    }

    //OBTENGO DISTANCIA ENTRE 2 VERTICES
    // este metodo obtiene el arco de un grafo dado por dos vertices, con el cual obtenemos la etiqueta (distancia)
    private Integer distanciaEntreVertices(Grafo grafo,Integer origen,Integer destino) {
		Arco arco = grafo.obtenerArco(origen, destino);
        Integer distancia = (Integer) arco.getEtiqueta();
        return distancia;
	}

    
}