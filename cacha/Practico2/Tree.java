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

	//No funca, preguntar mañana
	public void printPreOrder(){
		if(this.value != null){
			System.out.println(this.value + "");
			
			if(this.left != null) {
				this.left.printPosOrder();
			}
			
			if(this.right != null) {
				this.right.printPosOrder();
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

	public static void main(String[] args) {
		Tree newTree = new Tree(4);
		newTree.add(5);
		newTree.add(8);
		newTree.add(3);
		newTree.add(7);

		newTree.printPreOrder();
        //System.out.println(newTree.hasElement(3));
        //System.out.println(newTree.hasElement(5));
        //System.out.println(newTree.hasElement(7));
        //System.out.println(newTree.hasElement(8));
		//System.out.println(newTree.hasElement(9));

	}

}