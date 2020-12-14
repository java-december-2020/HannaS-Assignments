public class CalculatorTester{

    public static void main(String[] args){

        Calculator newOp = new Calculator();

        newOp.setNum1(10.5);
        newOp.setNum2(5.2);
        newOp.setOperation('+');
        newOp.performOperation();
        newOp.getResult();


    }
}