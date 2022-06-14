import java.util.Vector;
import java.time.LocalDate;  
import java.time.Duration;
/*
 * Design a class that serves as records of bank accounts. Member variables are 
 * - balance
 * - interest rate
 * - last date interest was payed.
 * - date of opening the account 
 * - primary member client (see Client class)
 * - Vector of secondary holders up to three secondary holders
 * - Methods:
 * - getters and setters fo balance, interest rate, primary holder, ....
 * - payInterest that computes the interest to be payed starting at the last date to today.
 * - deposit(double m) deposits increases balance by m
 * - widhdraw(double m) decreases the balance by m or set to 0 if not enough funds. 
 * - setPrimaryHolder(Client C) changes primary holder to new Client.  
 */
public class bankAccount  {
private double balance;
private double interestRate;
private Date lastInterestDay;
private Date openingDate;
private Client member;
private Vector<String> secHolders;
private int accountNum;

public bankAccount(){
	this.balance = 0;
	this.interestRate = 0.06;
}

public int getAccountNum() {
	return accountNum;
}
public void setAccountNum(int accountNum) {
	this.accountNum = accountNum;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public double getInterestRate() {
	return interestRate;
}
public void setInterestRate(double interestRate) {
	this.interestRate = interestRate;
}
public Date getLastInterestDay() {
	return lastInterestDay;
}
public void setLastInterestDay(Date lastInterestDay) {
	this.lastInterestDay = lastInterestDay;
}
public Date getOpeningDate() {
	return openingDate;
}
public void setOpeningDate(Date openingDate) {
	this.openingDate = openingDate;
}
public Client getMember() {
	return member;
}

public void setMember(Client member) {
	this.member = member;
}

public Vector<String> getSecHolders() {
    return secHolders;
}

public void setSecondaryHolders(Vector<String> secHolder) {
	secHolder = new Vector<String>();
    this.secHolders = secHolder;
	}

public double computeInterest() {
	LocalDate today = LocalDate.now();
	LocalDate last = LocalDate.parse(this.lastInterestDay.toString());
	Duration diff = Duration.between(today, last);
	long difference = diff.toDays();
	double interest = (balance * interestRate * difference/365)/100;
	return interest;
}

public void deposit(double m) {
    if(m > 0) {
	this.balance = balance + m;
}
    else{
    	 System.out.println("Please Enter a valid number:\n");
    	 }
    }

public void withdraw(double m) {
    if(this.balance < m)
    	this.balance = 0;
    else
    	this.balance -= m;
}
public void setPrimaryHolder(Client m) {
	this.member = m;
}

@Override
public String toString() {
	return  "bankAccount [balance=" + balance + ", interestRate=" + interestRate + ", lastInterestDay=" + lastInterestDay
			+ ", openingDate=" + openingDate + ", member=" + member + ", secHolders=" + secHolders + ", accountNum="
			+ accountNum + "]";
}

}
