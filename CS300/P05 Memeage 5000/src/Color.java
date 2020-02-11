//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Color - for storing a color in a single integer
// Files:           FourBytes.java
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
 * This class exists to store a color as an integer through a binary string. It
 * has many methods that help set the colors in a way that each color's value
 * can be stored at different indexes of the binary string.
 */
public class Color extends FourBytes{
  /**
   * @param argb - the integer to set for alpha, red, blue, and green
   */
  
  public Color(int argb) {
    super(argb);
  }
  /**
   * @param alpha - the integer value to set for alpha
   * @param red - the integer value to set for red
   * @param green - the integer value to set for green
   * @param blue - the integer value to set for green
   */
  
  public Color(int alpha, int red, int green, int blue) {
    super(0);
    int temp = Integer.toBinaryString(blue).length();
    setBits(temp, 0, blue);
    temp = Integer.toBinaryString(green).length();
    setBits(temp, 8, green);
    temp = Integer.toBinaryString(red).length();
    setBits(temp, 16, red);
    temp = Integer.toBinaryString(alpha).length();
    setBits(temp, 24, alpha);
  }
  
  /**
   * @param other - another color reference whose ARGB value is used to create
   * a copy of it.
   */
  public Color(Color other) {
    super(other.getARGB());
  }
  
  /**
   * @return the integer value of alpha and all colors
   */
  public int getARGB() {
    return getInt();
  }
  
  /**
   * @return the integer value of alpha
   */
  public int getAlpha() {
    return getBits(8, 24);
  }
  
  /**
   * @return the integer value of red
   */
  public int getRed() {
    return getBits(8, 16);
  }
  
  /**
   * @return the integer value of green
   */
  public int getGreen() {
    return getBits(8, 8);
  }
  
  /**
   * @return the integer value of blue
   */
  public int getBlue() {
    return getBits(8, 0);
  }
  
  /**
   * @param argb - sets the integer value of alpha and all colors to this value
   */
  public void setARGB(int argb) {
    setInt(argb);
  }
  
  /**
   * @param alpha - sets this value to the 'alpha' portion of value's binary
   *                string
   */
  public void setAlpha(int alpha) {
    setBits(Integer.toBinaryString(alpha).length(), 24, alpha);
  }
  
  /**
   * @param red - sets this value to the 'red' portion of value's binary string
   */
  public void setRed(int red) {
    setBits(Integer.toBinaryString(red).length(), 16, red);
  }
  
  /**
   * @param green - sets this value to the 'green' portion of value's binary
   *                string
   */
  public void setGreen(int green) {
    setBits(Integer.toBinaryString(green).length(), 8, green);
  }
  
  /**
   * @param blue - sets this value to the 'blue' portion of value's binary
   *               string
   */
  public void setBlue(int blue) {
    setBits(Integer.toBinaryString(blue).length(), 0, blue);
  }
}