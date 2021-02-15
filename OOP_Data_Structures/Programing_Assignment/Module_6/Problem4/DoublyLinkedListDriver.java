package Mod6PA.Problem4;

/**
* @author EMILIA BUTU
* version 1.0
* since   2020-03
*
* Student name:  xxxxx
* Completion date: xxxx
*
* DriverDoublyLinkedList.txt: template file of DriverDoublyLinkedList.java. 
* Demonstrates and tests the DoublyLinkedList class.
* The tests mostly deal with adding and deleting nodes at various places in the list (beginning, middle, and end).

*/

public class DoublyLinkedListDriver
{
    public static void main(String[] args)
    {
     //		*** Task #1: define variables you need for application

     //		*** Task #2: instantiate new doubly-linked list
     DoublyLinkedList<String> classList = new DoublyLinkedList<>();

     //		*** Task #3: display state of list, making sure to format it nicely
     System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++");
     classList.showListState();

    //		*** Task #4: build your list, with a number of elements, by adding nodes, // such as:
    //		*** Task #5: Add a node to an empty list.
     System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++");
     System.out.println("Add a node to an empty list");
     classList.addANodeToStart("CS201");
     classList.showListState();

     // 		*** Task #6: Add nodes to the end of the list.
     System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++");
     System.out.println("Add nodes to the end of the list");
     classList.addANodeToRear("CS203");
     classList.addANodeToRear("CS204");
     classList.addANodeToRear("CS205");
     classList.showListState();
     classList.showList();

     //		*** Task #7: Add nodes to the middle of the list.
     System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++");
     System.out.println("Add node to the middle of the list.");
     classList.resetIteration();
     int inter = classList.length() / 2;
     for (int i = 0; i < inter; i++) {
      classList.goToNext();
     }
     classList.insertNodeAfterCurrent("HIS101");
     classList.showListState();
     classList.showList();


     // see here a sample of set of actions to perform in order
     // to show the outcome of that particular set of actions
     System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++");
     System.out.println("Reset Iteration.");
     classList.resetIteration();
     classList.showListState();
     System.out.println("Go to Next.");
     classList.goToNext();
     classList.showListState();
     System.out.println("Go to Next.");
     classList.goToNext();
     classList.showListState();

     System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++");
     System.out.println("Insert After Current.");
     classList.insertNodeAfterCurrent("ENG211");
     classList.showListState();
     classList.showList();

     //*** Task #8: Continue with other operations to demonstrate the
     //*** Task #9: way doubly linked list works
     //*** Task #11: delete the first node
     System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++");
     System.out.println("Delete the first node.");
     classList.deleteHeadNode();
     classList.showListState();
     classList.showList();

     //*** Task #12: add more nodes to the end of list
     System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++");
     System.out.println("add more nodes to the end of list.");
     classList.addANodeToRear("CS299");
     classList.showListState();
     classList.addANodeToRear("CS300");
     classList.showListState();
     classList.showList();

     System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++");
     //*** Task #13: delete from the middle of the list
     System.out.println("delete from the middle of the list.");
     classList.showListState();
     classList.resetIteration();
     inter = classList.length() / 2;
     for (int i = 0; i < inter; i++) {
      classList.goToNext();
     }
     classList.deleteCurrentNode();
     classList.showList();


     //*** Task #14: add in the beginning of the list
     System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++");
     System.out.println("add in the beginning of the list.");
     classList.addANodeToStart("CS200");
     classList.showListState();
     classList.showList();

     //*** Task #15: iterate to the end of list
     System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++");
     System.out.println("iterate to the end of list.");
     classList.resetIteration();
     for (int i = 0; i < classList.length(); i++) {
      System.out.println(classList.getDataAtCurrent());
      classList.goToNext();
     }

     //*** Task #16: iterate list in reverse.");
     System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++");
     System.out.println("iterate list in reverse.");
     classList.resetIterationReverse();
     for (int i = 0; i < classList.length(); i++) {
      System.out.println(classList.getDataAtCurrent());
      classList.goToPrevious();
     }

     //*** Task #17: delete from the end of the list.
     System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++");
     System.out.println("delete from the end of the list.");
     classList.showListState();
     classList.resetIteration();
     for (int i = 0; i < classList.length() -1; i++) {
      System.out.println(classList.getDataAtCurrent());
      classList.goToNext();
     }
     classList.deleteCurrentNode();

     //*** Task #18: find element that should still be in the list
     System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++");
     System.out.println("find element that should still be in the list.");
     System.out.println("Is CS205 still in list? " + classList.findInList("CS205"));
     classList.showList();

     //*** Task #19: find element that should not be in the list anymore
     System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++");
     System.out.println("find element that should not be in the list anymore");
     System.out.println("Is CS204 still in list? " + classList.findInList("CS204"));
     classList.showList();

     //*** Task #20: display the final list
     System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++");
     System.out.println("display the final list");
     classList.showList();

/*
	NOTE:
	* the list of operations required above is just a framework
	* if you feel the need, play more by adding and removing nodes
*/

    }
}