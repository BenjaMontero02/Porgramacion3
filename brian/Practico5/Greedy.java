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

    public ArrayList<Actividades> ejercicio3(ArrayList<Actividad> C) {

        ArrayList<Actividades> S = new ArrayList<>();

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

    // Atrapando leones. Dado un arreglo donde en cada posición se encuentra un cazador o un león,
    // queremos capturar la mayor cantidad de leones sabiendo que:
    // ● Un cazador solo puede atrapar un león,
    // ● Los cazadores sólo pueden capturar leones que estén a menos de K pasos de su posición

    public int ejercicio4(ArrayList<Candidato> C, int K) {
        ArrayList<Candidato> S = new ArrayList<Candidato>();
        boolean par_Cazador_Leon = true;

        //mientras tenga un candidate (cazador y leon) sigo iterando
        while (par_Cazador_Leon) { //pregunto si mi conjunto de candidatos no esta vacio

            Candidato cazador = this.seleccionarCazador(C); //selecciona el primer cazador del conjunto de Candidatos
            Candidato leon = this.seleccionarLeon(C); //selecciona el primer leon que encuentre en el conjunto de candidatos
            C.borrar(cazador);
            C.borrar(leon);

            if(cazador != null && leon != null) { //chequeo tener un par de cazador/leon, si me falta debe cortar el while
                if(this.factible(cazador, leon, K)) {
                    //factible() chequea que la distancia de posiciones entre el cazzador y el leon sea mayor a K
                    // si
                    S.agregar(leon);
                }
            }
            else {
                par_Cazador_Leon = false; //al no tener mas leones o cazadores no tiene sentido seguir buscando
            }
        }
    }


    // Armando CDs. Dado un conjunto de archivos de canciones, donde cada uno tiene la información
    // de nombre, género, duración del tema, y tamaño en kilobytes, se desea grabar un disco CD (que
    // tiene una capacidad máxima de M kilobytes) de modo tal de:
    // ● Variante A: Maximizar la capacidad ocupada del disco CD.
    // ● Variante B: Maximizar la cantidad de canciones que se pueden grabar en el CD.
    // Para ambas variantes se quiere, además, que el CD no contenga más de 3 canciones de un
    // mismo género.


    public void grabarDiscoCD(ArrayList<ArchivoCancion> C, int tamMaxCD)  {

        ArrayList<ArchivoCancion> varianteB = new ArrayList<ArchivoCancion>();
        ArrayList<ArchivoCancion> varianteA = new ArrayList<ArchivoCancion>();
        int tamaño_actual = 0;
        boolean terminarBusqueda = false;

        //mientras tamaño actual no iguale/supere el limite o terminarbusqueda == true sigo iterando
        while(tamaño_actual < tamMaxCD && !terminarBusqueda) {
                ArchivoCancion archivoA = seleccionar(C); //seleccionar(C) selecciona en orden descendente
                ArchivoCancion archivoB = seleccionar(C); //seleccionar(C) selecciona candidatos del conjunto C en orden Ascendente(basado en kilobytes)
                if(factible(tamaño_actual,tamMaxCD,archivo)) { //explicado a bajo
                    tamaño_actual = tamaño_actual + archivo.tamañoKilobytes();
                    varianteB.agregar(archivo);
                }
                else { //si la suma del tamaño total mas el nuevo archivo supera el limite no tiene sentido seguir buscando
                    terminarBusqueda = true;
                }
        }
    }

    /*
    public boolean factible(int tamanio_actual, int tamMaxCD, ArchivoCancion archivo)
        if(tamaño_actual + archivo.tamañoKilobytes() <= tamMaxCD && this.cantCancionesPorGenero(archivo.getGenero())) {
            return true;
        }
        else {
            return false;
        }
     */







}