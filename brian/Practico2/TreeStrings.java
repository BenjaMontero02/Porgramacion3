package brian.Practico2;

import java.util.ArrayList;

public class TreeStrings implements Comparable<String>{

    private String value;
	private TreeStrings left;
	private TreeStrings right;

	public TreeStrings(String value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
	
	public String getValue() {
		return value;
	}

    public TreeStrings getLeft() {
        return left;
    }

    public TreeStrings getRight() {
        return right;
    }

    public boolean isVowel(String letra) {
        if(letra == "a" || letra == "e" || letra == "i" || letra == "o" || letra == "u") {
            return true;
        }
        else {
            return false;
        }
    }

    public void printPreOrder() {
        if(this.value != null){
            System.out.print(this.value + " ");
            if (this.left != null) {
                this.left.printPreOrder();
            }
            if (this.right != null) {
                this.right.printPreOrder();
            }
        }
    }

    @Override
    public int compareTo(String o) {
        if(this.value.compareTo(o) == 1) {
            return 1;
        }
        else if(this.value.compareTo(o) == 0) {
            return 0;
        }
        else {
            return -1;
        }
    }

    private ArrayList<String> getPalabra(ArrayList<String> arr, String palabra, int n, int contador){
        // deberias cambiar el arreglo aux y instanciarlo en la funcion publica
        // xq si no cada vez q lo llamas recursivamente volves a instanciarlo

        if(isVowel(this.value)){
            contador++;
        }

        palabra += this.getValue();
        
        if(this.left == null && this.right == null){
            if(contador == n){
                arr.add(palabra);
            }
        }
        else{
            if(contador <= n){
                if(this.left != null){
                    arr.addAll(this.left.getPalabra(arr,palabra, n, contador));
                }
                if(this.right != null){
                    arr.addAll(this.right.getPalabra(arr,palabra, n, contador));
                }
            }
        }
        return arr;
    }

    public ArrayList<String> getPalabra(int n){
        int c = 0;
        String palabra = "";
        ArrayList<String> palabras = new ArrayList<>();
        return getPalabra(palabras, palabra, n, c);
    }
    
}
