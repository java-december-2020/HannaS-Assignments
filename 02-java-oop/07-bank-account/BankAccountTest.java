public class BankAccountTest{
    public static void main(String[] args){

    BankAccount newBankAccount = new BankAccount(); 

    newBankAccount.deposit(2000.00, "checking");
    newBankAccount.deposit(800.50, "savings");
    newBankAccount.displayTotal();

    System.out.println(BankAccount.currentTotalBalance);

    newBankAccount.withdrawel(600, "checking");
    newBankAccount.withdrawel(90.39, "savings");
    newBankAccount.displayTotal();
    
    System.out.println(BankAccount.currentTotalBalance);
    System.out.println(BankAccount.numOfAccounts);
    newBankAccount.displayAccNum();
}

}