import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee {
	//create variables
	private int ID;
	private String EmpPhoneNumber,EmployeeFN,EmployeeTitle,EmployeeDep,EmployeeEmail,EmpNum;
	
	//creat set and get methods
	public String getEmpNum() {
		return EmpNum;
	}
	public void setEmpNum(String empNum) {
		EmpNum = empNum;
	}
	public String getEmpPhoneNumber() {
		return EmpPhoneNumber;
	}
	public void setEmpPhoneNumber(String empPhoneNumber) {
		EmpPhoneNumber = empPhoneNumber;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getEmployeeFN() {
		return EmployeeFN;
	}
	public void setEmployeeFN(String employeeFN) {
		EmployeeFN = employeeFN;
	}
	public String getEmployeeTitle() {
		return EmployeeTitle;
	}
	public void setEmployeeTitle(String employeeTitle) {
		EmployeeTitle = employeeTitle;
	}
	public String getEmployeeDep() {
		return EmployeeDep;
	}
	public void setEmployeeDep(String employeeDep) {
		EmployeeDep = employeeDep;
	}
	public String getEmployeeEmail() {
		return EmployeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		EmployeeEmail = employeeEmail;
	}
	

	//create regex methods
	public void inputempNum(String EmpNum) throws InvalidEmployeeDetailException {
		String regexNumber="^^(E01)([0-9][1-9]|[1-9][0-9])$";
		Pattern ptrn1 = Pattern.compile(regexNumber);
		Matcher firstmatch = ptrn1.matcher(EmpNum);
		if (firstmatch.matches()) {
			System.out.println("data added succesfully");
			
		} else {
			throw new InvalidEmployeeDetailException() ;


		}
	

		
		
	}
	public void inputEmployeePhonenumber(String EmployeePhoneNumber) throws InvalidEmployeeDetailException {
		String regexPhoneNumber="^^(06|07)(0|5|6|7|9)\\d{7}$";
		Pattern ptrn2 = Pattern.compile(regexPhoneNumber);
		Matcher secondmatch = ptrn2.matcher(EmployeePhoneNumber);
		if (secondmatch.matches()) {
			System.out.println("data added succesfully");
			
		} else {
			throw new InvalidEmployeeDetailException() ;


		}
	}
	public void inputEmployeeFN(String EmployeeFN) throws InvalidEmployeeDetailException {
		String regexEmployeeFN="^^[a-zA-Z]{3,10}\\s[a-zA-Z]{3,10}$";
		Pattern ptrn3 = Pattern.compile(regexEmployeeFN);
		Matcher thirdmatch = ptrn3.matcher(EmployeeFN);
		if (thirdmatch.matches()) {
			System.out.println("data added succesfully");
			
		} else {
			throw new InvalidEmployeeDetailException() ;


		}
	}
	public void inputEmployeeTitle(String EmployeeTitle) throws InvalidEmployeeDetailException {
		String regexEmployeeTitle="^^(Director|Manager|Assistant|Supervisor|Trainee)$";
		Pattern ptrn4 = Pattern.compile(regexEmployeeTitle);
		Matcher fourthmatch = ptrn4.matcher(EmployeeTitle);
		if (fourthmatch.matches()) {
			System.out.println("data added succesfully");
			
		} else {
			throw new InvalidEmployeeDetailException() ;


		}
	}
	public void inputgetEmployeeDep(String EmployeeDep) throws InvalidEmployeeDetailException {
		String regexEmployeeDep="^^(IT|Sales|R&D|Prod|HR)$";
		Pattern ptrn5 = Pattern.compile(regexEmployeeDep);
		Matcher fifthmatch = ptrn5.matcher(EmployeeDep);
		if (fifthmatch.matches()) {
			System.out.println("data added succesfully");
			
		} else {
			throw new InvalidEmployeeDetailException() ;


		}
	}
	public void inputgetEmployeeEmail(String EmployeeEmail) throws InvalidEmployeeDetailException {
		String regexEmployeeEmail="^^[a-zA-Z]{1,2}\\.[a-zA-Z]{3,10}((\\_{0,1}\\d{0,1})|(\\d{0,1}\\_{0,1}))@logicaly.net$";
		Pattern ptrn6 = Pattern.compile(regexEmployeeEmail);
		Matcher sixthmatch = ptrn6.matcher(EmployeeEmail);
		if (sixthmatch.matches()) {
			System.out.println("data added succesfully");
			
		} else {
			throw new InvalidEmployeeDetailException() ;


		}
		
	}

		
	}
	
	


