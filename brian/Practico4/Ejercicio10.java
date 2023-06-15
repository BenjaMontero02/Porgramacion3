package brian.Practico4;

import java.util.ArrayList;

public class Ejercicio10 {

    private ArrayList<Solucion> soluciones;


    public Ejercicio10(Integer s) {
        this.soluciones=new ArrayList<>();
    }


    // Utilizando la técnica Backtraking, escriba un algoritmo que dado un conjunto de números
    // enteros, devuelva (si existen) todos los subconjuntos de tamaño N (dado como parámetro),
    // cuyas sumas sean exactamente cero.
    // Por ejemplo dado el conjunto {-7, -3, -2, -1, 5, 8 } y N = 3, los subconjuntos que suman cero son:
    // {-7, -1, 8} y {-3, -2, 5}.


    //  mi solucion de atributo es una lista de listas de enteros
    //  mi estado tiene un conjunto ya inicializado con sus valores y un atributo SubConjunto (lista) de enteros

    public void subConjuntos(Estado estado, Integer n) {
        if(estado.subConjuntoSize() == n) { //posible solucion
            if(estado.sumaSubConjunto() == 0) {
                soluciones.add(estado.getCopiaSubConjunto());
            }
        }
        else { //explorar arbol

            for (Integer i : estado.getConjuntoK()) {
                estado.quitarNumeroDelConjunto(i);
                estado.agregarNumeroASubConjunto(i);
                this.subConjuntos(estado, n);
                estado.quitarNumeroDeSubConjunto(i);
                estado.agregarNumeroAConjunto(i);
            }
        }
    }

    // El robot de limpieza necesita volver desde su posición actual hasta su base de carga. Dado que al
    // robot le queda poca batería, desea encontrar el camino más corto. El robot dispone de un mapa
    // de la casa representado como una matriz, donde cada celda es una posición de la casa. La matriz
    // posee un 0 si la celda está vacía, o un 1 si la celda presenta algún obstáculo (por ejemplo, un
    // mueble). Se desea encontrar entonces el camino más corto considerando que:
    // - Desde una celda solo te puedes mover a las celdas contiguas (izquierda, derecha, arriba y
    // abajo)
    // - El robot sólo puede caminar por celdas libres (no por celdas con obstáculos)
    // ¿Hay alguna poda que se pueda aplicar al algoritmo?

    public void robotLimpieza(Estado estado, Casilla posActual) {
        if(estado.solucionActualContieneDestinto()) {
            if(this.solucion.isEmpty()) {
                this.solucion = estado.getSolucionActual();
            }
            else {
                if(estado.getSolucionFinalSize() < this.solucion.size());{
                    this.solucion = estado.getSolucionActual();
                }
            }
        }
        else {
            for (Casilla casilla : estado.getCeldasContiguas(posActual)) {
                if(casilla.esValida())
                    if(!estado.solucionActualContiene(casilla)) {
                        estado.agregarCasillaSolucionActual(casilla);
                        this.robotLimpieza(estado, casilla);
                        estado.eliminarCasillaSolucionActual(casilla);
                    }
            }
        }
    }
    
}
