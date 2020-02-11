/////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           ProcessScheduler - this class schedules
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

import java.util.Scanner;

/**
 * @author Dhruv Jain
 * 
 * This class uses methods in the WaitingProcessQueue class to implement a full
 * scheduler.
 *
 */
public class ProcessScheduler {
  private int currentTime; // stores the current time after the last run
  private int numProcessesRun; // stores the number of processes run so far
  private WaitingProcessQueue queue; // this processing unit’s queue
  
  /**
   * This default constructor initializes the queue as a new WaitingProcessQueue,
   * and initializes instance variables currentTime and numProcessesRun to zero.
   */
  public ProcessScheduler() {
    queue = new WaitingProcessQueue();
    currentTime = 0;
    numProcessesRun = 0;
  }
  
  /**
   * This method inserts the given process in the WaitingProcessQueue queue.
   * 
   * @param process - the process to add to the queue
   */
  public void scheduleProcess(CustomProcess process) {
    queue.insert(process);
  }
  
  /**
   * This method runs the ready processes already scheduled in this processScheduler’s queue.
   * 
   * @return - a full string of the processes that were just run
   */
  public String run() {
    StringBuilder sb = new StringBuilder();
    if(queue.size()==1) {
      sb.append("Starting 1 process\n\n");
    }
    else {
      sb.append("Starting "+queue.size()+" process\n\n");
    }
    while(!queue.isEmpty()) {
      CustomProcess cur = queue.removeBest();
      sb.append("Time "+currentTime+" : Process ID "+cur.getProcessId()+" Starting.\n");
      currentTime+=cur.getBurstTime();
      sb.append("Time "+currentTime+" : Process ID "+cur.getProcessId()+" Completed.\n");
      numProcessesRun++;
    }
    sb.append("\nTime "+currentTime+": All scheduled processes completed.\n");
    return sb.toString();
  }
  
  /**
   * This main method acts as the driver for this class, it brings up a printed
   * UI and presents the users with a list of options. It utilizes two helper methods
   * to undertake its tasks.
   * 
   * @param args - parameter for main method
   */
  public static void main(String[] args) {
    ProcessScheduler ps = new ProcessScheduler();
    Scanner sc = new Scanner(System.in);
    System.out.println("========== Welcome to the SJF Process Scheduler App ========");
    System.out.println();
    String str = "";
    while(true) {
      System.out.println("Enter command:\n" + 
          "[schedule <burstTime>] or [s <burstTime>]\n" + 
          "[run] or [r]\n" + 
          "[quit] or [q]");
      System.out.println();
      str = sc.nextLine();
      if(str.equals("q")||str.equals("quit")) {
        break;
      }
      
      int check = ps.checkValidInput(str);
      if(check==0) {
        ps.doActions(str);
      }
      else if(check==1) {
        System.out.println("WARNING: Please enter a valid command!");
      }
      else if(check==2) {
        System.out.println("WARNING: burst time MUST be an integer!");
      }
    }
    sc.close();
    System.out.println("Thank you for using our scheduler!");
    System.out.println("Goodbye!");
  }
  
  /**
   * This method does two actions, one if the user selects to run the
   * processes if 'r' or 'run' is typed in, and inserts if 's' or 'schedule'
   * is typed in.
   * 
   * @param str - string that was input by the user to do actions based on
   */
  private void doActions(String str) {
    int spaceInd = str.indexOf(' ');
    if(spaceInd==-1) {
      run();
    }
    else{
      queue.insert(new CustomProcess(Integer.parseInt(str.substring(spaceInd+1))));
    }
  }
  
  /**
   * This method takes a string that may or may not be right. Since there are three
   * possible outcomes of the method, it returns 0 if the string is properly formatted,
   * 1 if it has a format error, and 2 if there is an error with parsing part of
   * string into a number.
   * 
   * @param str - string that was input by the user that may or may not be in the proper format
   * @return - 0 if the string is properly formatted, 1 if it has a format error, and 2
   *           if there is an error with parsing part of the string into a number
   */
  private int checkValidInput(String str) {
    int spaceInd = str.indexOf(' ');
    if(spaceInd==-1) {
      if(str.length()!=1&&str.length()!=3) {
        return 1;
      }
      if(!str.equals("r")&&!str.equals("run")) {
        return 1;
      }
    }
    else if(spaceInd==1||spaceInd==8) {
      String s = str.substring(0, spaceInd);
      if(!s.equals("s")&&!s.equals("schedule")) {
        return 1;
      }
      try {
        Integer.parseInt(str.substring(spaceInd+1));
      } catch(NumberFormatException e) {
        return 2;
      }
    }
    else {
      return 1;
    }
    return 0;
  }
}
