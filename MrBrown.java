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
		answer = "Where is your answer";
		moves = new ArrayList<String>();
		moves.add("Convert");
		moves.add("Binary");
		moves.add("Sort");
		moves.add("Directly Answer");
	}
	
    public String about() {
    	String story = "";
		story += "Your name is Mr.Brown.\n";
		return story;
    }
    
       	//convert to Decimal from any base
   	public String specialOne(String a, String b) {
   		//String a is the number being converted to base 10
   		//String b is the base it is being converted from
   		int base = Integer.parseInt(b);
   		String s = a;

   		int dec = 0;
		int power = 0;
		for (int ctr = 0; ctr < s.length(); ctr ++ ) {
		    power = s.length() - ctr - 1;
		    //ctr and power increment at opposite ends
		    dec += (DIGITS.indexOf(s.substring(ctr,ctr+1))
			    //goes through each char in string s
			    //returns corresponding index of char in string HEXDIGITS
			    * Math.pow(base, power));//number multiplied by base raised to th correct power
		}
		answer += dec;
		return answer;
   	}
   	
	//convert binary to another base(2 to 16)   	
   	public String specialTwo(String a, String b) {
   		//String a is the binary number
   		//String b is the base a is converted to
   		int num = Integer.parseInt(a);
   		int base = Integer.parseInt(b);

   		if (base < 2 || base > 16) {
         	return "Please enter a base between 2 and 16";
      	}
      	if (num == 0) return "";
      	answer =  specialTwo(Integer.toString(num/base), Integer.toString(base)) 
      		+ DIGITS.substring(num%base, (num%base)+1);
      		
      	return specialTwo(Integer.toString(num/base), Integer.toString(base)) 
      		+ DIGITS.substring(num%base, (num%base)+1);
      	//n divided by base goes into each recursion until it reaches 0
      	//adds on the hexdigit that corresponds with the remainder of n%bas
   		
   	}
      	
   	  	//Sort method 
   	public ArrayList<Integer> sorting( ArrayList<Integer> data ) {
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
    	//num is not used; signature must be kept constant
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
