// importing the scanner class to take value frome user
import java.util.Scanner;
// main class ninjaatm
public class NinjaAtm {

    public static void main(String[] args){
        // intialization and declaration of varibales
        // intialize the variable with the specific limit to that user can not exceed  
        int pin = 2311 ;
        int balance = 50000;
        int Addamount ;
        int Takeamount ;
        // invokeing the scanner class 
        Scanner scanner  = new Scanner(System.in);
        System.out.println("Enter your pin number: ");
        int password = scanner.nextInt(); // password by user
        scanner.nextLine();
        /*  if condition to check the password is correct or not if it is correct then
        enter in the condition unless exit with wrong pin*/
        if(password == pin)
        {
            System.out.print("Enter your Name: ");
            String name = scanner.nextLine();
            System.out.println("Welcome "+ name);
         //while condition to select the statement if no that from then invalid operation
            while (true)
            {
                System.out.println("For Check Balance Press 1 ");
                System.out.println("For Deposite Money Press 2");
                System.out.println("For Withdraw Money Press 3");
                System.out.println("For Transfer Money Press 4");
                System.out.println("For Exit Press 5 ");
                System.out.println("For Customer care no. Press 6");
                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

                int option = scanner.nextInt();
                // switch statement to go for the whatever the user need like
                // alis as check ,enquiry,balance and many more.....
                switch (option)
                {// case one for check balance
                    case 1:
                        System.out.println("================================");
                        System.out.println("Your current Balance is : "+balance);
                        System.out.println("================================");
                        break;
                // case two for deposit amount on your own account
                    case 2:
                        System.out.print("Enter the amount you want to Deposited : ");
                        Addamount = scanner.nextInt();
                        System.out.println("================================");
                        System.out.println("Amount credited Sucessfully!");
                        System.out.println("================================");
                        balance=Addamount + balance;
                        break;
                /*  case three for withdrow amount by putting the condition as 
                    withdrow no < balance */
                    case 3:
                        System.out.print("How much amount do you want to withdraw:   ");
                        Takeamount = scanner.nextInt();
                        if(Takeamount>balance)
                        {
                            System.out.println("================================");
                            System.out.println("Insufficient Balance!");
                            System.out.println("Try Less than your current balance account");
                            System.out.println("================================");
                        }
                        else
                        {   System.out.println("================================");
                            System.out.println("Amount debited Sucessfully!");
                            System.out.println("================================");
                        }
                        balance = balance - Takeamount;
                        break;
                    // case four for transfer amount to another account 
                    case 4:
                        int a=0;
                        System.out.println("================================");
                        System.out.println("Enter the amount you want to transfer : ");
                        System.out.println("--------------------------------");
                        a= scanner.nextInt();
                        System.out.println("Enter the Account No of Reciever");
                        scanner.nextInt();
                        System.out.println("--------------------------------");
                        System.out.println("Amount Transferred!");
                        balance=balance-a;
                        System.out.println("--------------------------------");
                        System.out.println("Current Balance : "+balance);
                        System.out.println("--------------------------------");
                        System.out.println("Thank You Visit Again :)");
                        System.out.println("================================");
                        break;
                    // case five for exit the process
                    case 5:
                        System.out.println("Collect Your Card :)");
                        System.exit(0);
                    // case six for contact with bank customer care
                    case 6:
                        System.out.println("Customer care Number:88888555555");
                        break;

                }
                if(option>6)
                {
                    System.out.println("Invalid Operation");
                    break;
                }
            }
        }
        // earlier  already mention at the starting of if condition
        else
        {
            System.out.println("Wrong Pin Number!");
        }
    }
}
