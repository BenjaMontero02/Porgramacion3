package brian.Practico2;

import java.util.ArrayList;

public class Genero {

    private String nombre;
    private ArrayList<Book> libros;

    public Genero() {
        this.libros = new ArrayList<>();
    }

    public void addBook(Book book) {
        libros.add(book);
    }

}
