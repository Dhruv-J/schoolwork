//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           LinkedListMegaBlock - links MegaBlock objects to form a list
// Files:           Color.java, MegaBlock.java, LinkedMegaBlock.java
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
 * This class is for creating a list of LinkedMegaBlock objects. There is are
 * head and tail objects of type LinkedMegaBlock to make some of the other methods
 * easier to implement.
 */
public class LinkedListMegaBlock {
  private LinkedMegaBlock head; // head of this list
  private LinkedMegaBlock tail; // tail of this list
  private int size; // size of this list (total number of megablocks stored in this list)
  private int redCount; // number of RED megablocks stored in this list
  private int yellowCount; // number of YELLOW megablocks stored in this list
  private int blueCount; // number of BLUE megablocks stored in this list
  
  /**
   * This constructor initializes an empty linked list. 
   */
  public LinkedListMegaBlock() {
    head = null;
    tail = null;
    size=0;
    redCount=0;
    yellowCount=0;
    blueCount=0;
  }
  
  /**
   * This method returns true if the instance variable size is zero.
   * 
   * @return - true if the size is zero
   */
  public boolean isEmpty() {
    if(size==0) {
      return true;
    }
    return false;
  }
  
  /**
   * This method returns the instance variable size.
   * 
   * @return - instance variable size
   */
  public int size() {
    return size;
  }
  
  /**
   * This method intializes every static field to null, clearing the list. 
   */
  public void clear() {
    head = null;
    tail = null;
    size=0;
    redCount=0;
    yellowCount=0;
    blueCount=0;
  }
  
  /**
   * This method adds a red block to the front of the list. If the block is null
   * or the color of the block isn't red, then the method throws an IllegalArgumentException.
   * The method also updates head accordingly.
   * 
   * @param redBlock - reference to MegaBlock object to add to the list
   * @throws IllegalArgumentException - if the block is null or if the color is not red
   */
  public void addRed(MegaBlock redBlock) {
    if(redBlock==null || redBlock.getColor()!=Color.RED) {
      throw new IllegalArgumentException("Null value for redBlock, or redBlock color is not red.");
    }
    LinkedMegaBlock linkedRedBlock = new LinkedMegaBlock(redBlock);
    linkedRedBlock.setNext(head);
    head = linkedRedBlock;
    redCount+=1;
    size+=1;
  }

  /**
   * This method adds a blue block to the end of the list. If the block is null
   * or the color of the block isn't blue, the method throws an IllegalArgumentException.
   * The method also updates tail accordingly.
   * 
   * @param blueBlock - reference to MegaBlock object to add to the list
   * @throws IllegalArgumentExeption - if the block is null or if the color is not blue
   */
  public void addBlue(MegaBlock blueBlock) {
    if(blueBlock==null || blueBlock.getColor()!=Color.BLUE) {
      throw new IllegalArgumentException("Null value for blueBlock, or blueBlock color is not blue.");
    }
    LinkedMegaBlock linkedBlueBlock = new LinkedMegaBlock(blueBlock);
    if(tail!=null) {
      tail.setNext(linkedBlueBlock);
      tail = linkedBlueBlock;
    }
    else {
      head = linkedBlueBlock;
      tail = linkedBlueBlock;
      linkedBlueBlock.setNext(null);
    }
    blueCount+=1;
    size+=1;
  }
  
