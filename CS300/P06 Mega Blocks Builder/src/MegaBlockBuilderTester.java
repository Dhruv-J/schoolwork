//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           MegaBlockBuilderTester - tests select methods from the classes below
// Files:           Color.java, MegaBlock.java, LinkedMegaBlock.java, LinkedListMegaBlock.java
// Course:          CS 300 Fall 2019
//
// Author:          Dhruv Jain
// Email:           djain22@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Prafull Sharma
// Partner Email:   psharma49@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   _X_ Write-up states that pair programming is allowed for this assignment.
//   _X_ We have both read and understand the course Pair Programming Policy.
//   _X_ We have registered our team prior to the team registration deadline.
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
 * @author Dhruv Jain, Prafull Sharma
 *
 * This class is for testing select methods in MegaBlock.java, LinkedMegaBlock.java,
 * and LinkedListMegaBlock.java.
 */
public class MegaBlockBuilderTester {
  
  /**
   * This main method runs tests and prints out the results.
   * 
   * @param args - param for main
   */
  public static void main(String[] args) {
    System.out.println(testMegaBlockEquals());
    System.out.println(testMegaBlockToString());
    System.out.println(testLinkedMegaBlock());
    System.out.println(testLinkedListMegaBlockBasics());
    System.out.println(testLinkedListMegaBlockAddRed());
    System.out.println(testLinkedListMegaBlockAddBlue());
    System.out.println(testLinkedListMegaBlockAddYellow());
    System.out.println(testLinkedListMegaBlockGet());
    System.out.println(testLinkedListMegaBlockSet());
    System.out.println(testLinkedListMegaBlockRemoveRed());
    System.out.println(testLinkedListMegaBlockRemoveBlue());
    System.out.println(testLinkedListMegaBlockRemoveYellow());
    System.out.println(testLinkedListMegaBlockColorCount());
//    testLinkedListMegaBlockGradescope();
  }
  
  /**
   * Condition 1: the equals method returns true for an object that has the same
   * color as the object it is being compared to
   * Condition 2: the equals method returns false for faulty input, or input that
   * does not have the same color
   * 
   * @return - true if all conditions are met
   */
  public static boolean testMegaBlockEquals() {
    boolean bool1=false, bool2=false;
    MegaBlock mb = new MegaBlock(Color.RED, 'a');
    bool1 = mb.equals(new MegaBlock(Color.RED, 'b'));
    bool2 = !mb.equals(new String("block"));
    return bool1&&bool2;
  }
  
  /**
   * Condition 1: the toString method returns the proper string for an initialized
   * block
   * 
   * @return - true if the condition is met
   */
  public static boolean testMegaBlockToString() {
    boolean bool1=false;
    MegaBlock mb = new MegaBlock(Color.RED, 'a');
    bool1 = mb.toString().equals("RED a");
    return bool1;
  }
  
  /**
   * Condition 1: two LinkedMegaBlock objects are able to be constructed, and one
   * is able to be set as the next of the other
   * 
   * @return - true if the condition is met
   */
  public static boolean testLinkedMegaBlock() {
    MegaBlock mb1 = new MegaBlock(Color.RED, 'a');
    MegaBlock mb2 = new MegaBlock(Color.YELLOW, 'b');
    LinkedMegaBlock lmb1 = new LinkedMegaBlock(mb1);
    LinkedMegaBlock lmb2 = new LinkedMegaBlock(mb2);
    lmb2.setNext(lmb1);
    LinkedMegaBlock temp = lmb2;
    String compareString = "";
    while(temp!=null) {
      compareString += temp.toString();
      temp = temp.getNext();
    }
    return compareString.equals("YELLOW b -> RED a -> END");
  }

  /**
   * Condition 1: the method throws an IllegalArgumentException when a yellow
   * MegaBlock is passed in
   * Condition 2: the method is able update the red count properly
   * Condition 3: the method is able to check the size of the linked list properly
   * Conditino 4: the string for the object is correct after calling the method
   * 
   * @return - true if all conditions are met
   */
  public static boolean testLinkedListMegaBlockAddRed() {
    LinkedListMegaBlock linkedListBlock = new LinkedListMegaBlock();
    boolean bool1=false, bool2=false, bool3=false, bool4=false;
    linkedListBlock.addBlue(new MegaBlock(Color.BLUE, 'a'));
    linkedListBlock.addBlue(new MegaBlock(Color.BLUE, 'b'));
    linkedListBlock.addRed(new MegaBlock(Color.RED, 'a'));
    linkedListBlock.addRed(new MegaBlock(Color.RED, 'b'));
    try{
      linkedListBlock.addRed(new MegaBlock(Color.YELLOW, 'a'));
    }
    catch(IllegalArgumentException e) {
      bool1 = true;
    }
    bool2 = linkedListBlock.getRedCount()==2;
    bool3 = linkedListBlock.size()==4;
    bool4 = linkedListBlock.toString().equals("RED b -> RED a -> BLUE a -> BLUE b -> END");
    return bool1&&bool2&&bool3&&bool4;
  }
  
