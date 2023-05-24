package cacha.Practico3;

import java.util.ArrayList;
import java.util.Iterator;

public class caminos {
    private int value = 0;
    private Grafo g;
    private ArrayList<Integer> solucion; 

    public caminos(Grafo g) {
        this.solucion = new ArrayList<Integer>();
        this.g = g;
    }

    public ArrayList<Integer> conexionPc(int a, int b){
        Iterator<Integer> it = this.g.obtenerVertices();
        while(it.hasNext()) {
            value = it.next();


        }

        return this.solucion;
    }

    private void generatedSolucionPc(){
        
    }
}
