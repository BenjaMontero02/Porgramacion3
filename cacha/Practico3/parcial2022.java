package cacha.Practico3;

import java.util.ArrayList;

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
            //getCasillasVacias me da todas las casillas que no tinene un valro asignado
            for (Casilla casilla : tablero.getCasillasVacias()) {
                for (Integer i : this.conjunto) {
                    //conjunto es una lista de numeros del 1 al 9 
                    casilla.setValor(i);
                    backTracking(tablero);
                }
            }
        }
    }

    
}
