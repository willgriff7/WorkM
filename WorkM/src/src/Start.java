package src;

import java.util.Scanner;

public class Start {
	
	static Scanner input = new Scanner(System.in);
	
	private static void test1() {
		
		String firstName = "";
		String lastName = "";
		String email = "";
		String pass = "";
		
			
		/**
		 * Ask for first name
		 */
		
		System.out.println("Please type in a first name");
		
		firstName = input.nextLine();
		
		if(firstName.equalsIgnoreCase("exit")) {
			input.close();
			System.exit(0);
		}
			
		/**
		 * Ask for last name
		 */
		
		System.out.println("Please type in the last name");
		
		lastName = input.nextLine();
		
		if(lastName.equalsIgnoreCase("exit")) {
			input.close();
			System.exit(0);
		}
		
		/**
		 * Ask for email
		 */
		
		System.out.println("Please enter a valid email");
		
		email = input.nextLine();
		
		if(email.equalsIgnoreCase("exit")) {
			input.close();
			System.exit(0);
		}
		
		/**
		 * Ask for password
		 */
		
		System.out.println("Please enter a valid password");
		
		pass = input.nextLine();
		
		if(pass.equalsIgnoreCase("exit")) {
			input.close();
			System.exit(0);
		}
		
		new SignUpTest(firstName, lastName, email, pass);
		
	}
	
	private static void test2() {
		
		
		String criteria = "";
		
		System.out.println("Enter some criteria for search");
		
		criteria = input.nextLine();
		
		if(criteria.equalsIgnoreCase("exit")) {
			input.close();
			System.exit(0);
		}
	
		new SearchTest(criteria);
		
		input.close();
	}
	
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver74.exe");
		
		test1();
		
		test2();
		
		System.exit(0);
		
	}
	
}
