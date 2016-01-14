/*=============================================

  =============================================*/

import java.io.*;
import java.util.*;

public class Hotline {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~

    //change this constant to set number of encounters in a game
    public final static int MAX_ENCOUNTERS = 5;

    //each round, a Warrior and a Monster will be instantiated
    private Character pat;   //Is it man or woman?
    private Monster smaug; //Friendly generic monster name, eh?

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
	s += "\t5: Ernie: He is skilled in Art Appreciation";
	s += "\t6: Alice: She is skilled in Art Appreciation";
	
	try {
	    hero = Integer.parseInt( in.readLine() );
	}
	catch ( IOException e ) { }

	if (hero == 1) {//If choose BLin
		System.out.println("Your name is Hotline BLin.\n");
		System.out.println("Starting last week, your girlfriend, Rubik's Cube, has been acting quite distant.");
		System.out.println("She did not return your texts, calls, or emails. Then you finally realized: She's missing.");
		System.out.println("Here is a picture of the love of your life:");
		System.out.println("   ___ ___ ___" +
	"   /___/___/___/|" +
	"  /___/___/___/||" +
	" /___/___/__ /|/|" +
	"|   |   |   | /||" +
	"|___|___|___|/|/|" +
	"|   |   |   | /||" +
	"|___|___|___|/|/" +
	"|   |   |   | /" +
	"|___|___|___|/")
			
		b = "Think of the subject you are the most capable in:\n";
		b += "\t1: CS\n";
		b += "\t2: Math\n";
		b += "\t3: Art Appreciation\n";
		b += "Selection: ";
		System.out.print( b );
		
		try {
		    vocation = Integer.parseInt( in.readLine() );
		}
		catch ( IOException e ) { }
	
	
		//instantiate the player's character
		if (vocation == 1 ){
			 BLin = new BLinCS( );}
		if (vocation == 2 ){
			 BLin = new BLinMath( );}
		if (vocation == 3 ){
			  BLin = new BLinArt( );}
		}
    }
	
	else if (hero == 2) {//if choose Drake
		player = new Drake();
		System.out.println(player.about());
	}
	else if (hero == 3) {//if choose MooCow
		player = new MooCow();
	}
	
	else if (hero == 4) {//if choose Mr.Brown
		player = new MrBrown();
	}
	
	else if (hero == 5) {//if choose Ernie
		player = new Ernie();
	}
	
	else if (hero == 6) {//if choose Alice
		player = new Alice();
	}
	
	//System.out.println (pat.details + "\n");
		 




    }//end newGame()


    /*=============================================
      boolean playTurn -- simulates a round of combat
      pre:  Character pat has been initialized
      post: Returns true if player wins (monster dies).
            Returns false if monster wins (player dies).
      =============================================*/
    public boolean playTurn() {

	int i = 1;
	int d1, d2;

	if ( Math.random() >= ( difficulty / 3.0 ) )
	    System.out.println( "There doesn't seem to anything here. You decided to move on." );

	else {
	    System.out.println( "A monster approaches! Activating combat mode!" );
	    

	    smaug = new Monster();

	    while( smaug.isAlive() && pat.isAlive() ) {

		// Give user the option of using a special attack:
		// If you land a hit, you incur greater damage,
		// ...but if you get hit, you take more damage.
		try {
		    System.out.println( "What will you do?" );
		    System.out.println( "\t1: Attack\n\t2: Special\n\t3: Heal" );
		    i = Integer.parseInt( in.readLine() );
		}
		catch ( IOException e ) { }
		
		if (vocation == 1){
		    ((Warrior)pat).normalize();}
		if (vocation == 2){
		    ((Wizard)pat).normalize();}
		if (vocation == 3){
		    ((Rogue)pat).normalize();}
		if (vocation == 4){
		    ((Archer)pat).normalize();}
		if (vocation == 5){
		    ((Priest)pat).normalize();}

		if ( i == 2 ){
			if (vocation == 1){
		    ((Warrior)pat).specialize();}
		    if (vocation == 2){
		    ((Wizard)pat).specialize();}
		     if (vocation == 3){
		    ((Rogue)pat).specialize();}
		    if (vocation == 4){
		    ((Archer)pat).specialize();}
		    if (vocation == 5){
		    ((Priest)pat).specialize();}}
		    
		if ( i == 3 ){
			if (vocation == 1){
		    ((Warrior)pat).recover();}
		    if (vocation == 2){
		    ((Wizard)pat).recover();}
		     if (vocation == 3){
		    ((Rogue)pat).recover();}
		    if (vocation == 4){
		    ((Archer)pat).recover();}
		    if (vocation == 5){
		    ((Priest)pat).recover();}}
		    
		    
	
		    

		d1 = pat.attack( smaug );
		d2 = smaug.attack( pat );
		
		
		
		if (d1 <= 0){
			d1 = 0;
		}
		
		if (d1 > 9999){
			d1 = 9999;
		}
		
		if (d2 <= 0){
			d2 = 0;
		}
		
		if (!(pat.healing)){
		System.out.println( "You" + " dealt " + d1 +
				    " points of damage.");
		if (pat.crit){
			System.out.println("It's a critical hit!");
		}}
				    

		System.out.println( "The enemy hit back for " + d2 +
				    " points of damage.");
		
		if (smaug.crit){
			System.out.println("It's a critical hit!");
		}
				    
	
	    }//end while

	    //option 1: you & the monster perish
	    if ( !smaug.isAlive() && !pat.isAlive() ) {
		System.out.println( "'Twas an epic battle, to be sure... " + 
				    "You cut ye olde monster down, but " +
				    "with its dying breath ye olde monster. " +
				    "laid a fatal blow upon thy skull." );
		return false;
	    }
	    //option 2: you slay the beast
	    else if ( !smaug.isAlive() ) {
		System.out.println( "Conglaturations! You gained an insignificant amount of experience points.\n");
		if (Math.random() >= .5){
			System.out.println( "The monster left a cookie! Restored health!" );
			pat.HP = pat.hpInitial;

		}
		return true;
	    }
	    //option 3: the beast slays you
	    else if ( !pat.isAlive() ) {
		System.out.println( "GG. Welcome to die." );
		return false;
	    }
	}//end else

	return true;
    }//end playTurn()
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    public static void main( String[] args ) {

	//As usual, move the begin-comment bar down as you progressively 
	//test each new bit of functionality...

	//loading...
	Hotline game = new Hotline();

	int encounters = 0;

	while( encounters < MAX_ENCOUNTERS ) {
	    if ( !game.playTurn() )
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
