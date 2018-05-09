import java.io.*;
import java.util.*;

public class AccountDriver {
	public static void main(String[] args) throws IOException {
		run();
	}
	public static void run() throws IOException {
		Account[] accounts = new Account[10];
		populate(accounts);
		description();

	}
	public static void populate(Account[] accounts) throws IOException {
		Scanner kb = new Scanner(System.in);
		File f = new File(getFileName(kb));
		Scanner input = new Scanner(f);
	    int i = 0;
	    while(input.hasNextLine()) {
	    	   String line = input.nextLine();
	    	   Scanner token = new Scanner(line);
	    	   String name = token.next() + " " + token.next();
	       int id = token.nextInt();
	       double balance = token.nextDouble();
	       String password = token.next();
	       accounts[i] = new Account(id, balance, 1.2, name, password);
	       i++;
	       token.close();
	    }
	    input.close();
	    kb.close();
	}
	public static void display() {
		System.out.println("Enter your accountId: ");
	}
	public static int searchId(int id, Account[] accounts) {
		for(int i = 0; i < accounts.length; i++) {
			if(accounts[i].getId() == id) {
				return i;
			}
		}
		return -1;
	}
	public static void description() {
		System.out.println("");
	}
	public static void withdraw(double amount, int index, Account[] accounts) {
		if(accounts[index].withDraw(amount)) {
			System.out.println("You have successfully withdrawn $" + amount);
		} else {
			System.out.println("An unknown error occured, please try again or contact our representatives.");
		}
	}
	public static void deposit(double amount, int index, Account[] accounts) {
		if(accounts[index].deposit(amount)) {
			System.out.println("You have succesfully deposited $" + amount);
		} else {
			System.out.println("An unknown error occured, please try again or contact our representatives.");
		}
	}
	public static void checkBalance(int index, Account[] accounts) {
		System.out.println("You have $" + accounts[index].getBalance() + " within your account.");
	}
	public static int getChoice(Scanner kb) {
		System.out.println("Enter a number between 1-4");
		int choice = 0;
		while(kb.hasNextInt() && choice < 0 || choice > 5) {
			choice = kb.nextInt();
			System.out.println("Enter a number between 1-4");
		}
		return choice;
	}
	public static String getFileName(Scanner kb) {
		//System.out.print("Enter a file name: ");
		String fileName = "";
		boolean file = false;
		while( !file) {
			System.out.print("Enter a valid file name: ");
			fileName = kb.nextLine();
			System.out.println(fileName);
			file = new File(fileName).isFile();
		}
		return fileName;
	}
	public static void listCustomers(Account[] accounts) {
		
	}
	public static int getValidInput(Scanner kb) {
		System.out.println("Enter a number greater than 0");
		int choice = 0;
		while(kb.hasNextInt() && choice > 0) {
			choice = kb.nextInt();
			System.out.println("Enter a number between 1-4");
		}
		return choice;
	}
	
}
