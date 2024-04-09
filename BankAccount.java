// Joe Bewley
// Assignment: Ex 8-13
// 4/9/2024
// This program uses methods from the Bank Account class to modify BankAccount objects within the transactions class
//  Instance methods are called in the transactions class, and the user/client can use a few operations on each bank
//  account (methods in the BankAccount class). The client can call the withdraw, transfer, deposit, and toString method
//  in the transactions class.
// The toString method is called within all transactions to print the contents of each bank account involved to the screen
// Println statements are used throughout to display the balance before and after a transaction to the screen
//	in order to allow the user to track the money of each bank account easier and for readability


public class BankAccount {

	//Allow objects to have a name (so we can print it out), default balance of 25, and transaction fee of $2. 
	String name;
	double balance = 25;
	double transactionFee = 2;
	
	
	
	//The toString method will print out the name of the object and its balance. This is called in every transaction i.e. all other methods within the class
	public void toString(String accName, double accBalance) {
		System.out.println(accName + ", " + accBalance);
	}
	
	
	
	//The deposit method will add the user's desired deposit amount to the balance of the bank account
	//	note that there are no if/else statements, since there is no limit to how much money a bank account may hold
	public void deposit(double amount) {
		System.out.println("Balance before deposit:");
		toString(this.name, this.balance);
		System.out.println("Deposit amount: " + amount);
		this.balance = this.balance + amount;				//add the deposit amount to the balance of the bank account involved
		System.out.println("Balance after deposit:");
		toString(this.name, this.balance);
		System.out.println();
	}
	
	
	
	//The withdraw method will deduct the user's desired amount from the balance of the bank account
	// a there is a transaction fee of $2 (that the client can change above)
	public void withdraw(double amount) {
		System.out.println("Balance before withdrawal:");
		toString(this.name, this.balance);
		System.out.println("Withdrawal amount: " + amount);
		
		//if the current balance - the transaction fee and the withdrawal amount is greater than or equal to 0, the withdrawal is executed
		if((this.balance - transactionFee - amount)>=0) {
			this.balance = this.balance - transactionFee;
			this.balance = this.balance - amount;
			System.out.println("Balance after withdrawal:");
			toString(this.name, this.balance);
		}
		else {				//if the if statement condition is not true, we do nothing and notify the user the withdrawal was canceled
			System.out.println("Transaction Canceled: You cannot have a balance under $0.00");
		}
		System.out.println();
	}
	
	
	
	//The transfer method will transfer money from the initiating bank account to the desired receiver
	// The initiator has a base fee of $5 deducted from their account balance, then the amount they wish to transfer is deducted from their balance,
	// and the receiver has the transferred amount added to their bank account balance
	public void transfer(double amount, BankAccount receiver) {
		System.out.println("Balances before transfer:");
		toString(this.name, this.balance);				//display balances of initiator and reciever prior to transfer
		toString(receiver.name, receiver.balance);
		System.out.println("Transfer amount: " + amount);	//display transfer amount
		transactionFee = 5;										//Set the transaction fee to $5 for transfers (as per E-8.13). Client may change this variable as they wish
		
		//If the initiator's balance is greater than the transaction fee, we first deduct the transaction fee from their balance
		if (this.balance > transactionFee) {
			this.balance = this.balance - transactionFee;
			
			//We then check if the initiator's new balance is greater than the amount they wish to transfer. If the condition is true,
			// then we deduct the desired transfer amount from their balance and add the amount to the reciever's balance.
			// If the condition is no true, then we deduct whatever is left from the initiator's balance and send it to the receiver's balance
			if(this.balance > amount) {
				this.balance = this.balance - amount;
				receiver.balance = receiver.balance + amount;
			}
			else {
				amount = this.balance;
				receiver.balance = this.balance + receiver.balance;
				this.balance = this.balance - this.balance;
			}
			System.out.println("Balances after transfer:");
			toString(this.name, this.balance);
			toString(receiver.name, receiver.balance);
		}
		else {
			System.out.println(this.name + "'s balance is less than the transaction fee. Transfer Canceled.");	//If the initial condition is false, notify the user and cancel the transfer
		}
		System.out.println();

	}
	

}


