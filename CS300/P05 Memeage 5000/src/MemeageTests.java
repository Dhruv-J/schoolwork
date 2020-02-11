//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           MemeageTest - for testing all classes
// Files:           FourBytes.java, Color.java, ColorPlusChar.java, Image,java, Memeage.java
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

import java.io.File;
import java.io.IOException;

/**
 * @author Dhruv Jain
 * This class tests methods and constructors from the Color, ColorPlusChar and
 * Memeage classes.
 */
public class MemeageTests {
  /**
   * @param args - of type String[]
   * Prints the results of all the tests.
   */
  public static void main(String[] args) {
    System.out.println(testFourBytesGetBits());
    System.out.println(testFourBytesSetBits());
    System.out.println(testColor());
    System.out.println(testImage());
    System.out.println(testColorPlusChar());
    System.out.println(testMemeage());
  }
  
  /**
   * @return true if the FourBytes constructor and setBits method is working properly
   */
  public static boolean testFourBytesGetBits() {
    FourBytes f = new FourBytes(0);
    f.setBits(3, 8, 13);
    return f.getInt()==1280;
  }
  /**
   * Condition 1: FourBytes constructor works with a valid argument
   * Condition 2: the setBytes method works properly
   * 
   * @return true if all conditions are met
   */
  public static boolean testFourBytesSetBits() {
    FourBytes f = new FourBytes(13);
    f.setBits(3, 8, 13);
    int val = f.getBits(3, 8);
    return val==5;
  }
  
  /**
   * Condition 1: Color constructor works with a valid argument
   * Condition 2: the binary string of a color value is assigned/processed correctly
   * Condition 3: setting alpha to 15 correctly modifies the binary string of value
   * Condition 4: getting blue correctly returns 12 as the integer for blue
   * 
   * @return true if all conditions are met
   */
  public static boolean testColor() {
    boolean bool1, bool2, bool3;
    Color c = new Color(220005644);
    bool1 = Integer.toBinaryString(c.getInt()).equals("1101000111010000010100001100");
    c.setAlpha(15);
    bool2 = Integer.toBinaryString(c.getInt()).equals("1111000111010000010100001100");
    bool3 = c.getBlue()==12;
    return bool1&&bool2&&bool3;
  }
  
  /**
   * Condition 1: Image constructor works with a valid argument
   * Condition 2: the height and the width of the test image should be 3
   * Condition 3: the green and red values should be 255 and blue should be 0 for the middle
   * 
   * @return true if all conditions are met
   */
  public static boolean testImage() {
    boolean bool1 = false, bool2 = false;
    try {
      Image img = new Image(new File("images"+File.separator+"testImage.png"));
      bool1 = img.getHeight()==3&&img.getWidth()==3;
      Color temp = img.getColor(1, 1);
      bool2 = temp.getBlue()==255&&temp.getGreen()==255&&temp.getRed()==0;
    }
    catch(IOException e) {
      System.out.println(e.getMessage());
    }
    return bool1&&bool2;
  }
  
  /**
   * Condition 1: ColorPlusChar constructor must work properly with valid argument
   * Condition 2: revealChar should reveal 'T'
   * Condition 3: hideChar with 'E' should hide 'E"
   * 
   * @return true if all conditions are met
   */
  public static boolean testColorPlusChar() {
    boolean bool1 = false, bool2 = false;
    Color c = new Color(220005644);
    ColorPlusChar cpc = new ColorPlusChar(c);
    bool1 = cpc.revealChar()=='T';
    cpc.hideChar('E');
    bool2 = cpc.revealChar()=='E';
    return bool1&&bool2;
  }
  
  /**
   * Condition 1: The Memeage constructor works when given proper input.
   * Condition 2: The hidden message is properly extracted from the first image.
   * Condition 3: The hidden message is properly extracted from the second image.
   * Condition 4: The hidden message is properly extracted from the third image.
   * Condition 5: A new valid hidden message is set for the third image, and is 
   *              then properly extracted.
   *              
   * @return true if all conditions are met
   */
  public static boolean testMemeage() {
    boolean bool1 = false, bool2 = false, bool3 = false, bool4 = false;
    try {
      File f1 = new File("images"+File.separator+"image01.png");
      File f2 = new File("images"+File.separator+"image02.png");
      File f3 = new File("images"+File.separator+"image03.png");
      Memeage memer = new Memeage(f1);
      bool1 = memer.getMeme().equals("Clever code blinds, whereas clear code reveals.");
      memer = new Memeage(f2);
      bool2 = memer.getMeme().equals("A language that doesn't affect the way you think about programming is not worth knowing. - Alan Perlis");
      memer = new Memeage(f3);
      bool3 = memer.getMeme().equals("From then on, when anything went wrong with a computer, we said it had bugs in it. - Grace Hopper");
      String newStr = "Brom bhen bon, bhen banything bent brong bith a bomputer, be baid bit bad bugs bin bit. - Brace Bopper";
      memer = new Memeage(f3, newStr);
      bool4 = memer.getMeme().equals(newStr);
    }
    catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return bool1&&bool2&&bool3&&bool4;
  }
}
