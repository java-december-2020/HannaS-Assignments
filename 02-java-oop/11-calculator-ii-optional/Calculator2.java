import java.util.ArrayList; 
public class Calculator2{

    private double result;
    ArrayList<Character> operators = new ArrayList<Character>();
    ArrayList<Double> nums = new ArrayList<Double>();

    public Calculator2(){
    }

    public void getResult(){
        System.out.println(result); 
    } 
    
    public void performOperation(double num){
        nums.add((double) num);
    }
    public void performOperation(int num){
        nums.add((double) num);
    }

    public void performOperation(Character ch){
        if(ch != '='){
            operators.add(ch);
        }
        Double currentTotal = nums.get(0);

        for (int i = 0; i < operators.size(); i++){
            if(operators.get(i) == '+'){
                currentTotal = currentTotal + nums.get(i); break;

            }else if (operators.get(i) == '-'){
                currentTotal = currentTotal - nums.get(i); break;

            }else if (operators.get(i) == '/'){
                currentTotal = currentTotal / nums.get(i); break;
            }else if (operators.get(i) == '*'){
                currentTotal = currentTotal * nums.get(i);
            }else {
                System.out.println("Operator unrecognizable."); break; 
            }
        }
        this.result = currentTotal; 
    }

}