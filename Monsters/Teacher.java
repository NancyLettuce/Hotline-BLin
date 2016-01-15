import java.util.ArrayList;

public class Teacher extends Monster {
    
    public String about() {
        String story = "";
        story += "Teachers appear only in Quest 1.\n";
        story += "They will ask you questions to impede your progress.\n";
        story += "If you subdue this monster by giving the right answer, \n"
        story += "they will leave you with a clue to aid you in assembling your team.\n";
        return story;
    }    
}
