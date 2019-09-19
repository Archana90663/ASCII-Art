import java.util.Iterator;

/**
 * This class implements StackADT<DrawingChange> to create a stack in which types DrawingChange are
 * stored in
 *
 * @author Archana and Niharika
 *
 */
public class DrawingStack implements StackADT<DrawingChange> {
  Node<DrawingChange> head;

  /**
   * Add an element to this stack
   *
   * @param element an element to be added
   * @throws IllegalArgumentException if the input element is null
   */
  @Override
  public void push(DrawingChange element) throws IllegalArgumentException {
    if (head == null) {
      Node<DrawingChange> node = new Node<DrawingChange>(element, null);
      head = node;
    } else {
      Node<DrawingChange> node = new Node<DrawingChange>(element, head);
      head = node;
    }
  }

  /**
   * Remove the element on the stack top and return it
   *
   * @return the element removed from the stack top
   */
  @Override
  public DrawingChange pop() {
    if (head != null) {
      DrawingChange change = head.getData();
      head = head.getNext();
      return change;
    } else {
      return null;
    }
  }

  /**
   * Get the element on the stack top
   *
   * @return the element on the stack top
   */
  @Override
  public DrawingChange peek() {
    if (head != null) {
      return head.getData();
    } else {
      return null;
    }
  };

  /**
   * Returns true if this stack contains no elements.
   *
   * @return true if this stack contains no elements, otherwise false
   */
  @Override
  public boolean isEmpty() {
    if (head == null) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Get the number of elements in the stack
   *
   * @return the size of the stack
   */
  @Override
  public int size() {
    int count = 0;
    if (head != null) {
      Node<DrawingChange> node;
      node = head;
      while (node != null) {
        count++;
        node = node.getNext();
      }
      return count;
    } else {
      return count;
    }
  }

  /**
   *
   * @return iterator of the stack
   */
  @Override
  public Iterator<DrawingChange> iterator() {
    DrawingStackIterator iterator = new DrawingStackIterator(head);
    return iterator;
  };
}
