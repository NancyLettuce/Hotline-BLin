public class Drake extends Character implements MathKid {
	
	public Drake() {
		super();
		HP = 100;
		def = 10;
		str = 20;
		type = "math";
		talent = "Only Character skilled in math";
	}
	
    public String about() {
		story += "Your name is Drake.\n";
		story += "Despite a lucrative stint in the music industry, your true calling is math.\n";
		story += "BLin recruited you after a touching recount of his love story in an appeal to pathos.\n";
		story += "Now you are ready to help him and the rest of the squad find Rubik's Cube\n";
		return story;
    }
    
    
    
    
    
}
