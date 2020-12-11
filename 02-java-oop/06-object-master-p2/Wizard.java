public class Wizard extends Human{
    public Wizard(){
        this.health = 50; 
        this.intelligence = 8; 
    }

    public void heal(Human name){
        name.health += this.intelligence; 
    }
    public void fireball(Human name){
        name.health -= (this.intelligence * 3);
    }

    public int getHealth(){
        return health;
    }
    public void setHealth(int health){
        this.health = health;  
    }
}