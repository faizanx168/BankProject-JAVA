
public class Client {
private String fName;
private String Lname;
private Date birthday;
private String address;
private int SSN;

Client(){
	
}
public String getfName() {
	return fName;
}
public void setfName(String fName) {
	this.fName = fName;
}
public String getLname() {
	return Lname;
}
public void setLname(String lname) {
	Lname = lname;
}
public Date getBirthday() {
	return birthday;
}

public void setBirthday(Date birthday) {
	this.birthday = birthday;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getSSN() {
	return SSN;
}
public void setSSN(int sSN) {
	SSN = sSN;
}

@Override
public String toString() {
	return "Client [fName=" + fName + ", Lname=" + Lname + ", birthday=" + birthday + ", address=" + address + ", SSN="
			+ SSN + "]";
}
}
