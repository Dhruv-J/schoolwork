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
 * This is the Traingle class for the Kaleidoscope program
 * 
 * @author jain, sharma
 */

public class Triangle {
  private Point ptA;
  private Point ptB;
  private Point ptC;
  private int color;
  private static final int[] COLORS = new int[] { // int packed w/8 bits of ARGB
      // WHITE, RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
      -1, -766643, -752563, -723891, -11668348, -11696908, -8106508, -766476};

  /*
   * constructs a Triangle object with 4 private instance fields
   * 
   * @param the 3 points of the triangle. The last is for the color index used for each triangle
   * made
   * 
   * 
   */
  public Triangle(Point a, Point b, Point c, int color) {
    ptA = a;
    ptB = b;
    ptC = c;
    this.color = color;
  }

  /*
   * method sets the color of the triangle in question
   * 
   * @param color that the triangle is being set to
   */

  public void setColor(int color) {
    this.color = COLORS[color];
  }

  /*
   * method draws fills and draws the triangle
   * 
   * @param processing the PApplet object that references the graphic display window
   */
  public void draw(PApplet processing) {
    processing.fill(color);
    processing.triangle(ptA.getX(), ptA.getY(), ptB.getX(), ptB.getY(), ptC.getX(), ptC.getY());
  }

  /*
   * method detects whether the position x and y is over the triangle drawn with the three points or
   * not
   * 
   * @param x coordinate of position
   * 
   * @param y coordinate of position
   * 
   * @return true if the x and y are within the field of the triangle or false if not
   */
  public boolean isOver(int x, int y) {
    return isPointInTriangle(x, y, ptA.getX(), ptA.getY(), ptB.getX(), ptB.getY(), ptC.getX(),
        ptC.getY());
  }

  /*
   * method checks whether a point is within a triangle
   * 
   * @param px and py is the point to test,
   * 
   * @param (t1x,t1y) point 1 of the triangle to test point against
   * 
   * @param (t2x,t2y) point 2 of the triangle to test point against
   * 
   * @param (t3x,t3y) point 3 of the triangle to test point against
   */
  private static boolean isPointInTriangle(int px, int py, int t1x, int t1y, int t2x, int t2y,
      int t3x, int t3y) {
    px -= t1x; // don't worry about this arithmetic
    py -= t1y;
    t2x -= t1x;
    t2y -= t1y;
    t3x -= t1x;
    t3y -= t1y;
    double dotp2 = px * t2x + py * t2y;
    double dotp3 = px * t3x + py * t3y;
    double dot22 = t2x * t2x + t2y * t2y;
    double dot23 = t2x * t3x + t2y * t3y;
    double dot33 = t3x * t3x + t3y * t3y;
    double invDen = 1 / (dot33 * dot22 - dot23 * dot23);
    double a = (dot22 * dotp3 - dot23 * dotp2) * invDen;
    double b = (dot33 * dotp2 - dot23 * dotp3) * invDen;
    return (a >= 0) && (b >= 0) && (a + b < 1);
  }

}
