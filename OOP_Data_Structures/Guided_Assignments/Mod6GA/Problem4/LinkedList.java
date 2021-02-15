package Mod6GA.Problem4;

/**
* @author EMILIA BUTU
* version 1.0
* since   2020-03 
*
* Student name:  xxxxx
* Completion date: xxxx
*
* LinkedList.txt: template file of LinkedList.java
* Student tasks: complete tasks specified in the file. Scope of this program is to implement a linked list of values of type String, and use it in an application that creates a list of five colors, as indicated in the requirements.
*/

class LinkedList
{
    /**
       The Node class stores a list element and a reference to the next node.
    */

    private class Node
    {
        String value;
        Node next;

        /**
           Constructor.
			   @param val 	element to store in the node.
			   @param n 	reference to the successor node.
        */
		// constructor with attributes given as arguments
        Node(String val, Node n)
        {
		//*** Task #1: fill in body of this constructor
            value = val;
            next = n;
        }

        /**
           Constructor.
           @param val 	element to store in the node.
        */

        Node(String val)
        {
		//*** Task #2: fill in the body of this constructor
            value = val;
            next = null;

        }
    }
    private Node first;  // list head
    private Node last;   // last element in list

    /**
       Constructor.
    */

    public LinkedList()
    {
        first = null;
        last = null;
    }
    /**
       The isEmpty method checks to see
		 if the list is empty.
		 @return true if list is empty,
		 false otherwise.
    */

    public boolean isEmpty()
    {
		//*** Task #3: fill in the body of this method

        return (size() == 0);

    }
    /**
       The size method returns the length of the list.
       @return The number of elements in the list.
    */

    public int size()
    {
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

    public void add(String e)
    {
      if (isEmpty())
      {
          first = new Node(e);
          last = first;
      }
      else
      {
          // Add to end of existing list
          last.next = new Node(e);
          last = last.next;
      }
    }
    /**
       The add method adds an element at a position.
       @param e The element to add to the list.
       @param index The position at which to add
		 the element.
       @exception IndexOutOfBoundsException When
		 index is out of bounds.
    */

    public void add(int index, String e)
    {
		//*** Task #4: fill in the body of this method, following instructions given by comments
		/*
			Directions :
			* check that index is in the correct range, and throw IndexOutOfBoundsException if not
			* consider index is 0, and place the new element in the beginning of the list
			* set a reference pred to point to the node that will be the predecessor of the new node
			* Splice in a node containing the new element
 			* check if there is a new last element, and set up last
 		*/

        if (index > size() || index < 0 )
            throw new IndexOutOfBoundsException();

        Node newNode = new Node(e);

        if (index == 0) {
            newNode.next = first;
            first = newNode;
        }
        else if (index == size()) {


            add(e);



        }
        else {
            Node temp = first;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            newNode.next = last;
            temp.next = newNode;
            first.next = temp;
        }
    }

    /**
       The toString method computes the string
       representation of the list.
       @return The string form of the list.
    */

    public String toString()
    {
      StringBuilder strBuilder = new StringBuilder();

      // Use p to walk down the linked list
      Node p = first;
      while (p != null)
      {
         strBuilder.append(p.value + "\n");
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