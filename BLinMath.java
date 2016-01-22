public class BLinMath extends Character implements MathKid {
    
    public BLinMath() {
	super();
	HP = 50;
	def = 10;
	str = 10;
	type = "math";
	talent = "lol";
	name = "BLin";
    }
	
    public String about() {
	String story = "Your name is Hotline BLin.\n";
	story += "Starting last week, your girlfriend, Rubik's Cube, has been acting quite distant.\n";
	story += "She did not return your texts, calls, or emails. Then you finally realized: She's missing.\n";
	story += "Here is a picture of the love of your life:\n";
	story += "    ___ ___ ___\n" +
	    "   /___/___/___/|\n" +
	    "  /___/___/___/||\n" +
	    " /___/___/__ /|/|\n" +
	    "|   |   |   | /||\n" +
	    "|___|___|___|/|/|\n" +
	    "|   |   |   | /||\n" +
	    "|___|___|___|/|/\n" +
	    "|   |   |   | /\n" +
	    "|___|___|___|/\n";
	return story;
    }

    public String specialOne(String a, String b) {
    	return "hi";
    }
}
