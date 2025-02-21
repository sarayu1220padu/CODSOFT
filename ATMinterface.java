import java.util.Scanner;
public class ATMinterface 
{
    private double balance;
    public ATMinterface(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

     
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount.");
        }
    }

     
    public void checkBalance() {
        System.out.println("Your current balance is: " + balance);
    }

     
    public void displayMenu() {
        System.out.println("\nWelcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

     
    public void handleUserInput() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            try {
                choice = sc.nextInt();  
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();  
                choice = 0;  
                continue;
            }

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    try {
                        double depositAmount = sc.nextDouble();
                        deposit(depositAmount);
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter a valid amount.");
                        sc.nextLine();  
                    }
                    break;
                case 3:
                    System.out.print("Enter the amount to withdraw: ");
                    try {
                        double withdrawAmount = sc.nextDouble();
                        withdraw(withdrawAmount);
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter a valid amount.");
                        sc.nextLine();  
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Have a nice day!!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        sc.close();  
    }
 
    public static void main(String[] args) {
        ATMinterface a = new ATMinterface(1000);  
        a.handleUserInput();  
    }
}