package lucas.Practico2;

import javax.smartcardio.ATR;

public class Main {
    public static void main(String[] args) {

        /*Prueba de funcionamiento altura de arbol */
        Tree nuevoArbol = new Tree('m');
        nuevoArbol.addChar('a');
        nuevoArbol.addChar('i');
        nuevoArbol.addChar('l');
        nuevoArbol.addChar('n');
        nuevoArbol.addChar('a');
        nuevoArbol.addChar('o');
        nuevoArbol.addChar('s');
        nuevoArbol.addChar('o');
        nuevoArbol.addChar('a');
        /*System.out.println(nuevoArbol.getFrontera());*/
        /*System.out.println(nuevoArbol.getLongestBranch());*/
        /*System.out.println(nuevoArbol.getMaxElem());*/
        /*System.out.println(nuevoArbol.ListgetElemAtLevel(1));*/
        /*System.out.println(nuevoArbol.getSumaElementos());*/
        System.out.println(nuevoArbol.getPalabra(1));
    }
}

