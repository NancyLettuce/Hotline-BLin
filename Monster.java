import java.io.*;
import java.util.*;

public abstract class Monster{
    //Basic properties of all characters.
    public int HP;
    public int def;
    public int str;
    
    //properties
    int strInitial = 0;
    int defInitial = 0;
    int hpInitial = 0;
    //end of properties

    //for asking questions==================================================
    public ArrayList<String> types;//no real use, just to track methods
    private Map<String, String> map = new HashMap<String, String>();
    private ArrayList<String> names;
    private ArrayList<String> works;
    
    public ArrayList<Integer> data; //for sorting
    private ArrayList<Integer> holder;//to copy data
    
    int random = -1; //randomly generated number 
    int randMethod = -1; //number to keep track of methods
    
    //stores answer choices
    private String choice;

    protected int a = (int) (Math.random()*5+1);
    //correct answer for the math find root question
    protected int b = (int) (Math.random()*38+2);
    //correct answer for the math isPrime question
    private String title; //should store the thing you are looking for
    //for artists, stores painting names
    protected String sorted;//correct answer for sorted array
    protected int correctArt; //stores correct answer;
    //======================================================
    
    //constructor
    public Monster() {
        types = new ArrayList<String>();
        random = (int)(Math.random() * (types.size()+1));
        types.add("askRoot");
        types.add("askArtist");
        types.add("askSort");
        types.add("askPrime");
        map.put("\"The Water Lily Pond\"", "Claude Monet");
        map.put("Ballet Rehearsal", "Edgar Degas");
        map.put("\"The Basket of Apples\"", "Paul Cezanne");
        map.put("\"By the Seashore\"", "Pierre Renoir");
        map.put("\"The Potato Eaters\"", "Vincent van Gogh");
        map.put("\"The Persistence of Memory\"", "Salvador Dali");
        map.put("Canvas Covered in Paint Drops", "Jackson Pollock");
        map.put("\"Portrait of Adele Bloch-Bauer\"", "Gustave Klimt");
        map.put("The son of Man", "Rene Magritte");
        map.put("Fruits", "Paul Cezanne");        
    }
    
    //Dead or alive?
    public boolean isAlive(){
        return (HP > 0);
    }//
    
    //Accessors
    public int getDefense(){
        return def;
    }
    
    public abstract String about();

    //Taking damage
    public void lowerHP(int damage){
        this.HP -= damage;
    }
    
    //
    public int attack (Character other){
        int damage = (int)(Math.random() * (this.str - other.def));
        other.HP -= damage;
        return damage;
    }


    //asking questions ================================================
    
    //arrayList of artist names
    public void listOfNames() {
        names = new ArrayList<String>(map.values());
        //ArrayList names populated with keySet();
    }
    
    public void listOfWorks() {
        works = new ArrayList<String>(map.keySet());
        //ArrayList works populated with values of dictionary map
    }

    
    //====prime====================
    public void askPrime() {
        b = (int) (Math.random()*38+2);
        System.out.println("Is "+b+" prime?");
        System.out.println("\t1. True");
        System.out.println("\t2. False");
    }
    
    public boolean isPrime(int p) {
	if (p == 1) {
	    return false;
	}
	if (p == 2) {
	    return true;
	}
	for (int i = 2; i <= Math.sqrt(p) + 1; i++) {
	    if (p % i == 0) {
		return false;
	    }
	}
	return true;
    } 

    //=======root===============
    public void askRoot() {
        a = (int) (Math.random()*5+1);
        System.out.println("Find a root of the quadratic:");
        System.out.println("\tx^2+"+2*a+"x"+"+"+a*a);
    }

    //=========sort==============================
    //CS array generator
    public void populate(int size, int lo, int hi) {
    	data = new ArrayList<Integer>(size);
    	while( size > 0 ) {
    	    //     offset + rand int on interval [lo,hi]
    	    data.add( lo + (int)(Math.random() * hi) );
    	    size--;
    	}
    }//populates array
    
    public void askSort() {//prints out ArrayList moves
        String stuff = "Please sort this ArrayList in ascending order: \n";
        for (int i = 0; i < data.size(); i ++) {
            stuff += data.get(i) + ",";
        }
        stuff= stuff.substring(0,stuff.length()-1)+ "\n";
        System.out.println(stuff);
    }//prints array and asks about it
    
