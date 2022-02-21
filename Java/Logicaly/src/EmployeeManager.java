import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class EmployeeManager {
	//create Exit boolean to repeat the logicaly menu and not end on one number(it is in the main method we will come back to it later )
	static Boolean Exit=false;
	//create retry boolean to repeat the user input and not end if the user doesn't match the input regex
	static Boolean retry=true;
	//retry(n) booleans will be used in the addmethod
	static Boolean retry1=true;
	static Boolean retry2=true;
	static Boolean retry3=true;
	static Boolean retry4=true;
	static Boolean retry5=true;
	static Boolean retry6=true;


	//count can be used and increment in all the methods since it's static so i can increment in the add method and use it in the other methods
	public static int count=1;
	
	//we use a Hashmap hear so that the user can go through employee's information using the key only
	static HashMap<String,List<Object>> EmployeeHash=new HashMap<String,List<Object>>();





	public void addEmployee() throws InvalidEmployeeDetailException {
		
		//we use an Object arraylist because count is an integer and the other informations are String
		List<Object> lstObject = new ArrayList<Object>();
        //create object of type Employee to use Employee class methods
		Employee emp = new Employee();
		//Open the Scanner to take user input
		Scanner info = new Scanner(System.in);
	
		//a loop that includes all the regex methods and we can get out of it only if we type all the informations correct(matches all the regexes) else it throws a customizable exception
		while(retry==true) {
			
			while(retry1==true) {
		System.out.println("Employee Number");
		String EmployeeNumber = info.next();
		if(EmployeeHash.keySet().contains(EmployeeNumber)) {
		System.err.println("The employee number is already in the database try again");
			info.nextLine();
		}
		else {
			emp.setEmpNum(EmployeeNumber);
			try {
				emp.inputempNum(emp.getEmpNum());
				retry1=false;


				}
				catch(InvalidEmployeeDetailException e) {
					System.err.println("the number should contain five characters starting with E01 followed by two digits different than 00 try again");
					
				}
		}
		

				
		
			}
		//didn't use full name because scanner.next() does not detect the space 
			while(retry2==true) {
		System.out.println("Employee First name");
		String EmployeeFirstName = info.next();
		System.out.println("Employee Last name");
		String EmployeeLastName = info.next();
		String EmployeeFullName=EmployeeFirstName+" "+EmployeeLastName;
		emp.setEmployeeFN(EmployeeFullName);
		try {
		emp.inputEmployeeFN(emp.getEmployeeFN());
		retry2=false;

		}
		catch(InvalidEmployeeDetailException e) {
			System.err.println("the full name should contain two words separated by a space, each word contains between 3-10 alphabets try again");
		}
			}
			while(retry3==true) {
		System.out.println("Employee Title");
		String EmployeeTitle = info.next();
		emp.setEmployeeTitle(EmployeeTitle);

	    try {
		emp.inputEmployeeTitle(emp.getEmployeeTitle());
	    retry3=false;

		}
		catch(InvalidEmployeeDetailException e) {
			System.err.println("the title should either be Directo,Manager, Assistant, Supervisor, Trainee try again");
			
		}
			}
			while(retry4==true) {
		System.out.println("Employee Department");
		String EmployeeDepartment = info.next();
		emp.setEmployeeDep(EmployeeDepartment);
		try {
		emp.inputgetEmployeeDep(emp.getEmployeeDep());
		retry4=false;

		}
		catch(InvalidEmployeeDetailException e) {
			System.err.println("the valid department are: IT, Sales, R&D, Prod, HR try again");
			
		}
			}
			while(retry5==true) {
		System.out.println("Employee Phone number");
		String EmployeePhoneNumber = info.next();
		emp.setEmpPhoneNumber(EmployeePhoneNumber);
		try {
		emp.inputEmployeePhonenumber(emp.getEmpPhoneNumber());
		retry5=false;

		}
		catch(InvalidEmployeeDetailException e) {
			System.err.println("A valid phone number contains 10 digits, starts with 06 or \r\n"
					+ "07 followed by one of these digits 5, 6, 7, 9 or 0. No constraint on the \r\n"
					+ "remaining digits try again");
			
		}
			}
			while(retry6==true) {
		System.out.println("Employee Email");
		String EmployeeEmail = info.next();
		emp.setEmployeeEmail(EmployeeEmail);
		try {
		emp.inputgetEmployeeEmail(emp.getEmployeeEmail());
		retry6=false;

		
		}
		catch(InvalidEmployeeDetailException e) {
			System.err.println("A valid email must verify the following rules:\r\n"
					+ "o The local domain (before the @ sign) must start with one or two \r\n"
					+ "letter followed by a dot (.) and 3-10 alphabets, only one underscore \r\n"
					+ "(_ ) and one digit can be used.\r\n"
					+ "o The domain name (after the @ sign) must be �logicaly.net� try again");
			
			
		}
			}
		//we set the value of ID
		emp.setID(count);
		//we add all the informations to the arraylist
		lstObject.add(emp.getID());//index0
		lstObject.add(emp.getEmployeeFN()); //index1
		lstObject.add(emp.getEmployeeTitle()); //index2
		lstObject.add(emp.getEmployeeDep()); //index3
		lstObject.add(emp.getEmpPhoneNumber()); //index4
		lstObject.add(emp.getEmployeeEmail()); //index5
		//we add the key(Employee number) and the values (the arraylist ) to the hashmap
		EmployeeHash.put(emp.getEmpNum(),lstObject);
		System.out.println("Employee registered succesfully");
		//we put retry=false so we break out of the loop
		retry=false;
		

		//increment the ID for the next employee 
		count++;

		}
		//in order to reset the while loop if the function is called again
		retry=true;
		retry1=true;
		retry2=true;
		retry3=true;
		retry4=true;
		retry5=true;
		retry6=true;

		
	}
	public void updateEmployee() throws InvalidEmployeeDetailException {
		Boolean retry=true;
		//create new object to get method regex
		Employee emp3=new Employee();
		Scanner EmployeeUpdate = new Scanner(System.in);
		System.out.println("Enter the number of the employee");
		String EmployeeNumber=EmployeeUpdate.next();
		//create array that gets employee values
		List<Object> arrayemployee = EmployeeHash.get(EmployeeNumber);
		while(retry==true){
		//if the array is empty means tthat number never was added ;
		if(arrayemployee==null) {
			System.out.println("The number is incorrect");
			break;
			//we break out of the loop because if the user enters the wrong number he shouldn't het the rest of the while loop output
			
		}
		System.out.println("the employee's details are"+arrayemployee);

		System.out.println("which employee detail you want to update ?\r\n"
		+ "1. Full Name\r\n"
		+ "2. Title\r\n"
		+ "3. Department\r\n"
		+ "4. Phone number\r\n"
		+ "5. Email\r\n");
		int index = EmployeeUpdate.nextInt();
		System.out.println("type the substitute informations");
		//the options number suit the indexes since the index 0 is the ID and it shouldn't be changed
		if(index==1) {
			try {
				System.out.println("type First Name");
				String FirstName=EmployeeUpdate.next();
				System.out.println("type Last Name");
				String LastName=EmployeeUpdate.next();
				String substitute=FirstName+" "+LastName;
				emp3.inputEmployeeFN(substitute);
				//we use the set method which requires two parametres index and element to replace the content of that index with element(in this case substitute)
				arrayemployee.set(index, substitute);
				System.out.println("Element changed succesfuly");


				
			}
			catch(InvalidEmployeeDetailException e){
				System.out.println("the full name should contain two words separated by a space, each word contains between 3-10 alphabets. The contact wont'be updated");
				break;
				
			}
			
		}
		else if (index==2) {

			try {
			String substitute = EmployeeUpdate.next();
            emp3.inputEmployeeTitle(substitute);
			arrayemployee.set(index, substitute);
			System.out.println("Element changed succesfuly");

			}
			catch(InvalidEmployeeDetailException e){
				System.out.println("the title should either be Director,Manager, Assistant, Supervisor, Trainee. The contact wont'be updated");
				break;

				
			}


			
		}
        else if (index==3) {
			try {
				String substitute = EmployeeUpdate.next();
				emp3.inputgetEmployeeDep(substitute);
				arrayemployee.set(index, substitute);
				System.out.println("Element changed succesfuly");

				}
				catch(InvalidEmployeeDetailException e){
					System.out.println("the valid department are: IT, Sales, R&D, Prod, HR. The contact wont'be updated");
					break;

					
				}


			
		}
        else if (index==4) {
        	try {
				String substitute = EmployeeUpdate.next();
				emp3.inputempNum(substitute);
				arrayemployee.set(index, substitute);
				System.out.println("Element changed succesfuly");

				}
				catch(InvalidEmployeeDetailException e){
					System.out.println("A valid phone number should contain 10 digits, starts with 06 or \r\n"
							+ "07 followed by one of these digits 5, 6, 7, 9 or 0. No constraint on the \r\n"
							+ "remaining digits . The contact wont'be updated");
					break;

					
				}
			
		}
        else if (index==5) {
        	try {
				String substitute = EmployeeUpdate.next();
				emp3.inputgetEmployeeEmail(substitute);
				arrayemployee.set(index, substitute);
				System.out.println("Element changed succesfuly");

				}
				catch(InvalidEmployeeDetailException e){
					System.out.println("A valid email must verify the following rules:\r\n"
							+ "o The local domain (before the @ sign) must start with one or two \r\n"
							+ "letter followed by a dot (.) and 3-10 alphabets, only one underscore \r\n"
							+ "(_ ) and one digit can be used.\r\n"
							+ "o The domain name (after the @ sign) must be �logicaly.net'. The contact wont'be updated");
					break;

					
				}
        	
			
			
		}
        else {
        	System.err.println("Invalid input : choose a number betwwen 1 and 5");
        }
        // if the user types everything right the code will reach here and get out of the loop
		retry=false;
		}
		
		
		
		
		
	}
	public void searchEmployee() {

		Scanner EmployeeSearch = new Scanner(System.in);
		System.out.println("Enter the number of the employee");
		String EmployeeNumber=EmployeeSearch.next();
		//we get the values(in this case it is an array list ) through the key(employeenumber)
		List<Object> arrayemployee = EmployeeHash.get(EmployeeNumber);
		if(arrayemployee==null) {
			System.err.println("No employee with this number Has been found try again");
		}
		else {
		System.out.println("the details of the employee "+EmployeeNumber+" are");
		//we iterate through the array with the for each method to print the employee's information in order
		for(Object i :arrayemployee) {
			System.out.println("*"+i);
		}
		}
	

			
	

		
		
		
		
	}
    public void displayEmployees() {
    	//we add two arrays that we will iterate trough later
		 List<Object> arrayvalues = new ArrayList<Object>();
		 List<String> arraynumbers = new ArrayList<String>();


    	//we didn't use count here because the employee might delete a person so the number of employees doesn't necessarily equal count
    	int count2=0;
    	if(EmployeeHash.isEmpty()) {
    		System.out.println("Not a single employee has been added");
    	}
    	else {
    		//we add the hashmap keys to the arraynumbers and count 2 would equal to the number of employees because number of employees == number of keys
        	for(String a:EmployeeHash.keySet()) {
        		arraynumbers.add(a);
        		count2++;
        			
        		}
        	//we add the hashmap values to the arrayvalues 
        	for(List<Object> b:EmployeeHash.values() ) {
        		arrayvalues.add(b);
        		
        		
        	}
        		}
		System.out.println("Total number of employee is/are "+count2+" their details are");
		//we iterate trought each of them withh an iterator since in while loop or for loop you can't loop trought two variables in a row per example for(String a : array a && String b:array b)
		//and we need to in this case because we need to separate the employee number from his values yet print them in the same line 
    	java.util.Iterator<Object> valuesIterator = arrayvalues.iterator();
    	java.util.Iterator<String> numbersIterator = arraynumbers.iterator();
    	while (valuesIterator.hasNext() && numbersIterator.hasNext()) {
    	    System.out.println("Employee Number "+numbersIterator.next()+" Employee Infomations are: "+valuesIterator.next());
    	}
        		
        		
        	}

        		
        	
    	
    	
    	
    	
    

    public void deleteEmployee() {
    	Scanner EmployeeDelete = new Scanner(System.in);
		System.out.println("Enter the number of the employee");
		String EmployeeNumber=EmployeeDelete.next();
		//in this if loop we will check if the employeehash hashap contains a key that has the same name as the user input (Employeenumber )
		if(EmployeeHash.containsKey(EmployeeNumber)!=true) {
			System.err.println("No employee with this number Has been found try again");
		}
		else {
			EmployeeHash.remove(EmployeeNumber);
			System.out.println("the employee has been removed");

		
		}
		}
		
    	
    
    public void generateFile() {

    	// I used the getProperty method because i don't know which disk / which which username the user user is using
    	String main=System.getProperty("user.home");
    	//we want to print it to the desktop so we continue the path
    	File logicaly = new File(main+"/Desktop/logicaly.txt");
 
    	Scanner validate = new Scanner(System.in);

    	try {

        	//loop that creates the file in case it wasn't created
        
    		if(logicaly.createNewFile()) {
    			System.out.println("file succesfuly created");
    		}
    		else {
				
				boolean validation = false;
				while(validation==false) {
					System.out.println("file already exists do you want to clear its informations ? (y/n)");
					char yesorno = validate.next().charAt(0);
					if (yesorno=='y') {

						 try {
							 //we do the same thing as ingenerating a new file because in write mode the filewrite overwrite the existing content
						    	FileWriter LogicalyWriter2 = new FileWriter(main+"/Desktop/logicaly.txt");

						    	List<Object> arrayvalues = new ArrayList<Object>();
								List<String> arraynumbers = new ArrayList<String>();
								if(EmployeeHash.isEmpty()) {
							   		System.out.println("Not a single employee has been added");
							   	}
							   	else {
							       	for(String a:EmployeeHash.keySet()) {
							       		arraynumbers.add(a);
							       			
							       		}
							       	for(List<Object> b:EmployeeHash.values() ) {
							       		arrayvalues.add(b);
							       		
							       		
							       	}
							       		}
						    
							   	java.util.Iterator<Object> valuesIterator = arrayvalues.iterator();
							   	java.util.Iterator<String> numbersIterator = arraynumbers.iterator();
							   	while (valuesIterator.hasNext() && numbersIterator.hasNext()) {
							   		LogicalyWriter2.write("Employee Number: "+numbersIterator.next()+" Employee Infomations: "+valuesIterator.next()+"\n");
							   	}
							   	LogicalyWriter2.close();

						    }
							   	catch(IOException e) {
							   		System.out.println("an error has occured");
							   		e.printStackTrace();
							   	}
							System.out.println("new informations have been added succesfully");
						    //method to get the path of the file logicaly
						    System.err.println("To access employee�s records, please refer to the file located here:"+logicaly.getAbsolutePath());
						    validation=true;
							
						
						
						
						
					}
					else if(yesorno=='n'){

						   
						    try {
						        //we open the filewriter in append mode using a second parameter and it is true in append mode the text is not overwritten
					        	FileWriter LogicalyWriter1 = new FileWriter(main+"/Desktop/logicaly.txt",true);

						    	

						    	List<Object> arrayvalues = new ArrayList<Object>();
								List<String> arraynumbers = new ArrayList<String>();

								if(EmployeeHash.isEmpty()) {
							   		System.out.println("Not a single employee has been added");

							   	}
							   	else {
							       	for(String a:EmployeeHash.keySet()) {
							       		arraynumbers.add(a);
							       			
							       		}
							       	for(List<Object> b:EmployeeHash.values() ) {
							       		arrayvalues.add(b);
							       		
							       		
							       	}
							       	
							       		
							    
							   	java.util.Iterator<Object> valuesIterator = arrayvalues.iterator();
							   	java.util.Iterator<String> numbersIterator = arraynumbers.iterator();
							   		while (valuesIterator.hasNext() || numbersIterator.hasNext()) {							   	 
								   		LogicalyWriter1.write("Employee Number: "+numbersIterator.next()+" Employee Infomations: "+valuesIterator.next()+"\n");
								   		}
								   	LogicalyWriter1.close();

									System.out.println("new informations have been appended succesfully");
								    //method to get the path of the file logicaly
								    System.err.println("To access employee�s records, please refer to the file located here:"+logicaly.getAbsolutePath());
							   	

							  
							   	
							  
						    
			
							   	
									
											
										
							   		
						  
						    }
						    }
						

						    
					
							   	catch(IOException e) {
							   		System.out.println("an error has occured");
							   		e.printStackTrace();
							   	}
						validation=true;
						
						
					}
					else{
						System.err.println("invalid character select again");
						System.out.println(yesorno);
						
						
					}
					
			
				
			}
    		}
    	}
    	catch (IOException e) {
    		System.out.println("an error has occured");
    		e.printStackTrace();
		}
    	System.out.println("your file is in"+" "+logicaly.getPath());
    
    	


	}
    
    


   	
   	
       	
    	
    
	

	
	public static void main(String args[]) throws InvalidEmployeeDetailException{
		
		EmployeeManager emp2 = new EmployeeManager();
		Scanner choice = new Scanner(System.in);
		String welcome="Welcome to LOGICALY employees� records manager!";
		String options="===========++ Operations Menu ++============\r\n"
				+ "1. Add a new employee\r\n"
				+ "2. Update an employee\r\n"
				+ "3. Search an employee\r\n"
				+ "4. Display all employees� records\r\n"
				+ "5. Delete an employee\r\n"
				+ "6. Generate a file\r\n"
				+ "7. Exit";
		//we print welcome before the while loop because we don't want the program to print the welcome message everytime the user types an number or finished a method
		System.out.println(welcome);


		

		
		
		

	
		while(Exit==false) {
			try {
			System.out.println(options);
			int number =choice.nextInt();
			if(number==1) {
				emp2.addEmployee();
				}

				
			
			if(number==2) {
				emp2.updateEmployee();
				}

				
				
			
			
			if(number==3) {
				emp2.searchEmployee();
				}

				
				
			
			
			if(number==4) {
				emp2.displayEmployees();
				}

				
				
				
			
			
			if(number==5) {
				emp2.deleteEmployee();
				}

				
				
				
			
			
			if(number==6) {
				emp2.generateFile();
				}

				
				
				
			
			
			if(number==7) {
				System.out.println("See you next time on Logicaly Employees� Manager!");
				Exit=true;

			}
			//else can't be used because the program confuses the input after number with number that's why we need to specify
			else if(number!=1 && number!=2 && number!=3 && number!=4 && number!=5 && number!=6 && number!=7) {
				System.err.println("Invalid input: you should type a number between 1 and 7");
			}
				
			}
			
			
			//input mismatch exception in case the user types letters instead of numbers
			catch(InputMismatchException e) {
				System.err.println("Invalid Input: you should type a number");
				choice.nextLine();
				
			}
			
		
			
			
			}
			
			
				
			
		
		
		
	}
}
		
		
			
			
			
			
			
			
			
			
			
			



	
	
	

	
		
		
	
			
	



		
		
	





		