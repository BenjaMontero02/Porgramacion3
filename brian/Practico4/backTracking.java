package brian.Practico4;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Iterator;

import brian.Practico3.Grafo;

public class backTracking {

    private Grafo<?> g;
    private ArrayList<Integer> solucion;
    private ArrayList<ArrayList<Integer>> listaDeListas;
    private ArrayList<Integer> numeros;
    //private HashMap<Integer,String> hashAuxiliar;

    public backTracking(Grafo<?> g, int tamMatriz) {
        this.g=g;
        this.solucion=new ArrayList<>();
        this.listaDeListas = new ArrayList<>();
        this.numeros = new ArrayList<>(); 
        //this.hashAuxiliar=new HashMap<>();
    }

    //EJERCICIO 1
    public ArrayList<Integer> getCaminoMasLargo(Integer entrada, Integer salida) {
        solucion.clear();
        ArrayList<Integer> recorrido = new ArrayList<>();
        this.getCaminoMasLargo(entrada, salida, recorrido);
        return this.solucion;
    }

    //metodo privado se ejecuta recursivamente hasta conseguir el camino mas largo entre dos vertices
    private void getCaminoMasLargo(Integer entrada, Integer salida, ArrayList<Integer> recorrido) {
        recorrido.add(entrada);
        if(entrada != salida) {
            Iterator<Integer> itAdy = g.obtenerAdyacentes(entrada);
            while(itAdy.hasNext()) {
                int key = itAdy.next();
                if(!recorrido.contains(key)) {
                    this.getCaminoMasLargo(key, salida, recorrido);
                }
            }
        }
        else {
            if(solucion.size() < recorrido.size()) {
                solucion.clear();
                solucion.addAll(recorrido);
            }
        }
        recorrido.remove(recorrido.size()-1);
    }

    //EJERCICIO 2
    // Dado un laberinto consistente en una matriz cuadrada que tiene en cada posición un valor natural
    // y cuatro valores booleanos, indicando estos últimos si desde esa casilla se puede ir al norte, este,
    // sur y oeste, encontrar un camino de longitud mínima entre dos casillas dadas, siendo la longitud
    // de un camino la suma de los valores naturales de las casillas por las que pasa. Idea: podría
    // representarse el laberinto como una matriz, de objetos, donde cada objeto tiene el valor natural, y
    // cuatro booleanos, uno para cada dirección a la que se permite ir desde allí.

    public ArrayList<Integer> getCaminoMasCorto(Casilla casilla1, Casilla casilla2) {
        ArrayList<Casilla> solucion = new ArrayList<>(); //camino entre casillas
        ArrayList<Casilla> actual = new ArrayList<>(); //camino entre casillas
        this.getCaminoMasCorto(casilla1, casilla2, solucion, actual);
        return solucion;
    }

    private ArrayList<Integer> getCaminoMasCorto(Casilla casilla, Casilla casilla2, ArrayList<Integer> solucion,ArrayList<Integer> actual) {
        actual.add(casilla);
        if(casilla != casilla2) {
            for (Casilla c : casilla.getListDirecciones()) {
                if(c) {
                    if(!actual.contains(c)) {
                        this.getCaminoMasCorto(c, casilla2);
                    }
                }
            }
        }
        else {
            if(solucion.isEmpty()) {
				solucion.addAll(actual);
			}
            else {
                if(solucion.size() > actual.size()) {
                    solucion.clear();
                    solucion.addAll(actual);
                }
            }
        }
        actual.remove(actual.size()-1);
    }

    //EJERCICIO 3
    public ArrayList<ArrayList<Integer>> getCombinaciones(ArrayList<Integer> listNumbers, Integer m) {
        
        solucion.clear();
        
        for (Integer numero : numeros) { //recorro cada numero de la lista de numeros
            int suma = 0;
            int indiceNumeros = numeros.indexOf(numero); //obtengo indice
            this.getCombinaciones(m, numero, indiceNumeros, suma);
        }
        return listaDeListas;
    }

    private void getCombinaciones(Integer m, int numeroActual,int indice, int suma) {
        suma += numeroActual;
        solucion.add(numeroActual);
        if(suma != m) { //suma no es igual a M
            if(suma < m) { //si es menor debo seguir sumando
                indice++;
                numeroActual = numeros.get(indice); //cambio el valor del numero actual
                this.getCombinaciones(m,numeroActual,indice,suma);
            }
        }
        else { //suma es igual a M (solucion para agregar)
            ArrayList<Integer> nuevaSolucion = new ArrayList<>();
            nuevaSolucion.addAll(solucion);
            listaDeListas.add(nuevaSolucion);
        }
        solucion.remove(solucion.size()-1);
    }
    
}