import java.util.ArrayList;

public class Portfolio{

    public ArrayList<Projects> allProjects; 
    public Portfolio() {
        this.allProjects = new ArrayList<Projects>();
    }
    public void AddToPortfolio(Projects p){
        allProjects.add(p);
    }
    public String getPortfolio(){
        return allProjects.toString();
    }
    public double getPortfolioCost(){
        double total = 0;
        for (Projects p : allProjects){
            total += p.getInitCost();
        }
        return total; 
    }
public void showPorfolio(){
    System.out.println("All projects: ");
    for(Projects p : allProjects){
        System.out.println(p.elevatorPitch());
    }
    System.out.println("Total Cost: "  + this.getPortfolioCost());
    }

}