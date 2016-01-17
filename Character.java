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
    
    public ArrayList moves; //the attacks they can use
    public String answer; //to store answers to the questions
    
    /*      WHAT IS THIS USED FOR?**********************************************
    int strInitial = 0;
    int defInitial = 0;
    int hpInitial = 0;
    */
    
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
