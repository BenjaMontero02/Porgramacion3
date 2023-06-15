package brian.Practico4;

import java.util.ArrayList;

public class backTrackingg {

    private ArrayList<ArrayList<Integer>> solucionPrincipal;
    private ArrayList<Casilla> solucion;
    private ArrayList<Casilla> recorridoActual;

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
        if(estado.tareasIsEmpty()) { //pregunto si estado se quedo sin tareas

        }
        else {

            Tarea tarea = estado.obtenerPrimerTarea();

            for (Procesador procesador : estado.solucionProcesadores()) {
                //saco la primer tarea de mi lista de tareas y la agrego a la lista de tareas del Procesador
                procesador.addTarea(tarea); //agrego primer tarea de la lista de tareas a la lista de tareas del procesador
                this.asignarTareas(estado); //llamo recursivamente
                procesador.quitarTarea(); //saco primer tarea de la lista de tareas del procesador
            }

            estado.addTarea(tarea); //devuelvo la tarea ala primer posicion de la lista de tareas del estado
        }
    }

    //EJERCICIO 6
    //DUDA (tengo que saber el orden en el que la casilla consulta sus lados?)
    //DUDA (el recorrido puede ser ORIGEN, SIGCASILLA, ORIGEN)

    public void getCaminoCaballo(Estado estado, Casilla casilla) { //la casilla inicialmente es el origen
        estado.addCasillaARecorrido(casilla); //agrego casilla a recorrido actual
        if(casilla == estado.getCasillaOrigen()) { //chequeo si ya volvi a la casilla origen
            if(solucion.size() < estado.casillaOrigenSize()) { //pregunto si mi recorrido actual es mayor a la solucion anteriormente adquirida
                solucion.clear();
                solucion.addAll(estado.getRecorridoCasillas()); // agrego recorrido a la solucion
            }

        }
        else {
            for (Casilla c : estado.casillasAdy(casilla)) { //me devuelve las casillas adyacentes de una casilla determinada(N,O,S,E)
                if(!estado.RecorridocontieneCasilla(c)) { //pregunto si no pase ya por la casilla a la que quiero avanzar
                    this.getCaminoCaballo(estado, c); //Sigo con recursividad
                }
                else if(c == estado.getCasillaOrigen()) {
                    this.getCaminoCaballo(estado, c); //Sigo con recursividad por que encontro el origen
                }
            }
        }
        estado.eliminarCasillaRecorrido(casilla); //elimino casilla del recorrido (ESTO ESTA BIEN?)
    }

    //EJERCICIO 7
    // Tablero mágico. Dado un tablero de tamaño n x n, construir un algoritmo que ubique (si es posible)
    // n*n números naturales diferentes, entre 1 y un cierto k (con k>n*n), de manera tal que la suma de
    // las columnas y de las filas sea igual a S.

    private void caballoDeAtila(Estado estado,Casilla origen, Casilla casilla, ArrayList<Casilla> camino){
        if(camino.contains(origen)){//
            estado.addSolucion(camino); //guarda una solucion en un atributo de tipo array solucion
        }
        else{//sigo explorando arbol
            for(Casilla casillaActual : estado.casillasAdyacentes(casilla)){ //me devuelve una casilla adyacente a la actual a la que el caballo puede ir (arriba, abajo, izq o derecha)
                if(casillaActual != null){
                    if(!camino.contains(casillaActual)){
                        camino.add(casillaActual);
                        caballoDeAtila(estado, origen, casillaActual, camino);
                        estado.eliminarCasillaActual(casillaActual);// elimina la casilla encontrada de la solucion
                    }
                }
            }
        }
    }

    public ArrayList<Casilla> caballoDeAtila(Casilla CasillaActual, Casilla origen){
        ArrayList<Casilla> camino = new ArrayList<>();
        this.caballoDeAtila(null,origen, CasillaActual, camino);
        return camino;
    }
}
