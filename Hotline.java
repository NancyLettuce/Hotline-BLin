/*=============================================

  =============================================*/

import java.io.*;
import java.util.*;

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

    /*=============================================
      void newGame() -- facilitates info gathering to begin a new game
      pre:  
      post: according to user input, modifies instance var for difficulty 
      and instantiates a Warrior
      =============================================*/
    public void newGame() {

	String s;
	String b; //what is displayed if you choose BLin

	s = "Welcome to Stuyvesant High School.\n";
	s += "Choose the Character you wish to play as: \n";
	s += "BLin is present for the first and second quest.\n";
	s += "All other characters are only present for the second quest.\n";
	s += "A few have special, hidden talents that may aid you on the quest.\n";
	s += "\t1: BLin: Our main character. You may choose his skill.\n";
	s += "\t2: Drake: He is skilled in Math.\n";
	s += "\t3: MooCow: He is skilled in CS.\n";
	s += "\t4: Mr.Brown: He is skilled in CS.\n";
	s += "\t5: Ernie: He is skilled in Art Appreciation.\n";
	s += "\t6: Alice: She is skilled in Art Appreciation.";
	
	System.out.println(s);
	
	try {
	    hero = Integer.parseInt( in.readLine() );
	}
	catch ( IOException e ) { }
	
	if (hero == 1) {//If choose BLin
	    b = "Think of the subject you are the most capable in:\n";
	    b += "\t1: CS\n";
	    b += "\t2: Math\n";
	    b += "\t3: Art Appreciation\n";
	    b += "Selection: ";
	    System.out.print( b );
		
	    try {
		vocation = Integer.parseInt( in.readLine() );
		//instantiate the player's character		    
	    }
	    catch ( IOException e ) {
		player = new BLinCS( );	
	    }

	    if (vocation == 1 ){
		player = new BLinCS( );	
	    }
	    else if (vocation == 2 ){
		player = new BLinMath( );	
	    }
	    else if (vocation == 3 ){
		player = new BLinArt( );	
	    }
	    System.out.println(player.about());
	    System.out.println("Onwards to assembling a team!");
	}//close BLin
	
	else if (hero == 2) {//if choose Drake
	    player = new Drake();
	}//close Drake
	else if (hero == 3) {//if choose MooCow
	    player = new MooCow();
	}//close MooCow		
	else if (hero == 4) {//if choose Mr.Brown
	    player = new MrBrown();
	}//close MrBrown	
	else if (hero == 5) {//if choose Ernie
	    player = new Ernie();
	}//close Ernie	
	else if (hero == 6) {//if choose Alice
	    player = new Alice();
	}//close Alice      
	System.out.println(player.about());
    }//end newGame()

    //takes a Monster and simulates combat with that Monster
    //returns false if dead, true if alice
    public boolean battle(Monster generic) {
	
	int descrip = 0;//used for printing description
	int i = 1;
	int choice = 0;//used when deciding whether or not to fight
	int d1, d2;
	
	//for Monster's description		
	try {
	    System.out.println("You see a Monster approaching.\n Do you wish to view its credentials?");
	    System.out.println("\t1: Yes\n\t2: No");
	    descrip = Integer.parseInt( in.readLine() );
	}
	catch ( IOException e ) { }
		
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
		    System.out.println("\t1: Attack\n\t2: Special" );
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
		    System.out.println("\t1: Fight\n\t2: Answer Question" );
		    choice =  Integer.parseInt( in.readLine() );
		    if (choice == 1) {
			try{
			    System.out.println("\t1: Attack\n\t2: Special" );
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
		    }
		    else if (choice == 2) {
			System.out.println("lol maybe later");
		    }
		}
		catch ( IOException e ) { }

	    }//ends Admission officer choice
			
	    else if (generic instanceof Teacher) {
		teach = (Teacher)generic;
		try {
		    System.out.println( "What will you do?" );	
		    System.out.println("\t1: Fight\n\t2: Answer Question" );
		    choice =  Integer.parseInt( in.readLine() );
		    if (choice == 1) {
			try{
			    System.out.println("\t1: Attack\n\t2: Special" );
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
		    }
		    else if (choice == 2) {
			System.out.println("lol maybe later");
		    }
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
    
    //implements battle
    public boolean questOne() {
    	teach = new Teacher();
    	return battle(teach);
    }

    public static void main( String[] args ) {

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

    }//end main
 
}//end class YoRPG

