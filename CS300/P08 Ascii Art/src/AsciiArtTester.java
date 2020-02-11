//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           AsciiArtTester - This class tests the DrawingStack and Canvas Classes
// Files:           DrawingStack.java, Canvas.java
// Course:          CS 300 Fall 2019
//
// Author:          Dhruv Jain
// Email:           djain22@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    N/A
// Partner Email:   N/A
// Partner Lecturer's Name: N/A
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         N/A
// Online Sources:  Zybooks
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.*;

/**
 * @author Dhruv Jain
 * 
 * This class is for testing the DrawingStack and Canvas classes. It has two primary
 * methods to help test the validity of this classes.
 */
public class AsciiArtTester {
  /**
   * This method calls both tester methods, and prints their results.
   * 
   * @param args - argument for main method
   */
  public static void main(String[] args) {
    System.out.println(testStackPushPeek());
    System.out.println(runAsciiArtTestSuite());
  }
  
  /**
   * Condition 1 - push(null) called on a DrawingStack object throws an IllegalArgumentException
   * Condition 2 - peek called on an empty stack throws an EmptyStackException
   * Condition 3 - push and peek called and the data types returned from the peek are correct
   * Condition 4 - the size after calling peek is unchanged
   * 
   * @return - true if all conditions are met, false otherwise
   */
  public static boolean testStackPushPeek() {
    boolean bool1=false, bool2=false, bool3=false, bool4=false;
    DrawingStack ds = new DrawingStack();
    try{
      ds.push(null);
      return false;
    } catch(IllegalArgumentException e) {
      bool1=true;
    }
    try{
      ds.peek();
      return false;
    } catch(EmptyStackException e) {
      bool2 = true;
    }
    ds.push(new DrawingChange(0, 1, 'a', 'b'));
    String tempStr = ds.peek().row+" "+ds.peek().col+" "+ds.peek().prevChar+" "+ds.peek().newChar;
    bool3 = tempStr.equals("0 1 a b");
    bool4 = ds.size()==1;
    return bool1&&bool2&&bool3&&bool4;
  }
  
  /**
   * Condition 1 - creating a canvas object by passing 0 throws an IllegalArgumentException
   * Condition 2 - the iterator's next() and hasNext() method are working properly
   * Condition 3 - drawing four characters puts them in the correct position and prints correctly
   * Condition 4 - undoing twice removes the two most recent characters drawn
   * Condition 5 - redoing once puts back the third character 
   * 
   * @return - true if all conditions are met, false otherwise
   */
  public static boolean runAsciiArtTestSuite() {
    boolean bool1=false, bool2=false, bool3=false, bool4=false, bool5;
    try {
      Canvas c = new Canvas(0, 5);
      return false;
    } catch(IllegalArgumentException e) {
      bool1 = true;
    }
    DrawingStack ds = new DrawingStack();
    ds.push(new DrawingChange(0, 1, 'a', 'b'));
    bool2 = ds.iterator().hasNext();
    Canvas c = new Canvas(5, 5);
    c.draw(0, 0, 'a');
    c.draw(0, 1, 'b');
    c.draw(0, 2, 'c');
    c.draw(0, 3, 'd');
    bool3 = c.toString().equals("abcd_"+System.lineSeparator()+"_____"+System.lineSeparator()
        +"_____"+System.lineSeparator()+"_____"+System.lineSeparator()+"_____");
    c.undo();
    c.undo();
    bool4 = c.toString().equals("ab___"+System.lineSeparator()+"_____"+System.lineSeparator()
        +"_____"+System.lineSeparator()+"_____"+System.lineSeparator()+"_____");
    c.redo();
    bool5 = c.toString().equals("abc__"+System.lineSeparator()+"_____"+System.lineSeparator()
        +"_____"+System.lineSeparator()+"_____"+System.lineSeparator()+"_____");
    return bool1&&bool2&&bool3&&bool4&&bool5;
  }
}
