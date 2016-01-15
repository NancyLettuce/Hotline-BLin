import java.util.ArrayList;

public abstract class Monster{
    //Basic properties of all characters.
    public int HP;
    public int def;
    public int str;
    
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
    
    public abstract String about();

    //Taking damage
    public void lowerHP(int damage){
        this.HP -= damage;
    }
    
    //
    public int attack (Character other){
        int damage = (int)(Math.random() * (this.str - other.def));
        other.HP -= damage;
        return damage;
    }
    
}
  
}
