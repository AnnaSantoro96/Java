package Classes.BankAccount;

import java.util.Scanner;

public class Main {
    static void main() {

        Scanner in = new Scanner(System.in);
        IO.println("Enter your first and last name");
        String owner = in.nextLine();

        IO.println("Enter your balance");
        double balance = in.nextDouble();

        BankAccount ba = new BankAccount(owner, balance);

        IO.println("Enter the value to deposit");
        ba.deposit(in.nextDouble());

        IO.println("Enter the value to withdraw");
        ba.withdraw(in.nextDouble());

        IO.println("Owner: " + ba.getOwner() + "\nCurrent balance: " + ba.getBalance());
    }
}
