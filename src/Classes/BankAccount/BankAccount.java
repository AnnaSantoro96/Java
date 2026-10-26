package Classes.BankAccount;

public class BankAccount {

    private String owner;
    private double balance;

    public BankAccount(String owner, double balance) {
        this.owner = owner;

        if (balance > 0) {
        this.balance = balance;
        } else {
        IO.println("ERROR...value not correct");
        }
    }

    public double getBalance() {
        return balance;
    }



    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void deposit(double value){
        if(value > 0){
            balance = balance + value;
        }else {
            System.out.println(
                    "ERROR: the value must be greater than zero"
            );
        }

    }

    public void withdraw(double value){
        if(value <= balance && value > 0){
            balance = balance - value;
        }else {
            System.out.println(
                    "ERROR: the value must be less than balance"
            );
        }

    }

}
