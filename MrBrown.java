public class MrBrown extends Character implements CSKid {
    public MrBrown() {
		super();
		HP = 100;
		def = 13;
		str = 8;
		type = "cs";
		talent = "extra credit";
	}
	
    public String about() {
        String ernie = "";
		ernie += "Your name is Ernie.\n";
		ernie += "You get offended easily, but you're more or less a good teammate.\n";
		ernie += "BLin recruited you after you repeatedly asked him through Facebook.\n";
		ernie += "Now you are ready to help him and the rest of the squad to make sure BLin has a great prom night!\n";
		return ernie;
    }
}
