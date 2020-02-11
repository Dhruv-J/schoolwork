//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           SongCollection - This class emulates a doubly linked list.
// Files:           Song.java, DoublyLinkedNode.java, Playlist.java, ReversePlaylist.java
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
 * This class is used for implementing a doubly linked list. It has a head, tail,
 * and play direction to determine how to play the playlist. The class implements
 * the Iterable interface for type Song.
 */
public class SongCollection implements Iterable<Song> {
  private DoublyLinkedNode<Song> head;
  private DoublyLinkedNode<Song> tail;
  private boolean playDirectionForward;
  
  /**
   * This constructor initializes the instance variables head and tail to null,
   * and playDirectionForward to true;
   */
  public SongCollection() {
    head = null;
    tail = null;
    playDirectionForward = true;
  }
  
  /**
   * This constructor takes a reference to a Song object as a parameter and adds it
   * to the end of the linked list. It throws a NullPointerException if the
   * song is null.
   * 
   * @param song - reference to object of type Song to add to the end of the list
   * @throws NullPointerException - if song is null
   */
  public void add(Song song) {
    if(song==null) {
      throw new NullPointerException("Song is null.");
    }
    DoublyLinkedNode<Song> tempSong = new DoublyLinkedNode<Song>(song);
    if(head==null&&tail==null) {
      head = tempSong;
      tail = tempSong;
      tempSong.setPrevious(null);
      tempSong.setNext(null);
    }
    else if(head==tail) {
      tempSong.setPrevious(head);
      tempSong.setNext(null);
      head.setNext(tempSong);
      tail = tempSong;
    }
    else {
      DoublyLinkedNode<Song> copyTail = tail;
      tail.setNext(tempSong);
      tail = tempSong;
      tail.setPrevious(copyTail);
      tail.setNext(null);
    }
  }
  
  /**
   * This method removes the song at the head of the list. If the list is empty,
   * when head or tail are null, the method throws a NoSuchElementException. It
   * returns a reference to the song that was previously at the head of the list.
   * 
   * @return - a reference to the song that was removed
   * @throws NoSuchElementException - if the head or tail is null
   */
  public Song remove() {
    if(head==null||tail==null) {
      throw new NoSuchElementException("List has no elements.");
    }
    DoublyLinkedNode<Song> tempSong = head;
    if(head==tail) {
      head = null;
      tail = null;
      return tempSong.getData();
    }
    else {
      head = head.getNext();
      head.setPrevious(null);
      return tempSong.getData();
    }
  }
  
  /**
   * This method takes a boolean as a parameter and sets the class instance
   * variable playDirectionForward to it.
   * 
   * @param isForward - to set instance variable isForward to
   */
  public void setPlayDirection(boolean isForward) {
    playDirectionForward = isForward;
  }
  
  /**
   * This method returns either a reference to a Playlist or ReversePlaylist
   * object. This decision is based on the value of playDirectionForward.
   * 
   * @return - the type of Iterator that will iterate through this playlist
   */
  @Override
  public Iterator<Song> iterator() {
    if(playDirectionForward) {
      return new Playlist(this.head);
    }
    return new ReversePlaylist(this.tail);
  }
}

///////////////////////////////////////////////////////////////////////////////////
//For each of the following big-O time complexity analyses, consider the problem
//size to be the number of Songs that are stored within the argument songs, when
//the method is first called.
//
//For analysisMethodA, the big-O time complexity is _O(1)__________.
//
//For analysisMethodB, the big-O time complexity is _O(N)__________.
//
//For analysisMethodC, the big-O time complexity is _O(1)__________.
//
///////////////////////////////////////////////////////////////////////////////////