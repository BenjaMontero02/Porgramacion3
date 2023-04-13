package brian.Practico2;

public class Main {
    public static void main(String[] args) {

        /*Prueba de funcionamiento altura de arbol */
        Tree nuevoArbol = new Tree(5);
        nuevoArbol.add(7);
        nuevoArbol.add(3);
        nuevoArbol.add(4);
        nuevoArbol.add(9);
        nuevoArbol.add(10);
        System.out.println(nuevoArbol.getHeight());
    }
}

