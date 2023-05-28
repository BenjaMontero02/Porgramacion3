package cacha.Practico3;

import java.util.ArrayList;
import java.util.Iterator;

public class Backtracking{

    private ArrayList<Integer> solucion;
    private Grafo grafo;

    public Backtracking(Grafo grafo){
        this.solucion = new ArrayList<Integer>();
        this.grafo = grafo;
    }

    public ArrayList<Integer> getBestSolution(int entrada, int salida){
        this.solucion.clear();

        ArrayList<Integer> actual = new ArrayList<Integer>();
        this.getBestSolution(entrada, salida, actual);

        return solucion;
    }

    private void getBestSolution(int entrada, int salida, ArrayList<Integer> actual){
        actual.add(salida);
        if(entrada == salida){
            if(solucion.isEmpty()){
                solucion.addAll(actual);
            }else if(solucion.size() < actual.size()){
                solucion.clear();
                solucion.addAll(actual);
            }

            if(!actual.isEmpty()){
                actual.remove(actual.size()-1);
            }
        }else{

            Iterator it = this.grafo.obtenerAdyacentes(entrada);

            while(it.hasNext()){
                int k = (int) it.next();

                if(!actual.contains(k)){
                    this.getBestSolution(k, salida, actual);
                }
            }

            if(!actual.isEmpty()){
                actual.remove(actual.size()-1);
            }
        }

    }
}