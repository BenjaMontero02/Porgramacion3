import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ServicioDFS {
    
    private HashMap<Integer, String> auxHashMap;
    private Grafo<?> grafo;
    private int value;

	public ServicioDFS(Grafo<?> grafo) {
		this.grafo = grafo;
        this.auxHashMap = new HashMap<Integer, String>();
        this.value = 0;
	}

	public List<Integer> dfsForest() {
        Iterator<Integer> it = this.grafo.obtenerVertices();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        while(it.hasNext()){
            Integer value = it.next();

            this.auxHashMap.put(value, "blanco");
        }

        it = this.grafo.obtenerVertices();

        while(it.hasNext()){
            int key = it.next();
            if(auxHashMap.get(key) == "blanco"){
                this.dfsVisit(key, arr);
            }
        }

		return arr;
	}

    private void dfsVisit(int key, ArrayList<Integer> arr){
        auxHashMap.replace(key, "amarillo");
        arr.add(key);

        Iterator<Integer> it = this.grafo.obtenerAdyacentes(key);

        while(it.hasNext()){
            int value = it.next();
            if(this.auxHashMap.get(value) == "blanco"){
                this.dfsVisit(value, arr);
            }
        }

        auxHashMap.replace(key, "negro");
    }

}