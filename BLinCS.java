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
	moves = new ArrayList<String>();
	moves.add("Decimal");
	moves.add("Convert");
	moves.add("Sort");
	moves.add("Directly Answer");
    }
	
    public String about() {
        String story = "You win all of the local coding competitions.\n";
	story += "Although random juniors message you at 3 in the morning about CS questions, life is good.\n";
	return story;
    }

    //convert to Decimal from any base
    public String specialOne(String a, String b) {
	//String a is the number being converted to base 10
	//String b is the base it is being converted from
	int base = Integer.parseInt(a);
	String s = b;
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
        answer = Integer.toString(dec);
	return answer;
    }

    //convert binary to another base(2 to 16)   	   	
    public String specialTwo(String a, String b) {
	//String a is the decimal number
	//String b is the base a is converted to
	answer = "";
	int num = Integer.parseInt(a);
	int base = Integer.parseInt(b);
        String ret = "";
        while (num > 0){
	    answer = DIGITS.substring(num%base, (num%base)+1) + answer;
	    //ret is the hexdigit whose index corresponds with the remainder of n%16
	    num /= base;
	    //n divided by 16 each time until it reaches 0
	}
        return answer;
    }

    //Sort method 
    public ArrayList<Integer> sorting(ArrayList<Integer> data ) {
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
	return data;
    }
    
    public String specialThree(int a, int b, ArrayList<Integer> data) {
    	//a and b not used; signature must be kept constant
        answer = "";
        data = sorting(data);
        for (int i = 0; i < data.size(); i ++) {
            answer += data.get(i) + ",";
        }
        answer = answer.substring(0,answer.length()-1);
        return answer;
    }
    ///end sort
}
