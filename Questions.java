import java.io.*;
import java.util.*;

public class Questions {
    int a = (int) (Math.random()*5+1);
    //Math
    public static void askRoot() {
        System.out.println("Find a root of the quadratic:");
        System.out.println("x^2+"+2*a+"x"+"+"+a*a);
    }
    
    public static boolean checkRoot() {
        try {
            Scanner sc = new Scanner(System.in);
            int ans = sc.nextInt();
            if (ans==a) return true;
        }
        catch (Exception e) { 
        return false;
        }
        return false;
    }
    
    //CS array generator
    public static ArrayList populate( int size, int lo, int hi ) {
    	ArrayList<Integer> retAL = new ArrayList<Integer>();
    	while( size > 0 ) {
    	    //     offset + rand int on interval [lo,hi]
    	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
    	    size--;
    	}
    	return retAL;
    }
    //Art
    public static void askArtist() {
        System.out.println("");
    }
    
    public static boolean checkArtist() {
        try {
            Scanner sc = new Scanner(System.in);
            int ans = sc.nextInt();
            if (ans==a) return true;
        }
        catch (Exception e) { 
        return false;
        }
        return false;
    }
    
    
    public static askArtist {
    String[] multiChoice1;
    Scanner input = new Scanner(System.in);

    multiChoice1 = new String[5];
    multiChoice1[0] = "1. Which country currently emits the most greenhouse gases?\n";
    multiChoice1[1] = "blah blah";
    multiChoice1[2] = "blah blah";
    multiChoice1[3] = "blah blah";
    multiChoice1[4] = "blah blah";

    String userSelect1 = multiChoice1[0];

    if(userSelect1==multiChoice1[0]){
        System.out.println(multiChoice1[0]);
        System.out.println("A. United States");
        System.out.println("B. China");
        System.out.println("C. India");
        System.out.println("D. England");
        System.out.println();
        System.out.print("Your answer: ");
        String uSelect1 = input.next();

        switch (uSelect1.toUpperCase()){
            case "A":
                uSelect1 = "United States";
                System.out.println("Incorrect!\n\n");
                break;
            case "B":
                uSelect1 = "China";
                System.out.println("Correct!\n\n");
                scorePro++;
                score++;
                break;
            case "C":
                uSelect1 = "India";
                System.out.println("Incorrect!\n\n");
                break;
            case "D":
                uSelect1 = "England";
                System.out.println("Incorrect!\n\n");
                break;
            default: 
                uSelect1 = "Incorrect, choice.\n\n";
                break;
        }
    }
    // more multiple choice questions with similar structure
}


    
    //testing
    public static void main(String[] args) {
        System.out.println(generatePF());
    }
}
