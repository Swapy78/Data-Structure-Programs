//Java program to create banking cash counter

package demo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BankingCashCounter {

	// Main method to execute the program
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    
	    // Creating a queue to store customers
	    Queue<Customer> queue = new LinkedList<>();
	    
	    // Telling user to enter initial cash balance
	    System.out.print("Enter initial cash balance: ");
	    int cashBalance = sc.nextInt();
	    int choice = 0;
	    
	    // Looping to display menu and handle user choices
	    while (choice != 3) {
	        System.out.println("1. Add customer to queue");
	        System.out.println("2. Serve customer");
	        System.out.println("3. Exit");
	        System.out.print("Enter your choice: ");
	        choice = sc.nextInt();

	        // Switch case to handle user choices
	        switch (choice) {
	            // Adding customer to the queue
	            case 1:
	                System.out.print("Enter customer name: ");
	                String name = sc.next();
	                System.out.print("Enter 1 to deposit or 2 to withdraw: ");
	                int transactionType = sc.nextInt();
	                System.out.print("Enter transaction amount: ");
	                int transactionAmount = sc.nextInt();
	                queue.add(new Customer(name, transactionType, transactionAmount));
	                break;
	            // Serving customer from the queue
	            case 2:
	                if (queue.isEmpty()) {
	                    System.out.println("No customers in queue.");
	                } else {
	                    Customer customer = queue.remove();
	                    int amount = customer.getTransactionAmount();
	                    if (customer.getTransactionType() == 1) {
	                        // Depositing cash into the account
	                        cashBalance += amount;
	                        System.out.println(customer.getName() + " deposited " + amount + " rupees. New balance: " + cashBalance);
	                    } else {
	                        if (cashBalance < amount) {
	                            System.out.println("Sorry, cash balance is not sufficient to withdraw " + amount + " rupees.");
	                        } else {
	                            // Withdrawing cash from the account
	                            cashBalance -= amount;
	                            System.out.println(customer.getName() + " withdrew " + amount + " rupees. New balance: " + cashBalance);
	                        }
	                    }
	                }
	                break;
	            // Exiting the program
	            case 3:
	                System.out.println("Exiting program.");
	                break;
	            // Handling invalid user choices
	            default:
	                System.out.println("Invalid choice.");
	        }
	    }
	    
	    // Closing the scanner object
	    sc.close();
	}

	// Static inner class to represent a customer
	static class Customer {
	    private final String name;
	    private final int transactionType;
	    private final int transactionAmount;

	    // Constructor to initialize customer object
	    public Customer(String name, int transactionType, int transactionAmount) {
	        this.name = name;
	        this.transactionType = transactionType;
	        this.transactionAmount = transactionAmount;
	    }

	    // Getter method to return the customer name
	    public String getName() {
	        return name;
	    }

	    // Getter method to return the transaction type (1 for deposit, 2 for withdrawal)
	    public int getTransactionType() {
	        return transactionType;
	    }

	    // Getter method to return the transaction amount
	    public int getTransactionAmount() {
	        return transactionAmount;
	    }
	}
}