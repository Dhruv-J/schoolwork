//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Matching Game
// Files: CS300MatchingGame.jar
// Course: CS 300 Fall 2019
//
// Author: Dhruv Jain
// Email: djain22@wisc.edu
// Lecturer's Name: Gary Dahl
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: NONE
// Online Sources: Zybooks
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.Scanner;
import java.util.zip.DataFormatException;
import java.io.File;
import java.util.ArrayList;

public class BankAccountTester {
  
  public static void main(String[] args) {
    System.out.println(testBankAccountConstructorValidInitialBalance());
    System.out.println(testBankAccountConstructorNotValidInitialBalance());
    System.out.println(testBankAccountEquals());
    System.out.println(testBankAccountWithdrawInvalidAmount());
    System.out.println(testBankAccountWithdrawLargerOfBalanceAmount());
    System.out.println(testBankAccountWithdrawValidAmount());
    System.out.println(testBankAccountDepositNegativeAmount());
  }
    
  /**
   * @return - true if the account balance and ID are correct upon creation, and if the transaction in the transaction list has been formatted correctly
   */
  public static boolean testBankAccountConstructorValidInitialBalance() {
    BankAccount account = new BankAccount("123456", 20);
    if(account.getID().equals("123456") && account.getBalance()==20 && account.getTransactionsCount()==1 && account.getMostRecentTransactions()[0].equals("1 20")) {
      return true;
    }
    else {
      return false;
    }
  }
  
  /**
   * @return - true if a bank account created with an invalid intial balance throws an IllegalArgumentException
   */
  public static boolean testBankAccountConstructorNotValidInitialBalance() {
    try {
      BankAccount account = new BankAccount("123456", 5);
      return false;
    }
    catch(IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return true;
    }
  }
  
  /**
   * @return - true if the two bank accounts created with equal IDs are equal to each other
   */
  public static boolean testBankAccountEquals() {
    BankAccount account1 = new BankAccount("123456", 10);
    BankAccount account2 = new BankAccount("123456", 20);
    return account1.getID().equals(account2.getID());
  }
  
  /**
   * @return - true if a DataFormatException is thrown when the withdrawal amount is negative or not divisible by 10
   */
  public static boolean testBankAccountWithdrawInvalidAmount() {
    BankAccount account1 = new BankAccount("123456", 20);
    try {
      account1.withdraw(-15);
      return false;
    }
    catch(DataFormatException e) {
      System.out.println(e.getMessage());
      return true;
    }
    catch(IllegalStateException e) {
      System.out.println(e.getMessage());
      return false;
    }
  }
  
  /**
   * @return - true if an IllegalStateException is thrown when the withdrawal amount is larger than the account balance
   */
  public static boolean testBankAccountWithdrawLargerOfBalanceAmount() {
    BankAccount account1 = new BankAccount("123456", 10);
    try {
      account1.withdraw(20);
      return false;
    }
    catch(IllegalStateException e) {
      System.out.println(e.getMessage());
      return true;
    }
    catch(DataFormatException e) {
      System.out.println(e.getMessage());
      return false;
    }
  }
  
  /**
   * @return - true if no exceptions are thrown for a valid withdrawal amount, and if the transaction list and account balance are updated properly 
   */
  public static boolean testBankAccountWithdrawValidAmount() {
    BankAccount account = new BankAccount("123456", 20);
    try {
      int temp = account.getBalance();
      account.withdraw(10);
      if(temp-10==account.getBalance() && account.getMostRecentTransactions()[0].equals("0 10")) {
        return true;
      }
      else {
        return false;
      }
    }
    catch(IllegalStateException e) {
      System.out.println(e.getMessage());
      return false;
    }
    catch(DataFormatException e) {
      System.out.println(e.getMessage());
      return false;
    }
  }
  
  /**
   * @return - true if an IllegalArgument is thrown when a negative amount is passed into the deposit method
   */
  public static boolean testBankAccountDepositNegativeAmount() {
    BankAccount account = new BankAccount("123456", 20);
    try {
      account.deposit(-10);
      return false;
    }
    catch(IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return true;
    }
  }
}
