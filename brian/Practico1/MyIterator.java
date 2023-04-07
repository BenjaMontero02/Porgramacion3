import java.util.Iterator;

public class MyIterator<T> implements Iterator<T> {

    private Node cursor;

    public <T> MyIterator(Node<T> obj) {
        this.cursor = obj;
    }



    @Override //pregunta si donde estoy parado hay algo para retornar
    public boolean hasNext() {
        return cursor != null;
    }

    public T get() {
        T temp = (T) this.cursor.getInfo();
        return temp;
    }

    @Override //me devuelve el objeto y pasa al siguiente
    public T next() {
        T temp = (T) this.cursor.getInfo();
        this.cursor = cursor.getNext();
        return temp;
    }

    public void nextNode() {
        this.cursor = cursor.getNext();
    }
    
}