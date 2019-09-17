//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: AsciiArt
// Files: DrawingStackIterator.java
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