    private void sort() {
        holder = new ArrayList<Integer>(data);
        int pass = 0; //index of next value to be compared
	while (pass < holder.size()) {
	    //separates sorted from unsorted
	    for( int i = pass; i > 0; i-- ) {
		// swap the numbers if they are not in order
		if ( holder.get(i).compareTo( holder.get(i-1) ) < 0 ) {
		    holder.set( i, holder.set( i-1, holder.get(i) ) ); 
		}
		else {
		    break;
		}
	    }
	    pass ++;
	}
    }
    
    private void string() {
        sorted = "";
        for (int i = 0; i < holder.size(); i ++) {
            sorted += holder.get(i) + ",";
        }
        sorted = sorted.substring(0,sorted.length()-1);
    }

    
    //===========art=============
    public void askArtist() {
        ArrayList<String> nameCopy = names;//copy of names
        ArrayList<String> titleCopy = works;//copy of works
        ArrayList<String> answerChoices = new ArrayList<String>(4);//stores asnwer choices
        //stores values for each choice
        String A = "";
        String B = "";
        String C = "";
        String D = "";
        
        random = (int)(Math.random() * titleCopy.size());//generates random int
        title = titleCopy.get(random);//used to determine random work to ask about
        titleCopy.remove(title);//deleted to avoid repetition
        
        String multiChoice1[] = {"Who is the artist who painted " + title + "?"};
        int scorePro;
        int score;
        Scanner input = new Scanner(System.in);
        String userSelect1 =  multiChoice1[0];
        
        answerChoices.add(map.get(title));//adds artist who painted it to answer choices
        nameCopy.remove(map.get(title));//removes it from list of names
        for (int ctr = 0; ctr < 3; ctr ++) {
            String randName = "";
            random = (int)(Math.random() * (nameCopy.size()-1));
            randName = nameCopy.get(random);
            answerChoices.add(randName);//adds random name to answer choice
            nameCopy.remove(randName);//removes that name from nameCopy
        }

        if (userSelect1.equals(multiChoice1[0])) {
            System.out.println(multiChoice1[0]);
            random = (int)(Math.random() * (answerChoices.size()-1));
            //randomizes which element from answerChoice is used here
            A = answerChoices.get(random);//artist name
            System.out.println("\t1." + A);
            answerChoices.remove(answerChoices.get(random));//removes to avoid repetition
            //basically the same code repeated
            random = (int)(Math.random() * (answerChoices.size()-1));
            B = answerChoices.get(random);
            System.out.println("\t2." + B);
            answerChoices.remove(answerChoices.get(random));
            
            random = (int)(Math.random() * (answerChoices.size()-1));
            C = answerChoices.get(random);
            System.out.println("\t3." + C);
            answerChoices.remove(answerChoices.get(random));
            
            random = (int)(Math.random() * (answerChoices.size()-1));
            D = answerChoices.get(random);
            System.out.println("\t4." + D);
            
            System.out.println();
            
        }
        
        if (map.get(title) == A) {
            //if artist corresponding to the painting is A...
            correctArt = 1;
            //the correct choice is A
        }
        else if (map.get(title) == B) {
            correctArt = 2;
        }
        else if (map.get(title) == C) {
            correctArt = 3;
        }
        else if (map.get(title) == D) {
            correctArt = 4;
        }
            
    }
    
    // more multiple choice questions with similar structure
    public void askQuestion() {
	int size = (int)(Math.random() * 10) + 2;//used in populate
        int hi = (int)(Math.random() * 100);//used in populate
        int lo = (int)(Math.random() * 10);//used in populate
        randMethod = (int)(Math.random() * types.size());
        listOfNames();
        listOfWorks();
	populate(size, lo, hi);//populates array
        sort();
        string();//answer with sorted array
        System.out.println(types.get(randMethod));
        if (types.get(randMethod) == "askArtist") {
            askArtist();
        }
        else if (types.get(randMethod) == "askRoot") {
            askRoot();
        }
        else if (types.get(randMethod) == "askPrime") {
            askPrime();
        }
        else if (types.get(randMethod) == "askSort") {
            askSort();
        }
    }
}

