//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           DrawingChange - This class holds basic information for a character
// Files:           none
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
 * This class is for storing basic informationa about a character in a boxed array.
 */
public class DrawingChange {
  public final int row; // row (y-coordinate) for this DrawingChange
  public final int col; // col (x-coordinate) for this DrawingChange
  public final char prevChar; // previous character in the (row,col) position
  public final char newChar; // new character in the (row,col) position
  
  /**
   * This constructor initializes all instance variables to the parameters passed
   * into it.
   * 
   * @param row - integer to initialize instance variable row to
   * @param col - integer to initialize instance variable col to
   * @param prevChar - character to initialize instance variable prevChar to 
   * @param newChar - character to initialize instance variable newChar to
   */
  public DrawingChange(int row, int col, char prevChar, char newChar) {
    this.row = row;
    this.col = col;
    this.prevChar = prevChar;
    this.newChar = newChar;
  }
}
