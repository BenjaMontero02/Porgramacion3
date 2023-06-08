package cacha.Practico3;

import java.util.ArrayList;

public class Greedy{
    private static int puntero = 0;

    public ArrayList<Integer> ej1(ArrayList<Integer> c, int totalAPagar){
        ArrayList<Integer> solucion = new ArrayList<Integer>();
        while(totalAPagar != 0){
            //me selecciona del conjunto de candidatos el valor mas grande, dependiendo el puntero
            int valor = seleccionar(c); 
            if((totalAPagar - valor) >= 0){
                solucion.add(valor);
                totalAPagar = totalAPagar - valor;
            }else{
                puntero++;
            }
        }

        return solucion;
    }

    

    
}