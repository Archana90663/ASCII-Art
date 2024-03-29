/**
 * This class tests all the methods implemented in DrawingStack
 *
 * @author Archana and Niharika
 *
 */
public class AsciiTest {

  /**
   * Tests whether the method push() works
   *
   * @return true if the latest DrawingChange has the same parameter values as the expected, and
   *         false otherwise
   */
  public static boolean testStackPushPeek() {
    DrawingChange element1 = new DrawingChange(3, 4, 'A', 'B');
    DrawingChange element2 = new DrawingChange(10, 20, 'B', 'C');
    DrawingChange output;
    DrawingStack stack = new DrawingStack();
    boolean isValid = false;
    stack.push(element1);
    stack.push(element2);
    output = stack.peek();
    if (output.x == 10 && output.y == 20 && output.prevChar == 'B' && output.newChar == 'C') {
      isValid = true;
    } else {
      isValid = false;
    }
    if (isValid) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Tests whether the method pop() works
   *
   * @return true if the latest DrawingChange has the same parameter values as the expected, and
   *         false otherwise
   */
  public static boolean testStackPopPeek() {
    DrawingChange element1 = new DrawingChange(3, 4, 'A', 'B');
    DrawingChange element2 = new DrawingChange(10, 20, 'B', 'C');
    DrawingChange output;
    DrawingStack stack = new DrawingStack();
    boolean isValid = false;
    stack.push(element1);
    stack.push(element2);
    stack.pop();
    output = stack.peek();
    if (output.x == 3 && output.y == 4 && output.prevChar == 'A' && output.newChar == 'B') {
      isValid = true;
    } else {
      isValid = false;
    }
    if (isValid) {
      return true;
    } else {
      return false;
    }
  }


  /**
   * Tests whether the method isEmpty()
   *
   * @return true if the size is the same as the expected, and false otherwise
   */
  public static boolean testStackIsEmpty() {
    DrawingChange element1 = new DrawingChange(3, 4, 'A', 'B');
    DrawingChange element2 = new DrawingChange(10, 20, 'B', 'C');
    boolean output;
    DrawingStack stack = new DrawingStack();
    boolean isValid = false;
    stack.push(element1);
    stack.push(element2);
    output = stack.isEmpty();
    if (output == false) {
      isValid = true;
    } else {
      isValid = false;
    }
    if (isValid) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Tests whether the method size() works
   *
   * @return true if the size is the same as the expected, and false otherwise
   */
  public static boolean testStackSize() {
    DrawingChange element1 = new DrawingChange(3, 4, 'A', 'B');
    DrawingChange element2 = new DrawingChange(10, 20, 'B', 'C');
    int output;
    DrawingStack stack = new DrawingStack();
    boolean isValid = false;
    stack.push(element1);
    stack.push(element2);
    stack.pop();
    output = stack.size();
    if (output == 1) {
      isValid = true;
    } else {
      isValid = false;
    }
    if (isValid) {
      return true;
    } else {
      return false;
    }

  }

  /**
   * Tests whether all the test methods work.
   *
   * @return true if all methods return true, false otherwise
   */
  public static boolean runStackTestSuite() {
    boolean stackPushPeekValid = testStackPushPeek();
    boolean stackPopPeekValid = testStackPopPeek();
    boolean stackIsEmptyValid = testStackIsEmpty();
    boolean stackSizeValid = testStackSize();
    boolean isValid1 = false;
    boolean isValid2 = false;
    boolean isValid3 = false;
    boolean isValid4 = false;
    if (stackPushPeekValid) {
      System.out.println("testStackPushPeek PASSED!");
      isValid1 = true;
    } else {
      System.out.println("testStackPushPeek FAILED");
      isValid1 = false;
    }
    if (stackPopPeekValid) {
      System.out.println("testStackPopPeekValid PASSED!");
      isValid2 = true;
    } else {
      System.out.println("testStackPopPeekValid FAILED");
      isValid2 = false;
    }
    if (stackIsEmptyValid) {
      System.out.println("testStackIsEmpty PASSED!");
      isValid3 = true;
    } else {
      System.out.println("testStackIsEmpty FAILED");
      isValid3 = false;
    }
    if (stackSizeValid) {
      System.out.println("testStackSize PASSED!");
      isValid4 = true;
    } else {
      System.out.println("testStackSize FAILED");
      isValid4 = false;
    }

    if (isValid1 == true && isValid2 == true && isValid3 == true && isValid4 == true) {
      System.out.println("runStackTestSuite() PASSED!");
      return true;
    } else {
      System.out.println("runStackTestSuite() FAILED");
      return false;
    }
  }

  public static void main(String[] args) {
    runStackTestSuite();
  }
}
