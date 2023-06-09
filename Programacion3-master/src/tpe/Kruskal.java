package tpe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class Kruskal {
    
    private ArrayList<Arco> arcos;
    private Grafo grafo;
    private int ameDist,ameArcos,ameNI;
    private HashMap<Integer,Integer> padres;
    private ArrayList<Arco> tuneles;

    Kruskal(Grafo grafo) {
        this.padres = new HashMap();
        this.arcos = new ArrayList<Arco>();
        this.grafo = grafo;
        this.tuneles = new ArrayList<>();
        this.inicializoKruskal();
    }

    void inicializoKruskal() {
        //cargo arcos
        Iterator<Arco> itArcos = grafo.obtenerArcos();
        while (itArcos.hasNext()) {
            Arco arc = itArcos.next();
            if(!arcos.contains(arc)) {
                arcos.add(arc);
            }
        }

        //ordeno arcos ASC por distancia
        Collections.sort(arcos, new ComparadorArcos());

        //cargo padres
        for (int i = 1; i <= grafo.cantidadVertices(); i++) {
            padres.put(i, i);
        }

    }

    public int metodoKruskal() {
    
        ameArcos = 0;
        ameDist = 0;
        ameNI = 0;
        int cantArcos = grafo.cantidadArcos();
        int cantVertices = grafo.cantidadVertices();

        //recorro arr de arcos ordenado y observo que vertices se pueden unir sin generar ciclo
        while((ameArcos<cantVertices-1)&&(ameNI<cantArcos)) {
            Integer origen = arcos.get(ameNI).getVerticeOrigen();
            Integer destino = arcos.get(ameNI).getVerticeDestino();
            Integer distancia = (Integer)arcos.get(ameNI).getEtiqueta();
            //chequeo si el arco se puede agregar al AME
            //chequeo si el orig y dest se encuentran en el mismo arbol en caso de que no se pueda add
            if(find(origen)!=find(destino)) {
                tuneles.add(grafo.obtenerArco(origen, destino));
                unite(origen, destino);
                ameDist += distancia; //se agrega la distancia al total de kms a construir
                ameArcos++; //aumenta contador de arcos de AME
            }

            ameNI++;
        }
        if(ameArcos==cantVertices-1) {
            return ameDist;
        }
        return 0;
    }

    int find(int x) { //encuentra el mayor padre de vertice x
        if (padres.get(x) == x) { //si padre de x es x retorno valor x
            return x;
        }
        return find(padres.get(x)); //retorna valor del padre encontrado
    }

    //este metodo esta en revision
    void unite(int x, int y) { // este metodo une dos vertices
        int fx = find(x);
        int fy = find(y);
        if(fx == x) { //si fx y x son iguales entonces reemplazo el padre de fx por y
            padres.replace(fx,y);
        }
        else { //si fx y x no son iguales (x ya tiene padre)
            if(fy == y) { //si y no tiene padre cambio el padre de y por x
                padres.replace(y,x);
            }
            else { //si y tiene padre (fy) entonces seguro fy de fy es igual
                //si tengo x=1, y=3, fy=4, fy de 4 = 4
                //entonces fy de 4 = 3, fy = 1
                //cacha si no entendes sos un boludo
              padres.replace(fy,y);
              padres.replace(y,x);  
            }
        }
    }

    ArrayList<Arco> getTuneles() {
        ArrayList<Arco> aux = new ArrayList();
        aux.addAll(tuneles);
        return aux;
    }
}
