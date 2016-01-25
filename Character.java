import java.util.ArrayList;

public abstract class Character{
    
    //Basic properties of all characters.
    protected String story;
    protected int HP;
    protected int def;
    protected int str;
    protected String name;
    protected double attack;
    protected String type; //the skill they possess
    protected String talent; //their special talent
    
    protected final static String DIGITS = "0123456789ABCDEF";
    
    protected ArrayList<String> moves; //the attacks they can use
    public String answer; //to store answers to the questions
    
    public Character() {
        HP = 30;
        def = 10;
        str = 20;
        name = "hero";
        attack = .2;
    }
    
    //Dead or alive?
    public boolean isAlive(){
        return (HP > 0);
    }//
    
    //Accessors
    public int getDefense(){
        return def;
    }
    public String getName() {
	    return name;
    }//end of accessors
    
    public String toString() {//prints out ArrayList moves
        String stuff = "";
        for (int i = 0; i < moves.size(); i ++) {
            stuff += "\t" + (i+1) + ": " + moves.get(i) + "\n";
        }
        return stuff;
    }
    
    public abstract String about();

    //Taking damage
    public void lowerHP(int damage){
        this.HP -= damage;
    }
    
    public void normalize() {
    	attack*=.5;
    	def*=1.25;
    }
    public void specialize() {
    	attack*=2;
    	def*=.8;
    }
    
    //special moves
    public String specialOne(String a, String b){
        return "this is some bad coding";
    }
    
    public String specialTwo(String a, String b){
        return "this reeks of desperation";//why so negative
    }
    
    public String specialThree(int a, int b, ArrayList<Integer> data) {
        return "we messed up";//what happened
        //standardizing signatures rip
    }
    
    
    
    //
    public int attack (Monster other){
        int damage = (int)( (str * attack) - other.getDefense() );
        if (damage < 0) {
            damage = 0;
            //damage cannot be negative
        }
        other.lowerHP(damage);
        return damage;
    }
    
}
