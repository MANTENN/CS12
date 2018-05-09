import java.util.*;

public class Account {
	private int id;
	private String name;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated;
	private boolean active;
	private boolean authorized;
	private boolean locked;
	private String[][] security = new String[2][];
	
	private String password;
	//logins and password resets
	private int[] attempts = new int[3];
	
	public Account() {
		this(0, 0, 0, "", "");
	}
	public Account(int id, double balance, double annualInterestRate, String name, String password) {
		this.authorized = true;
		this.setId(id);
		this.setBalance(balance);
		this.setRate(annualInterestRate);
		this.name = name;
		this.password = password;
		this.changeStatus(true);
		this.dateCreated = new Date();
		this.authorized = false;
	}
	public int getId() {
		return this.id;
	}
	public boolean getActive() {
		return this.active;
	}
	public void changeStatus(boolean b) {
		this.active = b;
	}
	public double getRate() {
		return this.annualInterestRate;
	}
	public Date getDate() {
		return this.dateCreated;
	}
	public double getBalance() {
		return this.balance;
	}
	public double getMonthylInterestRate() {
		return this.annualInterestRate / 12;
	}
	public void setId(int id) {
		if(id < 0)
			throw new IllegalArgumentException();
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setRate(double r) {
		if(r > 0)
			this.annualInterestRate = r;
	}
	public void changeLockStatus(boolean b) {
		this.locked = b;
	}
	public void changeAuthorization(boolean b) {
		this.authorized = b;
	}
	public boolean getLockStatus() {
		return this.locked;
	}
	public boolean login(String password) {
		if(!this.locked && this.password.equals(password)) {
			this.changeAuthorization(true);
			return true;
		}
		this.attempts[0] += 1;
		return false;
	}
	public void logout() {
		this.changeAuthorization(false);
	}
	public boolean isLocked() {
		return this.locked;
	}
	public boolean isAuthorized() {
		return this.authorized;
	}
	public boolean setPassword(String password) {
		if(!this.locked) {			
			this.password = password;
			return true;
		}
		return false;
	}
	public void checkSecurityQuestionAnswer(String answer) {
		if(!this.isLocked() && Arrays.asList(this.security[0]).indexOf(answer) < 0) {
			this.attempts[1] += 1;
		}
	}
	public void close() {
		this.withDraw(this.balance);
		this.changeStatus(false);
	}
	public void setBalance(double b) {
		if(b > 0)
			this.balance = b;
	}
	public boolean deposit(double d) {
		if(d > 0) {
			this.balance += d;
			return true;
		}
		return false;
	}
	public boolean withDraw(double amount) {
		if(amount > 0 && this.balance >= amount) {
			this.balance -= amount;
			return true;
		}
		return false;
	}
	public boolean equals(Account otherAcc) {
		return this.id == otherAcc.id;
	}
	public String toString() {
		return String.format(" Id: %d \n Name: %s \n Balance: %.2f\n Annual Interest Rate: %.3f\n Date created: %s\n Active: %b", this.id, this.name, this.balance, this.annualInterestRate, this.dateCreated, this.active);
	}
}
