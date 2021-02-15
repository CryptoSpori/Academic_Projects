package Mod6PA.Problem3;
/**
* @author EMILIA BUTU
* version 1.0
* since   2020-03 
*
* Student name:  John Stelly
* Completion date: 11/15/2020
*
* LinkedList.txt: template file of LinkedList.java
* Student tasks: complete tasks specified in the file. Scope of this program is to implement a linked list of values of type String, and use it in an application that creates a list of five colors, as indicated in the requirements.
*/

class ClassParticipation
{
    /**
       The Node class stores a list element and a reference to the next node.
    */
    private class Node {
        String value;
        Node next;
        private int studentFrequency = 0;
        /**
           Constructor.
			   @param val 	element to store in the node.
			   @param n 	reference to the successor node.
        */
		// constructor with attributes given as arguments

        Node(String val, Node n) {
		//*** Task #1: fill in body of this constructor
            this.value = val;
            this.next = n;
            setStudentFrequency();
        }

        /**
           Constructor.
           @param val 	element to store in the node.
        */
        Node(String val) {
		//*** Task #2: fill in the body of this constructor
            this.value = val;
            this.next = null;
            setStudentFrequency();
        }

        public void setStudentFrequency() {
            studentFrequency = studentFrequency + 1;
        }
    }

    private Node first;  // list head
    private Node last;   // last element in list


    /**
       Constructor.
    */
    public ClassParticipation() {
        first = null;
        last = null;
    }

    /**
       The isEmpty method checks to see
		 if the list is empty.
		 @return true if list is empty,
		 false otherwise.
    */
    public boolean isEmpty() {
        return (size() == 0);
    }

    /**
       The size method returns the length of the list.
       @return The number of elements in the list.
    */
    public int size() {
       int count = 0;
       Node p = first;
       while (p != null)
       {
           // There is an element at p
           count ++;
           p = p.next;
       }
       return count;
    }

    /**
       The add method adds an element to
		 the end of the list.
       @param e The value to add to the
		 end of the list.
    */
    public void add(String e) {


        int allReadyIn = find(e);

        if (isEmpty())
      {
          first = new Node(e);
          last = first;

      }
      else
      {
          // Add to end of existing list
          if (allReadyIn != 1) {
              last.next = new Node(e);
              last = last.next;
          }
      }
    }

    public int getStudentFrequency(int frequency){
        return first.studentFrequency;
    }
    public int find(String name){
        Node tmp = first;
        while(tmp != null){
            if(tmp.value.equals(name)) {
               tmp.setStudentFrequency();
               first = tmp;
               return 1;
            }
            tmp = tmp.next;
        }
        return -1;
    }

    /**
       The toString method computes the string
       representation of the list.
       @return The string form of the list.
    */
    public String toString() {
      StringBuilder strBuilder = new StringBuilder();

      // Use p to walk down the linked list
      Node p = first;
      while (p != null)
      {
         strBuilder.append(p.value + " has a count of " + p.studentFrequency +  "\n");
         p = p.next;
      }
      return strBuilder.toString();
    }

    /**
       The remove method removes the element at an index.
       @param index The index of the element to remove.
       @return The element removed.
       @exception IndexOutOfBoundsException When index is
                  out of bounds.
    */
}