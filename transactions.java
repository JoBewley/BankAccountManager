
public class transactions {

	public static void main(String[] args) {
		
		//construct instances of the BankAccount class
		//create two objects (ben & hal) with initial deposit amounts (80 & 20 respectively)
		BankAccount ben = new BankAccount();
		ben.name = "Ben";
		ben.deposit(80);
		
		BankAccount hal = new BankAccount();
		hal.name = "Hal";
		hal.deposit(20);
		
		ben.transfer(20, hal);		//Attempt a transfer $20 from Ben's bank account to Hal's
		
		ben.transfer(10, hal);		//Attempt a transfer $10 from Hal's bank account to Ben's
		
		ben.withdraw(100);			//Attempt a withdrawal $100 from Hal's bank account
		
		hal.withdraw(100);			//Attempt a withdrawal $100 from Ben's bank account
		
		hal.transfer(75, ben);		//Attempt a transfer $75 from Hal's bank account to Ben's


	}

}
