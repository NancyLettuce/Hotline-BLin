import java.util.ArrayList;

public class BLinMath extends Character implements MathKid {
    public BLinMath() {
		super();
		HP = 50;
		def = 10;
		str = 10;
		type = "math";
		talent = "lol";
		name = "BLin";
		answer = "Where is your answer";
		moves = new ArrayList<String>();
		moves.add("Quadratic");
		moves.add("Prime");
		moves.add("Multiply");
		moves.add("Directly Answer");
	}
	
    public String about() {
		String story = "\nYou love finding areas under funky curves.\n";
		story += "Your friends compete with you on who does better in math competitions, but you enjoy it.\n";

		return story;
    }
    
    public String specialOne(String a, String b) {
    	//we don't need b here
    	//b in this case is gen.num which we don't want
    	answer = a;
    	return answer;
    }
    
    //is Prime?
    public String specialTwo(String a, String b){
    	//we don't need a here
    	//a in this case is gen.num which we don't want
    	int p = Integer.parseInt(b);//turn into integer
    	if (p == 1) {
            answer = "false";
            return answer;
        }
        if (p == 2) {
            answer = "true";
            return answer;
        }
        for (int i = 2; i <= Math.sqrt(p) + 1; i++) {
            if (p % i == 0) {
                answer = "false";
                return answer;
            }
        }
        answer = "true";
        return answer;
    }
    
    //multiply
    public String specialThree(int a, int b, ArrayList<Integer> data) {
    	//data not needed
    	int ans = a * b;
    	answer = Integer.toString(ans);
    	return answer;
    }
    
    
}
