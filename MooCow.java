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
	moves.add("Sort");
    }
	
    public String about() {
	String story = "Your name is MooCow\n";
	story += "You were battling against senioritis until BLin came along.\n";
	story += "He enlightened you on whom the real monsters you should be battling are.\n";
	story += "Now, you are ready to help him and the rest of the squad fight evil and spread love.\n";
	return story;
    }

    //convert to Decimal from any base
    public String specialOne(String a, String b) {
	//String a is the number being converted to base 10
	//String b is the base it is being converted from
	int base = Integer.parseInt(b);
	String s = a;
	String answer ="";
	int dec = 0;
	int power = 0;
	for (int ctr = 0; ctr < s.length(); ctr ++ ) {
	    power = s.length() - ctr - 1;
	    //ctr and power increment at opposite ends
	    dec += (DIGITS.indexOf(s.substring(ctr,ctr+1))
		    //goes through each char in string s
		    //returns corresponding index of char in string HEXDIGITS
		    * Math.pow(base, power));
	    //number multiplied by base raised to the correct power
	}
	answer += dec;
	return answer;
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

    public static void Sort( ArrayList<Comparable> data ) {
	int pass = 0; //index of next value to be compared
	while (pass < data.size()) {
	    //separates sorted from unsorted
	    for( int i = pass; i > 0; i-- ) {
		// swap the numbers if they are not in order
		if ( data.get(i).compareTo( data.get(i-1) ) < 0 ) {
		    data.set( i, data.set( i-1, data.get(i) ) ); 
		}
		else 
		    break; 
	    }
	    pass ++;
	}
    }

    
}
