public class Bat extends Mammal{

    public Bat(){
        super(500);
    }

    public void fly(){
        System.out.println("swoosh");
        energyLevel -= 50;
    }
    public void eatHumans(){
        energyLevel += 25;
    }
    public void attackTown(){
        System.out.println("*crackling*");
        energyLevel -= 100; 
    }
    


}