  /**
   * This method adds a yellow block to the specified index of the list. If the
   * block is null or the color of the block isn't yellow, the method throws an
   * IllegalAgumentException. If the index is outside of the allowed index for
   * yellow blocks, the method throws an IndexOutOfBounds Exception.
   * 
   * @param index - index to add the yellow block to
   * @param yellowBlock - reference to MegaBlock object to add to the list
   * @throws IllegalArgumentException - if the block is null or if the color is not yellow
   * @throws IndexOutOfBoundsException - if the index is not within the allowed range
   */
  public void addYellow(int index, MegaBlock yellowBlock) {
    if(yellowBlock==null || yellowBlock.getColor()!=Color.YELLOW) {
      throw new IllegalArgumentException("Null value for yellowBlock, or yellowBlock color is not yellow.");
    }
    if(index<redCount || index>size-blueCount && blueCount!=0) {
      throw new IndexOutOfBoundsException("Yellow index not within allowed yellow range.");
    }
    int counter = 0;
    LinkedMegaBlock linkedYellowBlock = new LinkedMegaBlock(yellowBlock);
    LinkedMegaBlock temp = head;
    LinkedMegaBlock prev = null;
    while(temp!=null&&counter!=index) {
      prev = temp;
      temp = temp.getNext();
      counter+=1;
    }
    if(prev!=null&&temp!=null) {
      linkedYellowBlock.setNext(temp);
      prev.setNext(linkedYellowBlock);
    }
    else if(temp!=null&&prev==null) {
      linkedYellowBlock.setNext(temp);
      head = linkedYellowBlock;
    }
    else if(temp==null&&prev!=null) {
      prev.setNext(linkedYellowBlock);
      tail = linkedYellowBlock;
    }
    else {
      head = linkedYellowBlock;
      tail = linkedYellowBlock;
    }
    yellowCount+=1;
    size+=1;
  }
  
  /**
   * This method returns a reference to the MegaBlock object part of the
   * LinkedMegaBlock at the specified index. It throws an IndexOutOfBoundsException
   * if the index is less than zero or if the index is larger than the size of
   * the linked list itself.
   * 
   * @param index - index of the list to get the block from
   * @return - a reference to the MegaBlock that is at the position
   * @throws IndexOutOfBoundsException - if the index is less than zero or larger than the size
   */
  public MegaBlock get(int index) {
    if(index<0 || index>=size()) {
      throw new IndexOutOfBoundsException("Index out of range of size.");
    }
    int counter = 0;
    LinkedMegaBlock temp = head;
    while(counter!=index) {
      temp = temp.getNext();
      counter+=1;
    }
    return temp.getBlock();
  }
  
  /**
   * This method sets the MegaBlock of the LinkedMegaBlock at the given index
   * to the new MegaBlock passed in to the method. It returns a reference to
   * the MegaBlock that used to be at the position. The method throws an
   * IndexOutOfBoundsException if the index is less than zero or more than the
   * size. It also throws an IllegalArgumentException if the index is out of
   * bounds for the respective color.
   * 
   * @param index - index of the list to set the new block to
   * @param block - a reference to a MegaBlock object to set as the new MegaBlock
   * @return - a reference to the MegaBlock that used to be at the position
   * @throws IndexOutOfBoundsException - if the index is less than zero or larger than the size
   * @throws IllegalArgumentException - if the index is out of bounds for the respective color
   */
  public MegaBlock set(int index, MegaBlock block) {
    if(index<0 || index>=size()) {
      throw new IndexOutOfBoundsException("Index out of range of size.");
    }
    int counter = 0;
    LinkedMegaBlock linkedBlock = new LinkedMegaBlock(block);
    LinkedMegaBlock temp = head;
    LinkedMegaBlock prev = null;
    if(block.getColor()==Color.RED) {
      if(index<0||index>redCount) {
        throw new IllegalArgumentException("Red index is wrong.");
      }
    }
    else if(block.getColor()==Color.BLUE) {
      if(index<size-blueCount||index>size) {
        throw new IllegalArgumentException("Blue index is wrong.");
      }
    }
    else if(block.getColor()==Color.YELLOW) {
      if(index<redCount||index>size-blueCount) {
        throw new IllegalArgumentException("Yellow index is wrong.");
      }
    }
    else {
      System.out.println("Wrong color input?");
    }
    while(temp!=null&&counter!=index) {
      prev = temp;
      temp = temp.getNext();
      counter+=1;
    }
    LinkedMegaBlock retBlock = null;
    if(prev!=null&&temp!=null) {
      retBlock = temp;
      linkedBlock.setNext(temp.getNext());
      prev.setNext(linkedBlock);
    }
    else if(prev==null&&temp!=null) {
      retBlock = temp;
      linkedBlock.setNext(temp.getNext());
      head = linkedBlock;
    }
    else if(prev!=null&&temp==null) {
      retBlock = prev;
      prev = linkedBlock;
      tail = linkedBlock;
    }
    else {
      System.out.println("How did we get here?");
    }
    return retBlock.getBlock();
  }
  
