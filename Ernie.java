import java.util.ArrayList;

public class Ernie extends Character implements ArtKid {

    public Ernie() {
	super();
	HP = 30;
	def = 0;
	str = 5;
	type = "art";
	talent = "failure";
	name = "Ernie";
    }
	
    public String about() {
        String ernie = "";
	ernie += "Your name is Ernie.\n";
	ernie += "You get offended easily, but you're more or less a good teammate.\n";
	ernie += "BLin recruited you after you repeatedly asked him through facebook.\n";
	ernie += "Now you are ready to help him and the rest of the squad to make sure BLin has a great prom night.\n";
	return ernie;
    }

    public String specialOne(String a, String b) {
    	return "hi";
    }
}
