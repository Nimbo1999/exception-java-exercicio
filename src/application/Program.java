package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.AccountExceptions;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Enter account data");
			System.out.print("Account Number: ");
			int number = sc.nextInt();
			System.out.print("Account Holder: ");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.print("Account Initial balance: ");
			double balance = sc.nextDouble();
			System.out.print("Account Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();
			
			Account account = new Account(number, holder, balance, withdrawLimit);
			
			System.out.println();
			System.out.print("Enter amount for withdrawn: ");
			double amount = sc.nextDouble();
			account.withdraw(amount);
			System.out.println(account);
		}
		catch(AccountExceptions e) {
			System.out.println("Withdrawn Error: " + e.getMessage() + ".");
		}
		catch(InputMismatchException e) {
			System.out.println("Input type not accepted!");
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected Exception.");
		}
		finally {
			sc.close();
		}
	}

}
