//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Matching Game
// Files: CS300MatchingGame.jar
// Course: CS 300 Fall 2019
//
// Author: Dhruv Jain
// Email: djain22@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Prafull Sharma
// Partner Email: psharma49@wisc.edu
// Partner Lecturer's Name: Mouna
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
// Online Sources: Zybooks
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.io.File;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;

public class MatchingGame {
  // Congratulations message
  private final static String CONGRA_MSG = "CONGRATULATIONS! YOU WON!";
  // Cards not matched message
  private final static String NOT_MATCHED = "CARDS NOT MATCHED. Try again!";
  // Cards matched message
  private final static String MATCHED = "CARDS MATCHED! Good Job!";
  // 2D-array which stores cards coordinates on the window display
  private final static float[][] CARDS_COORDINATES =
      new float[][] {{170, 170}, {324, 170}, {478, 170}, {632, 170}, {170, 324}, {324, 324},
          {478, 324}, {632, 324}, {170, 478}, {324, 478}, {478, 478}, {632, 478}};
  // Array that stores the card images filenames
  private final static String[] CARD_IMAGES_NAMES = new String[] {"apple.png", "ball.png",
      "peach.png", "redFlower.png", "shark.png", "yellowFlower.png"};

  private static PApplet processing; // PApplet object that represent the graphic display window
  private static Card[] cards; // one dimensional array of cards
  private static PImage[] images; // array of images of the different cards
  private static Random randGen; // generator of random numbers
  private static Card selectedCard1; // First selected card
  private static Card selectedCard2; // Second selected card
  private static boolean winner; // boolean evaluated true if the game is won, and false otherwise
  private static int matchedCardsCount; // number of cards matched so far in one session of the game
  private static String message; // Displayed message to the display window
  /*
   * Populates the images array for all the image cards. Populates array "images" using the string
   * elements from the "CARD_IMAGES_NAMES" array in order to reference all the needed images for the
   * game using the "images.zip" compressed folder
   * 
   * @param the PApplet object that references the graphic display window
   */

  public static void setup(PApplet processing) {
    MatchingGame.processing = processing;
    images = new PImage[CARD_IMAGES_NAMES.length];
    for (int i = 0; i < CARD_IMAGES_NAMES.length; i++) {
      images[i] =
          MatchingGame.processing.loadImage("images" + File.separator + CARD_IMAGES_NAMES[i]);
    }
    // Draw an image of an apple at the center of the screen
    // processing.image(images[0], processing.width / 2, processing.height / 2);
    // width [resp. height]: System variable of the processing library
    // that stores the width [resp. height] of the display window.
    initGame();
  }

  /**
   * Method initializes the game for the player. Uses variables selectedCard1 and selectedCard2 to
   * keep track of what cards the player has currently selected. Uses these cards to keep track of
   * how many cards the player has successfully matched, incrementing matchedCardsCount and displays
   * the appropriate message depending on whether the player succesfully matched all the cars or
   * not.
   *
   */
  public static void initGame() {
    int len = CARD_IMAGES_NAMES.length;
    randGen = new Random(Utility.getSeed());
    selectedCard1 = null;
    selectedCard2 = null;
    matchedCardsCount = 0;
    winner = false;
    message = "";

    cards = new Card[len * 2];
    int[] checked = new int[len * 2];

    for (int i = 0; i < len * 2; i++) {
      for (int j = 0; j < i; j++) {
        if (checked[i] == checked[j]) {
          checked[i] = randGen.nextInt(len * 2);
          j = -1;
        }
      }
      cards[i] = new Card(images[(int) i / 2], CARDS_COORDINATES[checked[i]][0],
          CARDS_COORDINATES[checked[i]][1]);
      // cards[i].setVisible(true);
    }
  }

  /*
   * Method checks if user has pressed the "n" key, whether it be upper case or lower case. If "n"
   * is indeed pressed, game is re-initialized
   */
  public static void keyPressed() {
    if (processing.key == 'n' || processing.key == 'N') {
      initGame();
    }
  }

  /**
   * Mathod creates the actual gameboard players use using the cards array and populating the
   * gameboard using elements from said array If the player wins by matching all the cards to each
   * other, the congratulations message stored in CONGRA_MSG is displayed.
   */
  public static void draw() {
    processing.background(245, 255, 250);
    for (int i = 0; i < cards.length; i++)
      cards[i].draw();
    displayMessage(message);
    if (matchedCardsCount == cards.length)
      winner = true;
    if (winner == true)
      message = CONGRA_MSG;

  }

  /*
   * If the mouse is pressed over a card that is laying down on the game surface then the card must
   * be turned over and displayed as "selected". This is what the isMouseOver mehtod does
   * 
   * @param the card in question that is selected by the mouse. Uses the height and width fields of
   * the card as the field to determine whether the card is selected
   * 
   * @return true if the mouse is over the image of the card object which is passed as a reference
   * to the method, or false otherwise
   */
  public static boolean isMouseOver(Card card) {
    if (processing.mouseX > (card.getX() - (card.getWidth() / 2))
        && processing.mouseX < (card.getX() + (card.getWidth() / 2))) {
      if (processing.mouseY > (card.getY() - (card.getHeight() / 2))
          && processing.mouseY < (card.getY() + (card.getHeight() / 2))) {
        return true;
      }
    }
    return false;
  }

  /*
   * In the mousePressed method, check if the mouse is over a card. If this is the case, make the
   * card visible using the setVisible(); method, passing either true or false. If the two cards
   * match, keep them flipped over.
   */
  public static void mousePressed() {
    if (message == NOT_MATCHED || message == MATCHED) {
      if (message == NOT_MATCHED) {
        selectedCard2.setVisible(false);
        selectedCard1.setVisible(false);
      }
      if (selectedCard1 != null)
        selectedCard1.deselect();
      if (selectedCard2 != null)
        selectedCard2.deselect();
      if (selectedCard1 != null)
        selectedCard1 = null;
      if (selectedCard2 != null)
        selectedCard2 = null;
    }

    if (!winner) {
      for (int i = 0; i < cards.length; i++) {
        if (isMouseOver(cards[i])) {
          if (cards[i].isVisible() == false) {
            cards[i].setVisible(true);
            cards[i].select();
            if (selectedCard1 == null) {
              selectedCard1 = cards[i];
              message = "";
            } else {
              if (matchingCards(selectedCard1, cards[i])) {
                matchedCardsCount += 2;
                message = MATCHED;
                selectedCard2 = cards[i];
              } else {
                message = NOT_MATCHED;
                selectedCard2 = cards[i];
              }
            }
          }
        }
      }
    }
  }

  /*
   * @param cards to check whether they are matching or not
   * 
   * @return the result of comparing the images between the two cards in question (false if they do
   * not match, true if they do)
   */
  public static boolean matchingCards(Card card1, Card card2) {
    return card1.getImage() == card2.getImage();
  }

  /*
   * Method draws the class variable "message" to the application
   * 
   * @param message is the message to be displayed
   */
  public static void displayMessage(String message) {
    processing.fill(0);
    processing.textSize(20);
    processing.text(message, processing.width / 2, 50);
    processing.textSize(12);
  }
  /*
   * @param args runs application
   */

  public static void main(String args[]) {
    Utility.runApplication();
  }
}
