package brian.Practico4;


public class mainBackTracking {
    public static void main(String[] args) {
        
        int num1 = 31;
        double pd = 0.9;
        int result = casteo(num1, pd);
        System.out.println(result);
    }

    public static int casteo(int num, double num2) {
        int result = (int)(num  * num2);
        return result;
    }
    
}
