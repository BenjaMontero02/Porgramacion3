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
        nuevoArbol.add(25);
        nuevoArbol.add(95);

        nuevoArbol.printPreOrder();
        System.out.println(nuevoArbol.delete(90));
        System.out.println("------------------------------------------------");
        nuevoArbol.printPreOrder();


        /*System.out.println(nuevoArbol.getFrontera());*/
        /*System.out.println(nuevoArbol.getLongestBranch());*/
        /*System.out.println(nuevoArbol.getMaxElem());*/
        /*System.out.println(nuevoArbol.getElemAtLevel(1));*/
        /*System.out.println(nuevoArbol.getSumInternos());*/
        /*System.out.println(nuevoArbol.getHigherValues(80));*/

        /*nuevoArbol.delete(); //Borra los internos
        System.out.println(nuevoArbol.getFrontera());
        System.out.println(nuevoArbol.completeTree()); //completa arbol y devuelve la raiz (hice el calculo y da bien la raiz)
        */
    }
}

