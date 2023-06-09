package brian.Practico5;

import java.util.ArrayList;

public class Greedy {


    //x es aun array de fracciones
    //W es el peso limite de la mochila
    //w es una array de pesos
    public ArrayList<Double> ejercicio2(W, x, w) {

        //inicializo el array de fracciones con ceros    
        for (int i=0; i < n; i++) {
            x[i] = 0;
        }
        
        int peso_actual = 0;
        
        while (peso_actual < W) {
            i = seleccion(); // No definido cómo
            if (peso_actual + w[i] < W) {
                x[i] = 1;
                peso_actual = peso_actual + w[i];
            } 
            else {
                x[i] = (W - peso_actual) / w[i];
                peso_actual = W;
            }
        }
        return x;
    }

    //C es conjunto de actividades
    //x es de tipo actividad

    // Maximizar el número de actividades compatibles. Se tienen n actividades que necesitan utilizar un
    // recurso, tal como una sala de conferencias, en exclusión mutua. Cada actividad i tiene asociado
    // un tiempo de comienzo ci y un tiempo de finalización fi de utilización del recurso, con ci < fi. Si la
    // actividad i es seleccionada se llevará a cabo durante el intervalo [ci, fi). Las actividades i y j son
    // compatibles si los intervalos [ci, fi) y [cj, fj) no se superponen (es decir, ci > fj o cj > fi). El problema
    // consiste en encontrar la cantidad máxima de actividades compatibles entre sí.

    // actividades es mi conjunto de candidatos
    // i es elememto actividad que tiene 2 atributos:
        // inicio actividad
        // finalizacion actividad

    public ArrayList<Actividades> ejercicio3(ArrayList<Actividad> C, ArrayList<Actividades> S) {

        while(!C.vacio()) {
            Actividad act = seleccionar(C); //me trae una actividad

            if(S.vacio()) {
                S.agregar(act); // como la solucion esta vacia agrego actividad
            }
            else {
                // la ult actividad de mi solucion debe tener una horario de 
                // finalizacion menor al tiempo de inicio de la act nueva 
                if(S.ultimaActividad().getFinalizacion() < act.getInicio()) {  //puedo poner factible();
                    S.agregar(act);                    
                }
            }
        }

        return S;
        
    }


}