import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Libro> catalogos;
    private TreeString generos;

    public Biblioteca() {
        this.catalogos = new ArrayList<>();
        this.generos = new TreeString();
    }

    public void addLibro(Libro l1){
        this.catalogos.add(l1);
        
    }

    public void addGenero(Genero l1){
        this.generos.add(l1);
    }

    public int getCantEjById(int id){
        Libro l1 = this.catalogos.get(id); //se supone que buscar div/2 como metodo aprendido
        return l1.getEjemplates();
    }

    public ArrayList<Libro> getLibrosByGenero(String genero){
        ArrayList<Libro> l1 = new ArrayList<>();
        
        Genero g1 = this.generos.getGenero(genero); //deberia obtener del arbol binario de buscada de string el
                                                    //genero simplificando la buscada, mas eficientemente

        l1.addAll(g1.getArrayListLibros()); //esto deberia traer una copia de los libros que estan en ese genero

        return l1;
    }
}

// 1. Utilizaria una lista la cual se inserte ordenadamente, para luego cuando se pida buscar un libro por su
// identificador que en este caso seria un id(int) para que sea mas eficiente y rapida la busqueda, pueda dividirla
// para acortar cantidad de iteraciones;

// 2. Si utilizariamos un arbol binario de busqueda, en el cual se almacenaria, un string que sea el genero
// y como otro atributo guardariamos el objeto genero el cual va a tener un arraylist de libros, lo cual nos
// simplificara la busqueda cuando se pidan los servicios pedidos en el enunciado por la catedra





