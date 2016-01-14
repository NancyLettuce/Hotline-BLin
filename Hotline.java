/*=============================================

  =============================================*/

import java.io.*;
import java.util.*;

public class Hotline {
    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~

    //change this constant to set number of encounters in a game
    public final static int MAX_ENCOUNTERS = 5;

    //each round, a Warrior and a Monster will be instantiated
    private Character player;   //Is it man or woman?
    private Monster smaug; //Friendly generic monster name, eh?
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
	s += "\t5: Ernie: He is skilled in Art Appreciation";
	s += "\t6: Alice: She is skilled in Art Appreciation";
	
	System.out.println(s);
	
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
		    //instantiate the player's character
		    if (vocation == 1 ){
			player = new BLinCS( );
			System.out.println(player.about());	
		    }
		    if (vocation == 2 ){
			player = new BLinMath( );
			System.out.println(player.about());	
		    }
		    if (vocation == 3 ){
			player = new BLinArt( );
			System.out.println(player.about());	
		    }
		}
		catch ( IOException e ) { }
	    }
	
	    else if (hero == 2) {//if choose Drake
		player = new Drake();
		System.out.println(player.about());
	    }
	    else if (hero == 3) {//if choose MooCow
		player = new MooCow();
		System.out.println(player.about());
	    }
		
	    else if (hero == 4) {//if choose Mr.Brown
		player = new MrBrown();
		System.out.println(player.about());
	    }
		
	    else if (hero == 5) {//if choose Ernie
		player = new Ernie();
		System.out.println(player.about());
	    }
		
	    else if (hero == 6) {//if choose Alice
		player = new Alice();
		System.out.println(player.about());
	    }
	}
	catch ( IOException e ) { }

    }//end newGame()

    public static void main( String[] args ) {

	//loading...
	Hotline game = new Hotline();

	int encounters = 0;
	game.newGame();
	/*
	  while( encounters < MAX_ENCOUNTERS ) {
	  if ( !game.playTurn() )
	  break;
	  encounters++;
	  System.out.println();
	  }
	*/
	System.out.println( "Game over." );

    }//end main
 
}//end class YoRPG

