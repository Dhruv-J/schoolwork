//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Song - This class stores the basic information about a song.
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
 * This class is for storing the details of a song, specifically the artist and
 * title.
 */
public class Song {
  private String title;
  private String artist;
  
  /**
   * This constructor sets both the class instance variables to the Strings
   * passed in as parameters.
   * 
   * @param title - String to set the instance variable title to
   * @param artist - String to set the instance variable artist to
   */
  public Song(String title, String artist) {
    this.title = title;
    this.artist = artist;
  }
  
  /** 
   * This method returns a string with the title and and the artist separated
   * by a ' by '.
   * 
   * @return - the string in the following format: "title by artist"
   */
  @Override
  public String toString() {
    return(title+" by "+artist);
  }
  
  /**
   * This method returns true if the passed object has the same toString value
   * as this class' and false otherwise.
   * 
   * @param - Object to compare this class' contents to
   * @return - true if the other method's string equals this class' string
   */
  @Override
  public boolean equals(Object other) {
    if(other instanceof Song) {
      if(other.toString().equals(title+" by "+artist)) {
        return true;
      }
      else {
        return false;
      }
    }
    else {
      return false;
    }
  }
}
