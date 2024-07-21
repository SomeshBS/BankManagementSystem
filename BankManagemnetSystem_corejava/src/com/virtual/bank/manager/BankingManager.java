package com.virtual.bank.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.virtual.bank.custexception.AccountNotFoundException;
import com.virtual.bank.custexception.InsufficientBalenceException;
import com.virtual.bank.model.Bank;
import com.virtual.bank.model.User;

public class BankingManager extends Bank {

	User user = new User(0, null, null, null, null, 0, 0, 0, 0);
	public static List<User> users = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	@Override
	public void creatAccount() {
		System.out.println("Enter your details : ");
		while (true) {
			System.out.println("Enter your 9 digit SSN number : ");
			user.setSsnNo(sc.nextInt());
			if (Integer.toString(user.getSsnNo()).length() == 9) {
				break;
			} else {
				System.out.println("Please enter a valid SSN number, SSN should be 9 digits only");
			}
		}
		sc.nextLine();
		while (true) {
			System.out.println("Enter Your Name : ");
			user.setName(sc.nextLine());
			if (user.getName().length() > 30) {
				System.out.println("Name should not exceed 50 charectors, try again");
			} else {
				break;
			}
		}
		while (true) {
			int count = 0;
			System.out.println("Enter your Email : ");
			user.setEmail(sc.nextLine());
			/*
			 * for(int i=0;i<user.getEmail().length();i++) {
			 * 
			 * }
			 */
			if (user.getEmail().contains("@") != true) {
				count++;
			}
			if (count > 0) {
				System.out.println("Invalid email address, Please try again");
			} else {
				break;
			}

		}

		while (true) {
			System.out.println("Enter your Address : ");
			user.setAddress(sc.nextLine());
			if (user.getAddress().length() > 100) {
				System.out.println("Address should not exceed more than 100 charecters, try again");
			} else {
				break;
			}
		}
		while (true) {
			System.out.println("Enter your contact number");
			user.setContactNumber(sc.nextLong());
			if (Long.toString(user.getContactNumber()).length() == 10) {
				break;
			} else {
				System.out.println("Please enter valid contact Number");
			}
		}
		while (true) {
			System.out.println("Enter Aadhar Number : ");
			user.setAdharNumber(sc.nextLong());
			if (Long.toString(user.getAdharNumber()).length() == 12) {
				break;
			} else {
				System.out.println("Please enetr valid 12 digit Aadhar Number, Please try again");
			}
		}
		sc.nextLine();
		while (true) {
			System.out.println("Enter PAN Number : ");
			user.setPanNumber(sc.nextLine());
			if (user.getPanNumber().length() == 10) {
				break;
			} else {
				System.out.println("Please enetr valid 10 digit PAN Number, Please try again");
			}
		}
		while (true) {
			System.out.println("Enter Account Number : ");
			user.setAccountNumber(sc.nextLong());
			if (Long.toString(user.getAccountNumber()).length() == 12) {
				for(int i=0;i<users.size();i++) {
					if(users.get(i).getAccountNumber()==user.getAccountNumber()) {
						System.out.println("This Account is already exists");
					}
				}
				break;
			} else {
				System.out.println("Please enetr valid 16 digit Account Number, Please try again");
			}
		}

		while (true) {
			System.out.println("Enter intitial deposite amount(at least 500)");
			user.setBalence(sc.nextDouble());
			if (user.getBalence() < 500) {
				System.out.println("Minimum balence should be 500");
			} else {
				break;
			}
		}

		users.add(new User(user.getSsnNo(), user.getName(), user.getEmail(), user.getAddress(), user.getPanNumber(),
				user.getContactNumber(), user.getAccountNumber(), user.getAdharNumber(), user.getBalence()));
		System.out.println("Account is created successfully!");

	}

	@Override
	public User findCustomerByAccountNumber(long accountNumber) throws AccountNotFoundException {
		for (User user : users) {
			if (user.getAccountNumber() == accountNumber) {
				return user;
			}
		}
		return null;
	}
	
	/*
	 * public void displayUserByAccountNumber(long accountNumber) throws
	 * AccountNotFoundException {
	 * 
	 * }
	 */
	
	

	@Override
	public void depositAmount() {
		System.out.println("Enter Account Number : ");
		long accno = sc.nextLong();
		User user;
		try {
			user = findCustomerByAccountNumber(accno);

			if (user != null) {
				System.out.println("Enter Deposit amount : ");
				double amount = sc.nextDouble();
				user.deposit(amount);
				System.out.println("Balence is " + user.getBalence());
			} /*
				 * else { System.out.println("User Account not found"); }
				 */
		} catch (AccountNotFoundException e) {
			System.out.println("User account not found");
		}

	}

	@Override
	public void withdrawAmount() throws AccountNotFoundException {
		System.out.println("Enter Account Number : ");
		long accno = sc.nextLong();
		User user;
		try {
			user = findCustomerByAccountNumber(accno);
			if (user != null) {
				System.out.println("Enter withdraw amount : ");
				double amount = sc.nextDouble();
				user.withdraw(amount);
				System.out.println("Balence is " + user.getBalence());
			} else {
				throw new AccountNotFoundException("User Account not found");
			}
		} catch (InsufficientBalenceException e) {
			System.out.println("User has insufficient balence");
		}
	}

	@Override
	public void checkBalence() {
		System.out.println("Enter Account Number : ");
		long accno = sc.nextLong();
		User user;
		try {
			user = findCustomerByAccountNumber(accno);

			if (user != null) {
				System.out.println("Enter withdraw amount : ");
				System.out.println("Balence is " + user.getBalence());
			} else {
				System.out.println("User Account not found");
			}
		} catch (AccountNotFoundException e) {
			System.out.println("User account not found");
		}
	}

}
