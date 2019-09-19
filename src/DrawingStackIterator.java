import java.util.Iterator;

/**
 * This class implements Iterator<DrawingChange> and is the iterator provided for the stack
 *
 * @author Archana and Niharika
 *
 */
public class DrawingStackIterator implements Iterator<DrawingChange> {
  Node<DrawingChange> current;

  /**
   * This constructor creates an iterator.
   *
   * @param node is of type DrawingChange
   */
  public DrawingStackIterator(Node<DrawingChange> node) {
    current = node;
  }

  /**
   * This method returns the next node
   *
   * @return change which returns the next node and null if it's the last node
   */
  @Override
  public DrawingChange next() {
    if (current != null) {
      DrawingChange change = current.getData();
      current = current.getNext();
      return change;
    } else {
      return null;
    }
  }

  /**
   * This method checks if the current node has a next node
   *
   * @return true if there is a next node and false if otherwise
   */
  @Override
  public boolean hasNext() {
    if (current != null) {
      return true;
    } else {
      return false;
    }
  }
}
