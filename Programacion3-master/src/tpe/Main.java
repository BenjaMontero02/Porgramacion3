package tpe;

public class Main {

	public static void main(String[] args) {

		//grafos, servicios
        
        GrafoNoDirigido grafo = new GrafoNoDirigido();
		String path = "./datasets/dataset1.txt";
		CSVReader reader = new CSVReader(path);
        Greedy greedy = new Greedy();
		BackTracking back = new BackTracking();

		reader.read(grafo);


        System.out.println("-------------------------------------------------------------------");
        
        
        System.out.println(greedy.resolucionGreedy(grafo));
		System.out.println(back.back(grafo));



		
	}

}
