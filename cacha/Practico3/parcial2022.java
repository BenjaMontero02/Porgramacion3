package cacha.Practico3;

import java.util.ArrayList;
import java.util.Iterator;

import cacha.Practico2.Tree;

public class parcial2022 {
    private ArrayList<ArrayList> solucionArbol;

    public ArrayList ejercicio1(Tree arbol, int K){
        ejercicio1Solucion(arbol, K);
        return solucionArbol;
    }

    private void ejercicio1Solucion(Tree arbol, int K){

            if(!arbol.izquierda()!= null && !arbol.izquierda().esHoja()){
                if((arbol.getValor() - arbol.izquierda().getValor()) > K){
                    ArrayList<Integer> conexion = new ArrayList<Integer>();
                    conexion.add(arbol.getValor());
                    conexion.add(arbol.izquierda().getValor());
                    ejercicio1(arbol.izquierda(), K);
                }
            }

            if(!arbol.derecha()!= null && !arbol.derecha().esHoja()){
                //preguntar si esta bien dar vuelta la resta
                //ya que la derecha es mayor y me va a dar negativo
                if((arbol.derecha().getValor() - arbol.getValor()) > K){
                    ArrayList<Integer> conexion = new ArrayList<Integer>();
                    conexion.add(arbol.getValor());
                    conexion.add(arbol.derecha().getValor());
                    ejercicio1(arbol.derecha(), K);
                }
            }
    }

    public Matriz sudoku(Matriz tablero){
        llenarTablero(tablero);
        return solucion;
    }

    private void llenarTablero(Matriz tablero){
        if(!tablero.estaLLeno()){
            for (Integer i : tablero.getCantFilas()) {
                
                if(tablero.cumpleFila(i)){
                    if(tablero.cumpleColumna(i)){
                        if(!tablero.seccion(i)){
                            return;
                        }
                    }
                }
                //solucion es una matriz de 
                //igual tamaño que tablero
                this.solucion = tablero.getCopiaTablero();
            }
        }else{
            //getCasillasVacias me da todas las casillas que no tinene un valor asignado
            for (Casilla casilla : tablero.getCasillasVacias()) {
                for (Integer i : this.conjunto) {
                    //conjunto es una lista de numeros del 1 al 9 
                    casilla.setValor(i);
                    backTracking(tablero);
                }
            }
        }
    }

    public Grafo ejercicio3(Grafo g){
        ArrayList<Estaciones> estacionesSinConectar = new ArrayList<Estaciones>();
        agregarTodasLasEstaciones(g, estacionesSinConectar);
        //me llena el arreglo con todas las estaciones

        for (Estaciones estacion : estacionesSinConectar) {
            
            Estacion estacionAConectar = seleccionar(estacion);
            //me devuelve la estacion mas cercana
            g.conectar(estacion, estacionAConectar);
        }

        return g;
    }
}

public class Final2019{


    public boolean ej3(Grafo g, int k, int w, int d){
        ArrayList<Integer> caminoActual = new ArrayList<Integer>();
        if(g.contieneVertice(k) && g.contieneVertice(w)){
            ejer3(g, k, w, caminoActual, d);
        }

        return solucion;
    }

    private void ejer3(Grafo g, int k, int w, ArrayList<Integer> caminoActual, int d){
        if(k == w){
            caminoActual.add(k);

            if(caminoActual.size() >= d){
                this.solucion = true;
            }

            caminoActual.remove(k);

        }else{
                caminoActual.add(k);
                Iterator<Integer> it = g.obtenerAdyacentes(k);
                while(it.hasNext()){
                    int vertice = it.next();
                    if(!caminoActual.contains(vertice)){
                        ejer3(g, vertice, w, caminoActual, d);
                    }
                caminoActual.remove(k);
            }
        }
    }

    public ArrayList<ArrayList<Integer>> generarCombinaciones(ArrayList<Integer> conjunto, int m){
        ordernarConjunto(conjunto); // ordena mi conjunto de menor a mayor
        Estado estado = new Estado(conjunto, m);
        //inicializo el estado con un conjunto y m que los setea como atributos
        //tambien mi estado tiene un CI(conjunto inicial), que esta vacio
        resolverEjercicio(estado);
        return solucion; // atributo de clase q es arraylist
    }

    private void resolverEjercicio(Estado e){
        if(e.sumarCI() == e.getM()){ //getM me da el valor de M(suma a llegar)
            ArrayList combinacion = new ArrayList();
            combinacion.addAll(e.getCI());
            this.solucion.add(combinacion);
        }else{
            for (Integer value : e.getConjunto()) {
                    e.addValueACI(value);
                    e.sacarValueDeConjunto(value);
                    resolverEjercicio(e);
                    e.sacarValueDeCI(value);
                    e.addValueAConjunto(value); //lo agrega en orden de menor a mayor
                }
            }
    }

    public ArrayList djikstra(Grafo g, Estacion estacion){

        ArrayList<Estacion> distancias = new ArrayList<>();
        ArrayList<Estacion> padre = new ArrayList<>();

        llenarArregloEnInfinito(g, distancias);
        llenarArregloEnIndefinido(g, padre);

        distancias[Estacion] = 0;
        ArrayList<Integer> solucion = new ArrayList<>();
        while(g.vertices() - solucion){
            
        }
    }
}