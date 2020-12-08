public class Projects{

private String name; 
private String description; 
private String defaultName = "default name";
private String defaultDescription = "default description";
private double initialCost; 

public double getInitCost(){
    return initialCost; 
}
public void setCost(double cost){
    this.initialCost = cost;
}

public String getName(){
    return name; 
}
public void setName(String name){
    this.name = name;
}

public String getDesc(){
    return description; 
}
public void setDesc(String description){
    this.description = description; 
}

public String elevatorPitch(){
    return getName() + " (" + getInitCost() + ")" + ":" + getDesc();
}

public void Project(){
name = defaultName; 
description = defaultDescription; 
}

public void Project(String name){
this.name = name;
this.description = defaultDescription; 
}
public void Project(String name, String description, double cost){
this.description = description; 
this.name = name;
this.initialCost = cost; 
}

public static void main(String[] args){
    Projects n = new Projects();
    n.name = "New Project";
    n.description = "This is my newest project";
    n.initialCost = 2000;
    
    n.elevatorPitch();
}
}