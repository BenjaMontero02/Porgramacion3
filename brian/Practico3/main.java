package brian.Practico3;

public class main {
    public static void main(String[] args) {

        //grafo dirigido
        GrafoDirigido gDirigido = new GrafoDirigido<>();
        ServicioDFS dfs = new ServicioDFS(gDirigido);
        ServicioCaminos caminos = new ServicioCaminos(gDirigido);

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
        gDirigido.agregarArco(1, 2, "k");
        gDirigido.agregarArco(2, 3, "p");
        gDirigido.agregarArco(2, 4, "p");
        gDirigido.agregarArco(3, 1, "p");
        gDirigido.agregarArco(4, 3, "p");
        gDirigido.agregarArco(1, 4, "p");
        gDirigido.agregarArco(1, 5, "p");
        gDirigido.agregarArco(5, 4, "p");
        gDirigido.agregarArco(5, 6, "p");
        gDirigido.agregarArco(6, 4, "p");
        gDirigido.agregarArco(7, 8, "p");
        gDirigido.agregarArco(8, 4, "p");
        gDirigido.agregarArco(7, 6, "p");
        gDirigido.agregarArco(7, 5, "p");

         //EJERCICIO 5
        System.out.println(caminos.caminos(1, 4, 8));

         //EJERCICIO 6
         //System.out.println(gDirigido.getRouteBetweenVertexs(1, 4, 2));
        
    }
    
}
