package cacha.Practico3;

public class main {
    public static void main(String[] args) {

        //grafo dirigido
        GrafoNoDirigido gDirigido = new GrafoNoDirigido<>();
        ServicioDFS dfs = new ServicioDFS(gDirigido);
        ServicioBFS bfs = new ServicioBFS(gDirigido);

        //agrego vertices
        gDirigido.agregarVertice(1);
        gDirigido.agregarVertice(2);
        gDirigido.agregarVertice(3);
        gDirigido.agregarVertice(4);
        gDirigido.agregarVertice(5);
        gDirigido.agregarVertice(6);
        gDirigido.agregarVertice(7);
        gDirigido.agregarVertice(8);


        //agreo arcos
        gDirigido.agregarArco(1, 2, "k");
        gDirigido.agregarArco(2, 3, "p");
        gDirigido.agregarArco(2, 4, "p");
        gDirigido.agregarArco(1, 4, "p");
        gDirigido.agregarArco(4, 3, "p");
        gDirigido.agregarArco(1, 5, "p");
        gDirigido.agregarArco(5, 4, "p");
        gDirigido.agregarArco(5, 6, "p");
        gDirigido.agregarArco(6, 4, "p");
        gDirigido.agregarArco(7, 8, "p");
        gDirigido.agregarArco(8, 4, "p");
        gDirigido.agregarArco(7, 6, "p");
        gDirigido.agregarArco(7, 5, "p");


        //System.out.println(gDirigido.getTheBestRoad(1, 5));

        //System.out.println(dfs.getAllRoadToGrafoFromVertice(gDirigido, 4)); 
         //recorrido DFS
        //  for (Integer valor : dfs.dfsForest()) {
        //      System.out.println(valor);
        //  }

        System.out.println(gDirigido.getAllRoads(1, 8, 5, 7));
        //recorrido BFS
        //for (Integer valor : bfs.bfsForest()) {
        //    System.out.println(valor);
        //}
        

    }
    
}
