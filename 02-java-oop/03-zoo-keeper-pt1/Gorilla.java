
public class Gorilla extends Mammal{

    public Gorilla(int energyLevel){
        super(energyLevel);
    }

    public void throwSomething(){
        System.out.println("The gorilla threw something");
        energyLevel -= 5;
    }
    public void eatBananas(){
        System.out.println("The gorilla thought that was yummy!");
        energyLevel += 10; 
    }
    public void climb(){
        System.out.println("The gorilla climbed a tree");
        energyLevel -= 10;
    }
}