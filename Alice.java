public class Alice extends Character implements  ArtKid {
	
	public Alice() {
		super();
		HP = 50;
		def = 5;
		str = 15;
	}
	
	public Alice(String _name) {
		this();
		name = _name;
	}
	
    public String about() {
        String alice = "";
		alice += "Your name is Alice.\n";
		alice += "Although you have a tendency to eat whatever you see, you are highly skilled in art.\n";
		alice += "BLin recruited you after your heartrendering drawing of a Rubik's Cube in the perfect lighting.\n";
		alice += "Now you are ready to help him and the rest of the squad find your painting model.\n";
		return alice;
    }
}