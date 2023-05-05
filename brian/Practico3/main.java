package brian.Practico3;

public class main {
    public static void main(String[] args) {

        //grafo dirigido
        GrafoDirigido gDirigido = new GrafoDirigido<>();

        //agrego vertices
        gDirigido.agregarVertice(1);
        gDirigido.agregarVertice(2);
        gDirigido.agregarVertice(3);
        gDirigido.agregarVertice(4);
        gDirigido.agregarVertice(5);

        //agreo arcos
        gDirigido.agregarArco(1, 2, "k");
        gDirigido.agregarArco(1, 3, "p");
        gDirigido.agregarArco(1, 4, "p");
        gDirigido.agregarArco(3, 4, "p");
        gDirigido.agregarArco(3, 5, "p");
        gDirigido.agregarArco(1, 1, "p");

        // System.out.println(gDirigido.existeArco(3, 4)); 

        // gDirigido.borrarArco(3, 4);

        // System.out.println(gDirigido.existeArco(3, 4)); 

        gDirigido.borrarVertice(4);

        System.out.println(gDirigido.existeArco(1, 4)); 

        // gDirigido.existeArco(3, 4);
        

    }
    
}
