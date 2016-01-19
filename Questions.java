import java.io.*;
import java.util.*;

public class Questions {
    //Math
    public static boolean generatePF() {
        int a = (int) (Math.random()*5+1);
        System.out.println("x^2+"+2*a+"x"+"+"+a*a);
        try {
            System.out.println("Find a root of the quadratic:");
            Scanner sc = new Scanner(System.in);
            int ans = sc.nextInt(); // Learn to use this on the docs. Also, please use tabs. :'( The whitespace made me sad.
            if (ans==a) return true;
        }
        catch (Exception e) { 
        return false;
        }
        return false;
    }
    
    
    //Art
    
    
    public static void main(String[] args) {
        System.out.println(generatePF());
    }
}
