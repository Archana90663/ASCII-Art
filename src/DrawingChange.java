/**
 * This class records the details of a single change made to your canvas.
 *
 * @author niharikatomar, archanadhyani
 *
 */
public class DrawingChange {

  public final int x; // x coordinate for a change
  public final int y; // y coordinate for a change
  public final char prevChar; // previous character in the (x,y)
  public final char newChar; // new character in the (x,y)

  /**
   * constructor initialising the fields
   *
   * @param x is set to final int x
   * @param y is set to final int y
   * @param prevChar is set to final char prevChar
   * @param newChar is set to final char newChar
   */
  public DrawingChange(int x, int y, char prevChar, char newChar) {
    this.x = x; // set to final int x
    this.y = y; // set to final int y
    this.prevChar = prevChar; // set to final char prevChar
    this.newChar = newChar; // set to final char newChar
  }
}
