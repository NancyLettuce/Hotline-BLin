import java.util.ArrayList;

public class MrBrown extends Character implements CSKid {
    public MrBrown() {
	super();
	HP = 100;
	def = 13;
	str = 8;
	type = "cs";
	talent = "extra credit";
	name = "Mr.Brown";
    }
	
    public String about() {
        String story = "";
	story += "Your name is Mr.Brown.\n";
	return story;
    }
}
