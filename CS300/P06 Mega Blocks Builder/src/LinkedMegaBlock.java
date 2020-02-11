//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           LinkedMegaBlock - allows MegaBlock objects to be linked
// Files:           Color.java, MegaBlock.java 
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

/**
 * @author Dhruv Jain, Prafull Sharma
 * This class allows MegaBlocks to be linked together by providing a next field
 * and related accessor and mutator methods.
 */
public class LinkedMegaBlock {
  private MegaBlock block; // data field of this linkedMegaBlock
  private LinkedMegaBlock next; // link to the next linkedMegaBlock
  
  /**
   * This constructor takes a parameter of type MegaBlock and sets the instance
   * variable block to its value. It also initializes next to null.
   * 
   * @param block - MegaBlock to set class variable block to
   */
  public LinkedMegaBlock(MegaBlock block) {
    this.block = block;
    this.next = null;
  }
  
  /**
   * This constructor takes a parameter of type MegaBlock and sets the instance
   * variable block to its value. It also takes a parameter of type LinkedMegaBlock
   * and sets the instance variable next to its value. 
   * 
   * @param block - MegaBlock to set class variable block to
   * @param next - LinkedMegaBlock to set class variable next to
   */
  public LinkedMegaBlock(MegaBlock block, LinkedMegaBlock next) {
    this.block = block;
    this.next = next;
  }
  
  /**
   * This method returns a reference to the instance variable block.
   * 
   * @return - class variable block of type MegaBlock
   */
  public MegaBlock getBlock() {
    return block;
  }
  
  /**
   * This method takes a reference to a MegaBlock object and assigns the class
   * variable to it.
   * 
   * @param block - the reference of the block to set the instance variable to
   */
  public void setBlock(MegaBlock block) {
    this.block = block;
  }
  
  /**
   * This method returns a reference to the instance variable next.
   * 
   * @return - reference to instance vairable next
   */
  public LinkedMegaBlock getNext() {
    return next;
  }
  
  /**
   * This method takes a reference to a LinkedMegaBlock object and assigns the
   * class variable next to it.
   * 
   * @param next - the reference of the LinkedMegaBlock to set the instance
   * varaible 
   */
  public void setNext(LinkedMegaBlock next) {
    this.next = next;
  }
  
  /** 
   * This method returns a string with the toString of the block with an arrow
   * at the end if the next value is not null. Otherwise it returns it with an
   * arrow and the word END at the end.
   * 
   * @return - the object block to a string with proper formatting
   */
  @Override
  public String toString() {
    if(next==null) {
      return block.toString()+" -> END";
    }
    else {
      return block.toString()+" -> ";
    }
  }
}
