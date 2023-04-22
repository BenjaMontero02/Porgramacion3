import java.time.LocalDate;
import java.util.ArrayList;

public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private LocalDate fechaPub;
    private TreeString treeGeneros;
    private int cantEjemplares;

    public Libro(String titulo, String autor, LocalDate fechaPub, int cantEjemplares, int id) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPub = fechaPub;
        this.treeGeneros = new TreeString();
        this.cantEjemplares = cantEjemplares;  
    }

    public void addGenero(Genero genero){
        this.treeGeneros.add(genero);
        genero.addToLibro(this);
    }

    public int getEjemplates() {
        return this.cantEjemplares;
    }

}
