package cacha.Practico3;

import java.util.ArrayList;
import java.util.HashMap;

public class Greedy{
    private static int puntero = 0;

    public ArrayList<Integer> ej1(ArrayList<Integer> c, int totalAPagar){
        ArrayList<Integer> solucion = new ArrayList<Integer>();
        while(totalAPagar != 0){
            //me selecciona del conjunto de candidatos el valor mas grande, dependiendo el puntero
            int valor = seleccionar(c); 
            if((totalAPagar - valor) >= 0){
                solucion.add(valor);
                totalAPagar = totalAPagar - valor;
            }else{
                puntero++;
            }
        }

        return solucion;
    }

    public ArrayList<Integer> ej2(ArrayList<Double>fracciones, int peso, ArrayList<Integer>peso){

        for (int j = 0; j < fracciones.size()-1; j++) {
            fracciones[j] = 0;
        }
        int pesoActual = 0;

        while(pesoActual < peso){
            int i = seleccion(); //selecciona el producto de mayor valor/peso, asumo que no repite indices

            if((pesoActual + peso[i] < W)){
                fracciones[i] = 0;
                pesoActual = pesoActual + peso[i];
            }else{
                x[i] = (peso - pesoActual) / peso[i];
                pesoActual = peso;
            }
        }
        return x;
    }

    //recibo arreglo ordenado c
    public ArrayList<Actividades> getActDisponibles(ArrayList<Actividades>c){
        ArrayList<Actividades> solucion = new ArrayList<Actividades>();
        this.ordenarPorOrdenDeInicio(c);
        while(!c.isEmpty()){
            
            Actividad actividad = seleccionar(c); //selecciona la primer actividad del conjunto y la saca

            if(solucion.isEmpty()){
                solucion.add(actividad);
            }else{
                Actividad ultima = solucion.get(solucion.size()-1);

                if(ultima.getFin() <= actividad.getInicio()){
                    solucion.add(actividad);
                }
            }
        }

        return solucion;
    }

    public void ej4Dijkstra(Grafo g, int verticeOrigen){
        ArrayList<Integer> distancia = new ArrayList<Integer>();
        HashMap<Integer, Integer> padre = new HashMap();

        for (Integer vertices : g.getVertices()) {
            distancia.add(vertices);
            padre.put(vertices, null);
        }

        padre.replace(verticeOrigen, 0);
        ArrayList<Integer> solucion = new ArrayList<Integer>();

        for (Integer vertice : g.getVerices()) {
            Vertice seleccionado =  seleccionar(distancia); //me selecciona el vertice con el menor valor
            solucion.add(vertice);
            
            for (Integer verticeAdyacente : g.getAdyacentes(vertice)) {
                if((distancia[seleccionado] + dist_entre(seleccionado,verticeAdyacente)) < distancia[verticeAdyacente]) {
                    distancia[verticeAdyacente] = distancia[seleccionado] + dist_entre(seleccionado,verticeAdyacente);
                    padre.replace(verticeAdyacente, seleccionado);
                }
            }
        }
        return solucion;
    }


    public ArrayList ejercicio4(Grafo g, int origen){

    }


    public ArrayList ejercicio7(int k, ArrayList<Objeto> c){
        boolean noHayMas = false;
        while(!candidatos.isEmpty() && !noHayMas){
            Integer cazador = seleccionarCazador(c); 
            //me da el primer cazador que encuentre y lo saca de candidatos
            if(cazador != null){ //si encontro un cazador ya que puede que no hay mas cazadores
                Objeto leon = seleccionarLeon(cazador, k, c); 
                //me agarra un leon valido a menor a k y lo saca de candidatos
                if(leon != null){
                    ArrayList pareja = new ArrayList<>();
                    pareja.add(cazador);
                    pareja.add(leon);
                    solucion.add(pareja);
                }else{
                    noHayMas = true;
                }
            }else{
                noHayMas = true;
            }
        }
        return solucion;
    }

    // Desde un cierto conjunto grande de ciudades del interior de una provincia, se desean transportar
    // cereales hasta alguno de los 3 puertos pertenecientes al litoral de la provincia. Se pretende
    // efectuar el transporte total con mínimo costo sabiendo que el flete es más caro cuanto más
    // distancia tiene que recorrer. Dé un algoritmo que resuelva este problema, devolviendo para cada
    // ciudad el camino que debería recorrer hacia el puerto de menor costo.

    public HashMap ejercicio5(Grafo g){
        Ciudad ciudadAgregada = new Ciudad();

        g.agregarCiudadConectadaALosPuertos(ciudadAgregada);

        ArrayList<Ciudad> padre = djisktra(g, ciudadAgregada);
        ArrayList<Ciudad> camino = new ArrayList<Ciudad>();

        for(Ciudad ciudad : g.getCiudades()){  
            Ciudad i = ciudad;
            while(padre[i] != indefinido){
                camino.add(padre[i]);
                i = padre[i];
            }

            solucion.put(ciudad, camino);
            camino.clear();
        }

        return solucion;
    }

    public ArrayList<Ciudad> viajante(Grafo g, Ciudad origen){

        ArrayList<Ciudad> ciudad = g.obtenerCiudad();
        ArrayList<Ciudad> camino = new ArrayList<Ciudad>();
        camino.add(origen);
        ciudad.moverAPrimero(origen);

        for (Ciudad ciudad1 : ciudad) {
            Ciuadad ciudadElejida = seleccionar(ciudad1, ciudad);
            ciudad.remove(ciudadElejida);
            camino.add(ciudadElejida);
        }

        camino.add(origen);
    
    } 

    public void colorearGrafo(Grafo g){
        ArrayList<Color> colores = new ArrayList<>();
        colores.add(colorRandom());
        boolean pintado = false;
        for(Vertice i : g.getVertices()){
            
            for(Color color : colores){

                if(i.puedoPintarlo(color)){
                    pintarVertice(i,color);
                    pintado = true;
                }

                if(pintado == true){
                    break;
                }
            }

            if(pintado == false){
                Color color = colorRandom();
                pintarVertice(i, color);
                colores.add(color);
            }
        }
    }
}