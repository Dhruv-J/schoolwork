//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           DrawingStack - this class emulates a stack of DrawingChange objects
// Files:           DrawingChange.java, StackADT.java
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
 * This class emulates a stack of DrawingChange objects. It implements Iterable
 * and StackADT for the type DrawingChange.
 */
public class DrawingStack implements Iterable<DrawingChange>, StackADT<DrawingChange>{
  private LinkedNode<DrawingChange> head;
  private int size;
  
  /**
   * This constructor sets the head as null and the size to zero. It takes no
   * arguments.
   */
  public DrawingStack() {
    head = null;
    size = 0;
  }
  
  /**
   * This method adds an element to this stack.
   * 
   * @param element - an element to be added
   * @throws java.util.IllegalArgumentException - if the input element is null
   */
  @Override
  public void push(DrawingChange element) {
    if(element==null) {
      throw new IllegalArgumentException("Element is null.");
    }
    LinkedNode<DrawingChange> tempSong = new LinkedNode<DrawingChange>(element, head);
    head = tempSong;
    size++;
  }

  /**
   * This method removes the element on the top of this stack and returns it.
   * 
   * @return - the element removed from the top of the stack
   * @throws java.util.EmptyStackException - without error message if the stack is empty
   */
  @Override
  public DrawingChange pop() {
    if(head==null) {
      throw new EmptyStackException();
    }
    LinkedNode<DrawingChange> tempNode = head;
    head = head.getNext();
    size--;
    return tempNode.getData();
  }

  /**
   * This method gets the element on the top of this stack
   * 
   * @return - the element on the stack top
   * @throws java.util.EmptyStackException - without error message if the stack is empty
   */
  @Override
  public DrawingChange peek() {
    if(head==null) {
      throw new EmptyStackException();
    }
    return head.getData();
  }

  /**
   * This method checks if the stack is empty, and only returns true if the size
   * is zero.
   * 
   * @return - true if size is zero, false otherwise
   */
  @Override
  public boolean isEmpty() {
    return size==0;
  }

  /**
   * This method returns the size fo the stack.
   * 
   * @return - size of type integer
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * This method returns an Iterator of type DrawingChange, which in this case
   * is a DrawingStackIterator object.
   * 
   * @return - Iterator of type DrawingChange
   */
  @Override
  public Iterator<DrawingChange> iterator() {
    return new DrawingStackIterator(head);
  }

}
