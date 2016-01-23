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
	answer = "Where is your answer";
    }
	
    public String about() {
	String story = "Your name is Drake.\n";
	story += "Despite a lucrative stint in the music industry, your true calling is math.\n";
	story += "BLin recruited you after a touching recount of his love story in an appeal to pathos.\n";
	story += "Now you are ready to help him and the rest of the squad find Rubik's Cube\n";
	return story;
    }
    
    public String specialOne(String a, String b) {
    	return "hi";
    }

    public String specialTwo(String a, String b){
    	return "please work";
    }
    
    
}
