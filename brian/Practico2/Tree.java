package brian.Practico2;

import java.util.ArrayList;

import javax.security.sasl.AuthorizeCallback;

public class Tree {

	private Integer value;
	private Tree left;
	private Tree right;

	public Tree(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
	
	public Integer getValue() {
		return value;
	}
    public void setValue(Integer v) {
		this.value = v;
	}

    public Tree getLeft() {
        return left;
    }

    public Tree getRight() {
        return right;
    }

    public boolean hasElem(Integer num) {
        if(num != this.value) {
            if(num < getValue()) {
                if (this.left != null) {
                    return this.left.hasElem(num);
                }
            }
            else{
                if (this.right != null) {
                    return this.right.hasElem(num);
                }
            }
            return false;
        }
        else {
            return true;
        }
    }

    public boolean isEmpty() {
        return this.value == null;
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

    //numero mas a la izquierda del sub arbol derecho
    public int getNMI() {
        if (this.value != null && this.right != null) {
            int result = 0;
            return this.right.getNMI(result);
        }
        return 0;
    }
    private int getNMI(int result) {
        if(this.left != null) {
            return this.left.getNMI(result);
        }
        else {
            return this.value;
        }
    }

    //anda borrar: sin hijos, con un hijo
    private boolean delete(Integer node, int nmi) {

        if(node < this.value) {//the node is less than my root
            //left son
            if (this.left.getValue() == node && this.left.getLeft() == null && this.left.getRight() == null) { //its a LEAF
                this.left = null;
                return true;
            }
            if (this.left.getValue() == node && this.left.getLeft() != null && this.left.getRight() == null) { //has left
                this.left = this.left.getLeft();
                return true;
            }
            if (this.left.getValue() == node && this.left.getLeft() == null && this.left.getRight() != null) { //has right
                this.left = this.left.getRight();
                return true;
            }
            if (this.left.getValue() == node && this.left.getLeft() != null && this.left.getRight() != null) {
                nmi = this.left.getNMI();
                if(this.left.delete(nmi)) {
                    this.left.setValue(nmi);
                    return true;
                }
            }
            else {
                return this.left.delete(node,nmi);
            }
        }
        else {//the node is bigger to my root
            //right son
            if (this.right.getValue() == node && this.right.getLeft() == null && this.right.getRight() == null) { //its a LEAF
                this.right = null;
                return true;
            }
            if (this.right.getValue() == node && this.right.getLeft() != null && this.right.getRight() == null) { //has left
                this.right = this.right.getLeft();
                return true;
            }
            if (this.right.getValue() == node && this.right.getLeft() == null && this.right.getRight() != null) { //has right
                this.right = this.right.getRight();
                return true;
            }
            if (this.right.getValue() == node && this.right.getLeft() != null && this.right.getRight() != null) {
                nmi = this.right.getNMI();
                if(this.right.delete(nmi)) {
                    this.right.setValue(nmi);
                    return true;
                }
            }
            else {
                return this.right.delete(node,nmi);
            }
        }
        return false;
    }

    public boolean delete(Integer node) {
        if(this.value != null) {
            int nmi = 0;
            if (this.value == node && this.left != null && this.right != null) {
                nmi = this.getNMI();
                if(this.delete(nmi)) {
                    this.setValue(nmi);
                    return true;
                }
            }
            else {
                return this.delete(node,nmi);
            }
        }
        return false;
    }


    /* delete bruto de arbol 
    public void delete() {
        if(this.value != null && (this.left != null || this.right != null)) {
            this.value = null;
            if(this.left != null) {
                this.left.delete();
            }
            if(this.right != null) {
                this.right.delete();
            }
        }
    }
    */
    
    public Integer completeTree() {
        Integer antIzq=0;
        Integer antDer=0;
        return this.completeTree(antIzq, antDer);
    }
    private Integer completeTree(Integer antI,Integer antD) {
        if(this.value == null) {
            if (this.left != null){ //pregunto si left es null
                if(this.left.getValue() == null) { //pregunto si su valor es null
                    antI = this.left.completeTree(antI, antD);
                }
                else {
                    antI = this.left.getValue();
                }
            }
            else {
                antI = 0;
            }
            if (this.right != null) {
                if(this.right.getValue() == null) { //pregunto si su valor es nullo
                    antD = this.right.completeTree(antI, antD);
                }
                else {
                    antD = this.right.getValue();
                }
            }
            else {
                antD = 0;
            }

            this.value = (antD - antI);
        }
        return this.value;
    }

    public int getHeight() {
        int alturaIzq=0;
        int alturaDer=0;
        if(this.left != null) {
            alturaIzq = this.left.getHeight() + 1;
        }
        if (this.right != null) {
            alturaDer = this.right.getHeight() + 1;
        }
        if(alturaIzq < alturaDer) {
                return alturaDer;
        }
        else {
            return alturaIzq;
        }
        }

        public void printPostOrder() {
            if(this.value != null){
                if (this.left != null) {
                    this.left.printPreOrder();
                }
                if (this.right != null) {
                    this.right.printPreOrder();
                }
                System.out.print(this.value + " ");
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
        public void printInOrder() {
            if(this.value != null){
                if (this.left != null) {
                    this.left.printPreOrder();
                }
                System.out.print(this.value + " ");
                if (this.right != null) {
                    this.right.printPreOrder();
                }
            }
        }

    
        /*
        public ArrayList<Integer> getLongestBranch()  {
            ArrayList<Integer> list1 = new ArrayList<>();
            ArrayList<Integer> list2 = new ArrayList<>();
            list1.add(this.value);
            list2.add(this.value);
            if(this.left != null) {
                ArrayList<Integer> aux = this.left.getLongestBranch();
                list1.addAll(aux);
            }
            if (this.right != null) {
                ArrayList<Integer> aux = this.right.getLongestBranch();
                list2.addAll(aux);
            }
            if(list1.size() > list2.size()) {
                    return list1;
            }
            else {
                return list2;
            }
        }*/

        private ArrayList<Integer> getLongestBranch(ArrayList<Integer> solucion, ArrayList<Integer> actual)  {
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

        public ArrayList<Integer> getLongestBranch() {
            ArrayList<Integer> arr = new ArrayList<>();
            ArrayList<Integer> arr2 = new ArrayList<>();
            return this.getLongestBranch(arr, arr2);
        }

        public ArrayList<Integer> getFrontera() {
            ArrayList<Integer> arr = new ArrayList<>();
            return getFrontera(arr);
        }

        private ArrayList<Integer> getFrontera(ArrayList<Integer> arr) {
            if(this.left == null && this.right == null) {
                arr.add(this.value);
            }
            if(this.left != null) {
                this.left.getFrontera(arr);
            }
            if(this.right != null) {
                this.right.getFrontera(arr);
            }

            return arr;
        }

        public Integer getMaxElem(Integer solucion) {
            if(solucion < this.value){
                solucion = this.value;
            }
    
            if(this.left != null){
                solucion = this.left.getMaxElem(solucion);
            }
    
            if(this.right != null){
                solucion = this.right.getMaxElem(solucion);
            }
    
            return solucion;
        }

        //metodo publico
        public Integer getMaxElem() {
            if(this.value != null) {
                Integer solucion = this.value;
                return getMaxElem(solucion);
            }
            return null;
        }

        private ArrayList<Integer> getElemAtLevel(ArrayList<Integer> arr, int level, int jumps) {
            if(jumps == level) {
                arr.add(this.value);
            }
            else {
                if(this.left != null){
                    this.left.getElemAtLevel(arr, level, jumps+1);
                }
                if(this.right != null){
                    this.right.getElemAtLevel(arr, level, jumps+1);
                }
                return arr;
            }
            return null;
        }

        public ArrayList<Integer> getElemAtLevel(int level) {
            if(this.value != null) {
                ArrayList<Integer> list = new ArrayList<>();
                int jumps = 0;
                return this.getElemAtLevel(list, level, jumps);
            }
            return null;
        }

        private int getSumInternos(int suma) {
            if((this.left != null) || (this.right != null)) {
                suma = this.value;
                if(this.left != null){
                    suma += this.left.getSumInternos(suma);
                }
                if(this.right != null){
                    suma += this.right.getSumInternos(suma);
                }
                return suma;
            }

            return 0;
        }

        public int getSumInternos() {
            if(this.value != null) {
                int suma = 0;
                suma += this.getSumInternos(suma);
                return suma;
            }
            return 0;
        }

        public ArrayList<Integer> getHigherValues(ArrayList<Integer> arr, int k) {
            if(this.value > k) {
                arr.add(this.value);
                if(this.left != null) {
                    this.left.getHigherValues(arr, k);
                }
                if(this.right != null) {
                    this.right.getHigherValues(arr, k);
                }
            }
            else {
                if(this.right != null) {
                    this.right.getHigherValues(arr, k);
                }
            }
            return arr;
        }

        public ArrayList<Integer> getHigherValues(int k) {
            if(this.value != null) {
                ArrayList<Integer> list = new ArrayList<>();
                return this.getHigherValues(list, k);
            }
            return null;
        }

        


}
