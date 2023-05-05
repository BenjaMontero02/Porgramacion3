package brian.Practico2;

import java.util.ArrayList;
import java.util.concurrent.CancellationException;

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

    private ArrayList<String> getPalabras(ArrayList<String> palabras, String palabra, int cantVocales){
        if(isVowel(this.value)) {
            cantVocales--;
            if(cantVocales == -1) {
                return palabras;
            }
        }
        palabra += this.value;

        if(cantVocales == 0 && this.left == null && this.right == null) {
            palabras.add(palabra);
            palabra = palabra.substring(1, palabra.length() - 1); //elimino ultimo caracter
            return palabras;
        }
        if(cantVocales == 0) {
            palabra = palabra.substring(1, palabra.length() - 1); //elimino ultimo caracter
            return palabras;
        }
        
        if(cantVocales > 0){
            if(this.left != null){
                palabras.addAll(this.left.getPalabras(palabras, palabra, cantVocales));
            }
            if(this.right != null){
                palabras.addAll(this.right.getPalabras(palabras, palabra, cantVocales));
            }
            if(this.left == null && this.right == null) {
                palabra = palabra.substring(1, palabra.length() - 1);
            }
        }
        
        return palabras;
    }

    public ArrayList<String> getPalabras(int cantVocales){
        if(this.value != null) {
            ArrayList<String> palabras = new ArrayList<>();
            String palabra = "";
            return this.getPalabras(palabras, palabra, cantVocales);
        }
        return null;
    }

    
    
}
