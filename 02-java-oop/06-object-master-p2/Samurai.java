public class Samurai extends Human{

    private static int samCount = 0;
    private static int dHealth = 200; 


    public Samurai(){
        this.health = 200; 
        Samurai.samCount += 1;
    }

    public void deathBlow(Human name){
        name.health = 0; 
        this.health = (this.health/2);
    }
    public void meditate(){
        this.health = Samurai.dHealth; 
    }
    public int howMany(){
        return Samurai.samCount += 1;
    }

    public int getHealth(){
        return health;
    }
    public void setHealth(int health){
        this.health = health;  
    }
}