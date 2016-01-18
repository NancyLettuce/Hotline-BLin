import java.util.ArrayList;

public class BLinCS extends Character implements CSKid {
    
    private final static String DIGITS = "0123456789ABCDEF";
    
    public BLinCS() {
	super();
	HP = 50;
	def = 10;
	str = 10;
	type = "cs";
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

        //convert binary to another base(2 to 16)
    public String convert(int num, int base){
	if (base < 2 || base > 16) {
	    return "Please enter a base between 2 and 16";
      	}
      	if (num == 0) return "";
      	return convert(num/base, base) +
	    DIGITS.substring(num%base, (num%base)+1);
      	//n divided by base goes into each recursion until it reaches 0
      	//adds on the hexdigit that corresponds with the remainder of n%bas
    }
}
