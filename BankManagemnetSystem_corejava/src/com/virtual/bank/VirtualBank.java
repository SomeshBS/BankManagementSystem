package com.virtual.bank;

import java.util.Scanner;

import com.virtual.bank.custexception.AccountNotFoundException;
import com.virtual.bank.manager.BankingManager;
import com.virtual.bank.model.*;

public class VirtualBank {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Welcome to " + Bank.BANKNAME + " Bank");
			System.out.println("Bank Process available currently : ");
			System.out.println("1. Create Account");
			System.out.println("2. Deposit Amount");
			System.out.println("3. Withdraw Amount");
			System.out.println("4. Check Balence");
			System.out.println("5. Exit");
			System.out.println("Please select the opration you want to perform : ");

			int choise = sc.nextInt();
			BankingManager bankingManager = new BankingManager();
			switch (choise) {
			case 1:
				bankingManager.creatAccount();
				break;
			case 2:
				bankingManager.depositAmount();
				break;
			case 3:
				try {
					bankingManager.withdrawAmount();
				} catch (AccountNotFoundException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				bankingManager.checkBalence();
				break;
			case 5:
				System.out.println("exit");
				System.exit(0);
			default:
				System.out.println("Invalid choise, try again");
			}
		}
	}
}
