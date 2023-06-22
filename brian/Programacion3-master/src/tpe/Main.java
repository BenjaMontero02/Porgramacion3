package tpe;

public class Main {

	public static void main(String[] args) {

		//grafos, servicios
        
        GrafoNoDirigido grafo = new GrafoNoDirigido();
		String path = "./datasets/dataset1.txt";
		CSVReader reader = new CSVReader(path);
        Greedy greedy = new Greedy(reader);
        

        //VERTICES
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        

        //ARCOS
        grafo.agregarArco(1, 2, 15);
        grafo.agregarArco(1, 3, 20);
        grafo.agregarArco(1, 4, 30);
        grafo.agregarArco(2, 3, 15);
        grafo.agregarArco(2, 4, 25);
        grafo.agregarArco(3, 4, 50);

		reader.read();


        System.out.println("-------------------------------------------------------------------");
        
        
        System.out.println(greedy.resolucionGreedy(grafo));



		
	}

}
