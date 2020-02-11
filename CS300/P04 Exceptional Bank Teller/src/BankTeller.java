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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class BankTeller {
  private ArrayList<BankAccount> accountList;
  
  public BankTeller() {
    accountList = new ArrayList<BankAccount>();
  }
  
  /**
   * @param newAccount - a new bank account to add
   */
  public void addBankAccount(BankAccount newAccount) {
    if(newAccount==null) {
      throw new IllegalArgumentException("Try again with a non-null account.");
    }
    for(int i=0; i<accountList.size(); i++) {
      if(newAccount.getID().equals(accountList.get(i).getID())) {
        throw new IllegalStateException("This account ID has already been taken.");
      }
    }
    accountList.add(newAccount);
  }
  
  /**
   * @param id - the bank account's ID
   * @return - the bank account that has the same ID as the one passed to the method
   * @throws NoSuchElementException - if the account with such an ID does not exist
   */
  public BankAccount findAccount(String id) throws NoSuchElementException {
    for(BankAccount a: accountList) {
      if(a.getID().equals(id)) {
        return a;
      }
    }
    throw new NoSuchElementException("This account does not exist.");
  }
  
  /**
   * @param transaction - the transaction to add to the list
   * @param account - the account to add the transaction to
   * @throws DataFormatException - if the transaction is not formatted correctly
   */
  public void addTransaction(String transaction, BankAccount account) throws DataFormatException {
    if(account==null) {
      throw new NullPointerException("Account is null.");
    }
    String[] arr = new String[2];
    String str = transaction;
    str = str.trim();
    //System.out.println("|"+str+"|");
    if(str==null||str.equals("")) {
      throw new DataFormatException("String is empty or null.");
    }
    if(!str.contains(" ")) {
      throw new DataFormatException("String does not have a space.");
    }
    if(str.substring(1).charAt(0)!=' ') {
      throw new DataFormatException("Double digit first number.");
    }
    str = str.substring(0, 1)+" "+str.substring(1).trim();
    arr = str.split(" ");
    
    if(arr.length!=2) {
      throw new DataFormatException("Too many spaces.");
    }
    
    try {
      if(Integer.parseInt(arr[0])==0) {
        account.withdraw(Integer.parseInt(arr[1]));
        System.out.println("Withdraw: "+Integer.parseInt(arr[1]));
      }
      else if(Integer.parseInt(arr[0])==1) {
        account.deposit(Integer.parseInt(arr[1]));
        System.out.println("Deposit: "+Integer.parseInt(arr[1]));
      }
      else {
        throw new DataFormatException("Transaction is not formatted correctly.");
      }
    }
    catch(NumberFormatException e) {
      throw new DataFormatException("Transaction is not formatted correctly.");
    }
  }
  
  /**
   * @param file - the file to read the transactions from
   * @param account - the account to load the transactions onto
   * @throws FileNotFoundException - if the file is not found
   */
  public void loadTransactions(File file, BankAccount account) throws FileNotFoundException {
    try {
      Scanner scn = new Scanner(file);
      while(scn.hasNextLine()) {
        try {
          addTransaction(scn.nextLine(), account);
        }
        catch(NoSuchElementException e) {
          System.out.println(e.getMessage());
        }
        catch (DataFormatException e){
          System.out.println(e.getMessage());
        }
      }
    }
    catch(FileNotFoundException e) {
      System.out.println(e.getMessage());
    }
  }
  
  /**
   * @return - the size of the account list
   */
  public int getAccountsCount() {
    return accountList.size();
  }
}
