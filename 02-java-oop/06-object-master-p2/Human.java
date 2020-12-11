public class Human implements Attackable{

    public int strength = 3; 
    public int stealth = 3; 
    public int intelligence = 3; 
    public int health = 100; 

    public int getHealth(){
        return health;
    }
    public void setHealth(int health){
        this.health = health;  
    }
    
    public void attack(Human name){
        name.health = name.health - this.strength; 
    }

}