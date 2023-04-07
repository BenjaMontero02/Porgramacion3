public class MySimpleLinkedList<T> {
	
	private Node<T> first;
	private int sizeList;
	
	public MySimpleLinkedList() {
		this.first = null;
		this.sizeList = 0;
	}

	public Node<T> getFirstNode() {
		return this.first;
	}
	
	//inserta nuevo elemento en lista
	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info,null, null);
		tmp.setNext(this.first);
		if(!this.isEmpty()) {
			this.first.setBack(tmp);
		}
		this.first = tmp;
		this.sizeList++;
	}
	/*
	public void insertOrd(Node<T> nodo) {
		if(!isEmpty()) {
			int contador = 0;
			Node<T> tmpNext = this.first;
			Node<T> tmpAnterior = nodo;
			while(contador <= size()) {
				if(tmpNext.compareTo(nodo) != -1) {
					Node<T> nuevoNodo = new Node<T>(nodo.getInfo(), null, null);
					nuevoNodo.setNext(tmpNext);
					this.sizeList++;
				}
				else {
					contador++;
					tmpAnterior = tmpNext;
					tmpAnterior.setNext(nodo);
					if(tmpNext.getNext() != null) {
						tmpNext = tmpNext.getNext();
					}
				}
			}
		}
	}
	*/
	
	//devuelve primer elemento y lo elimina
	public T extractFront() {
		if(this.first != null) {
			T tmp = this.first.getInfo();
			this.first = this.first.getNext();
			this.first.setBack(null);
			this.sizeList--;
			return tmp;
		}
		else {
			return null;
		}
	}

	//devuelve lista vacia o no
	public boolean isEmpty() {
		if(this.first == null){
			return true;
		}
		return false;
	}
	
	//devuelve elemento dado por un indice
	public T get(int index) {
		
		if(this.size() > index) {
			int contador = 1;
			Node<T> tmp = this.first;
			while(contador < index) {
				tmp = tmp.getNext();
				contador++;
			}
			return tmp.getInfo();
		}
		return null;
	}
	
	//devuele tamaño lista
	public int size() {
		return this.sizeList;
	}

	//devuelve indice dado por un elemento
	public int indexOf(T o) {
		Node<T> temp = this.first;
		int contador = 0;
		while(temp !=null) {
			if(temp.getInfo().equals(o)) {
				return contador;
			}
			contador++;
			temp = temp.getNext();
		}
		return -1;
	}
	/*
	@Override
	public String toString() {
		Node<T> temp = this.first;
		String respuesta = "";
		for(int i = 0; i <= size(); i++) {
			respuesta += temp.getInfo().toString();
			temp = temp.getNext();
		}
		return respuesta;
	}
	*/
	@Override
	public String toString() {
		if(this.first != null) {
			this.first.getNext().toString();
			return this.first.getInfo().toString();
		}
		return "lista vacia";
	}

	public MySimpleLinkedList<T> newList(MySimpleLinkedList<T> la, MySimpleLinkedList<T> lb) {
		MyIterator l1 = la.getIterador();
		MyIterator l2 = lb.getIterador();
		
		return null;
	}
	
	public MyIterator getIterador() {
		return new MyIterator<>(this.first);
	}
	
}