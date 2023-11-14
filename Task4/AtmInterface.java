import java.util.Scanner;

class UserAccount 
{
    double account_balance=0.00;
}
class Atm extends UserAccount{
    public boolean withdraw(double amount)
    {
        double cost=account_balance-amount;
        if (cost>0)
        {
            account_balance=account_balance-amount;
        }
        else
        {
            return false;
        }
        return true;
    }
    public void deposit(double amount)
    {
        account_balance=account_balance+amount;
    }
    public double checkBalance()
    {
        return account_balance;
    }
}

public class AtmInterface {
    public static void main(String args[])
    {
        System.out.println("--------------------------------");
        System.out.println("ATM INTERFACE");
        System.out.println("--------------------------------");
        Atm atm = new Atm();
        while (true) 
        {
            System.out.println("--------------------------------");
            System.out.println("press 1 to Check Balance\npress 2 to Deposit Amount\npress 3 to WithDraw Amount\npress 4 to exit");
            System.out.println("--------------------------------");
            Scanner sc = new Scanner(System.in);
            int option=sc.nextInt();
            switch(option)
            {
                case 1:
                {
                   System.out.println("--------------------------------");
                   System.out.println("Your Account Balance : "+atm.checkBalance());
                   break;
                }
                case 2:
                {
                    System.out.println("--------------------------------");
                    System.out.println("Enter Amount to be Deposited:");
                    double amt=sc.nextDouble();
                    atm.deposit(amt);
                    System.out.println("--------------------------------");
                    System.out.println("Transaction Successful Amount Successfully Deposited");
                    break;
                }
                case 3:
                {
                    System.out.println("--------------------------------");
                    System.out.println("Enter Amount to be WithDrawn:");
                    double amt=sc.nextDouble();
                    if (atm.withdraw(amt))
                    {
                        System.out.println("--------------------------------");
                        System.out.println("Transaction Successful...");
                        System.out.println("Your Account is Debited with Rs."+amt);
                    }
                    else
                    {
                        System.out.println("--------------------------------");
                        System.out.println("Transaction Failure...");
                        System.out.println("Your Account Has Insufficient Balance....Can't make transaction..");
                    }
                    
                    break;
                }
                case 4:
                {
                    System.exit(0);
                }
                default:
                {
                    System.out.println("--------------------------------");
                    System.out.println("You may have selected a wrong option");
                    System.out.println("--------------------------------");
                }
            }
        }
    }
}
