import java.util.ArrayList;

public class BLinArt extends Character implements ArtKid {

    public BLinArt() {
	super();
	HP = 50;
	def = 10;
	str = 10;
	type = "art";
	talent = "lol";
	name = "BLin";
	moves = new ArrayList<String>();
	moves.add("Move1");
	moves.add("Move2");
	moves.add("Move3");
	moves.add("Directly Answer");
	answer = "Where is your answer";
    }
	
    public String about() {
        String story = "Despite the fact that you draw cooked stick figures, you love art.\n";
	story += "Your knowledge of art may come in handy to your teammates.\n";
	return story;
    }

    public String specialOne(String a, String b) {
    	return "hi";
    }

    public String specialTwo(String a, String b){
    	return "please work";
    }
    
}
