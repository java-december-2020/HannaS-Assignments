public class Calculator{

    private double result;
    private char operation;  
    private double num1; 
    private double num2; 

    public Calculator(){

    }

    public void getResult(){
        System.out.println(result); 
    }
    public void setNum1(double num1){
        this.num1 = num1; 
    }
    public void setNum2(double num2){
        this.num2 = num2; 
    }
    public void setOperation(char x){
        this.operation = x; 
    }
    
    public void performOperation(){
        if(this.operation == '+'){
            result = (num1) + (num2); 
        }else if(this.operation == '-'){
            result = (num1) - (num2); 
        }
    }
}