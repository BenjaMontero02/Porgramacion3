package brian.Practico2;

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
	
	public Integer getValue() {
		return value;
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

        private ArrayList<Integer> getLongestBranch(ArrayList<Integer> a1, ArrayList<Integer> a2)  {
            a1.add(this.value);
            a2.add(this.value);
            if(this.left != null) {
                a1.addAll(this.left.getLongestBranch(a1,a2));
            }
            if (this.right != null) {
                a2.addAll(this.right.getLongestBranch(a1,a2));
            }

            if(a1.size() > a2.size()) {
                return a1;
            }
            else {
                return a2;
            }
        }

        public ArrayList<Integer> getLongestBranch() {
            ArrayList<Integer> arr = new ArrayList<>();
            ArrayList<Integer> arr2 = new ArrayList<>();
            return getLongestBranch(arr, arr2);
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





}
