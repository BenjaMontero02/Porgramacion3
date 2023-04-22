import java.util.ArrayList;
import java.util.Collection;

public class Genero {
    private String nombre;
    private ArrayList<Libro> libros;

    public Genero(String nombre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>();
    }

    public void addToLibro(Libro libro) {
        //insertar ordenado;
        libros.add(libro);
    }

    public Collection<? extends Libro> getArrayListLibros() {
        return null;
    }

}
