//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: AsciiArt
// Files: AsciiArt.java
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
import java.util.Scanner;

/**
 * This is driver class. Running the main method in this class must result in an interactive session
 * with the user.
 *
 * @author niharikatomar, archanadhyani
 *
 */

public class AsciiArt {

  public static void main(String[] args) { // main driver method
    Scanner sc = new Scanner(System.in); // creating a scanner
    boolean quit = false;
    Canvas canvas = null; // setting canvas to null
    while (quit == false) { // loop condition
      System.out.println("======== MENU ========");
      System.out.println("[1] Create a new canvas");
      System.out.println("[2] Draw a character");
      System.out.println("[3] Undo drawing");
      System.out.println("[4] Redo drawing");
      System.out.println("[5] Show current canvas");
      System.out.println("[6] Exit");
      String input = sc.nextLine(); // reading user input
      char inputChar = input.charAt(0);
      if (inputChar == '1') { // if condition for user input
        System.out.println("Width: ");
        String strWidth = sc.nextLine(); // reading user input
        System.out.println("Height: ");
        String strHeight = sc.nextLine(); // reading user input
        int width = Integer.parseInt(strWidth);
        int height = Integer.parseInt(strHeight);
        canvas = new Canvas(width, height);
      } else if (inputChar == '2') { // if condition for user input
        if (canvas != null) {
          System.out.println("Row: ");
          String strRow = sc.nextLine(); // reading user input
          System.out.println("Col");
          String strCol = sc.nextLine(); // reading user input
          System.out.println("Character: ");
          String strChar = sc.nextLine(); // reading user input
          char c = strChar.charAt(0); // reading character
          int row = Integer.parseInt(strRow);
          int col = Integer.parseInt(strCol);
          canvas.draw(row, col, c); // calling draw method
        } else {
          System.out.println("Canvas is null"); // warning message
        }
      } else if (inputChar == '3') { // if condition for user input
        if (canvas != null) { // if condition to check if canvas is not null
          canvas.undo(); // calling undo method
        } else {
          System.out.println("Canvas is null"); // warning message
        }
      } else if (inputChar == '4') { // if condition for user input
        if (canvas != null) { // if condition to check if canvas is not null
          canvas.redo(); // calling redo method
        } else {
          System.out.println("Canvas is null"); // warning message
        }
      } else if (inputChar == '5') { // if condition for user input
        if (canvas != null) { // if condition to check if canvas is not null
          System.out.println(canvas.toString()); // printing canvas to console
        } else {
          System.out.println("Canvas is null"); // warning message
        }
      } else if (inputChar == '6') { // if condition for user input
        if (canvas != null) { // if condition to check if canvas is not null
          System.out.println("Bye!");
          quit = true;
        } else {
          System.out.println("Canvas is null"); // warning message
        }
      } else {
        System.out.println("Invalid input"); // warning message
      }
    }
  }
}
