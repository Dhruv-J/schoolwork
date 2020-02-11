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
import java.util.ArrayList;
import processing.core.PApplet;

/**
 * This is the TrainglePen class for the Kaleidoscope program
 * 
 * @author jain, sharma
 */

public class TrianglePen {
  private boolean mouseWasPressed = false; // mousePressed from previous update() call
  private char keyWasPressed = '\0'; // keyPressed from previous update() call
  private PApplet processing;
  private boolean showPoints;
  private ArrayList<Point> ptArr;
  private ArrayList<Triangle> triArr;
  private Point drg;
  private int cnt = 1;

  /*
   * creates a TrianglePen object to draw triangles
   * 
   * @param the PApplet object that references the graphic display window
   * 
   * @param whether the points are being shown or not
   */
  public TrianglePen(PApplet processing, boolean showPoints) {
    this.processing = processing;
    this.showPoints = showPoints;
    ptArr = new ArrayList<Point>();
    triArr = new ArrayList<Triangle>();
    drg = null;
  }

  /*
   * method updates the drawing space based on mouse and key input
   * 
   * @param mouseX position
   * 
   * @param mouseY position
   * 
   * @param whether mouse was pressed or not
   * 
   * @param key that the use pressed (between 0-9)
   */
  public void update(int mouseX, int mouseY, boolean mousePressed, char keyPressed) {
    // process mouse-based user input
    if (mousePressed != mouseWasPressed) {
      if (mousePressed)
        handleMousePress(mouseX, mouseY);
      else
        handleMouseRelease(mouseX, mouseY);
    }
    if (mousePressed)
      handleMouseDrag(mouseX, mouseY);
    mouseWasPressed = mousePressed;
    // process keyboard-based user input
    if (keyPressed != keyWasPressed)
      handleKeyPress(mouseX, mouseY, keyPressed);
    keyWasPressed = keyPressed;
    // draw everything in its current state
    draw();
  }

  /*
   * method nullifies drag if the mouse has been released
   * 
   * @param x position of mouse
   * 
   * @param y position of mouse
   */
  public void handleMouseRelease(int x, int y) {
    drg = null;
  }

  /*
   * allows user to drag points when the mouse is pressed over a point
   * 
   * @param x position of the mouse
   * 
   * @param y position of the mouse
   * 
   */
  public void handleMouseDrag(int x, int y) {
    if (drg != null)
      drg.setPosition(x, y);
  }

  /*
   * method handles key presses from user
   * 
   * @param x position of the mouse
   * 
   * @param y position of the mouse
   * 
   * @param key input from user
   */
  public void handleKeyPress(int x, int y, char key) {
    if (key - '0' >= 0 && key - '0' <= 7) {
      for (Triangle t : triArr) {
        if (t.isOver(x, y)) {
          t.setColor(key - '0');
        }
      }
    }
  }

  /*
   * method handles mouse based user input. Adds points and triangles to their respective arrays
   * 
   * @param x position of the mouse
   * 
   * @param y position of the mouse
   */
  public void handleMousePress(int x, int y) {
    for (Point p : ptArr) {
      if (p.isOver(x, y)) {
        drg = p;
        return;
      }
    }
    if ((ptArr.size() + 1) % 3 == 0) {
      ptArr.add(new Point(x, y));
      triArr.add(new Triangle(ptArr.get(ptArr.size() - 3), ptArr.get(ptArr.size() - 2),
          ptArr.get(ptArr.size() - 1), -1));
    } else {
      ptArr.add(new Point(x, y));
    }
  }

  /*
   * method draws all elements in their current states
   */
  public void draw() {
    if (showPoints) {
      for (Point p : ptArr) {
        p.draw(processing);
      }
    }
    for (Triangle t : triArr) {
      t.draw(processing);
    }
  }


}
