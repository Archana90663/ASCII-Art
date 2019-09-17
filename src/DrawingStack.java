//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: AsciiArt
// Files: DrawingStack.java
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
