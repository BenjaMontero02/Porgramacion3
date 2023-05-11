package brian.Practico3;

public class main {
    public static void main(String[] args) {

        //grafo dirigido
        GrafoDirigido gDirigido = new GrafoDirigido<>();
        GrafoDirigido gDirigido2 = new GrafoDirigido<>();
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

        //agreo arcos
        gDirigido.agregarArco(1, 2, "k");
        gDirigido.agregarArco(1, 3, "p");
        gDirigido.agregarArco(2, 4, "p");
        gDirigido.agregarArco(4, 6, "p");
        gDirigido.agregarArco(4, 7, "p");
        gDirigido.agregarArco(3, 5, "p");
        gDirigido.agregarArco(5, 4, "p");
        gDirigido.agregarArco(4, 1, "p");

        // recorrido DFS
        // for (Integer valor : dfs.dfsForest()) {
        //     System.out.println(valor);
        // }


        //recorrido BFS
        for (Integer valor : bfs.bfsForest()) {
            System.out.println(valor);
        }
        

    }
    
}
