//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Kaleidoscope Program
// Files: DriverApplication.java, Point.java, Triangle.java, TrianglePen.java, Kaleidoscope.java
// Course: CS 300, Fall, 2019
//
// Author: Dhruv Jain
// Email: djain22@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Prafull Sharma
// Partner Email: psharma49@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// X Write-up states that pair programming is allowed for this assignment.
// X We have both read and understand the course Pair Programming Policy.
// X We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: NONE
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import processing.core.PApplet;
import java.util.*;

/**
 * This is the TrainglePen class for the Kaleidoscope program
 * 
 * @author jain, sharma
 */

public class KaleidoscopePen {
  private ArrayList<TrianglePen> triPenArr;
  private int numTP;

  /*
   * creates a kaleidoscope pen to create the kaleidoscope using the triangles
   * 
   * @param the PApplet object that references the graphic display window
   * 
   * @param the number of triangle pens used to create the triangles to be used for the kaleidoscope
   * 
   */
  public KaleidoscopePen(PApplet drawTo, int numberOfTrianglePens) {
    this.numTP = numberOfTrianglePens;
    triPenArr = new ArrayList<TrianglePen>(numberOfTrianglePens);
    triPenArr.add(new TrianglePen(drawTo, true));
    for (int i = 1; i < numberOfTrianglePens; i++) {
      triPenArr.add(new TrianglePen(drawTo, false));
    }
  }

  /*
   * method updates the drawing space by creating the kaleidoscope based on mouse and key input
   * 
   * @param the x position of the mouse
   * 
   * @param the y position of the mouse
   *
   * @param whether the mouse has been pressed or not
   * 
   * @param what key has been pressed (between 0-9)
   */

  public void update(int mouseX, int mouseY, boolean mousePressed, char keyPressed) {
    for (int i = 0; i < triPenArr.size(); i++) {
      double angle = (double) (i * 2 * Math.PI / numTP);
      int[] temp = rotate(mouseX, mouseY, angle);
      triPenArr.get(i).update(temp[0], temp[1], mousePressed, keyPressed);
    }
  }

  /**
   * Rotates a position around the center of an 800x600 screen by the specified amount, and then
   * returns an array containing the resulting position.
   * 
   * @param x position of the point to be rotated (0 to 800 pixels)
   * @param y position of the point to be rotated (0 to 600 pixels)
   * @param angle amount of rotation to apply (angle in radians units: 0 to 2*PI)
   * @return the rotated position array: x @ index 0, y @ index 1
   */
  private static int[] rotate(int x, int y, double angle) {
    x -= 400; // translate center of screen to origin (0,0)
    y -= 300;
    int[] rotatedPosition = new int[] { // rotate around origin
        (int) (x * Math.cos(angle) - y * Math.sin(angle)),
        (int) (x * Math.sin(angle) + y * Math.cos(angle))};
    rotatedPosition[0] += 400; // return to center of screen
    rotatedPosition[1] += 300;
    return rotatedPosition;
  }

}
