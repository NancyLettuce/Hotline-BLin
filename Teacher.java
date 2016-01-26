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
	
	alice.add("The depths of hell");
        alice.add("The source of all my torment");
        alice.add("A raging inferno");
        alice.add("RIP my grades");
        alice.add("Where hopes and dreams go to die");
        
        drake.add("Drake is a famous singer");
        drake.add("Drake was once featured on a Rihanna song");
        drake.add("Pure, lyrical genius");
        drake.add("Revolutionary math");
        drake.add("Thinking outside of the box");
        
        ernie.add("The only constant in life is change");
        ernie.add("Second term seniors");
        ernie.add("The aftermath of college acceptance");
        ernie.add("Two words, one of which is a contraction");
        ernie.add("To become different");

	mooCow.add("Confusion");
        mooCow.add("Slang");
        mooCow.add("The answer is ever elusive");
        mooCow.add("The futility of life");
        mooCow.add("Three words encapsulated in one");
        
        mrBrown.add("The stuff of dreams");
        mrBrown.add("All of our hopes");
        mrBrown.add("Plural, as a class");
        mrBrown.add("This project");
        mrBrown.add("Everything I've ever wanted");
        
        
        aliceAns = "stuyvesant";
        drakeAns = "8 something";
        ernieAns = "you've changed";
        mooAns = "idk";
        brownAns = "please pass us";
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
        return story;
    }    
}
