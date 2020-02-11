//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           DrawingStackIterator - an iterator of a list of DrawingChange objects
// Files:           DrawingChange.java, LinkedNode.java
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
 * This helps iterate through a list of DrawingChange elements, specifically a stack of them.
 * It implements Iterator for the type DrawingChange.
 */
public class DrawingStackIterator implements Iterator<DrawingChange>{
  private LinkedNode<DrawingChange> next;
  
  /**
   * @param next - LinkedNode<DrawingChange> object to set instance variable next to
   */
  public DrawingStackIterator(LinkedNode<DrawingChange> next) {
    this.next = next;
  }

  /**
   * This method returns true if next is not hull.
   * 
   * @return true - if next is null
   */
  @Override
  public boolean hasNext() {
    return next!=null;
  }

  /**
   * This method returns the instance variable next's data, in this case a DrawingChange
   * object. It also sets next to its next node.
   * 
   * @return - the next node's DrawingChange data
   */
  @Override
  public DrawingChange next() {
    if(next==null) {
      throw new NoSuchElementException("There is no next element in the stack.");
    }
    LinkedNode<DrawingChange> copy = next;
    next = next.getNext();
    return copy.getData();
  }

}
