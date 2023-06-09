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
            Integer cazador = seleccionarCazador(c); //me da el primer cazador que encuentre
            if(cazador != null){ //si encontro un cazador ya que puede que no hay mas cazadores
                Objeto leon = seleccionarLeon(cazador, k); //me agarra
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
}