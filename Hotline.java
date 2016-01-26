/*=============================================
************************IMPORTANT*****************************************

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

    private ArrayList<String> floors;//the floors

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
		floors = new ArrayList<String>(3);
		floors.add("\t1: Art Department\n");
		floors.add("\t2: Math Department\n");
		floors.add("\t3: CS Department\n");
    }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // ~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~
    
    
    private static void pressAnyKeyToContinue() {
	System.out.println("\n______________________________________________");
        System.out.println("Press enter to continue...");
	Scanner keyboard = new Scanner(System.in);
	keyboard.nextLine();
    }
 	
    /*=============================================
      void newGame() -- facilitates info gathering to begin a new game
      pre:  
      post: according to user input, modifies instance var for difficulty 
      and instantiates a Warrior
      =============================================*/
    public void newGame() {

	String story;
	String b; //what is displayed if you choose BLin
	story = "This is Hotline BLin.\n";
	story += "\n          (.,------...__" +"\n"
	    +"         _.'\"             `."+"\n"
	    +"       .'  .'   `, `. `.    `"+"\n"
	    +"      . .'   .'/''--...__`.  \\"+"\n"
	    +"      . .--.`.  ' \"-.     '.  |"+"\n"
	    +"      ''  .'  _.' .())  .--\":/"+"\n"
	    +"      ''(  \\_\\      '   (()("+"\n"
	    +"      ''._'          (   \\ '"+"\n"
	    +"      ' `.            `--'  '"+"\n"
	    +"       `.:    .   `-.___.'  '"+"\n"
	    +"        `.     .    _  _  .'"+"\n"
	    +"          )       .____.-'"+"\n"
	    +"        .'`.        (--.."+"\n"
	    +"      .' \\  /\\      / /  `."+"\n"
	    +"    .'    \\(  \\    /|/     `."+"\n"
	    +"  .'           \\__/          `."+"\n"
	    +"/      |        o      |      \\"+"\n"
	    +"       |               |      |";
	System.out.println(story);
	story = "Starting last week, his girlfriend, Rubik's Cube, has been acting quite distant.\n";
	story += "She did not return any of his texts, calls, or emails. Then he finally realized: She's missing.\n";
	System.out.println(story);
	story = "Here is a picture of the love of his life:\n";
	pressAnyKeyToContinue();
	System.out.println(story);
	story = "    ___ ___ ___\n" +
	    "   /___/___/___/|\n" +
	    "  /___/___/___/||\n" +
	    " /___/___/__ /|/|\n" +
	    "|   |   |   | /||\n" +
	    "|___|___|___|/|/|\n" +
	    "|   |   |   | /||\n" +
	    "|___|___|___|/|/\n" +
	    "|   |   |   | /\n" +
	    "|___|___|___|/\n";
	System.out.println(story);
	pressAnyKeyToContinue();
	story = "\nMission: Help BLin find his true love, which will also magically guarantee his acceptance to his dream school, MIT.";
	System.out.println(story);
	pressAnyKeyToContinue();
	story = "Quest 1: Gather a team.";
	System.out.println(story);
	pressAnyKeyToContinue();
		
	b = "Think of the subject you are the most capable in:\n";
	b += "\t1: CS\n";
	b += "\t2: Math\n";
	b += "\t3: Art Appreciation\n";
	b += "Selection: ";
	System.out.print( b );
			
	try {
	    Scanner stuff = new Scanner(System.in);
	    vocation = stuff.nextInt();
	    if (vocation == 1 ){//BLin with CS skill
		player = new BLinCS( );
		team.add("BLinCS");
	    }
	    else if (vocation == 2 ){//BLin with Math skill
		player = new BLinMath( );
		team.add("BLinMath");
	    }
	    else if (vocation == 3 ){//BLin with Art Appreciation skill
		player = new BLinArt( );
		team.add("BLinArt");
	    }
	    else {
		player = new BLinCS( );
		team.add("BLinCS");
	    }
	}
	catch ( Exception e ) { 
	    player  = new BLinCS();
	    team.add("BLinCS");
	}
	System.out.println(player.about());
	return;
    }//end newGame()




    //=============================================
    public boolean checkAnswer(Monster gen){
    	int i = 0;
    	String move = "";
    	
    	System.out.println("Choose your course of action: ");
	System.out.print(player.toString());
	System.out.print("I wish to: ");

	if (gen instanceof AdmissionsOfficer) {
	    try {
		Scanner please = new Scanner(System.in);
		i = please.nextInt();
	    }
	    catch (Exception e) { 
                System.out.println("Your move does not exist");
            }
	    if (i == 1) {
		if (player instanceof Ernie || player instanceof BLinArt) {
		    System.out.println("You chose to directly answer");
		}
		else {
		    //System.out.println("You used " + player.moves.get(0));
		    System.out.print("The result of your move is: ");
		    player.specialOne(gen.b, gen.number);
		    System.out.println(player.answer); //initialized in Character.java
		}
	    }
	    else if (i == 2) {
		if (player instanceof BLinArt) {
		    System.out.println("You used " + player.moves.get(1));
		}
		else {
		    System.out.println("You used " + player.moves.get(1));
		    System.out.print("The result of your move is: ");
		    player.specialOne(gen.b, gen.number);
		    System.out.println(player.answer); //initialized in Character.java
		}
	    }
	    else if (i == 3) {
		System.out.println("You used " + player.moves.get(2));
		System.out.print("The result of your move is: ");
		player.specialThree(gen.a, gen.num, gen.data); //initialized in Character.java
		System.out.println(player.answer); 
	    }
	    else if (i ==4) {
		System.out.println("You used " + player.moves.get(2));
		System.out.println("You chose to directly answer");
	    }	    
	    else {
		System.out.println("You chose to directly answer");
	    }
	}
	else {
	    try {
		Scanner please = new Scanner(System.in);
	        i = please.nextInt();
	    }
	    catch ( Exception e ) {
		System.out.print("Your Move does not exist");
	    }
	    if (i == 1 && gen.types.get(gen.randMethod) == "askRoot" || gen.types.get(gen.randMethod) == "askDecimal" || gen.types.get(gen.randMethod) == "askArtist") {
		System.out.println("You used " + player.moves.get(0));
		System.out.print("The result of your move is: ");
		player.specialOne(gen.b, gen.number);
		System.out.println(player.answer); //initialized in Character.java
	    }
	    else if (i ==2 && gen.types.get(gen.randMethod) == "askPrime" || gen.types.get(gen.randMethod) == "askConversion") {
		System.out.println("You used " + player.moves.get(1));
		System.out.print("The result of your move is: ");
		player.specialTwo(gen.number, gen.b);
		System.out.println(player.answer); //initialized in Character.java
	    }
	    else if (i == 3 && gen.types.get(gen.randMethod) == "askSort" || gen.types.get(gen.randMethod) == "askProduct") {
		System.out.println("You used " + player.moves.get(2));
		System.out.print("The result of your move is: ");
		player.specialThree(gen.a, gen.num, gen.data); //initialized in Character.java
		System.out.println(player.answer); 
	    }
	    else  {
		System.out.println("You chose to directly answer");
	    }
	}
	System.out.print("\n"+"Enter your answer: ");
		
	if (gen instanceof AdmissionsOfficer) {
	    try {
                Scanner sc = new Scanner(System.in);
                int ans = sc.nextInt();
                if (ans == gen.correctArt) return true;
            }
            catch (Exception e) { 
                return false;
            }
	}
		
        if (gen.types.get(gen.randMethod) == "askRoot"){
            try {
                Scanner sc = new Scanner(System.in);
                int ans = sc.nextInt();
                if (ans==gen.a) return true;
            }
            catch (Exception e) { 
                return false;
            }
        }
        else if (gen.types.get(gen.randMethod) == "askArtist") {
            try {
                Scanner sc = new Scanner(System.in);
                int ans = sc.nextInt();
                if (ans == gen.correctArt) return true;
            }
            catch (Exception e) { 
                return false;
            }
        }
        
        else if (gen.types.get(gen.randMethod) == "askPrime") {
            try {
                Scanner sc = new Scanner(System.in);
                int ans = sc.nextInt();
                if ((ans==1) && gen.isPrime(gen.a)) return true;//used to be b
                if ((ans==2) && !gen.isPrime(gen.a)) return true;//change back if need be
                return false;
            }
            catch (Exception e) { 
                return false;
            }
        }
        else if (gen.types.get(gen.randMethod) == "askSort") {
	    try {
		Scanner sc = new Scanner(System.in);
		String ans = sc.nextLine();
		if (ans.compareTo(gen.sorted) ==0) {
		    return true;
		}
		else {
		    return false;
		}
	    }
	    catch (Exception e) { 
                return false;
            }
        }
        else if (gen.types.get(gen.randMethod) == "askProduct") {
	    try {
		Scanner sc = new Scanner(System.in);
		int ans = sc.nextInt();
		if (ans == (gen.num * gen.a)) {
		    return true;
		}
		else {
		    return false;
		}
	    }
	    catch (Exception e) { 
                return false;
            }
        }
        else if (gen.types.get(gen.randMethod) == "askDecimal") {
	    try {
                Scanner sc = new Scanner(System.in);
                String ans = sc.nextLine();
                if (gen.isDecimal(ans, gen.a)) return true;
                return false;
            }
            catch (Exception e) { 
                return false;
            }
        }
        else if (gen.types.get(gen.randMethod) == "askConversion") {
	    try {
                Scanner sc = new Scanner(System.in);
                String ans = sc.nextLine();
                if (ans.compareTo(gen.conversion(gen.number, gen.a)) ==0) return true;
                return false;
            }
            catch (Exception e) { 
                return false;
            }
        }
	else {
	    System.out.println("What is going on");
	}
        return false;
    }
    
    //================================================
      
    public boolean battle(Monster generic) {
	
	int descrip = 0;//used for printing description
	int i = 1; //used for choosing attacks
	int choice = 0;//used when deciding whether or not to fight
	int d1, d2;
	
	//generic = new Monster();

	//for Monster's description		
	try {
	    System.out.println("\nYou see a Monster approaching.\n Do you wish to view its credentials?");
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
		    System.out.println( "\nWhat will you do?" );
		    System.out.print("\t1: Attack\n\t2: Special\nSelection: " );
		    Scanner work = new Scanner(System.in);
		    i = work.nextInt();
		}
		catch ( Exception e ) {
		    i = 1;
		}
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
		    System.out.println( "\nWhat will you do?" );	
		    System.out.println("\t1: Fight\n\t2: Answer Question\nSelection: " );
		    Scanner why = new Scanner(System.in);
		    choice = why.nextInt();
		    if (choice == 1) {//fight
			try{
			    System.out.println("\t1: Attack\n\t2: Special\nSelection: " );
			    Scanner work = new Scanner(System.in);
			    i = work.nextInt();
			}
			catch ( Exception e ) {
			    i = 1;
			}
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
		        if (player.isAlive() == true) {
			    admin.askArtQuestion();
			}
			if (checkAnswer(teach) == false) {
			    player.HP -= 6;
			    System.out.print("Oops, wrong answer.");
			    System.out.println( "\n" + "AdmissionsOfficer dealt  6 points of damage.\n");
			}
			else {
			    teach.HP = -20;
			    System.out.println("\nYou have earned 100 dollars!");
			}
		    }//end question
		}
		catch ( Exception e ) {
		    choice = 2;
		}
	
	    }//ends Admission officer choice
				
	    else if (generic instanceof Teacher) {
		teach = (Teacher)generic;
		try {
		    System.out.println( "What will you do?" );	
		    System.out.print("\t1: Fight\n\t2: Answer Question\nSelection: " );
		    Scanner why = new Scanner(System.in);
		    choice = why.nextInt();
		    if (choice == 1) {//fight
			try{
			    System.out.print("\t1: Attack\n\t2: Special\nSelection: " );
			    Scanner work = new Scanner(System.in);
			    i = work.nextInt();
			}
			catch ( Exception e ) {
			    i = 1;
			}
			if ( i == 2 )
			    player.specialize();
			else
			    player.normalize();
					    		
			d1 = player.attack( teach );
			d2 = teach.attack( player );
			System.out.print( "\n" + player.getName() + " dealt "
					  + d1 + " points of damage.");
			System.out.println( "\n" + "Teacher dealt " +
					    player.getName() + " " + d2 + " points of damage.\n");	
		    }//end fight
		    else if (choice == 2) {//question
			if (player.isAlive()) {
			    teach.askQuestion();
			}
			else {
			    return false;
			}
		        if (checkAnswer(teach) == false) {
			    if (onTeam("Mr.Brown") != true && onTeam("Mr.Brown")==false) {
				player.HP -= 6;
				System.out.print("Oops, wrong answer.");
				System.out.println( "\n" + "Teacher dealt " +
						    player.getName() + " 6 points of damage.\n");
			    }
			    else {
				System.out.println("Mr.Brown deflected the attack of the Teacher.\n");
			    }
			}
			else {
			    teach.HP = -200;
			    System.out.println("\nThat is correct!");
			    System.out.println("The dreadful Teacher begins to smoke around the edges.");
			    System.out.println("A light flashes, and it is reduced to an explosion of ash.");
			    System.out.println("All that is left is a clue for the remainder of your quest.");
			}
		    }//end question
		}
		catch ( Exception e ) {
		    choice = 2;
		}
		    	
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

    //////ON TEAM? YES?nO?===============================================
    public boolean onTeam(String name) {
    	for (int ctr = 0; ctr < team.size(); ctr ++) {
	    if (team.get(ctr).compareTo(name) == 0) {
		return true;
	    }
    	}
    	return false;
    }
    //////////////////////////////////////////////////
    
    public boolean questOne() {
	teach = new Teacher();
    	int encounter = 5;
    	int resp = -1;
    	String storyline="";
    	String response= "";
    	while(floors.size() > 0) {
	    System.out.println("Please choose a floor to proceed to: ");
	    for (String x: floors) {
		System.out.print(x);//prints out the floors
	    }
	    try {
		Scanner sc = new Scanner(System.in);
		int floor = sc.nextInt();
		if (floor == 1) {
	            	
		    floors.remove("\t1: Art Department\n");
	            	
		    storyline= "You are now within the Art Department.\n";
		    storyline += "The smell of paint permeates the floor and paintings decorate the walls.\n";
		    storyline += "But you cannot stay to admire the view.";
		        	
		    System.out.println(storyline);
		    pressAnyKeyToContinue();

		    storyline = "\nAt the far end of the corridors there emerges the figure of a girl.\n";
		    storyline += "She is dressed in distinctive blue and white.\n\nAlice: \n";
		    storyline += "\tHello there. My name is Alice. Who are you and how are you doing?\n";
		    System.out.println(storyline);
		    
		    response = "Do you wish to choose Alice, or leave in pursuit of Ernie?\n";
		    response += "\t1: Stay with Alice.\n";
		    response += "\t2: Ernie is who I really want.\n";
		    System.out.print(response);
		    //===
		    try {
			sc = new Scanner(System.in);
			resp = sc.nextInt();//choice of team member
		    }
		    catch (Exception e) {
			resp =2;
		    }
		    response = "Choose your response: \n";
		    response += "\t1: My name is BLin and I'm doing well. What about you?\n";
		    response += "\t2: My perfect world was torn apart by the disappearance of my true love.\n";
		    response += "\tSo I guess you can say I could be doing better.\n";
		    if (resp == 1) {//if alice
			///THE DROPPING OF THE CLUE
			System.out.print("But wait! What is that in the distance?\n");
			while (encounter > 0) {
			    if (battle(teach)==false) {
				return false;
			    }
			    else {
				teach = new Teacher();//creates new teacher to reset values
				int randInd = (int) (Math.random()*5);
				System.out.println("\tClue: " + teach.alice.get(randInd));
				teach.alice.remove(teach.alice.get(randInd));
			    }
			    encounter --;
			}
			encounter = 5;
			/////////////////END CLUE
			System.out.print(response);
			pressAnyKeyToContinue();
			//=====
			try {
			    Scanner sca = new Scanner(System.in);
			    resp = sca.nextInt();//choice of dialogue
			}
			catch (Exception e) {
			    resp = 2;
			}
			if (resp == 1){//dialogue 1
			    response = "\tMy name is BLin and I'm doing well. What about you?\n";
			}
			else {//dialogue 2
			    response = "\tMy perfect world was torn apart by the disappearance of my one true love.\n";
			    response += "\tSo I guess you can say I could be doing better.\n";
			}
			//=====
			System.out.println("Now you turn to Alice");
			System.out.print("\nBLin: \n"+ response);
			pressAnyKeyToContinue();
			System.out.println("Alice: ");
			storyline = "\tWell, My fall down the rabbit hole is nothing compared to the drastic drop\n";
			storyline += "\tin my grades ever since I began attending Stuy.\n";
			storyline += "\tI want to help you. In fact I have a lovely drawing of Rubik's Cube.\n";
			storyline += "\tYou must, however, answer a question.\n";
			System.out.print(storyline);
			pressAnyKeyToContinue();
			System.out.print("BLin:\n\tAnything to facilitate the process!\n");
			System.out.println("Alice:\n\tOkay. I am thinking of a terrible place. What is its name?");
			System.out.print("\nBLin:\n\tThat's honestly just a ridiculous question.\n");
			pressAnyKeyToContinue();
			System.out.print("What is your answer to the riddle posed?\n\tYour answer:");
			try {
			    sc = new Scanner(System.in);
			    String finalAns = sc.nextLine();
			    finalAns = finalAns.toLowerCase();
			    if (finalAns.compareTo(teach.aliceAns) == 0) {
				team.add("Alice");
				System.out.println("Congratulations! You have added Alice to your team.");
			    }
			    else {
				System.out.println("Sorry, you weren't persuasive enough.");
			    }
			}
			catch (Exception e){
			    System.out.println("Sorry, you weren't persuasive enough.");
			}
		    }//end alice
		    else if (resp == 2) {//if ernie
			///THE DROPPING OF THE CLUE
			System.out.print("But wait! What is that in the distance?\n");
			while (encounter > 0) {
			    if (battle(teach)==false) {
				return false;
			    }
			    else {
				teach = new Teacher();//creates new teacher to reset values
				int randInd = (int) (Math.random()*5);
				System.out.println("\tClue: " + teach.ernie.get(randInd));
				teach.ernie.remove(teach.ernie.get(randInd));
			    }
			    encounter --;
			}
			encounter = 5;//reset
			pressAnyKeyToContinue();
			//END CLUE 
			storyline = "You walk furthur down the corridor and come upon Ernie.\n\nErnie:\n";
			storyline += "\tHello. It's me. Ernie.\n";
			storyline += "\tI was wondering if after all these years you have anything to tell me?\n";
			System.out.print(storyline);
			pressAnyKeyToContinue();
		        response = "You gaze upon the face you used to know so well,\n";
		        response +="amazed at the changes wrought by the unforgiving persistence of time,\n";
			response +="and can only say one thing...";
			System.out.println(response);
			pressAnyKeyToContinue();
			System.out.print("What is your answer to the riddle posed?\n\tYour answer:");
			try {
			    sc = new Scanner(System.in);
			    String finalAns = sc.nextLine();
			    finalAns = finalAns.toLowerCase();
			    if (finalAns.compareTo(teach.ernieAns) == 0) {
				team.add("Ernie");
				System.out.println("Congratulations! You have added Ernie to your team.");
			    }
			    else {
				System.out.println("Sorry, you were not persuasive enough.");
			    }
			}
			catch (Exception e){
			    System.out.println("Sorry, you were not persuasive enough.");
			}
		    }//end ernie

		    //====		        	
		}//end art/floor 1 
		
		if (floor == 2) {//if math
		    floors.remove("\t2: Math Department\n");
		    storyline = "You are now within the Math Department.";
		    storyline += "It is a dismal place, filled with lifeless students milling about.\n";
		    storyline += "They do not respond to any of your speech or actions.\n";
		    storyline += "But they are not of your concern right now.\n";
		    storyline += "You move to quickly find your next ally.\n";
		    System.out.println(storyline);
		    pressAnyKeyToContinue();
	        		
		    ///THE DROPPING OF THE CLUE
		    System.out.print("But wait! Darkness gathers in the distance.\n");
		    while (encounter > 0) {
			if (battle(teach)==false) {
			    return false;
			}
			else {
			    teach = new Teacher();//creates new teacher to reset values
			    int randInd = (int) (Math.random()*5);
			    System.out.println("\tClue: " + teach.drake.get(randInd));
			    teach.drake.remove(teach.drake.get(randInd));
			}
			encounter --;
		    }
		    encounter = 5;//reset
		    pressAnyKeyToContinue();
		    //END CLUE

		    storyline = "\nDrake:\n\tHey. Who are you? Why are you here.\n";
		    System.out.print(storyline);
		    pressAnyKeyToContinue();
		    response = "\nChoose your response: \n";
		    response += "\t1: My name is BLin. My girl has been gone for a while.\n";
		    response += "\tI need your help to find her\n";
		    response += "\t2: My name is BLin. My girl's been wearing less and going out more these days.\n";
		    response += "\tNow, she's been kidnapped and my life is meaningless without her.\n";
		    System.out.println(response);
		    //=====choose dialogue
		    try {
			Scanner sca = new Scanner(System.in);
			resp = sca.nextInt();//choice of dialogue
		    }
		    catch (Exception e) {
			pressAnyKeyToContinue();
		    }
		    if (resp == 1){//dialogue 1
			response = "\t1: My name is BLin. My girl has been gone for a while.\n";
			response += "\tI need your help to find her.\n";
		    }
		    else {//dialogue 2
			response = "\tMy name is BLin.\n\tMy girl's been wearing less and going out more these days.\n";
			response += "\tNow, she's been kidnapped and my life is meaningless without her.\n";
		    }
		    System.out.print("BLin: \n"+ response);//print dialogue
		    pressAnyKeyToContinue();
		    //=====
		    storyline = "Drake:\n\tDo not worry. I, too started from the bottom, but now I'm here.\n";
		    storyline += "\tI understand the struggle of heartbreak.\n";
		    storyline += "\tI will help you find your love, but you must answer this correctly: \n"; 
		    storyline += "\tTell me, what is the square root of sixty nine?";
		    System.out.println(storyline);
		    pressAnyKeyToContinue();
		    System.out.print("What is your answer to the riddle posed?\n\tYour answer:");
		    try {
			sc = new Scanner(System.in);
			String finalAns = sc.nextLine();
			finalAns = finalAns.toLowerCase();
			if (finalAns.compareTo(teach.drakeAns) == 0) {
			    team.add("Drake");
			    System.out.println("Congratulations! You have added Drake to your team.");
			}
			else {
			    System.out.println("Sorry, you were not persuasive enough.");
			}
		    }
		    catch (Exception e){
			System.out.println("Sorry, you were not persuasive enough.");
		    }
		   pressAnyKeyToContinue();
		}//end math/floor 2
		
		if (floor == 3){//if cs		   
		    floors.remove("\t3: CS Department\n");
		    storyline = "You are now within the CS Department.\n";
		    storyline = "It is all gleaming metal and rows of computers.\n";
		    System.out.print(storyline);
		    pressAnyKeyToContinue();
		    storyline = "You look to your right and you see your old friend MooCow approaching.\n";
		    storyline += "\nMooCow:\n\tBLin! How are you doing?\n";
		    System.out.println(storyline);
		    pressAnyKeyToContinue();
		    storyline = "\nHere you are, left with the dilemma of the century:\n";
		    storyline += "Do you continue in pursuit of Mr.Brown, or do you welcome your friend?\n";
		    System.out.println(storyline);
		    pressAnyKeyToContinue();
		    response = "Your choice:\n\t1: Approach MooCow\n\t2: Forsake him for Mr.Brown\n";
		    System.out.println(response);
		    //==
		    try {//who does he choose???
			sc = new Scanner(System.in);
			resp = sc.nextInt();//choice of team member
		    }
		    catch (Exception e) {
			resp =2;
		    }
		    if (resp == 1) {//if MooCow
			///THE DROPPING OF THE CLUE
			System.out.print("Do not let down your guard yet.\n");
			while (encounter > 0) {
			    if (battle(teach) == false) {
				return false;
			    }
			    else {
				teach = new Teacher();//creates new teacher to reset values
				int randInd = (int) (Math.random()*5);
				System.out.println("\tClue: " + teach.mooCow.get(randInd));
				teach.mooCow.remove(teach.mooCow.get(randInd));
			    }
			    encounter --;
			}
			encounter = 5;
			pressAnyKeyToContinue();
			/////////////////END CLUE
		        System.out.println("How do you feel right now?");		
			System.out.print("What is your answer to the riddle posed?\n\tYour answer:");
			try {//to get final clue answer
			    sc = new Scanner(System.in);
			    String finalAns = sc.nextLine();
			    finalAns = finalAns.toLowerCase();
			    if (finalAns.compareTo(teach.mooAns) == 0) {
				team.add("MooCow");
				System.out.println("Congratulations! You have added MooCow to your team.");
			    }
			    else {
				System.out.println("Sorry, you were not persuasive enough.");
			    }
			}
			catch (Exception e){
			    System.out.println("Sorry, you were not persuasive enough.");
			}
		        pressAnyKeyToContinue();		
		    }//end MooCow
		    else if (resp == 2) {//if Mr Brown
			///THE DROPPING OF THE CLUE
			System.out.print("You shake off your guilt at abandoning MooCow.\n");
			while (encounter > 0) {
			    if (battle(teach)==false) {
				return false;
			    }
			    else {
				teach = new Teacher();//creates new teacher to reset values
				int randInd = (int) (Math.random()*5);
				System.out.println("\tClue: " + teach.mrBrown.get(randInd));
				teach.mrBrown.remove(teach.mrBrown.get(randInd));
			    }
			    encounter --;
			}
			encounter = 5; //reset
			pressAnyKeyToContinue();
			/////////////////END CLUE
		        System.out.println("Mr.Brown:\n\tWhat is it that everyone desires?");		
			System.out.print("What is your answer to the riddle posed?\n\tYour answer:");
			try {//to get final clue answer
			    sc = new Scanner(System.in);
			    String finalAns = sc.nextLine();
			    finalAns = finalAns.toLowerCase();
			    if (finalAns.compareTo(teach.brownAns) == 0) {
				team.add("Mr.Brown");
				System.out.println("Congratulations! You have added Mr.Brown to your team.");
			    }
			    else {
				System.out.println("Sorry, you were did not have the keys to succes.");
			    }
			}
			catch (Exception e){
			    System.out.println("Sorry, you were did not have the keys to succes.");
			}
			pressAnyKeyToContinue();
		    }//end Brown
		}//end cs
	    }
	    catch (Exception e) { 
		return false;
	    }
    	}
    	return true;
    }
    
    public boolean questTwo() {
    	admin = new AdmissionsOfficer();
    	student = new Competitor();
    	String s;
    	String b; 
	s = "";
	s += "Choose the Character you wish to continue playing as: \n";
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
		    else {
			player  = new BLinCS();
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
		team.add("Drake");
	    }
	    else if (hero == 3) {//if choose MooCow
		player = new MooCow();
		team.add("MooCow");
	    }
				
	    else if (hero == 4) {//if choose Mr.Brown
		player = new MrBrown();
		team.add("MooCow");
	    }
				
	    else if (hero == 5) {//if choose Ernie
		player = new Ernie();
		team.add("MooCow");
	    }
				
	    else if (hero == 6) {//if choose Alice
		player = new Alice();
		team.add("MooCow");
	    }
	    else {
		player = new Drake();
		team.add("Drake");
	    }
	    
	}
	catch ( IOException e ) {
	    player = new BLinCS();
	}
	System.out.println(player.about());
	pressAnyKeyToContinue();
		
    	String story = "Quest 2: An Epic Journey.\n";
    	story += "BLin:\n\tOkay Team. We are looking for Rubik's Cube.\n";
	System.out.print(story);
	System.out.println(team.get(0) +":\n\tThere's always the option of buying another one.");
	story = "Drake:\n\tThat's disloyal. You can't just buy another Rubik's Cube.\n";
	story += "\tYou find yourself one and then you cherish it.";
	System.out.print(story);
	pressAnyKeyToContinue();
	if (team.get(1) != "BLinCS" || team.get(1) !="BLinArt" || team.get(1) !="BLinMath") {
	    story = team.get(1) + ":\n\tIt's probably wandering around in MIT.";
	    System.out.print(story);
	    pressAnyKeyToContinue();
	}
	story = "BLin:\n\tI already told you I wasn't applying to that school.\n";
	System.out.print(story);
	pressAnyKeyToContinue();
		
	if (team.get(2) != "BLinCS" || team.get(2) != "BLinArt" || team.get(2) != "BLinMath") {
	    story = team.get(1) + ":\n\tThat's all the more reason for your Rubik's Cube to go there.\n";
	    story += "\tThink about it. You've been very clingy lately.\n";
	    story += "\tIf she wanted a breath of fresh air, wouldn't she go somewhere you'd never want to go?\n";
	    System.out.print(story);
	    pressAnyKeyToContinue();
	}
	story = "BLin:\n\tI can't find fault in that. But how are we going to get into MIT?\n";
	System.out.print(story);
	pressAnyKeyToContinue();
		
	story = "Your next journey is to go to MIT where BLin's damsel in distress is sorrowfully awaiting.";
	if(onTeam("Alice")==true) {
	    story += "Alice had been walking up the broken escalators, when she noticed something.";
	    story += "\nThere was a step that was missing, and in is place was a hole.";
	    story += "\n'I wonder what's below these floors?' she wondered.";
	    story += "\nThen she fell.";
	    story += "\nAnd fell.";
	    story += "\nAnd fell.";
	    System.out.println(story);
	    pressAnyKeyToContinue();
	    story = "There was no word from Alice for a few hours.";
	    pressAnyKeyToContinue();
	    story += "\nThen she texted BLin.";
	    story += "\n'OMG GUISE, I found a shortcut to MIT!'";//lol
	}
	else {
	    story += "\nUnfortunately, you missed the easy way out.";
	    story += "\nYou have to take the traditional route.";
	    story += "\nIn order to pay for your plane ticket to MIT, you need a job.";
	    story += "\nWhat's the perfect job for a group of teenagers looking to earn monday to travel to MIT?";
	    story += "\nA museum curator.";
	    System.out.println(story);
	    pressAnyKeyToContinue();
	    story = "\nIn order to get the job, you first have to answer several questions related to famous paintings";
	    System.out.println(story);
	    pressAnyKeyToContinue();
	    story = "Unfortunately for you, this museum is run by a Monster.\n";
	    story += "More specifically, the all powerfull AdmissionsOfficer";
	    System.out.println(story);
	    pressAnyKeyToContinue();
	    story = "Fearsome Monster:\n";
	    story += "\tIf you manage to defeat me, puny mortals, I will pay for your airfare.\n";
	    System.out.print(story);
	    pressAnyKeyToContinue();
	    story = "Do you wish to take on art skills?\n";
	    story += "\t1: Yes\n\t2: No\n";
	    System.out.print(story);
	    try {
		vocation = Integer.parseInt( in.readLine() );
		if (vocation == 1 ){
		    if (onTeam("Ernie")==true) {
			player = new Ernie();
		    }
		    else if (onTeam("BLinArt")==true) {
			player = new BLinArt();
		    }
		}
		else {
		    System.out.println("Good luck fearless warrior!");
		}
	    }
	    catch ( IOException e ) { 
		player  = new BLinArt();
	    }
	    int encounter = 10;
	    while (encounter > 0) {
		if (battle(admin)==false) {
		    return false;
		}
		else {
		    admin = new AdmissionsOfficer();//creates new teacher to reset values
		}
		encounter --;
	    }
	    System.out.println("Finally, you have enough money to fly to MIT.");
	    pressAnyKeyToContinue();
	}
	story = "You and your friends have arrived at MIT.\n";
	story += "There are hordes of Competitors outside, barring your entrance.\n";
	story += "You know immediately that it will be an exhausting fight.\n";
	System.out.print(story);
	pressAnyKeyToContinue();
	if (onTeam("MooCow")) {
	    story = "Upon sight of MooCow, the crowds disperse. You are granted entrance.\n";
	    story += "Now all that remains is to find Rubik's Cube";
	    System.out.println(story);
	    pressAnyKeyToContinue();
	}
	else {
	    int encounter = 20;
	    while (encounter > 0) {
		if (battle(student)==false) {
		    return false;
		}
		else {
		    student = new Competitor();//creates new teacher to reset values
		}
		encounter --;
	    }
	    story = "You and the rest of the group and tired and worn out.\n";
	    story += "There is a trail of carnage behind you.\n";
	    story += "Now all that remains is to find Rubik's Cube";
	    System.out.println(story);
	    pressAnyKeyToContinue();
	}
		
	story = "BLin:\n\tIt is hard for me to believe that I am this close to reuniting with my beloved.";
	story += "\nThe Crew forged on, and finally, came across BLin's one true love on a stand,\n";
	story += "enveloped in a halo of light.";
	System.out.print(story);
	pressAnyKeyToContinue();
		
				
	if (player.isAlive() == false) {
	    return false;
	}
		
	if (onTeam("Ernie")) {
	    story = "But alas, happy endings are ever elusive.\n";
	    story += "When Ernie entered the room, the stones began to crumble.";
	    System.out.print(story);
	    return false;
	}
		
	else {
	    story = "BLin almost sobbed for joy as he gathered Rubik's Cube into his arms.\n";
	    story += "And he swore to never be ridiculously insecure and jealous again.";
	    System.out.print(story);
	    return true;
	}
    }
    
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    public static void main( String[] args ) {
	System.out.println("Note: We recommend that you expand your terminal.");
	pressAnyKeyToContinue();


	//loading...
	Hotline game = new Hotline();
	
	int encounters = 0;
	
	
	if ( game.questOne() == true ){
	    pressAnyKeyToContinue();
	    if (game.questTwo() == true) {
		System.out.println("And they all lived happily ever after.");
	    }
	    else {
		System.out.println("The door frame collapsed before you could reach her.\n");
		System.out.println("Wails of agony emanated from the building as the stones crashed.\n");
		System.out.println("Then, all that was left was silence as MIT was reduced to rubble.\n");
	    }
	}
		
	//game.questTwo();
	
	System.out.println( "Game over." );
		/*=============================================
	
		  =============================================*/

    }//end main

}//end class YoRPG




/*=============================================
  =============================================*/
