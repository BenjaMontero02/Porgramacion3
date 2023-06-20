import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Parcial2 {





    public ArrayList<Estacion> greedy(int kilometrosLimite, ListaVinculada<> ruta) {

        MyIterator<Node> itEstacion = ruta.estacionesRuta(); //obtengo iterador de lista vinculada de estaciones
        int kilometrosRecorridos = 0;
        ArrayList<Estacion> estacionesDeCarga = new ArrayList<>();

        while(itEstacion.hasNext()) { //mientras tengo estaciones para recorrer itero
            Node e = itEstacion.next(); //obtengo la estacion actual de la ruta
            Node eSiguiente = e.getNext(); //obtengo la siguiente estacion
            if(eSiguiente != null) {
                int dist = this.distancia(e,eSiguiente); //obtengo la distancia entre las dos estaciones
                if((kilometrosRecorridos + dist) <= kilometrosLimite) { //la suma de los km actuales mas la nueva distancia debe ser menor o igual a el limite del camion
                    kilometrosRecorridos = kilometrosRecorridos + dist;
                }
                else {
                    kilometrosRecorridos = 0;
                    estacionesDeCarga.add(e);
                }
            }
        }

        return estacionesDeCarga;

    }

    public ArrayList<Estacion> backTrackingEstaciones(int kLimite, ListaVinculada ruta) { //ruta es conjunto de candidatos
        MyIterator<Node> itEstacion = ruta.estacionesRuta(); //obtengo iterador de lista vinculada de estaciones
        int kilometrosRecorridos = 0;
        ArrayList<Estacion> estacionesDeCarga = new ArrayList<>();
        this.backTrackingEstaciones(kLimite, kilometrosRecorridos, itEstacion,estacionesDeCarga);
        return estacionesDeCarga;
    }

    private void backTrackingEstaciones(int kLimite,int kmRecorrido ,Node estacionActual, ArrayList<Estacion> estacionesDeCarga) {
        if(estacionActual.getNext() == null) {


        }
        else { //sigo explorando el arbol
            Node e = estacionActual.next(); //obtengo la estacion actual de la ruta
            Node eSiguiente = e.getNext(); //obtengo la siguiente estacion
            int dist = this.distancia(e,eSiguiente); //obtengo la distancia entre las dos estaciones
            if((kmRecorrido + dist) <= kLimite) { //la suma de los km actuales mas la nueva distancia debe ser menor o igual a el limite del camion
                kmRecorrido = kmRecorrido + dist;
            }
            else {
                kmRecorrido = dist;
                estacionesDeCarga.add(e);
            }
            this.backTrackingEstaciones(kLimite, kmRecorrido, estacionActual, estacionesDeCarga);
        }
    }

    public boolean hayCiclo() {
        ArrayList<Integer> recorrido = new ArrayList<>();

        //inicializas hashMap con clave=vertice, y valor booleaano si fue visitado
        Iterator<Integer> it = grafo.obtenerVertices();

        while(it.hasNext()) {
            //si el vertice no fue visitado
            //funcion recursiva
        }

        return recorrido;
    }

    public ArrayList<Integer> getCamino(Grafo g, Integer origen, Integer destino) {
        
        ArrayList<Integer> recorrido = new ArrayList<>();
        this.getCamino(g,origen,destino,recorrido);
        return recorrido;
    }

    private void getCamino(Grafo g, Integer actual, Integer destino, ArrayList<Integer> recorrido,ArrayList<Integer> solucion , int sumaPeajes, int peajeFinal) {
        recorrido.add(actual);
        sumaPeajes = sumaPeajes + this.getPeaje(actual); //getPeaje devuelve un double
        if(actual == destino) {
            if(peajeFinal > sumaPeajes) {
                peajeFinal = sumaPeajes;
                solucion.clear();
                solucion.addAll(recorrido);
            }
        }
        else {
            Iterator<Integer> itAdy = g.obtenerAdyacentes(actual);
            while(itAdy.hasNext()) {
                int k = itAdy.next();
                if(!recorrido.contains(k)) {
                    this.getCamino(k,destino,recorrido,solucion,sumaPeajes,peajeFinal);
                }
            }
        }
        recorrido.remove(recorrido.size()-1);
        sumaPeajes = sumaPeajes - this.getPeaje(actual); //resto lo ultimo que sume
    }






}