
import java.util.Scanner;

public class BankProject {

	public static void main(String[] args) {
		int tmp = 0;
//		int balance = 0;
//		int index = 0;
		int withdraw = 0;
		int userChoice = 0;
		System.out.println("Welcome to Java Bank\n");
		System.out.println("JAVA BANK MENU\n");
		
		 Bank user = new Bank(); // initilaize -- name,acc_number,Balance,Type
         
         boolean quit = false;

         do {
        	   Scanner in = new Scanner(System.in);
               System.out.println("1. Create Account");
               System.out.println("2. Deposit money");
               System.out.println("3. Withdraw money");
               System.out.println("4. Check balance");
               System.out.println("5. Display Account Details");
               System.out.println("6. to Modify account details");
               System.out.println("7. to Quit: \n");
               System.out.print("Enter Your Choice : ");
               userChoice = in.nextInt();
               switch (userChoice) {
               case 1:
                     user.addNewAccount();
                     System.out.println("\n\tDont Forget Account Number\n");
                     System.out.println("**************************");                       
                     break;
                   
             case 2: // deposit
            	 System.out.println("Please enter SSN number\n");
     			tmp = in.nextInt();
     			int temp = 0;
     			for (int i = 0; i<user.getBankaccounts().size();i++){
     				if(tmp == user.getBankaccounts().elementAt(i).getMember().getSSN()){
     				System.out.println("Please Enter the Amount you want to deposit:\n");
     				int amount = in.nextInt();
     				user.getBankaccounts().elementAt(i).deposit(amount);
     				System.out.println("Deposit Successful\n");
     			    System.out.println("Your Current Balance is: "+user.getBankaccounts().elementAt(i).getBalance());
     				}else {
     					temp =+ 1;
     				}
     				break;
     			}				
     			if(temp > 0) {
     				System.out.println("Account number doesn't exist:\nPlease try again!");
     			}
     			
                break; 
                 
               case 3: // withdraw money                      
                 
           
                   System.out.println("Please enter SSN number\n");
                   tmp=in.nextInt();
                 temp  = 0;
           		for (int i = 0; i<user.getBankaccounts().size();i++){
           			
                       if(tmp == user.getBankaccounts().elementAt(i).getMember().getSSN()){                         
                          if(user.getBankaccounts().elementAt(i).getBalance()==0)
                          {
                        	  System.out.print("Your Account is Empty.");
                        	  break;
                          }
                          else{
                          System.out.print("Enter Amout Of Money : ");   
                          withdraw=in.nextInt();   
                          
                          if(withdraw > user.getBankaccounts().elementAt(i).getBalance()){
                          System.out.print("Enter Valid Amout of Money : ");
                          withdraw=in.nextInt();
                          }
                          else
                        user.getBankaccounts().elementAt(i).withdraw(withdraw);
                        System.out.println("Your Current Balance is: "+user.getBankaccounts().elementAt(i).getBalance());   
                       
                                     }
                          break;
                       }
                       else {
                    	   temp += 1;
                       }
                       break;
                          
           		}
           		if(temp > 0)
           		{
                    System.out.println("Wrong Accoount Number."); 
           		}
               break;
               
               case 4: // check balance 1
            	   System.out.println(  user.getBankaccounts().size());  
            	   System.out.print("Enter your SSN Number : ");
                   tmp=in.nextInt();
                   for (int i = 0; i<user.getBankaccounts().size();i++){
       			       if(tmp == user.getBankaccounts().elementAt(i).getMember().getSSN()){ 
                          System.out.println("Your Current Balance : "+user.getBankaccounts().elementAt(i).getBalance());
                    
                          }
       			       break;
                   }
                 
                   break;
               case 5: // display all info 
            	   System.out.print("Enter your SSN Number : ");
                   tmp=in.nextInt();
                   for (int i = 0; i<user.getBankaccounts().size();i++){
       			       if(tmp == user.getBankaccounts().elementAt(i).getMember().getSSN()){ 
                          System.out.println("Your Account details Are: "+user.getBankaccounts().elementAt(i).toString());
                          }
                 break;
                   }
                   break;
               case 6:
                        user.modify();
                     
                   break;
               case 7:
                     quit = true;
                     break;
               default:
                     System.out.println("Wrong Choice.");
                     break;
               }
               System.out.println("\n");

   } while (!quit);
         System.out.println("Thanks !");
          
  } //  end main function 
 
 //  end mian class

	}

