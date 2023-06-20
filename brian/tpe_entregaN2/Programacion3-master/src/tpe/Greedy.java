package tpe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Greedy {
    
    private HashMap<Integer,Integer> padre;
    private HashMap<Integer,Integer> distancia;
    private ArrayList<Integer> solucion;
    private CSVReader datos;

    public Greedy(CSVReader datos) {
        this.distancia = new HashMap<>();
        this.padre = new HashMap<>();
        this.solucion = new ArrayList<Integer>();
        this.datos = datos;
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
            if(this.getSumaDistancias() < distanciaMasCorta) {
                distanciaMasCorta = this.getSumaDistancias(); //me quedo con la distancia mas corta
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
                    Integer nuevaDistancia = distancia.get(actual) + distanciaEntreVertices(actual, k); //suma de dist de actual al origen mas dist entre actual y ady
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

        return k; //retorno vertice con menor distancia al origen (sumo uno por que el array empieza con 0)
    }

    //OBTENGO DISTANCIA ENTRE 2 VERTICES
    private Integer distanciaEntreVertices(Integer origen,Integer destino) {
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



// package tpe;

// import java.util.ArrayList;
// import java.util.Iterator;

// public class Greedy {

//     private ArrayList<Integer> distancia;
//     private ArrayList<Integer> padre;
//     private ArrayList<Integer> solucion;
//     private CSVReader datos;

//     public Greedy(CSVReader datos) {
//         this.distancia = new ArrayList<Integer>();
//         this.padre = new ArrayList<Integer>();
//         this.solucion = new ArrayList<Integer>();
//         this.datos = datos;
//     }

//     //debe tener metodo usado (Greedy)
//     //tuneles construidos (arcos)
//     //cant metros a construir
//     //costo computacional
//     public int resolucionGreedy(Grafo grafo) {

//         int distanciaMasCorta = 1000;
//         ArrayList<Integer> solucionPadres = new ArrayList<Integer>();
//         Iterator<Integer> it = grafo.obtenerVertices();

//         //hago un dijkstra por cada vertice del grafo para conseguir la mejor solucion
//         while(it.hasNext()) {
//             Integer v = it.next();
//             this.Dijkstra(grafo, v);
//             if(this.getSumaDistancias() < distanciaMasCorta) {
//                 distanciaMasCorta = this.getSumaDistancias(); //me quedo con la distancia mas corta
//                 solucionPadres.clear(); //limpio solucion actual y me quedo con la mejor
//                 solucionPadres.addAll(padre);
//             }    
//         }

        
//         return distanciaMasCorta;
//     }

//     //OBTENGO SUMA DE TODAS LAS DISTANCIAS 
//     private int getSumaDistancias() {
//         int suma = 0;
//         for(int i = 0; i < distancia.size(); i++) {
//             suma += distancia.get(i);
//         }
//         return suma;
//     }

//     private ArrayList<Integer> Dijkstra(Grafo grafo, Integer origen) {

//         //limpio arrays cada vez que lo uso
//         solucion.clear();
//         padre.clear();
//         distancia.clear();

//         int cont = 0;

//         //establezco distancia inicial de cada estacion al origen en infinito
//         while(cont < grafo.cantidadVertices()) {
//             distancia.add(1000);
//             padre.add(null);
//             cont++;
//         }

//         distancia.set(0, 0); //seteo distancia desde origen a origen en 0

//         while (grafo.cantidadVertices() > solucion.size()) {//(mientras la cant de vertices sea distinta al tamaño de la solucion sigo)
            
//             Integer actual = this.seleccionar()+1; // vertice con menor distancia al origen y aun no considerado
//             solucion.add(actual);
//             Iterator<Integer> ady = grafo.obtenerAdyacentes(actual);
//             while(ady.hasNext()) {
//                 Integer k = ady.next();
//                 if(!solucion.contains(k)) { //pregunto si todavia no fue considerado
//                     Integer nuevaDistancia = distancia.get(actual-1) + distanciaEntreVertices(actual,k);
//                     if(nuevaDistancia < distancia.get(k-1)) {
//                         k=k-1;
//                         distancia.set(k,nuevaDistancia);
//                         padre.set(k, actual);
//                     }
//                 }
//             }
//         }
//         return distancia;
//     }

//     //OBTENGO EL VERTICE CON MENOR DISTANCIA AL ORIGEN, Y AUN NO CONSIDERADO
//     private Integer seleccionar() {
//         int s = 1000;
//         //recorro los elementos de distancia y busco el que tenga menor valor y que aun no este en la solucion
//         for (Integer i : distancia) {
//             if(i < s && (!solucion.contains(i))) {
//                 s = i;
//             }
//         }
//         return distancia.indexOf(s); //retorno indice del elemento con menor distancia al origen (sumo uno por que el array empieza con 0)
//     }

//     //OBTENGO DISTANCIA ENTRE 2 VERTICES
//     private Integer distanciaEntreVertices(Integer origen,Integer destino) {
// 		ArrayList<String[]> lines = datos.readContent(); //CAMBIE EL METODO A PUBLICO POR AHORA
// 		for (String[] line: lines) {
// 			Integer o = Integer.parseInt(line[0].trim().substring(1));
// 			Integer d = Integer.parseInt(line[1].trim().substring(1));
// 			Integer dist = Integer.parseInt(line[2].trim());
//             if(origen == o && destino == d || destino == o && origen == d) { //puede estar al reves (creo jaj)
//                 return dist; //retorno distancia entre vertices
//             }
// 		}
//         return null;
		
// 	}

    
// }
