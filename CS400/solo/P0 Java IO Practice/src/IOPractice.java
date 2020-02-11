//////////////// TITLE ////////////////
// Title: IO Practice
// Files: cards.txt
// Course: CS 400 Spring 2020
//
// Author: Dhruv Jain
// ID Number: 9080553457
// Email: djain22@wisc.edu
// Lecturer's Name: Debra Deppler
///////////////////////////////////////
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Dhruv Jain
 * 
 * This class draws and stores cards within a text file. It can also read
 * cards that the user has previously stored within the text file.
 *
 */
public class IOPractice {
  
  /**
   * The main method prints the starting title and runs a while loop to take
   * the user's input. It utilizes various helper methods to help draw, store
   * and read cards.
   * 
   * @param args - default parameter for main method
   */
  public static void main(String[] args) {
    try {
      System.out.println("+++++++++++DHRUV JAIN++++++++++++");
      System.out.println("++++++++++ID:9080553457++++++++++");
      File f = new File("cards.txt");
      PrintWriter pw = new PrintWriter(f);
      Scanner scn = new Scanner(System.in);
      while(true) {
        printMenu();
        try {
          int input = scn.nextInt();
          if(input==1) {
            System.out.println("You drawed: "+drawCard());
          }
          else if(input==2) {
            String card = drawCard();
            System.out.println("You drawed:"+card);
            storeCard(pw, card);
          }
          else if(input==3) {
            printCards(f);
          }
          else if(input==4) {
            break;
          }
          else {
            System.out.println("Please try again with valid input.");
            continue;
          }
        } catch(FileNotFoundException e) {
          System.out.println("The file is not valid");
          break;
        }
      }
      pw.close();
      System.out.println("Thank you for using this program!");
    } catch(FileNotFoundException e) {
      System.out.println("File not found.");
      e.printStackTrace();
    }
  }
  
  /**
   * This method moves the scanner ahead by one, then prints all the cards in
   * order from least to most recent.
   * 
   * @param file - file to read cards from
   * @throws FileNotFoundException - if the file does not exist or is not found
   */
  public static void printCards(File file) throws FileNotFoundException {
    Scanner sc = new Scanner(file);
    sc.nextLine();
    while(sc.hasNext()) {
      System.out.print(sc.nextLine());
    }
    System.out.println("Done!");
  }
  
  /**
   * This method stores the card with the given printwriter into the cards.txt
   * file.
   * 
   * @param pw - printwriter to store card with
   * @param card - String of card to store
   */
  public static void storeCard(PrintWriter pw, String card) {
    System.out.println("Storing...");
    pw.println(card);
    System.out.println("Stored!");
    pw.flush();
  }
  
  /**
   * This method randomly chooses a number and a suit for a card, and returns a
   * string representation of the card.
   * 
   * @return - string of card formatted like: "number of suit"
   */
  public static String drawCard() {
    String returnStr = "";
    Random randGen = new Random();
    
    int number = randGen.nextInt(13)+1;
    switch(number) {
      case 1:
        returnStr += "Ace";
        break;
      case 11:
        returnStr += "Jack";
        break;
      case 12:
        returnStr += "Queen";
        break;
      case 13:
        returnStr += "King";
        break;
      default:
        returnStr += number;
        break;
    }
    returnStr += " of ";
    switch(randGen.nextInt(4)) {
      case 0:
        returnStr += "Spades";
        break;
      case 1:
        returnStr += "Hearts";
        break;
      case 2:
        returnStr += "Clubs";
        break;
      case 3:
        returnStr += "Diamonds";
        break;
      default:
        System.out.println("ERROR");
        break;
    }
    return returnStr;
  }
  
  /**
   * This method simply prints the menu for the user to pick from.
   */
  public static void printMenu() {
    System.out.println("===============CARD MENU===============");
    System.out.println("1) Draw Card");
    System.out.println("2) Draw and Store Card");
    System.out.println("3) View Drawn Cards");
    System.out.println("4) Quit");
    System.out.println("Choose 1, 2, 3, or 4.");
  }
}
