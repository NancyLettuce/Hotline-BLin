import java.util.ArrayList;

public class MooCow extends Character implements CSKid {
    private final static String DIGITS = "0123456789ABCDEF";
    
    public MooCow() {
	super();
	HP = 50;
	def = 10;
	str = 20;
	type = "cs";
	talent = "MIT";
	name = "MooCow";
	moves = new ArrayList<String>();
	moves.add("Convert");
	moves.add("Binary");
    }
	
    public String about() {
	String story = "Your name is MooCow\n";
	story += "You were battling against senioritis until BLin came along.\n";
	story += "He enlightened you on whom the real monsters you should be battling are.\n";
	story += "Now, you are ready to help him and the rest of the squad fight evil and spread love.\n";
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

    //convert to Decimal from any base
    public int decimal(String s, int base) {
	int dec = 0;
	int power = 0;
	for (int ctr = 0; ctr < s.length(); ctr ++ ) {
	    power = s.length() - ctr - 1;
	    //ctr and power increment at opposite ends
	    dec += (DIGITS.indexOf(s.substring(ctr,ctr+1))
		    //goes through each char in string s
		    //returns corresponding index of char in string HEXDIGITS
		    * Math.pow(base, power));
	    //number multiplied by base raised to th correct power
	}
	return dec;
    }
}
