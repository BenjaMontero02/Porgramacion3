import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

import cacha.Practico3.Grafo;

public class Parcial1 {

    private Solucion s;

    public Parcial1(Solucion s) {
        this.s = s;
    }

    //EJERCICIO 1 (ARBOL BINARIO)
    private boolean diferenciaMenor(int k) { // k es la diferencia que tiene que haber entre cada nodo
        return this.diferenciaMenor(k); //value es el valor de la raiz del arbol
    }
    public boolean diferenciaMenor(int k) {

        //pregunto si tengo un hijo a la izq y si ese hijo no es una Hoja
        if(this.left != null && (this.left.getLeft() != null || this.left.getRight() != null)) {
            if((this.value - this.left.getValue()) <= k) {
                this.left.diferenciaMenor(k);
            }
            else {
                return false;
            }
        }

        //misma pregunta a hijo derecho
        if(this.right != null && (this.right.getLeft() != null || this.right.getRight() != null)) {
            if((this.right.getValue() - this.value) <= k) {
                this.right.diferenciaMenor(k);
            }
            else {
                return false;
            }
        }

        return true;
    }


    //EJERCICIO 2 (BACKTRACKING)

    //La clase Estado contiene una matriz de enteros, con algunos numeros precargados
    //ademas contiene un conjunto de numeros entre 1 y 9

    public Solucion completarSudoku(Estado estado) {
        this.completarSudoku(estado);
        return s; //S es un atributo de clase que contiene el tablero de sudoku completado (una matriz)
    }
    private void completarSudoku(Estado estado) {
        if(estado.sudokuCompleto()) { //estado final, gracias a la poda si llego a estado final es una solucion
            s.agrearSudoku(estado.getSudoku());
        }
        else { //sigo explorando el arbol
            for (Integer num : estado.getConjuntoNumeros()) { //contiene numero entre 1 y 9 ordenados de menor a mayor
                Casilla casilla = estado.getSigCasilleroVacio(); //obtengo el primer casillero vacio de la matriz en orden (fila, columna)
                estado.agregarEnSudoku(casilla,num); //ingreso num en el tablero lo ingresa en la casilla especificada por parametro
                //si el numero no se repite en la columna, ni en la fila en la que esta ubicado en la matriz, ni en la region  
                //entonces es un posible camino a la solucion
                if(!estado.seRepiteColumna(num) && !estado.seRepiteEnFila(num) && !estado.seRepiteEnRegion(num)) { //PODA
                    this.completarSudoku(estado); //sigo explorando 
                }
            }
        }

    }

    //EJERCICIO 3 (GREEDY)

    //por el enunciado tengo entendido que yo puedo saber que distancia hay de una estacion hacia otra

    // tengo un C conjunto de estaciones

    public ArrayList<Integer> conectarEstaciones(ArrayList<Estaciones> C) {

        ArrayList<Tunel> solucion = new ArrayList<Tunel>(); //lista de tuneles a construir

        while(C.size() > solucion.size()) { //mientras tenga estaciones en mi conjunto
            Estaciones estacion = this.seleccionar(C); //selecciona una estacion del conjunto (la seleccion avanza)
            int i = 0;
            while(i < C.size()) { //mientras tenga estaciones pregunto a todas 
                Estacion estacionCercana = this.seleccionar(C); //obtengo estacion
                distancia = distanciaEstaciones(estacion, estacionCercana);



            }
        }

    }   


    public boolean existeCamino(Grafo g, Integer v,Integer d, Integer w) {
        ArrayList<Integer> recorrido = new ArrayList<>();
        boolean existe = false;
        this.existeCamino(g,v,w,recorrido,existe);
        return existe;
    }

    private boolean existeCamino(Grafo<T> g, Integer actual,Integer d, Integer w, ArrayList<Integer> recorrido, boolean existe) {
        recorrido.add(actual);
        if(actual == w && recorrido.size() > d) {
            return true;
        }
        else {
            Iterator<Integer> it = g.obtenerAdyacentes(actual);
            while(it.hasNext()) {
                int k = it.next();
                if(!recorrido.contains(k)) {
                    this.existeCamino(g,k,w,recorrido);
                }
            }
        }
        recorrido.remove(recorrido.size()-1);
        return existe;
    }



    public ArrayList<ArrayList<Integer>> backTracking(ArrayList<Integer> conjunto, Integer m) {
        ArrayList<ArrayList<Integer>> solucion = new ArrayList<ArrayList<Integer>>();
        Estado estado = new Estado(conjunto,m);
        this.backTracking(estado);
        return solucion;
    }

    private void backTracking(Estado estado) {
        if(estado.sumaSubConjunto() == estado.getM()) { //pregunto si mi subconjunto es igual a M
            ArrayList<Integer> nuevaSolucion = new ArrayList<>();
            nuevaSolucion.addAll(estado.getSubConjunto());
            solucion.agregarSubconjunto(nuevaSolucion); //agreo nueva solucion al conjunto de soluciones
        }
        else {//sigo explorando
            for (Integer num : estado.getConjunto()) { //traigo conjunto de numeros
                int numero = estado.sacarNumeroConjunto(num);
                estado.agregarSubConjunto(numero);
                if(estado.sumaSubConjunto() <= estado.getM()) { //pregunto si la suma del subconjunto es menor a M
                    this.backTracking(estado);
                }
                estado.sacarNumeroSubConjunto(numero);
                estado.devolverAConjunto(numero);
                
            }

        }
    }
}
