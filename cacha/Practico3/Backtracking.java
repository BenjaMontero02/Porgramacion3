package cacha.Practico3;

import java.util.ArrayList;
import java.util.Iterator;

import javax.sql.DataSource;

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

    public ArrayList<Integer> sumaConjuntos(ArrayList<Integer> valores, int m){
        this.solucion.clear();

        for (Integer value: valores){
            this.sumaConjuntos(valores, m, value);
        }
        return this.solucion;
    }
    
    private void sumaConjuntos(ArrayList<Integer> valores, int m, int valor){
        int total = valor;
        ArrayList<Integer> result  = new ArrayList<>();
        result.add(valor);
        for (Integer value : valores) {
            
            total += value;

            if(total == m){
                result.add(value);
                ArrayList<Integer> copia = new ArrayList();

                for (Integer integer : result) {
                    copia.add(integer);
                }

                this.solucion.addAll(copia);
                total = valor;
            }else if (total > m){
                total = total - m;
            }
        }
    }
}

public void backtracking(casilla1, casillo2){ //asumo que a la matriz le puedo perdir los booleanos; // obtengo los valores de la matriz en la pos del parametro

    arragloBooleanos = casilla1.getValores(); //esto me devuelve los booleanos de la casilla
    arregloActual.add(casilla1)
    for (por cada valor de arregloBooleanos) {
        
        if(boolean == true){
            casillaSiguiente = casilla1.obtenerCasillaEnValor(boolean);
            if(casillaSiguiente == casilla2){
                arregloActual.add(casilla2) //agrego la ultima casilla para completar el camino
                break // para que salga del for
            }else if(!arregloActual.contains(casillaSiguiente)){
                this.backtracking(casillaSiguiente, casilla2);
            }
        }
    }

    if(solucion.isEmpty()){//si la solucion es vacia es xq es el primer camino que encontre
        for(por cada elemento de arregloActual){
            solucion.add(elemento)
        }
    }else if(solucion.size() > arregloActual.size()){ //entonces el acutal encintrado es una mejor solucion
        solucion.clear();
        for(por cada elemento de arregloActual){
            solucion.add(elemento);
        }
    }

    if(!arregloActual.isEmpty()) {// si no esta vacio el arreglo
        //le saco la ultima casilla agregada
        arregloActual.remove(arregloActual.size()-1);
    }

}

public void sumaDeConjuntos(Estado estado){

    int valor = this.conjutos.sacarCopiaPrimero();
    estado.agregar(valor);

    if(estado.getSumaSolucion())){

    }
}

public void particionDeConjunto(Estado estado){

    if(!estado.tieneMas()){
        if(estado.sumarPrimerSolucion() == estado.sumarSegundaSolucion()){
            ArrayList<ArrayList<Integer>>solucion1 = new ArrayList<>();
            solucion1.add(estado.obtenerSolucion1());
            solucion1.add(estado.obtenerSolucion2());
            this.solucion.add(solucion1);
        }

    }else{
        estado.agregarASolucion1();
        particionDeConjunto(estado);
        estado.sacarDeUltimoSolucion1();//lo saca y lo vuelve a meter en el Conjunto inicial

        estado.agregarASolucion2();
        particionDeConjunto(estado);
        estado.sacarDeUltimoSolucion2();
        
    }
}

public void tareasAProcesadores(Estado estado){
    //Estado tiene un CI de tareas y un CI de procesadores
    if (!estado.tieneTareas()) {
        if(estado.sumarSolucionProcesadores() < this.sumarSolucion(this.solucion)){//
            this.solucion = estado.copiarSolucion();
        }
    }else {
        Tarea tarea = estado.obtenerPrimerTarea();

        for (Procesador procesador : estado.getProcesadores()){
            procesador.agregar(tarea); //agraga a lo ultimo
            this.tareasAProcesadores(estado);
            procesador.sacarTarea(); //saca la ultima tarea
        }

        estado.agregarAPrincipio(tarea);
    }
}

