package brian.Practico4;

import brian.Practico3.Grafo;
import brian.Practico3.GrafoDirigido;

public class mainBackTracking {
    public static void main(String[] args) {
        
        GrafoDirigido gDirigido = new GrafoDirigido<>();
        backTracking back = new backTracking(gDirigido, 10);

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

        System.out.println(back.getCaminoMasLargo(2, 4));
    }
    
}
