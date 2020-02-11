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

public class BankAccount {
  private String accountID;
  private int balance;
  private ArrayList<String> transactions;
  
  /**
   * @param accountID - account ID
   * @param initialBalance - initial balance
   * @throws IllegalArgumentException - if the initial balance is less than 10
   */
  public BankAccount(String accountID, int initialBalance) throws IllegalArgumentException {
    if(initialBalance<10) {
      throw new IllegalArgumentException("Intial balance is too low, it must be at least 10.");
    }
    else {
      this.accountID = accountID;
      balance = initialBalance;
      transactions = new ArrayList<String>(1);
      transactions.add("1 "+initialBalance);
    }
  }
  
  /**
   * @param depositAmount - amount to deposit into the account
   * @throws IllegalArgumentException - if the deposit amount is negative
   */
  public void deposit(int depositAmount) throws IllegalArgumentException {
    if(depositAmount<0) {
      throw new IllegalArgumentException("Deposit amount cannot be negative.");
    }
    else {
      balance += depositAmount;
      transactions.add(("1 "+depositAmount));
    }
  }
  
  /**
   * @param other - the other bank account to check against
   * @return - true if both bank accounts have the same ID
   */
  public boolean equals(BankAccount other) {
    return (accountID==other.getID());
  }
  
  /**
   * @return - balance
   */
  public int getBalance() {
    return balance;
  }
  
  /**
   * @return - account ID
   */
  public String getID() {
    return accountID;
  }
  
  /**
   * @return - the five most recent transactions in order from most to least recent
   */
  public String[] getMostRecentTransactions() {
    int temp = transactions.size();
    String[] arr = new String[5];
    for(int i=5; i>0; i--) {
      if(temp<5) {
        if(temp-i<0) {
          arr[i-1]=null;
        }
        else {
          arr[i-1] = transactions.get(temp-i);
        }
      }
      else {
        arr[i-1] = transactions.get(temp-i);
      }
    }
    return arr;
  }
  
  /**
   * @return - the number of transactions
   */
  public int getTransactionsCount() {
    return transactions.size();
  }
  
  /**
   * @param withdrawAmount - amount to withdraw from the account
   * @throws DataFormatException - if the withdraw amount is less than 0 or not divisible by 10
   */
  public void withdraw(int withdrawAmount) throws DataFormatException{
    if(withdrawAmount<0 || withdrawAmount%10!=0) {
      throw new DataFormatException("Withdraw amount is less than 0 or it is not divisible by 10.");
    }
    else if(withdrawAmount>balance) {
      throw new IllegalStateException("Withdraw amount is more than account balance.");
    }
    else {
      balance -= withdrawAmount;
      transactions.add("0 "+withdrawAmount);
    }
  }
}
