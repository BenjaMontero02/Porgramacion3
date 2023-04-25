package brian.Practico2;

import java.time.LocalDate;
import java.util.ArrayList;

public class Book {

    private String titulo;
    private String autor;
    private LocalDate fechaPub;
    private ArrayList<Genero> generos;
    private int cantEjemplares;

    public Book(String título, String autor, LocalDate añoPublicación, int cantEjemplares) {
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPub = añoPublicación;
        this.cantEjemplares = cantEjemplares;
        this.generos = new ArrayList<Genero>();
    }

    public void addGenero(Genero genero) {
        generos.add(genero);
        genero.addBook(this);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public LocalDate getFechaPub() {
        return fechaPub;
    }

    public ArrayList<Genero> getGeneros() {
        return generos;
    }

    public int getCantEjemplares() {
        return cantEjemplares;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setFechaPub(LocalDate fechaPub) {
        this.fechaPub = fechaPub;
    }

    public void setGeneros(ArrayList<Genero> generos) {
        this.generos = generos;
    }

    public void setCantEjemplares(int cantEjemplares) {
        this.cantEjemplares = cantEjemplares;
    }

    
    
}
