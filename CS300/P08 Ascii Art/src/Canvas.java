//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Canvas - This class uses stacks to implement an array of chars
// Files:           DrawingChange.java, DrawingStack.java, DrawingStackIterator.java
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
 * This class is for storing basic information about a character in a two-dimensional
 * array. It has several functions to undo and redo changes made to the array.
 */
public class Canvas {
  private final int width; // width of the canvas
  private final int height; // height of the canvas
  private char [][] drawingArray; // 2D character array to store the drawing
  private final DrawingStack undoStack; // store previous changes for undo
  private final DrawingStack redoStack; // store undone changes for redo
  
  /**
   * This constructor initializes instance variables height and width to the
   * parameters. It also fills the array with spaces. The two stack variables
   * are intialized as well.
   * 
   * @param width - integer to initialize instance variable width to
   * @param height - integer to initialize instance variable height to
   */
  public Canvas(int width, int height) {
    if(width<=0||height<=0) {
      throw new IllegalArgumentException("Width and/or Height is less than or equal to 0.");
    }
    this.width = width;
    this.height = height;
    drawingArray = new char[height][width];
    for(int i=0; i<height; i++) {
      for(int j=0; j<width; j++) {
        drawingArray[i][j] = ' ';
      }
    }
    undoStack = new DrawingStack();
    redoStack = new DrawingStack();
  }

  /**
   * This method modifies the array at the specified row and column to be the
   * character passed as the parameter. It also updates the undo stack and clears
   * the redo stack.
   * 
   * @param row - the row to draw a character at
   * @param col - the column to draw a character at
   * @param c - the character to draw within the array
   */
  public void draw(int row, int col, char c) {
    if(row>=width||col>=height) {
      throw new IllegalArgumentException("Specified index is wrong.");
    }
    char temp = drawingArray[row][col];
    drawingArray[row][col] = c;
    undoStack.push(new DrawingChange(row, col, temp, c));
    while(!redoStack.isEmpty()) {
      redoStack.pop();
    }
  }

  /**
   * An undone DrawingChange is popped off the undoStack. An undone DrawingChange
   * is added to the redoStack so that it is possible to redo. The content of the
   * drawing array is updated accordingly.
   * 
   * @return - true if the operation was successful, false otherwise
   */
  public boolean undo() {
    try {
      redoStack.push(undoStack.pop());
      drawingArray[redoStack.peek().row][redoStack.peek().col] = redoStack.peek().prevChar;
      return true;
    } catch(Exception e) {
      return false;
    }
  }
  
  /**
   * An redone DrawingChange is popped off the redoStack. An redone DrawingChange
   * is added to the undoStack so that it is possible to undo. The content of the
   * drawing array is updated accordingly.
   * 
   * @return - true if the operation was successful, false otherwise
   */
  public boolean redo() {
    try {
      undoStack.push(redoStack.pop());
      drawingArray[undoStack.peek().row][undoStack.peek().col] = undoStack.peek().newChar;
      return true;
    } catch(Exception e) {
      return false;
    }
}
  /**
   * The return String is formatted in the following way:
   * X___X
   * _X_X_
   * __X__
   * _X_X_
   * X___X
   * The spaces in the original array are replaced by underscores.
   * 
   * @return - a printable string version of the canvas
   */
  public String toString() {
    String retStr = "";
    for(int i=0; i<width; i++) {
      for(int j=0; j<height; j++) {
        if(drawingArray[i][j]==' ') {
          retStr += "_";
        }
        else {
          retStr += ""+drawingArray[i][j];
        }
      }
      if(i!=width-1) {
        retStr += System.lineSeparator();
      }
    }
    return retStr;
  }
  
  /**
   * This method prints a toString version of this class. 
   */
  public void printDrawing() {
    System.out.println(this.toString());
  }
  
  /**
   * This method prints the undoStack of this class.
   */
  public void printHistory() {
    
  }
}
