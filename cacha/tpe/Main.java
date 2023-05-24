import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        //grafos, servicios
        
        GrafoDirigido gDirigido = new GrafoDirigido<>();
        ServicioDFS dfs = new ServicioDFS(gDirigido);
        ServicioBFS bfs = new ServicioBFS(gDirigido);
        ServicioCaminos sCaminos = new ServicioCaminos(gDirigido, 1, 4, 3);
        

        //VERTICES
        
        gDirigido.agregarVertice(1);
        gDirigido.agregarVertice(2);
        gDirigido.agregarVertice(3);
        gDirigido.agregarVertice(4);
        gDirigido.agregarVertice(5);
        gDirigido.agregarVertice(6);
        gDirigido.agregarVertice(7);
        gDirigido.agregarVertice(8);
        

        //ARCOS
        
        gDirigido.agregarArco(1, 2, "voy de 1 a 2");
        gDirigido.agregarArco(2, 3, "voy de 2 a 3");
        gDirigido.agregarArco(2, 4, "voy de 2 a 4");
        gDirigido.agregarArco(3, 1, "voy de 3 a 1");
        gDirigido.agregarArco(4, 3, "voy de 4 a 1");
        gDirigido.agregarArco(1, 4, "voy de 1 a 4");
        gDirigido.agregarArco(1, 5, "voy de 1 a 5");
        gDirigido.agregarArco(5, 4, "voy de 5 a 4");
        gDirigido.agregarArco(5, 6, "voy de 5 a 6");
        gDirigido.agregarArco(6, 4, "voy de 6 a 4");
        gDirigido.agregarArco(7, 8, "voy de 7 a 8");
        gDirigido.agregarArco(8, 4, "voy de 8 a 4");
        gDirigido.agregarArco(7, 6, "voy de 7 a 6");
        gDirigido.agregarArco(7, 5, "voy de 7 a 5");

        //PRUEBAS CON SERVICIOS

        

        
        //cantidad de arcos y vertices en el grafo
        System.out.println("CANTIDAD DE ARCOS: " + gDirigido.cantidadArcos());
        System.out.println("CANTIDAD DE VERTICES: " + gDirigido.cantidadVertices());

        System.out.println("-----------------------------------------------------------------");

        //grafo contiene vertice
        System.out.println("EL GRAFO CONTIENE VERTICE: " + gDirigido.contieneVertice(6));
        System.out.println("EL GRAFO CONTIENE VERTICE: " + gDirigido.contieneVertice(15));

        System.out.println("-----------------------------------------------------------------");

        //existe arco
        System.out.println("EXISTE ESTE ARCO: " + gDirigido.existeArco(1, 8));
        System.out.println("EXISTE ESTE ARCO: " + gDirigido.existeArco(6, 4));

        System.out.println("-----------------------------------------------------------------");

        //obtener arcos, vertices, adyacentes de vertices

        //obtener adyacentes de un vertice
        Iterator<Integer> itAdy = gDirigido.obtenerAdyacentes(1);
        while(itAdy.hasNext()) {
            System.out.println("adyacente de vertice 1: " + itAdy.next());
        }

        System.out.println("-----------------------------------------------------------------");

        //obtener arcos
        Iterator<Arco> itArcos = gDirigido.obtenerArcos();
        System.out.println("Arcos");
        while(itArcos.hasNext()) {
            System.out.println(itArcos.next().getEtiqueta());
        }

        System.out.println("-----------------------------------------------------------------");

        //obtener arcos por vertice
        Iterator<Arco> itArcos2 = gDirigido.obtenerArcos(1);
        while(itArcos2.hasNext()) {
            System.out.println("arco de vertice 1:  " + itArcos2.next().getEtiqueta());
        }

        System.out.println("-----------------------------------------------------------------");

        
        System.out.println("-----------------------------------------------------------------");

        //obtener vertices
        Iterator<Integer> v = gDirigido.obtenerVertices();
        System.out.println("vertices:");
        while(v.hasNext()) {
            System.out.println(v.next());
        }

        //borrar objs
        System.out.println("--------------------------------------------------------------:");
        System.out.println("borro arco entre 3 y 1");
        gDirigido.borrarArco(3, 1);
        System.out.println("existe arco entre 3 y 1: " + gDirigido.existeArco(3, 1));

        System.out.println("--------------------------------------------------------------:");
        System.out.println("cantidad de arcos: "+gDirigido.cantidadArcos());
        System.out.println("borro vertice");
        gDirigido.borrarVertice(6);
        System.out.println(gDirigido.contieneVertice(6));
        System.out.println("existe arco entre 5 y 6: " + gDirigido.existeArco(5, 6));
        System.out.println("existe arco entre 6 y 4: " + gDirigido.existeArco(6, 4));
        
        System.out.println("cantidad de arcos: "+gDirigido.cantidadArcos());


        Iterator<Integer> i = gDirigido.obtenerAdyacentes(5);
        while(i.hasNext()) {
            System.out.println("adyacente de vertice 1: " + i.next());
        }

        
        
    }
}