public void getRecorridoCaballo(Estado estado){
    //mi estado contiene una matriz de casillas, donde cada casilla tiene un booleando si fue 
    //pisada o no. Tambien un puntero que es donde se mueve paara recorrer las casillas


    //este metodo me devulve si existe una casilla por abajo o por siguiente
    if(estado.casillaActual() == estado.origen()){
        if(solucion.size() < estado.solucionActual().size()){
            solucion.clear();
            solucion.addAll(estado.getSolucion());
        }
    }else{
        //pregunto si existe una casilla a la izquierda
        if(estado.casillaIzquierda()){
            estado.avanzarCasillaAIzquierda();

            Casilla casilla = estado.getCasilla();

            if(casilla.visitada()){
                estado.addCasillaASolucion(casilla);
            }
            }else{
                estado.avanzarCasillaDerecha();
            }

            if(estado.casillaIzquierda()){
                estado.avanzarCasillaAIzquierda();
    
                Casilla casilla = estado.getCasilla();
    
                if(casilla.visitada()){
                    estado.addCasillaASolucion(casilla);
                    getRecorridoCaballo(estado);
                }
            }else{
                estado.avanzarCasillaDerecha();
            }
    


                if(estado.casillaAbajo()){
                    estado.avanzarCasillaAAbajo();
        
                    Casilla casilla = estado.getCasilla();
        
                    if(casilla.visitada()){
                        estado.addCasillaASolucion(casilla);
                    }
                }else{
                    estado.avanzarCasillaArriba();
                }

                if(estado.casillaArriba()){
                    estado.avanzarCasillaAArriba();
        
                    Casilla casilla = estado.getCasilla();
        
                    if(casilla.visitada()){
                        estado.addCasillaASolucion(casilla);
                    }
                }else{
                    estado.avanzarCasillaAbajo();
                }

                if(estado.casillaDerecha()){
                    estado.avanzarCasillaADerecha();
        
                    Casilla casilla = estado.getCasilla();
        
                    if(casilla.visitada()){
                        estado.addCasillaASolucion(casilla);
                    }
                }else{
                    estado.avanzarCasillaIzquierda();
                }
        }   
}
// Tablero mágico. Dado un tablero de tamaño n x n, construir un algoritmo
// que ubique (si es posible)
// n*n números naturales diferentes, entre 1 y 
//un cierto k (con k>n*n), de manera tal que la suma de
// las columnas y de las filas sea igual a S
public void tableroMagico(Estado estado){
    if(estado.matrizEstaLlena()){
        int contador = 0;
        boolean solucionEncontrada = true;
        while(contador < estado.getCantFilas() && solucionEncontrada){
            int sumaFila = estado.getSumaFila(contador);
            int sumaColumna = estado.getSumaColumna(contador);

            if(sumaFila != suma || sumaColumna != suma){
                solucionEncontrada = false;
            }
        }

        if(solucionEncontrada){
            solucion = estado.getSolucionActualMatriz();
        }

    }else{
        for(Integer i : estado.getListK()){

            estado.sacarElemntoK(i);
            estado.addAMatriz(i);

            if(estado.filaEstaLlena()){
                if(estado.filaEsValida()){
                    tableroMagico(estado);
                }
            }

            estado.agregarEnOrden(i);
            estado.eliminarDeMatriz(i);
        }
    }
}

public void piramide(Estado estado){

    // mi estado tiene una piramide que es un hashmap que su clave es el nivel de la piramide
    // y su valor es un arreglo de enteros

    if(estado.piramideEstaLlena()){

        //la solucion tiene un estructura igual a la piramide

        solucion = estado.getPiramideCompleta();

    }else{
        for (Integer i : estado.getConjuntoK()) {
            estado.sacarElementoDeK(i);
            estado.agregarAPiramide(i);

            if(estado.getSumaHijos(i)){  
                //este metodo me devuelve si la suma de los hijos de i son igual a i
                //y si no tiene hijos de devulve un true
                piramide(estado);
            }

            estado.sacarDePiramide(i);
            estado.agregarElementoEnOrden(i);
        }
    }
}
// mi solocion de atributo es una lista de listas de enteros
public void ejercicio10(Estado estado, Casilla actual){

    // mi estado tiene un conjunto que ya inicializado con sus valores
    // y tiene de atributo una list solucion de enteros

    if(estado.getSolucion().size() == n){
        if(estado.getSumaSolucion == 0){
            solucion.add(estado.getSolucion());
        }
    }else{
        for (Integer i : estado.getConjunto()) {
            estado.sacarElementoEnPrimerLugar(i);
            estado.agregarASolucion(i);
            ejercicio10(estado);
            estado.agregarElementoEnPrimerLugar(i);
            estado.sacarDeSolucion(i);
        }
    }
}

public ArrayList<Casilla> ejercicioRobot(Casilla actual, Casilla baseDeCarga){
    Estado estado = new Estado(baseDeCarga); 
    // estado contiene una arreglo de casillas solucion de atributo
    //lo inicializo con la base de carga
    ejercicio11(estado, actual);
    return solucion;
}

private void ejercicio11(Estado estado, Casilla actual){
    if(estado.solucionContieneBaseCarga()){
        if(solucion.isEmpty()){
            solucion.addAll(estado.getSolucion());
        }else if(solucion.size() > estado.getSizeSolucion()){
            solucion.clear();
            solucion.addAll(estado.getSolucion());
        }
    }else{
        for(Casilla casilla : estado.getCasillasVecinas(actual))
            if(casilla.esValida()) // si es 1, procede
                if(!estado.solucionContieneCasillaActual(casilla)){
                    //este if, funcionaria como poda, ya que si mi solucion contiene esa casilla,
                    //es al pedo volver a pasar por la misma
                    estado.addSolucion(casilla);
                    ejercicio11(estado, casilla);
                    estado.sacarCasillaDeSolucion(casilla);
                }
    }
}

