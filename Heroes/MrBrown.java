import java.util.ArrayList;

public class MrBrown extends Character implements CSKid {
    private final static String DIGITS = "0123456789ABCDEF";
    
    public MrBrown() {
	super();
	HP = 100;
	def = 13;
	str = 8;
	type = "cs";
	talent = "extra credit";
	name = "Mr.Brown";
	moves = new ArrayList<String>();
	moves.add("Convert");
	moves.add("Binary");
    }
	
    public String about() {
        String story = "";
	story += "Your name is Mr.Brown.\n";
	return story;
    }

    //convert binary to another base(2 to 16)
    public static String convert(int num, int base){
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
