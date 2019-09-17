
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: AsciiArt
// Files: Canvas.java
// Course: CS 300, Fall 2018
//
// Author: Niharika Tomar
// Email: ntomar@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Archana Dhyani
// Partner Email: adhyani@wisc.edu
// Partner Lecturer's Name: Gary Dahl
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// __x__ Write-up states that pair programming is allowed for this assignment.
// __x_ We have both read and understand the course Pair Programming Policy.
// __x_ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 100 COLUMNS WIDE ///////////////////////////////

/**
 * It initialises a canvas board and draws out the characters at the specified locations and has the
 * ability to undo and redo the changes based on user input
 *
 * @author niharikatomar, archanadhyani
 */
public class Canvas {

  private final int width; // width of the canvas
  private final int height; // height of the canvas

  private char[][] drawingArray; // 2D character array to store the drawing

  private final DrawingStack undoStack; // store previous changes for undo
  private final DrawingStack redoStack; // store undone changes for redo

  public Canvas(int width, int height) { // Constructor. Throws IllegalArgumentException
    // if width or height is 0 or negative
    this.width = width;
    this.height = height;
    drawingArray = new char[height][width];
    if (width <= 0 || height <= 0) { // throwing IllegalArgumentException() if
      throw new IllegalArgumentException();
    }
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        drawingArray[i][j] = ' '; // A Canvas is initially blank (use the space ' ' character)
      }
    }
    undoStack = new DrawingStack(); // initialising undoStack
    redoStack = new DrawingStack(); // initialising redoStack
  }

  /**
   * Draw a character at the given position This method should throw an IllegalArgumentException if
   * the drawing position is outside the canvas. If that position is already marked with a different
   * character, overwrite it. After making a new change, add a matching DrawingChange to the
   * undoStack so that we can undo if needed. After making a new change, the redoStack should be
   * empty.
   *
   * @param row is the row
   * @param col is the column
   * @param c is the character
   */
  public void draw(int row, int col, char c) {
    if (row > width - 1 && col > height - 1) {
      throw new IllegalArgumentException();
    }
    DrawingChange change = new DrawingChange(row, col, drawingArray[col][row], c);
    drawingArray[row][col] = c;
    undoStack.push(change);
  }

  /**
   * Undo the most recent drawing change. Return true if successful. False otherwise. An undone
   * DrawingChange should be added to the redoStack so that we can redo if needed.
   *
   * @return boolean true if correct implementation
   */
  public boolean undo() {
    if (undoStack.isEmpty()) {
      return false;
    } else {
      redoStack.push(undoStack.pop());
      drawingArray[redoStack.peek().x][redoStack.peek().y] = redoStack.peek().prevChar;
      return true;
    }
  }

  /**
   * Redo the most recent undone drawing change. Return true if successful. False otherwise. A
   * redone DrawingChange should be added (back) to the undoStack so that we can undo again if
   * needed.
   *
   * @return boolean true if correct implementation
   */
  public boolean redo() {
    if (redoStack.isEmpty()) {
      return false;
    } else {
      DrawingChange change = redoStack.pop();
      drawingArray[change.y][change.x] = change.newChar;
      undoStack.push(change);
      return true;
    }
  }

  /**
   * Return a printable string version of the Canvas
   */
  @Override
  public String toString() {
    String string = "";
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        if (drawingArray[i][j] == ' ') {
          string += "_";
        } else {
          string += drawingArray[i][j];
        }
      }
      string += System.lineSeparator(); // adding line separator
    }
    return string;
  }
  /*
   * Format example: [_ is blank. Use System.lineSeparator() to put a newline character between
   * rows] X___X _X_X_ __X__ _X_X_ X___X
   */
}
