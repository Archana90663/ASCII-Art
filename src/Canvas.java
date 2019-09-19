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
