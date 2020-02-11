//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           ColorPlusChar - for operations color with a character
// Files:           Color,java, FourBytes.java
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
 * This class is for hiding and revealing characters within the last two binary
 * digits within a color/alpha value.
 */
public class ColorPlusChar extends Color{
  /**
   * @param color - reference to a color object to pass to the Color class'
   *                constructor
   * @param character - character to hid within this color
   */
  public ColorPlusChar(Color color, char character) {
    super(color);
    hideChar(character);
  }
  
  /**
   * @param color - reference to a color object to pass to the Color class'
   *                constructor
   */
  public ColorPlusChar(Color color) {
    super(color);
  }
  
  /**
   * @param Character - character to hide in the color by modifying the last
   *                    two digits of the binary string of value
   */
  public void hideChar(char Character) {
    String val = Integer.toBinaryString((int)Character);
    while(val.length()<8) {
      val = "0"+val;
    }
    setBits(2,24, Integer.parseInt(val.substring(0, 2),2));
    setBits(2,16, Integer.parseInt(val.substring(2, 4),2));
    setBits(2,8, Integer.parseInt(val.substring(4, 6),2));
    setBits(2,0, Integer.parseInt(val.substring(6),2));
  }
  
  /**
   * @return the character that is hidden in a certain color
   */
  public char revealChar() {
    String val = "";
    String temp = Integer.toBinaryString(getAlpha());
    if(temp.length()==1) temp="0"+temp;
    temp = temp.substring(temp.length()-2, temp.length());
    val = val.concat(temp);
    
    temp = Integer.toBinaryString(getRed());
    if(temp.length()==1) temp="0"+temp;
    temp = temp.substring(temp.length()-2, temp.length());
    val = val.concat(temp);
    
    temp = Integer.toBinaryString(getGreen());
    if(temp.length()==1) temp="0"+temp;
    temp = temp.substring(temp.length()-2, temp.length());
    val = val.concat(temp);
    
    temp = Integer.toBinaryString(getBlue());
    if(temp.length()==1) temp="0"+temp;
    temp = temp.substring(temp.length()-2, temp.length());
    val = val.concat(temp);
    
    return (char)Integer.parseInt(val, 2);
  }
}