  /**
   * This method removes a red block from the head of the list and returns a
   * reference to its MegaBlock object. It throws a NoSuchElementException if
   * the red count is zero.
   * 
   * @return - the MegaBlock value of the LinkedMegaBlock that was removed
   * @throws NoSuchElementException - if redCount is zero
   */
  public MegaBlock removeRed() {
    if(redCount==0) {
      throw new NoSuchElementException("No reds in the list.");
    }
    LinkedMegaBlock tempBlock = head;
    head = head.getNext();
    redCount -= 1;
    return tempBlock.getBlock();
  }
  
  /**
   * This method removes a blue block from the head of the list and returns a
   * reference to its MegaBlock object. It throws a NoSuchElementException if
   * the blue count is zero.
   * 
   * @return - the MegaBlock value of the LinkedMegaBlock that was removed
   * @throws NoSuchElementException - if blueCount is zero
   */
  public MegaBlock removeBlue() {
    if(blueCount==0) {
      throw new NoSuchElementException("No blues in the list.");
    }
    LinkedMegaBlock tempBlock = head;
    while(tempBlock.getNext().getNext()!=null) {
      tempBlock=tempBlock.getNext();
    }
    LinkedMegaBlock retBlock = tempBlock.getNext();
    tempBlock.setNext(null);
    tail = tempBlock;
    blueCount -= 1;
    return retBlock.getBlock();
  }
  
  /**
   * This method removes a yellow block from the head of the list and returns a
   * reference to its MegaBlock object. It throws a IndexOutOfBoundsException if
   * the index is not within the acceptable range for a yellow block.
   * 
   * @return - the MegaBlock value of the LinkedMegaBlock that was removed
   * @throws IndexOutOfBoundsException - if yellowCount is not within acceptable range
   */
  public MegaBlock removeYellow(int index) {
    if(yellowCount==0 || index<redCount || index>=size-blueCount) {
      throw new IndexOutOfBoundsException("Index out of range of size.");
    }
    int counter = 0;
    LinkedMegaBlock temp = head;
    while(counter!=index-1) {
      temp = temp.getNext();
      counter+=1;
    }
    MegaBlock tempBlock = temp.getNext().getBlock();
    temp.setNext(temp.getNext().getNext());
    yellowCount -= 1;
    return tempBlock;
  }
  
  /**
   * This method returns the number of red blocks in the list.
   * 
   * @return - redCount
   */
  public int getRedCount() {
    return redCount;
  }
  
  /**
   * This method returns the number of blue blocks in the list.
   * 
   * @return - blueCount
   */
  public int getBlueCount() {
    return blueCount;
  }
  
  /**
   * This method returns the number of yellow blocks in the list.
   * 
   * @return - yellowCount
   */
  public int getYellowCount() {
    return yellowCount;
  }
  
  /** 
   * This method returns the entire list of LinkedMegaBlock objects by iterating
   * through the list and adding each block's string value and returning it.
   * 
   * @return - the entire list in string format
   */
  @Override
  public String toString() {
    if(size==0) {
      return "";
    }
    LinkedMegaBlock temp = head;
    String retString = "";
    while(temp!=null) {
//      System.out.println("called");
      retString += temp.toString();
//      System.out.println("retString: "+retString);
      temp = temp.getNext();
    }
    return retString;
  }
}
