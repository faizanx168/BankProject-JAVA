import java.util.Vector;
import java.util.Scanner;

public class Bank extends bankAccount {
private Vector<bankAccount> Bankaccounts;
public int actNum = 1111;
public Bank() {
	Bankaccounts = new Vector<bankAccount>();
}

public void addNewAccount(){
	Scanner sc = new Scanner(System.in);
    Client a = new Client();
    bankAccount account = new bankAccount();
    account.setPrimaryHolder(a);
    System.out.println("Please Enter todays's date:\n");
    String dat = sc.nextLine();
    Date d = new Date(dat);
    account.setOpeningDate(d);
    account.setLastInterestDay(d);
    input(a);
    account.setAccountNum(actNum);
    actNum++;
    Bankaccounts.add(account);
    System.out.println(account.toString());
}

public Vector<bankAccount> getBankaccounts() {
	return Bankaccounts;
}

public void setBankaccounts(Vector<bankAccount> bankaccounts) {
	Bankaccounts = bankaccounts;
}

public bankAccount getAccount(int ssn) {
    for (bankAccount account : Bankaccounts) {
        if (account.getMember().getSSN() == ssn) return account;
    }
    return null;

}
public bankAccount getAccount(String FN, String LN) {
    for (bankAccount account : Bankaccounts) {
        if ((account.getMember().getfName().equals(FN))&&(account.getMember().getfName().equals(LN))) return account;
    }
    return null;
}

public void modify(){
	boolean exit = false;
	int option;
	int SSN = 0;
	String name = "";
	do {
    Scanner sc = new Scanner(System.in);
	System.out.println("1. Change First Name\n"+ "2. Change last Name\n"+ "3. Add Secondary holders\n"+ "4. Change Address\n"+ "5. Modify date of birth\n"+ "6. Exit\n");
	System.out.print("Enter Your choice : ");
	option = sc.nextInt();
	
	switch (option){
	case 1:  
		System.out.println("Please enter SSN number\n");
		SSN = sc.nextInt();
		int temp=0;
		for (int i = 0; i<Bankaccounts.size();i++){
			if(SSN==Bankaccounts.elementAt(i).getMember().getSSN()){
	      System.out.println("Please Enter your First Name:\n");
	       sc.nextLine();
		   name = sc.nextLine();
			Bankaccounts.elementAt(i).getMember().setfName(name);
			System.out.println("Your new details are: "+Bankaccounts.elementAt(i).toString());
				break;
				}
			else {
				temp +=1;
			}
			break;
		}
		if(temp > 0) {
			System.out.println("Account number doesn't exist:\nPlease try again!");
		}
		break;
	
	case 2:
		System.out.println("Please enter SSN number\n");
		SSN = sc.nextInt();
		temp = 0;
		for (int i = 0; i<Bankaccounts.size();i++){
			if(SSN==Bankaccounts.elementAt(i).getMember().getSSN()){
	      System.out.println("Please Enter your Last Name:\n");
	      sc.nextLine();
		 name = sc.nextLine();
			Bankaccounts.elementAt(i).getMember().setfName(name);
			System.out.println("Your new details are: "+Bankaccounts.elementAt(i).toString());
				break;
				}
			else {
				temp += 1;
			}
			break;
		}
		if(temp > 0) {
		System.out.println("Account number doesn't exist:\nPlease try again!");
		}
		break;
		
	case 3:
		System.out.println("Please enter SSN number\n");
		SSN = sc.nextInt();
		temp = 0;
		Vector<String> holders = new Vector<String>(3);
		for (int i = 0; i<Bankaccounts.size();i++){
			if(SSN==Bankaccounts.elementAt(i).getMember().getSSN()){
				do {
	       System.out.println("Please Enter your Secondary holder Name: (Press N once done)");
	       sc.nextLine();
		   name = sc.nextLine();
		   holders.add(name);
		   Bankaccounts.elementAt(i).setSecondaryHolders(holders);
		
			}while(!name.equals("N"));
				System.out.println("Your new details are: "+Bankaccounts.elementAt(i).toString());
				
				}
			else {
				temp+=1;
			}
			break;
		}
		if(temp > 0) {
		System.out.println("Account number doesn't exist:\nPlease try again!");
		}
		break;
	case 4:
		System.out.println("Please enter SSN number\n");
		SSN = sc.nextInt();
		temp = 0;
		for (int i = 0; i<Bankaccounts.size();i++){
			if(SSN == Bankaccounts.elementAt(i).getMember().getSSN()){
	        System.out.println("Please Enter your new Address:\n");
	        sc.nextLine();
		    name = sc.nextLine();
			Bankaccounts.elementAt(i).getMember().setAddress(name);
			System.out.println("Your new details are: "+Bankaccounts.elementAt(i).toString());
				}
			else {
				temp +=1;
			}
			break;
		}
		if(temp > 0) {
		System.out.println("Account number doesn't exist:\nPlease try again!");
		}
		break;
		
	case 5:
		System.out.println("Please enter SSN number\n");
		SSN = sc.nextInt();
		temp = 0;
		for (int i = 0; i<Bankaccounts.size();i++){
			if(SSN==Bankaccounts.elementAt(i).getMember().getSSN()){
	      System.out.println("Please Enter your date of birth:\n");
	      sc.nextLine();
			name = sc.nextLine();
			Date bDay = new Date(name);
			Bankaccounts.elementAt(i).getMember().setBirthday(bDay);
			System.out.println("Your new details are: "+Bankaccounts.elementAt(i).toString());
				break;
				
			}else {
				temp += 1;
			}
			break;
		}
		if(temp > 0){
			System.out.println("Account number doesn't exist:\nPlease try again!");
		}
		case 6:
			exit = true;
			break;
			
		default:System.out.println("Please Enter correct option:");
			break;
			
			}

}while(!exit);
}

public void removeAccount(){
	Scanner sc = new Scanner(System.in);
	int index=0;
	System.out.println("Please Enter Account Number:\n");
	int accountNumber;
	accountNumber = sc.nextInt();
	for (int i = 0; i<Bankaccounts.size();i++){
		if(accountNumber==Bankaccounts.elementAt(i).getAccountNum()){
	index=i;
			}
	}
	System.out.println("ARE YOU SURE ABOUT DELETEING YOUR ACCOUNT? Enter Y/y\n");
	sc.nextLine();
	String st = sc.nextLine();
	if (st.contains("y")|| st.contains("Y"))
	{
		Bankaccounts.remove(index);
	}

}

public void input(Client isNew) {
Scanner sc = new Scanner(System.in);
System.out.println("Please Enter your First Name:\n");
String name = sc.nextLine();
isNew.setfName(name);
System.out.println("Please Enter your Last Name:\n");
String lname = sc.nextLine();
isNew.setLname(lname);
System.out.println("Please Enter your Address:\n");
String add = sc.nextLine();
isNew.setAddress(add);
System.out.println("Please Enter your Date of Birth:\n");
String bd = sc.nextLine();
Date bdate = new Date(bd);
isNew.setBirthday(bdate);
System.out.println("Please Enter your SSN:\n");
int SSN = sc.nextInt();
isNew.setSSN(SSN);

}
}
