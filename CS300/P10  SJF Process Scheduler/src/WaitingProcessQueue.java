/////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           WaitingProcessQueue - this class emulates a priority queue
// Files:           CustomProcess.java, WaitingQueueADT
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

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * @author Dhruv Jain
 * 
 * This class makes a priority queue using a heap of CustomProcess objects. It
 * uses the help of several instance variables and methods to carry out this
 * implementation.
 *
 */
public class WaitingProcessQueue implements WaitingQueueADT<CustomProcess>{
  private static final int INITIAL_CAPACITY = 2; // the initial capacity of this
                                                  // waiting process queue
  private CustomProcess[] data; // min heap-array storing the CustomProcesses
                                // inserted in this WaitingProcessQueue.
                                // data is an oversize array
  private int size; // number of CustomProcesses stored in this WaitingProcessQueue
  
  /**
   * This default constructor initializes the array to have initial capacity as
   * described by the instance variable INITIAL_CAPACITY. It also initializes
   * size to be zero.
   */
  public WaitingProcessQueue() {
    data = new CustomProcess[INITIAL_CAPACITY];
    size = 0;
  }
  
  /**
   * This method inserts a newObject in this waiting queue.
   * 
   * @param newObject - to insert in this waiting queue
   */
  @Override
  public void insert(CustomProcess newObject) {
    // TODO Auto-generated method stub
    if(size==data.length-1) {
      CustomProcess[] temp = new CustomProcess[data.length*2];
      for(int i=0; i<size; i++) {
        temp[i] = data[i];
      }
      data = temp;
    }
    
    data[size] = newObject;
    minHeapPercolateUp(size);
    size++;
  }

  /**
   * This method removes and returns the element with the highest priority.
   * 
   * @return - the removed element
   * @throws java.util.NoSuchElementException - if the waiting queue is empty
   */
  @Override
  public CustomProcess removeBest() {
    if(size==0) {
      throw new NoSuchElementException("Waiting queue is empty.");
    }
    CustomProcess origInd = data[0];
    minHeapPercolateDown(0);
    size -= 1;
    return origInd;
  }

  /**
   * This method returns without removing the element with the highest priority.
   * 
   * @return - the element with the highest priority
   * @throws java.util.NoSuchElementException - if the waiting queue is empty
   */
  @Override
  public CustomProcess peekBest() {
    if(size==0) {
      throw new NoSuchElementException("Waiting queue is empty.");
    }
    return data[0];
  }

  /**
   * This method is an accessor method for the instance variable size.
   * 
   * @return - instance variable size
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * This method checks if the queue is empty by checking if the size is zero.
   * 
   * @return - true if the size is zero
   */
  @Override
  public boolean isEmpty() {
    return size==0;
  }

  /**
   * This method percolates a value up from the bottom of the heap to its correct position.
   * 
   * @param index - index to start percolating up at
   */
  private void minHeapPercolateUp(int index) {
    int child = index;
    int parent = (child-1)/2;
    while(parent>=0 && data[child].compareTo(data[parent])<0) {
      CustomProcess temp = data[parent];
      data[parent] = data[child];
      data[child] = temp;
      child = parent;
      parent = (child-1)/2;
    }
  }
  
  /**
   * This method percolates a value down from the top of the heap to its correct position.
   * 
   * @param index - index to start percolating down at
   */
  private void minHeapPercolateDown(int index) {
    CustomProcess fin = data[size-1];
    int child=0;
    while(true) {
      int left=2*index+1, right=2*index+2;
      
      if(left>=size) {
        break;
      }
      
      if(left==size-1) {
        child = left;
      }
      else if(data[left].compareTo(data[right])<0) {
        child = left;
      }
      else {
        child = right;
      }
      
      if(fin.compareTo(data[child])<0) {
        break;
      }
      else {
        data[index] = data[child];
        index = child;
      }
    }
    data[child] = fin;
    data[size-1] = null;
  }
  
}
