public class Calculator2Tester{


public static void main(String[] args){

    Calculator2 newCalc = new Calculator2();

    newCalc.performOperation(10.5);
    newCalc.performOperation('+');
    newCalc.performOperation(5.2);
    newCalc.performOperation('*');
    newCalc.performOperation(10);
    newCalc.performOperation('=');
    newCalc.getResult(); 

}

}