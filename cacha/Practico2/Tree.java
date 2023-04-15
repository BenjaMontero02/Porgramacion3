import java.util.ArrayList;

public class Tree {

	private Integer value;
	private Tree left;
	private Tree right;

	public Tree(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}

	public Integer getRoot() {
		return this.value;
	}

	public void add(Integer newValue) {
		if (newValue < this.value) {
			if (this.left == null)
				this.left = new Tree(newValue);
			else
				this.left.add(newValue);
		} else if (newValue > this.value) {
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
		if(this.value != null){
			System.out.println(this.value + "");
			
			if(this.left != null) {
				this.left.printPreOrder();
			}
			
			if(this.right != null) {
				this.right.printPreOrder();
			}
			
		}
	}

	public void printInOrder(){
		if(this.value!= null){
			
            if(this.left!= null) {
                this.left.printInOrder();
            }
            
            System.out.println(this.value + "");
            
            if(this.right!= null) {
                this.right.printInOrder();
            }
            
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
		if(this.value!= null){
            int sum = 0;
			sum += this.getAmountOfTheTree(sum);
			return sum;
        }

		return null;
	}

	private int getAmountOfTheTree(int sum){
		sum = this.value.intValue();
		if(this.left != null){
			sum += this.left.getAmountOfTheTree(sum);
		}
		
		if(this.right!= null){
			sum += this.right.getAmountOfTheTree(sum);
        }
		
		return sum ;
	}

	public static void main(String[] args) {
		Tree newTree = new Tree(50);
		newTree.add(70);
		newTree.add(30);
		newTree.add(90);
		newTree.add(80);
		newTree.add(40);
		newTree.add(36);
		newTree.add(38);
		newTree.add(100);
		

		System.out.println(newTree.getAmountOfTheTree());
        //System.out.println(newTree.hasElement(3));
        //System.out.println(newTree.hasElement(5));
        //System.out.println(newTree.hasElement(7));
        //System.out.println(newTree.hasElement(8));
		//System.out.println(newTree.hasElement(9));

	}

}