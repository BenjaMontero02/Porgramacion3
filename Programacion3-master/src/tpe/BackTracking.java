package tpe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class BackTracking {
    
    private HashMap<Integer,Integer> distancia;
    private ArrayList<Arco> arcos;
    private ArrayList<Integer> considerados;
    private Integer result;
    
    public BackTracking() {
        this.distancia = new HashMap<>();
        this.arcos = new ArrayList();
        this.considerados = new ArrayList<Integer>();
    }

    public int back(Grafo grafo) {

        this.result = 0;
        this.arcos.clear();
        this.considerados.clear();

        Iterator<Integer> it = grafo.obtenerVertices();
        while (it.hasNext()) {
            Integer v = it.next();
            considerados.add(v);
            this.back(grafo,v);
            arcos.clear();
            considerados.clear();
        }
        return result;
    }

    private void back(Grafo grafo,Integer origen) {

        //si mi cantidad de considerados iguala a la cant de vertices tengo una solucion posible
        if(grafo.cantidadVertices() == considerados.size()) {
            Integer sumaArcos = this.getSumaArcos();
            //una vez obtenido la suma de los arcos comparo con solucion anterior
            if(result == 0) {
                result = sumaArcos;
            }
            else {
                if(result > sumaArcos) {
                    result = sumaArcos;
                }
            }

        }
        else {
            Iterator<Integer> ady = grafo.obtenerAdyacentes(origen);
            while(ady.hasNext()) {
                Integer k = ady.next();

                if(!considerados.contains(k)) {
                    this.arcos.add(grafo.obtenerArco(origen, k)); // agrego arco de origen a ady
                    this.considerados.add(k); // agrego ady a vertices considerados
    
                    this.back(grafo, origen);
    
                    this.back(grafo, k);
    
                    //remuevo los elementos agregados cuando vuelve de la recursividad
                    this.arcos.remove(this.arcos.size()-1);
                    this.considerados.remove(this.considerados.size()-1);
                }
            }
        }
    }

    private Integer getSumaArcos() {
        Integer distTotal = 0;
        for (Arco arco : arcos) {
            Integer distancia = (Integer) arco.getEtiqueta();
            distTotal += distancia;
        }
        return distTotal;
    }
}
