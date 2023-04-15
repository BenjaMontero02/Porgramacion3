package brian.Practico2;

public class Main {
    public static void main(String[] args) {

        /*Prueba de funcionamiento altura de arbol */
        Tree nuevoArbol = new Tree(50);
        nuevoArbol.add(70);
        nuevoArbol.add(30);
        nuevoArbol.add(90);
        nuevoArbol.add(80);
        nuevoArbol.add(40);
        nuevoArbol.add(36);
        nuevoArbol.add(38);
        nuevoArbol.add(100);
        /*System.out.println(nuevoArbol.getFrontera());*/
        System.out.println(nuevoArbol.getLongestBranch());
    }
}

