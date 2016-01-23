import java.io.*;
import java.util.*;

public class Questions {
    
    public ArrayList<String> types;//no real use, just to track methods
    private Map<String, String> map = new HashMap<String, String>();
    int random = -1; //randomly generated number to determine which method to use/type of question to ask

    int a;//for the math question
    String title; //should store the thing you are looking for
    //for artists, stores painting names
    
    public Questions() {
        //random = (int)(Math.random() * (types.size()-1));
        types = new ArrayList<String>();
        random = (int)(Math.random() * (types.size()+1));
        types.add("askRoot");
        types.add("askArtist");
        types.add("populate");
        map.put("haystacks", "Claude Monet");
        title = "haystacks";
        
    }
    
    //WE ARE INSTANTIATING THIS IN THE EXECUTING FILE, SO NONE OF THEM NEED TO BE STATIC
    //Math
    public void askRoot() {
        a = (int) (Math.random()*5+1);
        System.out.println("Find a root of the quadratic:");
        System.out.println("x^2+"+2*a+"x"+"+"+a*a);

    }
    
    public boolean answer(){
        if (types.get(random) == "askRoot"){
            try {
                Scanner sc = new Scanner(System.in);
                int ans = sc.nextInt();
                if (ans==a) return true;
            }
            catch (Exception e) { 
                return false;
            }
        }
        else if (types.get(random) == "askArtist") {
            try {
                Scanner sc = new Scanner(System.in);
                String ans = sc.next();
                if (ans == map.get(title)) return true;
            }
            catch (Exception e) { 
                return false;
            }
        }
        return false;
    }
    
    //CS array generator
    public ArrayList populate( int size, int lo, int hi ) {
    	ArrayList<Integer> retAL = new ArrayList<Integer>();
    	while( size > 0 ) {
    	    //     offset + rand int on interval [lo,hi]
    	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
    	    size--;
    	}
    	return retAL;
    }
    //Art
    
    
    public void askArtist() {
        String multiChoice1[] = {"Who is the artist who has a well-known painting of " + title + "?"};
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
            
            /*
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
                */

        }
    }
    
    // more multiple choice questions with similar structure


    
    //testing
    public static void main(String[] args) {
        Questions q = new Questions();
        System.out.println(q.random);
        /*
        if (q.random == 0) {
            q.askRoot();
            System.out.println(q.answer());
        }
        */
        if (q.random == 0) {
            q.askArtist();
            System.out.println(q.answer());
        }
        /*
        System.out.println(askRoot());
        askArtist();
        */
    }
}
