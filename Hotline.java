/*=============================================
************************IMPORTANT*****************************************
I THINK WE WILL HAVE TO WRITE A HELPER FUNCTION TO ANSWER THE QUESTIONS
OTHERWISE I WILL DIE FROM NESTED IF STATEMENTS
IT IS SO CONFUSING TO KEEP TRACK OF OMG
  =============================================*/

import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class Hotline {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~

    //change this constant to set number of encounters in a game
    public final static int MAX_ENCOUNTERS = 5;

    //each round, a Warrior and a Monster will be instantiated
    private Character player;   
    private Monster generic;
    private AdmissionsOfficer admin;
    private Teacher teach;
    private Competitor student;
    int hero; //the role/number they choose to play

    private int moveCount;
    private boolean gameOver;
    private int difficulty;

    private InputStreamReader isr;
    private BufferedReader in;
    
    private int vocation = 0;
    public ArrayList<String> team = new ArrayList<String>();
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // ~~~~~~~~~~ DEFAULT CONSTRUCTOR ~~~~~~~~~~~
    public Hotline() {
	moveCount = 0;
	gameOver = false;
	isr = new InputStreamReader( System.in );
	in = new BufferedReader( isr );
	newGame();
    }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // ~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~
    
    private void pressAnyKeyToContinue() { 
	System.out.println("Press any key to continue...");
	try {
	    System.in.read();
	}  
      	catch(Exception e){
        }  
    }
 	
    /*=============================================
      void newGame() -- facilitates info gathering to begin a new game
      pre:  
      post: according to user input, modifies instance var for difficulty 
      and instantiates a Warrior
      =============================================*/
    
    public void newGame() {

	String s;
	String b; //what is displayed if you choose BLin
	
	///***********BLIN STUFF LATER WHEN WE HAVE ACCOUNT WORKING
	
	s = "";
	s += "Choose the Character you wish to play as: \n";
	s += "BLin is present for the first and second quest.\n";
	s += "All other characters are only present for the second quest.\n";
	s += "A few have special, hidden talents that may aid you on the quest.\n";
	s += "\t1: BLin: Our main character. You may choose his skill.\n";
	s += "\t2: Drake: He is skilled in Math.\n";
	s += "\t3: MooCow: He is skilled in CS.\n";
	s += "\t4: Mr.Brown: He is skilled in CS.\n";
	s += "\t5: Ernie: He is skilled in Art Appreciation.\n";
	s += "\t6: Alice: She is skilled in Art Appreciation.\nSelection: ";
	System.out.print(s);
		
	try {
	    hero = Integer.parseInt( in.readLine() );
	    if (hero == 1) {//If choose BLin
		b = "Think of the subject you are the most capable in:\n";
		b += "\t1: CS\n";
		b += "\t2: Math\n";
		b += "\t3: Art Appreciation\n";
		b += "Selection: ";
		System.out.print( b );
			
		try {
		    vocation = Integer.parseInt( in.readLine() );
		    if (vocation == 1 ){//BLin with CS skill
			player = new BLinCS( );
		    }
		    else if (vocation == 2 ){//BLin with Math skill
			player = new BLinMath( );
		    }
		    else if (vocation == 3 ){//BLin with Art Appreciation skill
			player = new BLinArt( );
		    }
		}
		catch ( IOException e ) { 
		    player  = new BLinCS();
		}
		//System.out.println(player.about());	
		System.out.println("Onwards to assembling a team!");
		/////HERE WE WILL HAVE FLOOR CHOICES
	    }
		
	    else if (hero == 2) {//if choose Drake
		player = new Drake();
		//System.out.println(player.about());
	    }
	    else if (hero == 3) {//if choose MooCow
		player = new MooCow();
		//System.out.println(player.about());
	    }
			
	    else if (hero == 4) {//if choose Mr.Brown
		player = new MrBrown();
		//System.out.println(player.about());
	    }
			
	    else if (hero == 5) {//if choose Ernie
		player = new Ernie();
		//System.out.println(player.about());
	    }
			
	    else if (hero == 6) {//if choose Alice
		player = new Alice();
		//System.out.println(player.about());
	    }
	}
	catch ( IOException e ) {
	    player = new BLinCS();
	}
	System.out.println(player.about());
	return;
    }//end newGame()


    //=============================================
    //
    public String answering(Monster generic) {
    	int i = 0;
    	String move = "";
    	System.out.println("lol maybe later");
    	System.out.println("Choose your course of action: ");
	System.out.print(player.toString()+"\nSelection: ");
	try {
	    i = Integer.parseInt( in.readLine() );
	    move = player.moves.get(i-1);//the move you chose 
	}
	catch ( IOException e ) { }
	if (i == 1) {
	    System.out.print("Your answer is: ");
	    System.out.println(player.specialOne("17", "10"));
	}
	else if (i ==2) {
	    System.out.println("so much left");
	}
	else if (i == 3) {
	    System.out.println("third move");
	}
	return player.answer; //initialized in Character.java
    }
      
    public boolean battle(Monster generic) {
	
	int descrip = 0;//used for printing description
	int i = 1; //used for choosing attacks
	int choice = 0;//used when deciding whether or not to fight
	int d1, d2;
	
	//generic = new Monster();

	//for Monster's description		
	try {
	    System.out.println("You see a Monster approaching.\n Do you wish to view its credentials?");
	    System.out.print("\t1: Yes\n\t2: No\nSelection: ");
	    descrip = Integer.parseInt( in.readLine() );
	}
	catch ( IOException e ) { 
	    descrip = 1;
	}
		
	if (descrip == 1) {
	    if (generic instanceof AdmissionsOfficer){
		admin = (AdmissionsOfficer)generic; //typecast generic to AdmissionsOfficer
		System.out.println(admin.about());
	    }
	    else if (generic instanceof Competitor) {
		student = (Competitor)generic;//typecast generic to Competitor
		System.out.println(student.about());
	    }
	    else if (generic instanceof Teacher) {
		teach = (Teacher)generic;//typecast generic to Teacher
		System.out.println(teach.about());
	    }
	}
	/////ends part regarding description
		
	while (generic.isAlive() && player.isAlive()) {
	    if (generic instanceof Competitor) {
		student = (Competitor)generic;
		try {
		    System.out.println( "What will you do?" );
		    System.out.println("\t1: Attack\n\t2: Special\nSelection: " );
		    i = Integer.parseInt( in.readLine() );
		}
		catch ( IOException e ) { }
		if ( i == 2 )
		    player.specialize();
		else
		    player.normalize();
				    		
		d1 = player.attack( student );
		d2 = student.attack( player );
		System.out.println( "\n" + player.getName() + " dealt " + d1 +
				    " points of damage.");
		System.out.println( "\n" + "Competitor dealt " + player.getName() + " " +
				    d2 + " points of damage.");	
	    } //ends Competitor choice
				
	    else if (generic instanceof AdmissionsOfficer) {
		admin = (AdmissionsOfficer)generic; 
		try {
		    System.out.println( "What will you do?" );	
		    System.out.print("\t1: Fight\n\t2: Answer Question\nSelection: " );
		    choice =  Integer.parseInt( in.readLine() );
		    if (choice == 1) {//fight
			try{
			    System.out.print("\t1: Attack\n\t2: Special\nSelection: " );
			    i = Integer.parseInt( in.readLine() );
			}
			catch ( IOException e ) { }
			if ( i == 2 )
			    player.specialize();
			else
			    player.normalize();
					    		
			d1 = player.attack( admin );
			d2 = admin.attack( player );
			System.out.println( "\n" + player.getName() + " dealt "
					    + d1 +" points of damage.");
			System.out.println( "\n" + "AdmissionsOfficer dealt" +
					    player.getName() +d2 + " points of damage.");	
		    }//end fight
		    else if (choice == 2) {//question
		        answering(admin);
		    }//end question
		}
		catch ( IOException e ) { }
	
	    }//ends Admission officer choice
				
	    else if (generic instanceof Teacher) {
		teach = (Teacher)generic;
		try {
		    System.out.println( "What will you do?" );	
		    System.out.print("\t1: Fight\n\t2: Answer Question\nSelection: " );
		    choice =  Integer.parseInt( in.readLine() );
		    if (choice == 1) {//fight
			try{
			    System.out.print("\t1: Attack\n\t2: Special\nSelection: " );
			    i = Integer.parseInt( in.readLine() );
			}
			catch ( IOException e ) { }
			if ( i == 2 )
			    player.specialize();
			else
			    player.normalize();
					    		
			d1 = player.attack( teach );
			d2 = teach.attack( player );
			System.out.println( "\n" + player.getName() + " dealt "
					    + d1 + " points of damage.");
			System.out.println( "\n" + "Teacher dealt " +
					    player.getName() + " " + d2 + " points of damage.");	
		    }//end fight
		    else if (choice == 2) {//question
			answering(teach);
		    }//end question
		}
		catch ( IOException e ) { }
		    	
	    }//ends Teacher choice
	}//ends while loop
		
	//option 1: both die
	if ( !generic.isAlive() && !player.isAlive() ) {
	    System.out.println( "Oops you both die" );
	    return false;
	}
	//option 2: you defeat the Monster
	else if ( !generic.isAlive() ) {
	    System.out.println( "You have defeated the Monster!" );
	    return true;
	}
	//option 3: the monster kills you
	else if ( !player.isAlive() ) {
	    System.out.println( "You are dead." );
	    return false;
	}
	    
	return true;
	   
    }//end battle()
    
    public boolean questOne() {
    	teach = new Teacher();
    	return battle(teach);
    }
    
    
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    public static void main( String[] args ) {

	//As usual, move the begin-comment bar down as you progressively 
	//test each new bit of functionality...
	
	System.out.println("This does not work yet for anything other than BLinCS because of organization+lack of code.");
	System.out.println("Also, we need a helper function for answering questions because these nested if statements will will us before the quests do");

	//loading...
	Hotline game = new Hotline();

	int encounters = 0;

	while( encounters < MAX_ENCOUNTERS ) {
	    if ( !game.questOne() )
		break;
	    encounters++;
	    System.out.println();
	}

	System.out.println( "Game over." );
	/*=============================================

	  =============================================*/

    }//end main

}//end class YoRPG




/*=============================================
  =============================================*/
