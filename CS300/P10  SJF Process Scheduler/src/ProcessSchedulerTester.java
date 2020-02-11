/////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           ProcessSchedulerTester - this class tests the WaitingProcessQueue class
// Files:           WaitingProcessQueue.java
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

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * @author Dhruv Jain
 * 
 * This class tests two methods from the WaitingProcessQueue class.
 *
 */
public class ProcessSchedulerTester {
  
  /**
   * This method runs both tester methods and prints their results.
   * 
   * @param args - parameter for main method
   */
  public static void main(String[] args) {
    System.out.println(testInsertWaitingProcessQueue());
    System.out.println(testRemoveBestWaitingProcessQueue());
  }
  
  /**
   * This method checks the validity of the removeBest method from the WaitingProcessQueue
   * class, and returns true if all conditions are met.
   * Condition 1 - trying to insert a faulty CustomProcess throws an IllegalArgumentException
   * Condition 2 - inserting with valid values increments size and updates the best accordingly
   * 
   * @return - true if all conditions are met
   */
  public static boolean testInsertWaitingProcessQueue() {
    boolean bool1=false, bool2=false;
    WaitingProcessQueue wpc = new WaitingProcessQueue();
    try {
      wpc.insert(new CustomProcess(-1));
      return false;
    } catch(IllegalArgumentException e) {
      bool1 = true;
    }
    wpc.insert(new CustomProcess(8)); //burst time 8
    bool2 = wpc.peekBest().getBurstTime()==8;
    wpc.insert(new CustomProcess(10)); //burst time 10
    wpc.insert(new CustomProcess(7)); //burst time 7
    bool2 = bool2&&wpc.peekBest().getBurstTime()==7;
    wpc.insert(new CustomProcess(2)); //burst time 2
    bool2 = bool2&&wpc.peekBest().getBurstTime()==2;
    wpc.insert(new CustomProcess(9)); //burst time 9
    bool2 = bool2&&wpc.peekBest().getBurstTime()==2&&wpc.size()==5;
    return bool1&&bool2;
  }
  
  /**
   * This method checks the validity of the removeBest method from the WaitingProcessQueue
   * class, and returns true if all conditions are met.
   * Condition 1 - trying to remove from an empty queue throws a NoSuchElementException
   * Condition 2 - trying to remove best updates the size and updates the best accordingly
   * 
   * @return - true if all conditions are met
   */
  public static boolean testRemoveBestWaitingProcessQueue() {
    boolean bool1=false, bool2=false;
    WaitingProcessQueue wpc = new WaitingProcessQueue();
    CustomProcess.initNextProcessID();
    try {
      wpc.removeBest();
    } catch(NoSuchElementException e) {
      bool1 = true;
    }
    wpc.insert(new CustomProcess(2)); //burst time 2
    wpc.insert(new CustomProcess(8)); //burst time 8
    wpc.insert(new CustomProcess(10)); //burst time 10
    wpc.insert(new CustomProcess(7)); //burst time 7
    wpc.insert(new CustomProcess(9)); //burst time 9
    wpc.removeBest();
    bool2 = wpc.peekBest().getBurstTime()==7;
    wpc.removeBest();
    bool2 = bool2&&wpc.peekBest().getBurstTime()==8;
    wpc.removeBest();
    bool2 = bool2&&wpc.peekBest().getBurstTime()==9;
    bool2 = bool2&&wpc.size()==2;
    return bool1&&bool2;
  }
}
