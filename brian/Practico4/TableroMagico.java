package brian.Practico4;

import java.util.ArrayList;

public class TableroMagico {

    private Integer s;
    private boolean;
    private ArrayList<Solucion> soluciones;


    public TableroMagico(Integer s) {
        this.s=s;
    }

    //listaNumeros = numeros entre 1 y K (K>n*n)
    //N = cant de filas y columnas en la matriz del estado 
    //S = resultado que debe obtenerse (suma de fila, suma de columna)

    public void tableroMagico(Estado estado) {
        if(estado.matrizEstaLLena()) {//la matriz esta llena (Estado final / posible solucion)
            int contador = 0;
            boolean solucionEncontrada = true;
            while(contador < estado.cantFilasColumnas() && solucionEncontrada) { //recorro las columnas de la matriz
                //getSumaFila realiza suma de todas las columnas que contiene una fila
                //suponiendo que estado tiene un metodo que itera por cada fila y llama a un metodo que suma todos los numeros(columnas) de esa fila / misma logica para la columna
                int sumaFila = estado.getSumaFila(contador); //el contador indica la fila que debe hacer la suma
                int sumaColumna = estado.getSumaColumna(contador); //el contador indica la columna que debe hacer la suma
                if(sumaFila != s || sumaColumna != s) {
                    solucionEncontrada = false; //si las sumas
                }
            }
            if(solucionEncontrada) { //la suma de cada fila y cada columna es igual a "s"
                soluciones.add(estado.getSolucionActualMatriz());
            }
        }
        else {//debo seguir explorando el arbol

            for (Integer i : estado.listaDeNumeros()) {
                estado.sacarPrimeroDeListaDeNumeros(i); // saco el primer numero de la lista entre 1 y K
                estado.agregarASolucionActualMatriz(i); //el estado agrega num a matriz en orden
                this.tableroMagico(estado); //sigo explorando en el arbol
                estado.borrarDeSolucionActualMatriz(i); //el estado borra de la matriz el numero anteriormente agregado
                estado.ponerPrimeroEnLaListaDeNumeros(i); // devuelvo a la lista el numero que saque anteriormente
            }

            
        }
    }

    //DUDAS: deberia haber mas de una solucion?, guardo todas?
    
}