  public static boolean testLinkedListMegaBlockBasics() {
    LinkedListMegaBlock linkedListBlock = new LinkedListMegaBlock();
    return linkedListBlock.isEmpty();
  }
  
  public static boolean testLinkedListMegaBlockAddBlue() {
    LinkedListMegaBlock linkedListBlock = new LinkedListMegaBlock();
    boolean bool1=false, bool2=false, bool3=false, bool4=false;
    linkedListBlock.addBlue(new MegaBlock(Color.BLUE, 'a'));
    linkedListBlock.addBlue(new MegaBlock(Color.BLUE, 'b'));
    try{
      linkedListBlock.addBlue(new MegaBlock(Color.RED, 'a'));
    }
    catch(IllegalArgumentException e) {
      bool1 = true;
    }
    bool2 = linkedListBlock.getBlueCount()==2;
    bool3 = linkedListBlock.size()==2;
    bool4 = linkedListBlock.toString().equals("BLUE a -> BLUE b -> END");
    return bool1&&bool2&&bool3&&bool4;
  }
  
  public static boolean testLinkedListMegaBlockAddYellow() {
    LinkedListMegaBlock linkedListBlock = new LinkedListMegaBlock();
    boolean bool1=false, bool2=false, bool3=false, bool4=false, bool5=false;
    linkedListBlock.addBlue(new MegaBlock(Color.BLUE, 'a'));
    linkedListBlock.addBlue(new MegaBlock(Color.BLUE, 'b'));
    linkedListBlock.addRed(new MegaBlock(Color.RED, 'a'));
    linkedListBlock.addRed(new MegaBlock(Color.RED, 'b'));
    linkedListBlock.addYellow(2, new MegaBlock(Color.YELLOW, 'a'));
    linkedListBlock.addYellow(2, new MegaBlock(Color.YELLOW, 'b'));
    try{
      linkedListBlock.addYellow(2, new MegaBlock(Color.BLUE, 'a'));
    }
    catch(IllegalArgumentException e) {
      bool1 = true;
    }
    try{
      linkedListBlock.addYellow(5, new MegaBlock(Color.YELLOW, 'a'));
    }
    catch(IndexOutOfBoundsException e) {
      bool2 = true;
    }
    bool3 = linkedListBlock.getYellowCount()==2;
    bool4 = linkedListBlock.size()==6;
    bool5 = linkedListBlock.toString().equals("RED b -> RED a -> YELLOW b -> YELLOW a -> BLUE a -> BLUE b -> END");
    return bool1&&bool2&&bool3&&bool4&&bool5;
  }
  
  private static LinkedListMegaBlock fillLinked() {
    LinkedListMegaBlock linkedListBlock = new LinkedListMegaBlock();
    linkedListBlock.addBlue(new MegaBlock(Color.BLUE, 'a'));
    linkedListBlock.addBlue(new MegaBlock(Color.BLUE, 'b'));
    linkedListBlock.addRed(new MegaBlock(Color.RED, 'a'));
    linkedListBlock.addRed(new MegaBlock(Color.RED, 'b'));
    linkedListBlock.addYellow(2, new MegaBlock(Color.YELLOW, 'a'));
    linkedListBlock.addYellow(2, new MegaBlock(Color.YELLOW, 'b'));
    return linkedListBlock;
  }
  
  public static boolean testLinkedListMegaBlockGet() {
    LinkedListMegaBlock linkedListBlock = fillLinked();
    boolean bool1=false, bool2=false, bool3=false, bool4=false;
    try {
      linkedListBlock.get(7);
    }
    catch(IndexOutOfBoundsException e) {
      bool1 = true;
    }
    bool2 = linkedListBlock.get(0).equals(new MegaBlock(Color.RED, 'a'));
    bool3 = linkedListBlock.get(2).equals(new MegaBlock(Color.YELLOW, 'a'));
    bool4 = linkedListBlock.get(5).equals(new MegaBlock(Color.BLUE, 'a'));
    return bool1&&bool2&&bool3&&bool4;
  }
  
