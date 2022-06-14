
public class Date {
	static int[] daysInMonth = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private int day, month, year;
	
	public int getDay() {
		return day;
	}

	public Date() {
		day = month = 01;
		year = 2000;
	}
	
	public Date(int m, int d, int y) {
		if(m < 1 || m > 12) {
			System.out.println("invalid month");
			return;
		}
		//still have to deal the leap year for February 
		//29  is good if leap year
		if( m == 2 && d > 28 && !isLeap(y)) {
			System.out.println("Faebruary does not have that many days");
			return;
		}
		if(d > daysInMonth[m] || d < 1) {
			System.out.println("invalid day");
			return;
		}
		month = m;
		day = d;
		year = y;
	}
	
	//constructor that accepts a string in the form of mm/dd/yy or yyyy-mm-dd
	public Date(String s) {
		if(s.contains("/")) {
			//the formis mm/dd/yyyy split the string at /
			String[] strSplit = s.split("/");
			if(strSplit.length != 3) {
				System.out.println("The date is in an invalid format");
			}
			this.year = Integer.parseInt(strSplit[2]);
			this.setMonth(Integer.parseInt(strSplit[0]));
			//strSplit[0] would be day 
			this.setDay(Integer.parseInt(strSplit[1])); //converts a string into an integer	
		}else if (s.contains("-")) {
			//the formis yyyy-mm-dd split the string at /
			String[] strSplit = s.split("-");
			if(strSplit.length != 3) {
				System.out.println("The date is in an invalid format");
			}
			this.year = Integer.parseInt(strSplit[0]);
			this.setMonth(Integer.parseInt(strSplit[1]));
			//strSplit[0] would be day 
			this.setDay(Integer.parseInt(strSplit[2])); //converts a string into an integer	
		}else {
			System.out.println("Invalid date");
		}
	}
	
	public void setDay(int d) {
		
		if( this.month == 2 && d > 28 && !isLeap(this.year)) {
			System.out.println("February does not have that many days");
			return;
		}
		if(d > daysInMonth[this.month] || d < 1) {
			System.out.println("invalid day");
			return;
		}
		this.day = d;
		
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int m) {
		if(m < 1 || m > 12) {
			System.out.println("invalid month");
			return;
		}
		this.month = m;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	//return true if y is leap year and false if not.
	//A leap year is a year divisible by 4 but not by 100 or divisible by 400
	public boolean isLeap(int y) {
		if((y%4 == 0 && y%100 != 0) || (y%400 == 0)) {
		return true;
		}else 
			return false;
	}
	
	public String toString() {
		String st = this.month + "/" + this.day + "/" + this.year; //"23/03/1999"
		return st;
	}

}
