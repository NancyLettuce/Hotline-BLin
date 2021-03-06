public class Competitor extends Monster {
    
    public Competitor() {
        super();
        HP = 20; 
        def = 15;
        str = 10;
    }
    
    public String about() {
        String story = "\n";
        story += "Competitors appear in Quest 2.\n";
        story += "They will attempt to impede your progress, driven by unadulterated hatred and jealousy.\n";
        story += "Competitors will not ask you questions.\n";
        story += "You must do battle with them.\n";
        return story;
    }
}
