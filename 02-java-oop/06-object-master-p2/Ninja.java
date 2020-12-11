public class Ninja extends Human{

public Ninja(){
this.stealth = 10;
}

public void steal(Human name){
    name.health -= this.stealth; 
    this.health += this.stealth;
}
public void runAway(){
    this.health -= 10;
}
public int getHealth(){
    return health;
}
public void setHealth(int health){
    this.health = health;  
}
}