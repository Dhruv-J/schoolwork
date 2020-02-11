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

/**
 * This is the Point class for the Kaleidoscope program
 * 
 * @author jain, sharma
 */
public class Point {
  private static final int POINT_DIAMETER = 8;
  private int x;
  private int y;

  /*
   * constructs a Point object with two private instance fields, one for the x coordinate and the
   * other for the y coordinate
   * 
   * @param integers for the x and y coordinates of the point
   */
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /*
   * This method repeatedly updates the display, for as long as this program is running. Method
   * draws a circle at this points position
   * 
   * @param drawTo the PApplet object that references the graphic display window
   */
  public void draw(PApplet drawTo) {
    drawTo.circle(x, y, POINT_DIAMETER);
  }

  /*
   * Detects whether the position x and y is inside of the point in question
   * 
   * @return true or false if the position x and y is inside of the circle drawn to represent the
   * point, or not respectively
   */
  public boolean isOver(int x, int y) {
    return (Math.sqrt(
        (double) Math.pow(x - getX(), 2) + (double) Math.pow(y - getY(), 2)) < POINT_DIAMETER);
  }

  /*
   * Accessor method for the x position of the Point in question
   * 
   * @return the int value of the x position of the Point in question
   */
  public int getX() {
    return x;
  }

  /*
   * Accessor method for the y position of the Point in question
   * 
   * @return the int value of the y position of the Point in question
   */
  public int getY() {
    return y;
  }

  /*
   * method sets the x and y position of the Point in question
   * 
   * @param new x coordinate for new Point
   * 
   * @param new y coordinate for new Point
   */
  public void setPosition(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