  public static boolean testLinkedListMegaBlockSet() {
    LinkedListMegaBlock linkedListBlock = fillLinked();
    boolean bool1=false, bool2=false, bool3=false, bool4=false, bool5=true;
    try {
      linkedListBlock.set(7, new MegaBlock(Color.BLUE, 'c'));
    }
    catch(IndexOutOfBoundsException e) {
      bool1 = true;
    }
    try {
      linkedListBlock.set(0, new MegaBlock(Color.BLUE, 'c'));
    }
    catch(IllegalArgumentException e) {
      bool2 = true;
    }
    linkedListBlock.set(0, new MegaBlock(Color.RED, 'c'));
    bool3 = linkedListBlock.toString().equals("RED c -> RED a -> YELLOW b -> YELLOW a -> BLUE a -> BLUE b -> END");
    linkedListBlock.set(2, new MegaBlock(Color.YELLOW, 'd'));
    bool4 = linkedListBlock.toString().equals("RED c -> RED a -> YELLOW d -> YELLOW a -> BLUE a -> BLUE b -> END");
    linkedListBlock.set(5, new MegaBlock(Color.BLUE, 'e'));
    bool5 = linkedListBlock.toString().equals("RED c -> RED a -> YELLOW d -> YELLOW a -> BLUE a -> BLUE e -> END");
    return bool1&&bool2&&bool3&&bool4&&bool5;
  }
  
  public static boolean testLinkedListMegaBlockRemoveRed() {
    LinkedListMegaBlock linkedListBlock = fillLinked();
    boolean bool1=false, bool2=false, bool3=false;
    linkedListBlock.removeRed();
    bool1 = linkedListBlock.toString().equals("RED a -> YELLOW b -> YELLOW a -> BLUE a -> BLUE b -> END");
    linkedListBlock.removeRed();
    bool2 = linkedListBlock.toString().equals("YELLOW b -> YELLOW a -> BLUE a -> BLUE b -> END");
    try {
      linkedListBlock.removeRed();
    }
    catch(NoSuchElementException e) {
      bool3 = true;
    }
    return bool1&&bool2&&bool3;
  }
  
  /**
   * Condition 1: the method removes the first blue and has the list in the
   * correct order afterwards
   * Condition 2: the method removes the second blue and has the list in the
   * correct order afterwards
   * Condition 3: the method tries to remove another blue, and the code throws
   * a NoSuchElementException
   * 
   * @return - true if all conditions are met
   */
  public static boolean testLinkedListMegaBlockRemoveBlue() {
    LinkedListMegaBlock linkedListBlock = fillLinked();
    boolean bool1=false, bool2=false, bool3=false;
    linkedListBlock.removeBlue();
    bool1 = linkedListBlock.toString().equals("RED b -> RED a -> YELLOW b -> YELLOW a -> BLUE a -> END");
    linkedListBlock.removeBlue();
    bool2 = linkedListBlock.toString().equals("RED b -> RED a -> YELLOW b -> YELLOW a -> END");
    try {
      linkedListBlock.removeBlue();
    }
    catch(NoSuchElementException e) {
      bool3 = true;
    }
    return bool1&&bool2&&bool3;
  }
  
  public static boolean testLinkedListMegaBlockRemoveYellow() {
    LinkedListMegaBlock linkedListBlock = fillLinked();
    boolean bool1=false, bool2=false, bool3=false;
    linkedListBlock.removeYellow(3);
    bool1 = linkedListBlock.toString().equals("RED b -> RED a -> YELLOW b -> BLUE a -> BLUE b -> END");
    linkedListBlock.removeYellow(2);
    bool2 = linkedListBlock.toString().equals("RED b -> RED a -> BLUE a -> BLUE b -> END");
    try {
      linkedListBlock.removeYellow(2);
    }
    catch(IndexOutOfBoundsException e) {
      bool3 = true;
    }
    return bool1&&bool2&&bool3;
  }
  
  public static boolean testLinkedListMegaBlockColorCount() {
    LinkedListMegaBlock linkedListBlock = fillLinked();
    boolean bool1=false, bool2=false, bool3=false;
    bool1 = linkedListBlock.getRedCount()==2;
    bool2 = linkedListBlock.getBlueCount()==2;
    bool3 = linkedListBlock.getYellowCount()==2;
    return bool1&&bool2&&bool3;
  }
  
  /**public static void testLinkedListMegaBlockGradescope() {
    LinkedListMegaBlock linkedListBlock = new LinkedListMegaBlock();
    linkedListBlock.addYellow(0, new MegaBlock(Color.YELLOW, 'A'));
    linkedListBlock.addRed(new MegaBlock(Color.RED, 'B'));
    linkedListBlock.addYellow(linkedListBlock.size(), new MegaBlock(Color.YELLOW, 'C'));
    System.out.println(linkedListBlock);
    linkedListBlock.addYellow(2, new MegaBlock(Color.YELLOW, 'D'));
    System.out.println(linkedListBlock);
    linkedListBlock.addBlue(new MegaBlock(Color.BLUE, 'E'));
    System.out.println(linkedListBlock);
  }**/
}
