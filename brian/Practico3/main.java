package brian.Practico3;

public class main {
    public static void main(String[] args) {

        //grafo dirigido
        GrafoDirigido gDirigido = new GrafoDirigido<>();
        ServicioDFS dfs = new ServicioDFS(gDirigido);
        ServicioBFS bfs = new ServicioBFS(gDirigido);

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
<<<<<<< HEAD
        gDirigido.agregarArco(3, 5, "p");
=======
>>>>>>> 483f9c302525e2441b202876a7b92383f218ebd4
        gDirigido.agregarArco(2, 4, "p");
        gDirigido.agregarArco(3, 1, "p");
        gDirigido.agregarArco(4, 3, "p");
        gDirigido.agregarArco(1, 5, "p");
        gDirigido.agregarArco(5, 4, "p");
        gDirigido.agregarArco(5, 6, "p");
        gDirigido.agregarArco(6, 4, "p");
        gDirigido.agregarArco(7, 8, "p");
        gDirigido.agregarArco(8, 4, "p");
        gDirigido.agregarArco(7, 6, "p");
        gDirigido.agregarArco(7, 5, "p");

<<<<<<< HEAD
        System.out.println(gDirigido.getTheBestRoad(1, 5));


         //recorrido DFS
        //  for (Integer valor : dfs.dfsForest()) {
        //      System.out.println(valor);
        //  }


        //recorrido BFS
        //for (Integer valor : bfs.bfsForest()) {
        //    System.out.println(valor);
        //}
=======
         //EJERCICIO 5
         System.out.println(gDirigido.routesToVertex(5));

         //EJERCICIO 6
         //System.out.println(gDirigido.getRouteBetweenVertexs(1, 4, 2));
>>>>>>> 483f9c302525e2441b202876a7b92383f218ebd4
        
    }
    
}
