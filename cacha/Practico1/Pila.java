import java.lang.reflect.Array;

public class Pila<T> {
    
    private MySimpleLinkedList<T> myList;

    public Pila() {
        this.myList = new MySimpleLinkedList<>();
    }

    public void Push(T o) {
        this.myList.insertFront(o);
    }

    public T Pop() {
        return this.myList.extractFront();
    }

    public T Top() {
        return this.myList.get(1);
    }

    public void reverse() {
        MySimpleLinkedList<T> listReverse = new MySimpleLinkedList<>();
        while(!this.myList.isEmpty()) {
            listReverse.insertFront(this.myList.extractFront());
        }
        this.myList = listReverse;
    }


      

    //Ejercicio 7
    public MySimpleLinkedList<T> ejercicio7(MySimpleLinkedList<T> l1, MySimpleLinkedList<T> l2) {
        MySimpleLinkedList<T> newList = new MySimpleLinkedList<>();
        if(!l1.isEmpty() && !l2.isEmpty()) {
            int contadorL1 = 0;
            int contadorL2 = 0;
            Node<T> tmp = l1.getFirstNode();
            Node<T> tmp2 = l2.getFirstNode();
            boolean ocurrencia = false;
            while(contadorL1 <= l1.size()) { //recorre toda la lista 1
                while(contadorL2 <= l2.size()) { //recorre toda la lista 2
                    if(!tmp.getInfo().equals(tmp2.getInfo())) {
                        contadorL2++;
                        tmp2 = tmp2.getNext();
                    }
                    else {
                        ocurrencia = true;
                        contadorL2 = l2.size()+1;
                    }
                }
                if(!ocurrencia) {
                    newList.insertFront(tmp.getInfo());
                }
                contadorL1++;
                tmp = tmp.getNext();
            }
        }
        return newList;
    }


    // MAIN DE PRUEBAS
    public static void main(String[] args) {
        Pila l = new Pila<>();
        String texto = "neUquen";
        System.out.println(l.passToFibo(6, "", -1, 1));
        /*System.out.println(l.esCapicua(texto, 0, texto.length()-1));*/
    }

    //ejercicio 9
    public boolean esCapicua(String s, int i1, int i2) {
        char l1 = s.charAt(i1);
        char l2 = s.charAt(i2);
        if(i1 < i2) {
            if(l1 == l2) {
                i1++;
                i2--;
                return esCapicua(s, i1, i2);
            }
            else {
                return false;
            }
        }
        else {
            return true;
        }
    }


    //ejercicio 10

    //1)complejidad O(n) tenes que pasar por todas en el peor de los casos
    //2)el problema es que se van a apilar n bloques por que cada llamada recursiva
    //cosa que se puede evitar con un solo bloque(for, while), se duplica la informacion alpedo
    //3)al usar una lista V debe cambiar el algoritmo por que no tenemos control de las posiciones
    //como en un arreglo, habria que usar iterador o cambiar la estructura

    public boolean arrOrd(int [] arr, int pos) {
        if(pos < arr.length-1){
            if(arr[pos] <= arr[pos+1]) {
                pos++;
                return arrOrd(arr, pos);
            }
            else {
                return false;
            }
        }
        else {
            return true;
        }
    }

    //ejercicio 11
    public boolean findElement(int[]arr, int elem, int inicio, int fin) {
        int medio;
        if(inicio > fin) {
            return false;
        }
        else {
            medio = (inicio + fin)/2;
            if(elem > arr[medio]) {
                return findElement(arr, elem, medio+1, fin);
            }
            else {
                if(elem < arr[medio]) {
                    return findElement(arr, elem, inicio, medio-1);
                }
                else {
                    return true;
                }
            }
        }
    }

    //ejercicio 12
    public String passToBinari(int num, String numBinari) {
        if((num/2) >= 1) {
            numBinari = num%2 + numBinari;
            return passToBinari(num/2, numBinari);
        }
        else {
            return (numBinari = num%2 + numBinari);
        }
    }

    //ejercicio 13
    public String passToFibo(int nTerminos, String fibonazi, int n1, int n2) {
        if(fibonazi.length() < nTerminos) {
            fibonazi += n1+n2;
            return passToFibo(nTerminos, fibonazi, n2, n2+n1);
        }
        else {
            return fibonazi;
        }
    }
}
    
        



