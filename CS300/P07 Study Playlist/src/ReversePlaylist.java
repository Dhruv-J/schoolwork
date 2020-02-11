//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Playlist - This class implements a backwards iterator on a list of Song objects
// Files:           Song.java
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

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Dhruv Jain
 *
 * This class implements an iterator for a Song object. It extends the Iterator
 * class for type Song.
 */
public class ReversePlaylist implements Iterator<Song>{
  DoublyLinkedNode<Song> doubleNode;
  
  /**
   * This constructor takes in a reference to type DoublyLinkedNode<Song> and sets
   * the class instance variable to it.
   * 
   * @param doubleNode - reference to type DoublyLinkedNode<Song> to set the instance variable to
   */
  public ReversePlaylist(DoublyLinkedNode<Song> doubleNode) {
    this.doubleNode = doubleNode;
  }

  /**
   * This method returns true if the current node, or class instance variable
   * doublenode is not null.
   * 
   * @return - true if doubleNode is not null
   */
  @Override
  public boolean hasNext() {
    return doubleNode!=null;
  }

  /**
   * This method returns the Song of the current DoublyLinkedNode, and sets
   * the current doubly linked node to its next value.
   * 
   * @return - the Song of the current DoublyLinkedNode
   */
  @Override
  public Song next() {
    if(doubleNode==null) {
      throw new NoSuchElementException("There are no more in the list.");
    }
    DoublyLinkedNode<Song> copy = doubleNode;
    doubleNode = doubleNode.getPrevious();
    return copy.getData();
  }
  
}
