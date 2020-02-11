//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Memeage - for reading and storing messages in an image
// Files:           Image.java
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
 * This class sets messages into images, and gets messages from images.
 */
public class Memeage extends Image{
  /**
   * @param file - the file reference of the image to set
   * @throws IOException - if the file does not exist
   */
  public Memeage(File file) throws IOException {
    super(file);
  }
  
  /**
   * @param file - the file reference of the image to set
   * @param meme - the string to hide within the image
   * @throws IOException - if the file does not exist
   * @throws IllegalArgumentException - if the setMeme() method throws an 
   *                                    IllegalArgumentException
   */
  public Memeage(File file, String meme) throws IOException, IllegalArgumentException {
    super(file);
    setMeme(meme);
  }
  
  /**
   * @param meme - the string to set as a hidden message in the picture
   * @throws IllegalArgumentException - if the length of meme is larger than
   *                                    the picture size or if the character
   *                                    ASCII value is greater than 127
   */
  public void setMeme(String meme) throws IllegalArgumentException {
    if(meme.length()>getWidth()*getHeight()-1) {
      throw new IllegalArgumentException("The number of characters in the "
          + "string is more than the image width and height.");
    }
    for(int i=0; i<getHeight(); i++) {
      for(int j=0; j<getWidth(); j++) {
        if(getWidth()*i+j>=meme.length()) {
          setColor(j, i, new ColorPlusChar(getColor(j, i), '\0'));
          return;
        }
        if((int)meme.charAt(getWidth()*i+j)>127) {
          throw new IllegalArgumentException("The character ASCII value is "
              + "greater than 127.");
        }
        setColor(j, i, new ColorPlusChar(getColor(j, i), meme.charAt(getWidth()*i+j)));
      }
    }
  }
  
  /**
   * @return - the string hidden in a picture
   * @throws IllegalStateException - if the character ASCII value is greater
   *                                 than 127
   */
  public String getMeme() throws IllegalStateException {
    String val = "";
    for(int i=0; i<getHeight(); i++) {
      for(int j=0; j<getWidth(); j++) {
        ColorPlusChar cpc = new ColorPlusChar(getColor(j,i));
        if((int)cpc.revealChar()>127) {
          throw new IllegalStateException("The character ASCII value is greater"
              + " than 127.");
        }
        if(cpc.revealChar()=='\0') {
          return val;
        }
        val = val.concat(""+cpc.revealChar());
      }
    }
    throw new IllegalStateException("Last character not \0.");
  }
}
