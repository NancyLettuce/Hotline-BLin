import java.util.ArrayList;

public class Drake extends Character implements MathKid {
	
    public Drake() {
	super();
	HP = 100;
	def = 10;
	str = 20;
	type = "math";
	talent = "Only Character skilled in math";
	name = "Drake";
	moves = new ArrayList<String>();
	moves.add("Move1");
	moves.add("Move2");
	moves.add("Move3");
	moves.add("Directly Answer");
	answer = "Where is your answer";
    }
	
    public String about() {
	String story = "\nYour name is Drake.\n";
	story += "Despite a lucrative stint in the music industry, your true calling is math.\n";
	story += "BLin recruited you after a touching recount of his love story in an appeal to pathos.\n";
	story += "Now you are ready to help him and the rest of the squad find Rubik's Cube\n";
	return story;
    }

    //roots
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
