import java.util.ArrayList;

public class BLinMath extends Character implements MathKid {
    
    public BLinMath() {
	super();
	HP = 50;
	def = 10;
	str = 10;
	type = "math";
	talent = "lol";
	name = "BLin";
	moves = new ArrayList<String>();
	moves.add("Quadratic");
	moves.add("Prime");
	moves.add("Multiply");
	moves.add("Directly Answer");
	answer = "Where is your answer";
    }
	
    public String about() {
	String story = "\nYour name is Hotline BLin.\n";
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
    	//we don't need b here
    	//b in this case is gen.num which we don't want
    	answer = a;
    	return answer;
    }
    
    //is Prime?
    public String specialTwo(String a, String b){
    	//we don't need a here
    	//a in this case is gen.num which we don't want
    	int p = Integer.parseInt(b);//turn into integer
    	if (p == 1) {
            answer = "false";
            return answer;
        }
        if (p == 2) {
            answer = "true";
            return answer;
        }
        for (int i = 2; i <= Math.sqrt(p) + 1; i++) {
            if (p % i == 0) {
                answer = "false";
                return answer;
            }
        }
        answer = "true";
        return answer;
    }
}
