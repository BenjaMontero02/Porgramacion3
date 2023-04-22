import java.util.ArrayList;

public class Tree {

	private String value;
	private Tree left;
	private Tree right;

	public Tree(String value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}

	public Integer getRoot() {
		return this.value;
	}

	public void add(String newValue) {
		if (newValue.compareTo(this.value) == 1) {
			if (this.left == null)
				this.left = new Tree(newValue);
			else
				this.left.add(newValue);
		} else if (newValue.compareTo(this.value) == -1) {
			if (this.right == null)
				this.right = new Tree(newValue);
			else
				this.right.add(newValue);
		}
	}

	public boolean hasElement(Integer value) {
		if (this.value > value) {
			if (this.left != null) {
				return this.left.hasElement(value);
			}
		} else if (this.value < value) {
			if (this.right != null) {
				return this.right.hasElement(value);
			}
		}

		if (this.value == value) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isEmpty() {
		return this.value == null;
	}

	public int getHeight() {
		int altura = 1;
		int auxAltura = 0;

		if (this.left != null) {
			auxAltura += this.left.getHeight();
		}

		if (this.right != null) {
			auxAltura += this.right.getHeight();
		}

		if (altura < auxAltura) {
			return auxAltura;
		}
		return altura;
	}

	//funca pero dudosamente
	public void printPosOrder(){
		if(this.value != null){
			
			if(this.left != null) {
				this.left.printPosOrder();
			}
			
			if(this.right != null) {
				this.right.printPosOrder();
			}
			
			System.out.println(this.value + "");
		}
	}

	public void printPreOrder(){
		
			System.out.println(this.value + "");
			
			if(this.left != null) {
				this.left.printPreOrder();
			}
			
			if(this.right != null) {
				this.right.printPreOrder();
			}
			
		
	}

	public void printInOrder(){
		
            if(this.left!= null) {
                this.left.printInOrder();
            }
            
            System.out.println(this.value + "");
            
            if(this.right!= null) {
                this.right.printInOrder();
            }
            
        
	}

	public ArrayList<Integer> getLongestBranch(){
		ArrayList<Integer> solucion = new ArrayList<Integer>();
		ArrayList<Integer> actual = new ArrayList<Integer>();

		return this.getLongestBranch(solucion, actual);
	}
	
	private ArrayList<Integer> getLongestBranch(ArrayList solucion, ArrayList actual) {
		if(this.value != null) {
			actual.add(this.value);

			if(this.left!= null) {
                this.left.getLongestBranch(solucion, actual);
            }

			if(solucion.size() < actual.size()) {
				solucion.clear();
				solucion.addAll(actual);
			}

			if(this.right != null) {
				this.right.getLongestBranch(solucion, actual);
			}

			if(solucion.size() < actual.size()) {
				solucion.clear();
				solucion.addAll(actual);
			}

			actual.remove(actual.size()-1);
			return solucion;

		}

		return null;
	}

	public ArrayList<Integer> getFrontera(){
		ArrayList<Integer> aux = new ArrayList<Integer>();

		return getFrontera(aux);
	}

	private ArrayList<Integer> getFrontera(ArrayList<Integer> aux){
		if(this.left == null && this.right == null){
			aux.add((Integer) this.value);
		}

		if(this.left != null){
			this.left.getFrontera(aux);
		}

		if(this.right != null){
			this.right.getFrontera(aux);
		}

		return aux;
	}

	public Integer getMaxElement(){
		if(this.value != null){
			Integer maxElement = this.value;

			return getMaxElement(maxElement);
		}

		return null;
	}

	private Integer getMaxElement(Integer maxElement) {

		if(maxElement < this.value){
			maxElement = this.value;
		}

		if(this.left != null){
			maxElement = this.left.getMaxElement(maxElement);
		}

		if(this.right != null){
			maxElement = this.right.getMaxElement(maxElement);
		}

		return maxElement;
	}

	/*

	Preguntar no se me ocurre como resolverlo, toy quemado

	public ArrayList<Integer> getElementAtLevel(int level){
		if(this.value != null){
				
			ArrayList<Integer> aux = new ArrayList<Integer>();

			if(level == 0){
					aux.add((Integer) this.value);
					return aux;
				}

				for(int i = 0; i != level-1; i++, level--){
					
				}
		}

		return null;
	} */

	public Integer getAmountOfTheTree(){
            int sum = 0;
			sum += this.getAmountOfTheTree(sum);
			return sum;
	}

	private int getAmountOfTheTree(int sum){
		if(this.value != null){
			sum = this.value.intValue();
		}
		if(this.left != null){
			sum += this.left.getAmountOfTheTree(sum);
		}
		
		if(this.right!= null){
			sum += this.right.getAmountOfTheTree(sum);
        }
		
		return sum ;
	}

	public ArrayList<Integer> getAllElementsMayoresToInt(int k){
        ArrayList<Integer> aux = new ArrayList<Integer>();

		if(this.value != null){
			
			return this.getAllElementsMayoresToInt(aux, k);
		}

        return null;
    }

	private ArrayList<Integer> getAllElementsMayoresToInt(ArrayList<Integer> aux, int k){

		if(this.left == null && this.right == null){
			
			if(this.value.intValue() == k){
				aux.add(this.value);
				return aux;
			}

		}else if(this.left != null){
			this.left.getAllElementsMayoresToInt(aux, k);
		}else if(this.right != null){
			this.right.getAllElementsMayoresToInt(aux, k);
		}

		return aux;
	}

	public void deleteValue(){
		if(this.right != null || this.left != null){
			this.value = null;
		}
		
		if(this.left != null){
			this.left.deleteValue();
		}

		if(this.right!= null){
            this.right.deleteValue();
        }
	}

	public void complete(){

		if(this.left != null){
			this.left.complete();
		}

		if(this.right != null){
			this.right.complete();
		}
	
		if(this.left == null && this.right != null){
			this.value = this.right.value - 0;
		}else if(this.right == null && this.left != null){
			this.value = 0 - this.left.value;
		}else if (this.left != null && this.right != null){
			this.value = this.right.value - this.left.value;
		}
	}

	public ArrayList<String> getWordsMaxVocal(int cant){

		ArrayList<String> array = new ArrayList<String>();
		String copy = null;

		int contador = 0;

		return this.getWordsMaxVocal(array, copy, cant, contador);
	}

	private ArrayList<String> getWordsMaxVocal(ArrayList<String> array, ArrayList<String> copy, int cant){

		if(this.value != null){

			
			if(isVocal(this.value) && cant != 0){
				copy += this.value;
				cant--;
			}else if(!isVocal(this.value)){
				copy += this.value;
			}

			if(this.left!= null){
                this.left.getWordsMaxVocal(array, copy, cant);
            }

			if(this.right != null){
				this.right.getWordsMaxVocal(array, copy, cant);
			}

			if(this.left == null && this.right == null && cant == 0){
				array.add(copy);
				copy.substring(0, copy.length() -1);
				
				if(isVocal(this.value)){
					cant++;
				}
			}
		}

		return array;
	}

	public boolean isVocal(String value){
		if(value == "a" || value == "e" || value == "i" || value == "o" || value == "u"){
			return true;
		}else{
			return false;
		}
	}
	
	public static void main(String[] args) {
		Tree newTree = new Tree("m");
        newTree.add("a");
        newTree.add("l");
		newTree.add("i");
		newTree.printPreOrder();

		// newTree.deleteValue();
		// newTree.complete();
		// System.out.println(newTree.getRoot());
	
		//System.out.println(newTree.getAmountOfTheTree());
        //System.out.println(newTree.hasElement(3));
        //System.out.println(newTree.hasElement(5));
        //System.out.println(newTree.hasElement(7));
        //System.out.println(newTree.hasElement(8));
		//System.out.println(newTree.hasElement(9));

	}

}