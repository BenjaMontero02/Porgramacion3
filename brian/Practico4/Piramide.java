package brian.Practico4;

import java.util.ArrayList;

public class Piramide {

    private ArrayList<Solucion> soluciones;

    public Piramide() {
        this.soluciones = new ArrayList<>();
    }

    // Colocar un entero positivo (menor que un cierto valor entero k dado) en cada casilla de una
    // pirámide de base B (valor entero dado) de modo que cada número sea igual a la suma de las
    // casillas sobre las que está apoyado. Los números de todas las casillas deben ser diferentes.


    public void piramide(Estado estado) {

        if(estado.piramideEstaLLena()) { //Estado final
            soluciones.add(estado.getPiramide());
        }
        else { //sigo explorando arbol

            for (Integer i : estado.getConjuntoDeK()) {
                estado.sacarNumeroConjunto(i);
                estado.addNumeroAPiramide(i); //
                //si la suma de los dos hijos es igual a i sigo explorando el arbol
                if(estado.getSumaHijos(i)) { //si no tiene hijos tambien devuelve true
                    this.piramide(estado);
                }
                estado.sacarNumeroDePiramide(i);
                estado.addNumeroEnOrdenEnConjunto(i);
                
            }
        }
    }
    
}
