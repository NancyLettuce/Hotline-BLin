import java.util.ArrayList;

public class MooCow extends Character implements CSKid {
    public MooCow() {
	super();
	HP = 50;
	def = 10;
	str = 20;
	type = "cs";
	talent = "MIT";
	name = "MooCow";
    }
	
    public String about() {
	String story = "Your name is MooCow\n";
	story += "You were battling against senioritis until BLin came along.\n";
	story += "He enlightened you on whom the real monsters you should be battling are.\n";
	story += "Now you are ready to help him and the rest of the squad fight evil and spread love.\n";
	return story;
    }
}
