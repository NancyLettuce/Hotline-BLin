import java.io.*;
import java.util.*;

public class Questions {
    //Math
    public static boolean askRoot() {
        int a = (int) (Math.random()*5+1);
        System.out.println("Find a root of the quadratic:");
        System.out.println("x^2+"+2*a+"x"+"+"+a*a);
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
        String multiChoice1[] = {"Who is the artist who has a well-known painting of haystacks?"};
        int scorePro;
        int score;
        Scanner input = new Scanner(System.in);
        String userSelect1 =  multiChoice1[0];

        if (userSelect1.equals(multiChoice1[0])) {
            System.out.println(multiChoice1[0]);
            System.out.println("A. Claude Monet");
            System.out.println("B. Pierre Renoir");
            System.out.println("C. Edgar Degas");
            System.out.println("D. Paul Cezanne");
            System.out.println();
            System.out.print("Your answer: ");
            String uSelect1 = input.next();

            switch (uSelect1.toUpperCase()){
                case "A":
                    uSelect1 = "Claude Monet";
                    System.out.println("Correct Answer :p\n\n");
                    break;
                case "B":
                    uSelect1 = "Pierre Renoir";
                    System.out.println("Nope\n\n");;
                    break;
                case "C":
                    uSelect1 = "Edgar Degas";
                    System.out.println("Nope\n\n");
                    break;
                case "D":
                    uSelect1 = "Paul Cezanne";
                    System.out.println("Nope\n\n");
                    break;
                default: 
                    uSelect1 = "Nope.\n\n";
                    System.out.println("Please select an option from the provided options!!!");
                    askArtist();
                }

        }
    }
    
    // more multiple choice questions with similar structure


    
    //testing
    public static void main(String[] args) {
        System.out.println(askRoot());
        askArtist();
    }
}
