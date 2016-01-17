import java.util.ArrayList;

public class Teacher extends Monster {
    private ArrayList artQ;
    private ArrayList mathQ;
    private ArrayList csQ;
    
    public Teacher() {
        super();
        HP = 300; 
        def = 20;
        str = 100;
    }
    //you can choose to answer question or to attack normally
    //if you answer one question correctly, you defeat a teacher
    //will take much longer to attack(more difficult)
    
    public String about() {
        String story = "";
        story += "Teachers appear only in Quest 1.\n";
        story += "They will ask you questions to impede your progress.\n";
        story += "If you subdue this monster by giving the right answer, \n";
        story += "they will leave you with a clue to aid you in assembling your team.\n";
        story += "However, you may also choose to fight it in the traditional fashion.\n";
        return story;
    }    
}
