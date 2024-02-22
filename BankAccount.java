package com.wipro.test;

import java.util.Scanner;

//Class to represent the user's bank account
class BankAccount {
 private double balance;

 public BankAccount(double balance) {
     this.balance = balance;
 }

 public double getBalance() {
     return balance;
 }

 public void deposit(double amount) {
     balance += amount;
     System.out.println("Deposit of $" + amount + " successful.");
 }

 public void withdraw(double amount) {
     if (amount <= balance) {
         balance -= amount;
         System.out.println("Withdrawal of $" + amount + " successful.");
     } else {
         System.out.println("Insufficient funds. Withdrawal failed.");
     }
 }
}

//Class to represent the ATM machine
public class ATM {
 private BankAccount bankAccount;

 public ATM(BankAccount bankAccount) {
     this.bankAccount = bankAccount;
 }

 // Method to display options and handle user input
 public void displayMenu() {
     Scanner scanner = new Scanner(System.in);
     int choice;

     do {
         System.out.println("\nATM Menu:");
         System.out.println("1. Check Balance");
         System.out.println("2. Deposit");
         System.out.println("3. Withdraw");
         System.out.println("4. Exit");
         System.out.print("Enter your choice: ");
         choice = scanner.nextInt();

         switch (choice) {
             case 1:
                 checkBalance();
                 break;
             case 2:
                 System.out.print("Enter deposit amount: $");
                 double depositAmount = scanner.nextDouble();
                 deposit(depositAmount);
                 break;
             case 3:
                 System.out.print("Enter withdrawal amount: $");
                 double withdrawAmount = scanner.nextDouble();
                 withdraw(withdrawAmount);
                 break;
             case 4:
                 System.out.println("Thank you for using the ATM. Goodbye!");
                 break;
             default:
                 System.out.println("Invalid choice. Please try again.");
                 break;
         }
     } while (choice != 4);

     scanner.close();
 }

 // Method to check account balance
 private void checkBalance() {
     System.out.println("Your current balance is: $" + bankAccount.getBalance());
 }

 // Method to deposit money into the account
 private void deposit(double amount) {
     bankAccount.deposit(amount);
 }

 // Method to withdraw money from the account
 private void withdraw(double amount) {
     bankAccount.withdraw(amount);
 }

 public static void main(String[] args) {
     BankAccount userAccount = new BankAccount(1000); // Initialize with a balance of $1000
     ATM atm = new ATM(userAccount);
     atm.displayMenu();
 }
}

