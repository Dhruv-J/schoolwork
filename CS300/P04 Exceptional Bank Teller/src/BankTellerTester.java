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

public class BankTellerTester {
  
  public static void main(String[] args) {
    //System.out.println(testBankTellerConstructor());
    //System.out.println(testBankTellerAddBankAccountUsedIdentifier());
    //System.out.println(testBankTellerLoadTransactionsFileNotFound());
    System.out.println(testBanktellerLoadTransactions());
  }
  
  /**
   * @return - true if the bank teller constructor initializes the bank account list
   */
  public static boolean testBankTellerConstructor() {
    BankTeller bt = new BankTeller();
    return bt.getAccountsCount()==0;
  }
  
  /**
   * @return - true if an IllegalStateException is thrown when two bank accounts with the same ID are added to the bank account list
   */
  public static boolean testBankTellerAddBankAccountUsedIdentifier() {
    BankTeller bt = new BankTeller();
    try {
      bt.addBankAccount(new BankAccount("123456", 20));
      bt.addBankAccount(new BankAccount("123456", 10));
      return false;
    }
    catch(IllegalStateException e) {
      System.out.println(e.getMessage());
      return true;
    }
  }
  
  /**
   * @return - true if a FileNotFoundException is thrown when the file cannot be found
   */
  public static boolean testBankTellerLoadTransactionsFileNotFound() {
    BankTeller bt = new BankTeller();
    try {
      File f = new File("sheet.txt");
      BankAccount ba = new BankAccount("123456", 20);
      bt.loadTransactions(f, ba);
      return false;
    }
    catch(FileNotFoundException e) {
      return true;
    }
  }
  
  /**
   * @return - true if the transactions are loaded correctly from the file
   */
  public static boolean testBanktellerLoadTransactions() {
    BankTeller bt = new BankTeller();
    BankAccount ba = new BankAccount("123456", 20);
    bt.addBankAccount(ba);
    File f = new File("src/tranList.txt");
    try {
      bt.loadTransactions(f, ba);
    }
    catch(FileNotFoundException e) {
      System.out.println("File not found, try again.");
    }
    String[] arr = ba.getMostRecentTransactions();
    return true;
  }
  
}
