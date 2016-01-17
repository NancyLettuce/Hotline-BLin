import java.util.ArrayList;

public abstract class Character {
    
    //Basic properties of all characters.
    public String story;
    public int HP;
    public int def;
    public int str;
    public String type; //the skill they possess
    protected String talent; //their special talent
    
    public ArrayList moves; //the attacks they can use
    public String answer; //to store answers to the questions
    
    //properties
    int strInitial = 0;
    int defInitial = 0;
    int hpInitial = 0;
    //end of properties
    
    //Dead or alive?
    public boolean isAlive(){
        return (HP > 0);
    }//
    
    //Accessors
    public int getDefense(){
        return def;
    }
    /*   
	 public String getName() {
	 return name;
	 }//end of accessors
    */
    
    public abstract String about();

    //Taking damage
    public void lowerHP(int damage){
        this.HP -= damage;
    }
    
    //
    public int attack (Character other){
        int damage = (int)(Math.random() * (this.str - other.def));
        if (damage < 0) {
            damage = 0;//damage cannot be negative
        }
        other.lowerHP(damage);
        return damage;
    }
    
}
