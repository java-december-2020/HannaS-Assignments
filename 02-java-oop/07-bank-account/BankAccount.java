import java.util.Random; 
import java.util.ArrayList;

public class BankAccount{

private String accountNumber;
private double checkingBalance; 
private double savingsBalance; 

public static int numOfAccounts = 0;
public static double currentTotalBalance = 0; 

private static String accountNumberGenerator(){
    Random r = new Random(); 
    ArrayList<Integer> digits = new ArrayList<Integer>();
    String newAccountNum = "";
    for (int i = 0; i < 10; i++){
        digits.add(i);
    }
    for (int i = 10; i > 0; i--) {
        int randomDigit = r.nextInt(i);
        newAccountNum += digits.get(randomDigit);
    }   
return newAccountNum; 
}
public BankAccount(){
    this.checkingBalance = 0;
    this.savingsBalance = 0;
    this.accountNumber = BankAccount.accountNumberGenerator();
    numOfAccounts++;
}

public double getCheckingBalance(){
    return checkingBalance; 
}

public double getSavingsBalance(){
    return savingsBalance; 
}

public void deposit(double deposit, String account){
    if(account.equals("savings")){
        this.savingsBalance += deposit; 
    }else if(account.equals("checking")){
        this.checkingBalance += deposit; 
    }
    BankAccount.currentTotalBalance += deposit; 
}
public void withdrawel(double withdrawel, String account){
    boolean success = false; 
    if(account.equals("savings")){
        if(this.savingsBalance - withdrawel >= 0){
            success = true;
            this.savingsBalance -= withdrawel; 
        }
    }else if(account.equals("checking")){
        if(this.checkingBalance - withdrawel >= 0){
            success = true; 
            this.checkingBalance -= withdrawel; 
        }
    }
    if(success){
        BankAccount.currentTotalBalance -= withdrawel; 
    }
}
public void displayTotal(){
    System.out.println("Savings Balance: " + savingsBalance);
    System.out.println("Checking Balance: " + checkingBalance);
}
public void displayAccNum(){
    System.out.println(this.accountNumber);
}
}