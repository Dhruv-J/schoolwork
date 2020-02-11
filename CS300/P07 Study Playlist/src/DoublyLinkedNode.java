//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           DoublyLinkedNode - This class emulates a doubly linked node.
// Files:           None
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
 * This class is for implementing a doubly linked node, its methods and instance
 * fields help it in doing so.
 */
public class DoublyLinkedNode <T> {
  DoublyLinkedNode<T> previous;
  T data;
  DoublyLinkedNode<T> next;
  
  /**
   * This constructor takes two objects of this class and one object of type T, and
   * assigns them to the class instance variables. It throws an IllegalArgumenException
   * if data is null.
   * 
   * @param previous - object of this class to set instance field previous to
   * @param data - object of type T to store as the data, and instance field to
   * @param next - object of this class to set instance field next to
   * @throws IllegalArgumentException - if data is null
   */
  public DoublyLinkedNode(DoublyLinkedNode<T> previous, T data, DoublyLinkedNode<T> next) {
    if(data==null) {
      throw new IllegalArgumentException("Data is null.");
    }
    this.previous = previous;
    this.data = data;
    this.next = next;
  }
  
  /**
   * This constructor sets the class instance variable data to the parameter passed
   * in to the method. It throws an IllegalArgumentException if data is null.
   * 
   * @param data - to set isntance field 'data' to
   * @throws IllegalArgumentException - if data is null
   */
  public DoublyLinkedNode(T data) {
    if(data==null) {
      throw new IllegalArgumentException("Data is null.");
    }
    previous = null;
    this.data = data;
    next = null;
  }
  
  /**
   * This method returns a reference to the class instance variable of type T.
   * 
   * @return - reference to class instance variable of type T
   */
  public T getData() {
    return data;
  }
  
  /**
   * This method returns a reference to the class instance variable 'next'.
   * 
   * @return - a reference to class instance variable next
   */
  public DoublyLinkedNode<T> getNext() {
    return next;
  }
  
  /**
   * This method takes a reference to an object of this class and sets the class
   * instance variable 'next' to it.
   * 
   * @param next - to set instance variable 'next' to
   */
  public void setNext(DoublyLinkedNode<T> next) {
    this.next = next;
  }
  
  /**
   * This method returns a reference to the class instance variable 'previous'
   * of type T.
   * 
   * @return - a reference to class instance variable previous
   */
  public DoublyLinkedNode<T> getPrevious() {
    return previous;
  }
  
  /**
   * This method takes a reference to an object of this class and sets the class
   *  instance variable 'next' to it.
   * 
   * @param previous - to set instance variable 'previous' to
   */
  public void setPrevious(DoublyLinkedNode<T> previous) {
    this.previous = previous;
  }
}
