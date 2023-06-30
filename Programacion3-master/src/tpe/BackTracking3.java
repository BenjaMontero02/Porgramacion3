package tpe;

import java.util.ArrayList;
import java.util.Iterator;

public class BackTracking3 {
    
    private Integer kms_construccion;
    private ArrayList<Arco> tuneles;
    private int metrica;
    private Grafo grafo;

    public BackTracking3(Grafo grafo) {
        this.grafo = grafo;
        this.tuneles = new ArrayList<>();
    }

    public void backt() {

        tuneles.clear();
        kms_construccion = 0;
        metrica = 0;
        ArrayList<Arco> tunelesAux = new ArrayList<>();
        ArrayList<Arco> listaDeArcos = new ArrayList<>();
        Iterator<Arco> itArcos = grafo.obtenerArcos();
        while(itArcos.hasNext()) {
            Arco arco = itArcos.next();
            listaDeArcos.add(arco);
        }

        this.backt(tunelesAux,listaDeArcos);

        kms_construccion = this.getSumaArcos(tuneles);
    }

    private void backt(ArrayList<Arco> aux,ArrayList<Arco> listaDeArcos) {
        metrica++;

        if(this.isGrafoConexo(aux)) {
            if(tuneles.isEmpty()) { //si no tengo tuneles agrego solucion actual
                tuneles.addAll(aux);
            }
            else {
                int sumaTuneles = this.getSumaArcos(tuneles);
                int sumaAux = this.getSumaArcos(aux);
                if(sumaTuneles > sumaAux) { //comparo solucion anterior con actual
                    tuneles.clear();
                    tuneles.addAll(aux);
                }
            }
        }
        else{

            int max = listaDeArcos.size();
            int i = 0;
            while(i < max) {
                Arco arco = listaDeArcos.get(listaDeArcos.size()-(i+1));
                if(!contieneTunel(aux, arco)) {
                    aux.add(arco);
                    listaDeArcos.remove(arco);
                    if(getSumaArcos(aux) <= 55) {
                        System.out.println(arco.getVerticeOrigen() + ", " + arco.getVerticeDestino());
                        this.backt(aux,listaDeArcos);
                    }
                    aux.remove(arco);
                    listaDeArcos.add(arco);
                }
                i++;
            }
            
        }
    }

    // obtiene la suma de todos los arcos de una lista
    private Integer getSumaArcos(ArrayList<Arco> list) {
        Integer distTotal = 0;
        for (Arco arco : list) {
            Integer distancia = (Integer) arco.getEtiqueta();
            distTotal += distancia;
        }
        return distTotal;
    }

    // obtengo kms
    public Integer getKms_construccion() {
        return kms_construccion;
    }

    //obtengo tuneles
    public ArrayList<Arco> getTuneles() {
        ArrayList<Arco> aux = new ArrayList<Arco>();
        aux.addAll(tuneles);
        return aux;
    }

    //obtengo metrica
    public int getMetrica() {
        return metrica;
    }

    //chequea si una lista de arcos puede generar un grafo conexo?
    private boolean isGrafoConexo(ArrayList<Arco> listArcos) {

        int limite = grafo.cantidadVertices();

        if(listArcos.size() >= limite-1) {
            ArrayList<Integer> vConsiderados = new ArrayList<Integer>();
            for (Arco arco : listArcos) {

                Integer v1 = arco.getVerticeOrigen();
                Integer v2 = arco.getVerticeDestino();

                if(!vConsiderados.contains(v1) && vConsiderados.size() < limite) {
                    vConsiderados.add(v1);
                
                }
                if(!vConsiderados.contains(v2) && vConsiderados.size() < limite) {
                    vConsiderados.add(v2);
                }
            }
            //si la cant de vertices considerados es igual al limite(cant vertices) es una solucion posible
            return vConsiderados.size() == limite;
        }
        return false;
    }

    //chequea que una lista de arcos contenga o no un arco determinado, y luego revirtiendo los vertices
    private boolean contieneTunel(ArrayList<Arco> list, Arco a) {
        Integer v1 = a.getVerticeOrigen();
        Integer v2 = a.getVerticeDestino();
        Arco a2 = grafo.obtenerArco(v2, v1);
        if(list.contains(a) || list.contains(a2)) {
            return true;
        }
        else {
            return false;
        }
    }
}
