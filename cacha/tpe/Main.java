import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        
        GrafoDirigido gDirigido = new GrafoDirigido<>();
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
        gDirigido.agregarArco(1, 2, null);
        gDirigido.agregarArco(2, 3, null);
        gDirigido.agregarArco(2, 4, null);
        gDirigido.agregarArco(1, 4, null);
        gDirigido.agregarArco(4, 3, null);
        gDirigido.agregarArco(1, 5, null);
        gDirigido.agregarArco(5, 4, null);
        gDirigido.agregarArco(5, 6, null);
        gDirigido.agregarArco(6, 4, null);
        gDirigido.agregarArco(7, 8, null);
        gDirigido.agregarArco(8, 4, null);
        gDirigido.agregarArco(7, 6, null);
        gDirigido.agregarArco(7, 5, null);

    //     gDirigido.borrarVertice(6);
    //     System.out.println(gDirigido.contieneVertice(6));

    //     Iterator it = gDirigido.obtenerArcos(5);

    //     while(it.hasNext()){
    //         Arco arco = (Arco) it.next();
    //         System.out.println(arco.getVerticeOrigen());
    //         System.out.println(arco.getVerticeDestino());
    //     }

    // System.out.println("------------------------------------");

    //     Iterator its = gDirigido.obtenerAdyacentes(5);

    //     while (its.hasNext()) {
    //         System.out.println(its.next());
    //     }

    gDirigido.borrarArco(5, 6);

    Iterator it = gDirigido.obtenerArcos(5);

    while(it.hasNext()){
        Arco arco = (Arco) it.next();
        System.out.println(arco.getVerticeOrigen());
        System.out.println(arco.getVerticeDestino());
    }

    System.out.println(gDirigido.existeArco(5, 6));
}
    
}
