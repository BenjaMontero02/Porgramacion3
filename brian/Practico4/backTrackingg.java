package brian.Practico4;

import java.util.ArrayList;

public class backTrackingg {

    private ArrayList<ArrayList> solucionPrincipal;

    public backTrackingg() {
        this.solucionPrincipal = new ArrayList<>();
    }



    public void particionDeConjunto(Estado estado) {
        if(estado.conjuntosIsEmpty()) { //me dice si mi conjunto inicial esta vacio o no
            if(estado.sumarPrimerSolucion() == estado.sumarSegundaSolucion()) {
                ArrayList<ArrayList<Integer>> solucionMetodo = new ArrayList<>();
                solucionMetodo.add(estado.getSolucion1());
                solucionMetodo.add(estado.getSolucion2());
                solucionPrincipal.add(solucionMetodo);
            }
        }
        else {
            estado.agregarElementoASolucion1(estado.obtenerPrimerElementoConjunto()); //saco del conjunto inicial el primer elemento

            this.particionDeConjunto(estado); // llamo recursivamente a la funcion

            estado.agregarElementoAConjuntoInicial(estado.obtenerPrimerElementoS1()); //obtengo primer elemento de la solucion 1

            estado.agregarElementoASolucion2(estado.obtenerPrimerElementoConjunto()); //saco del conjunto inicial el primer elemento

            this.particionDeConjunto(estado); //llamo recursivamente a la funcion

            estado.agregarElementoAConjuntoInicial(estado.obtenerPrimerElementoS2());

        }
    }

    // Asignación de tareas a procesadores. Se tienen m procesadores idénticos y n tareas con un
    // tiempo de ejecución dado. Se requiere encontrar una asignación de tareas a procesadores de
    // manera de minimizar el tiempo de ejecución del total de tareas.

    public void asignarTareas(Estado estado) {
        if(estado.tareasIsEmpty()) {

        }
        else {
            // saco procesador de lista de procesadores y lo agrego a mi solucion
            // mi solucion contiene procesadores
            estado.sacarPrimerProcesador();

            for (Procesador procesador : estado.solucionProcesadores()) {
                //saco la primer tarea de mi lista de tareas y la agrego a la lista de tareas del Procesador
                procesador.addTarea(estado.sacarPrimerTarea()); //agrego primer tarea de la lista de tareas a la lista de tareas del procesador
                this.asignarTareas(estado); //llamo recursivamente
                estado.addTareaEnPrimerPosicion(procesador.sacarUltimaTarea()); //devuelvo la tarea ala primer posicion
            }
        }
    }
    
}
