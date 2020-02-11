//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           CustomProcess - This class represents a sample process
// Files:           N/A
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

/**
 * @author Dhruv Jain
 * 
 * This class implements a process. Each process has an ID which is unique to
 * it, and a burstTime which may not be unique.
 *
 */
public class CustomProcess implements Comparable<CustomProcess>{
  private static int nextProcessId = 1; // stores the id to be assigned to the next process
                                        // to be created
  private final int PROCESS_ID; // unique identifier for this process
  private int burstTime; // time required by this process for CPU execution
  
  /**
   * This constructor initializes the instance variable burstTime to the one
   * passed as a parameter. It also initializes PROCESS_ID accordingly, and
   * updates nextProcessId.
   * 
   * @param burstTime - time to set instance variable burstTime to
   */
  public CustomProcess(int burstTime) {
    if(burstTime<=0) {
      throw new IllegalArgumentException("Burst time must be greater than 0.");
    }
    this.burstTime = burstTime;
    PROCESS_ID = nextProcessId;
    nextProcessId++;
  }
  
  /**
   * This method compares the passed object to the current class. It first compares
   * the burst time of both, and if they are equal, it compares the process IDs. It
   * returns -1 if the current class is smaller, 1 if it is larger, and 0 if they are
   * both the same.
   * 
   * @param o - another object of type CustomProcess to compare the current one to
   * @return - -1 if this class is smaller, 1 if this class is bigger, 0 if they are equal
   */
  @Override
  public int compareTo(CustomProcess o) {
    if(this.burstTime<o.getBurstTime()) {
      return -1;
    }
    else if(this.burstTime>o.getBurstTime()) {
      return 1;
    }
    else {
      if(PROCESS_ID<o.getProcessId()) {
        return -1;
      }
      else if(PROCESS_ID>o.getProcessId()) {
        return 1;
      }
      return 0;
    }
  }
  
  /**
   * This method is an accessor method for the instance variable processId.
   * 
   * @return - instance variable processId
   */
  public int getProcessId() {
    return PROCESS_ID;
  }
  
  /**
   * This method is an accessor method for the instance variable burstTime.
   * 
   * @return - instance variable burstTime
   */
  public int getBurstTime() {
    return burstTime;
  }
  
  /**
   * Returns a String representation of this CustomProcess
   * 
   * @return a string representation of this CustomProcess
   */
  public String toString() {
    return "p" + this.PROCESS_ID + "(" + this.burstTime + ")";
  }
  
  /**
   * Initializes the nextProcessId to zero. This method can be called at the beginning of the test
   * methods.
   */
  static void initNextProcessID() {
    CustomProcess.nextProcessId = 0;
  }
}
