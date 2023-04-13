package brian.Practico2;

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


        
    

}
