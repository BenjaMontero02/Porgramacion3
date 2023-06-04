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

    }
}
