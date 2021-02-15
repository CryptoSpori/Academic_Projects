package Mod6PA.Problem4;



/**
* @author EMILIA BUTU
* version 1.0
* since   2020-03
*
* Student name:  John Stelly
* Completion date: 11/15/2020
*
* DoublyLinkedList.txt: template file of DoublyLinkedList.java. Implements a doubly-linked list with a type parameter for the node data. Contains an inner class is used for list nodes.
*/

public class DoublyLinkedList<E>
{
	// define ListNode elements specific for this type of list, indicating current, previous and next
	// consider head as name for previous node, and tail for the next one.
    private ListNode<E> head;
    private ListNode<E> current;
    private ListNode<E> tail;

    int position;

	// default constructor
	public DoublyLinkedList()
    {
		//*** Task #1: implement a default constructor here, initializing the nodes to null
        this.head = null;
        this.current = null;
        this.tail = null;
    }

	// method that calculates the length of the list
    public int length()
    {
		//*** Task #2: implement the method navigating through the list until you run out of elements
        int length = 0;
        ListNode<E> temp = head;
        while (temp != null)
        {
            length++;
            temp = temp.link;
        }
        return length;
    }

	// method that adds a node at the beginning of the list
    public void addANodeToStart(E addData)
    {
		//*** Task #3: implement this method, taking into consideration that the head will be replaced by a new node. You may want to use a temporary variable
        ListNode<E> newHead = new ListNode<>();
        newHead.data = addData;
        current = newHead;
        if (tail == null)
            tail = newHead;
        if (head != null)
            head.setPrevious(newHead);
        newHead.link = head;
        head = newHead;
    }

    public void addANodeToRear(E addData)
    {
        //*** Task #3: implement this method, taking into consideration that the head will be replaced by a new node. You may want to use a temporary variable
        ListNode<E> newNode = new ListNode<>();
        newNode.data = addData;
        current = newNode;
        if (tail != null)
           newNode.previous = tail;
        if (tail == null)
            head = newNode;
        else
            tail.link = newNode;
        tail = newNode;
    }

	// accessor method that gets data at current node
    public E getDataAtCurrent()
    {
		//*** Task #4: implement this method making sure to take into account the situation when
		// there current doesn't point to any data (is null)
        return current.data;
    }

	// method that sets the current node in the beginning, resetting the iteration
    public void resetIteration()
    {
		//*** Task #5: implement the body of the method
        current = head;
    }

	// method that checks if there is more to iterate in the list
    public boolean moreToIterate()
    {
		//*** Task #6: implement the body of the method
        return (current.link != null);
    }

	// method that moves the node to the next position, if possible
    public void goToNext()
    {
		//*** Task #7: implement the method taking into account the situation when the list is empty
		// check if there are other instances when the move is not possible.
        if (head == null) {
            System.out.println("Is Empty");
        }
        else if (!moreToIterate())
            System.out.println("Nothing else");
        else {
            current = current.link;
            position++;

        }
    }

	// method that resets the reverse iteration, setting the current node to the last one
    public void resetIterationReverse()
    {
		//*** Task #8: implement the body of the method
        current = tail;

    }

	// method that facilitates the move in the reverse directions, redirecting the node to previous
    public void goToPrevious()
    {
		//*** Task #9: implement this method in a similar way the goToNext() method
        // make sure to have the right links for the reverse navigations
        if (tail == null) {
            System.out.println("Is Empty");
        }
        else if (current.previous == null)
            System.out.println("Nothing else");
        else {
            current = current.previous;
            position--;
        }
    }

    /*
     Method that inserts node with newData after the current node.
     Note: The current node is the same after invocation as it is before invocation.
     Should not be used with an empty list.
     Should not be used when the current node has iterated past the entire list.
    */
    public void insertNodeAfterCurrent(E newData)
    {
		//*** Task #10: implement this method, making sure to observe the ideas noted above
        position = 0;
        int size = length();
        findInList(current.data);
        ListNode<E> newNode = new ListNode<>();
        newNode.setData(newData);
        ListNode<E> workNode = head;
        for (int i = 0; i < position; i++) {
            addANodeToRear(workNode.data);
            workNode = workNode.link;
        }
        addANodeToRear(newData);
        for (int i = position; i < size; i++) {
            addANodeToRear(workNode.data);
            workNode = workNode.link;
        }
        head = workNode;
        findInList(newNode.data);
    }

    /*
     Method that deletes the current node. After the invocation,
     the current node is the node after the
     deleted node or null if there is no next node.
    */

    public void deleteCurrentNode()
    {
		//*** Task #11: implement this method, making sure to observe the ideas noted above
        int size = length();
        ListNode<E> holdCurrent = current;
        findInList(current.data);
        ListNode<E> workNode = head;
        for (int i = 0; i < size; i++) {
            String wordK = (String) workNode.data;
            String wordQ = (String) holdCurrent.data;
            if (wordK.equalsIgnoreCase(wordQ))
                current = null;
            else
                addANodeToRear(workNode.data);
            workNode = workNode.link;
        }
        head = workNode;
    }

	// method that deletes the head node.
    public void deleteHeadNode()
    {
		//*** Task #12: implement this method
        head = head.link;
    }


    // Searches list for element containing target data.
    // If target is found, current is set to point at it,
    // and the function returns true.
    // If target is not found, current is set to null
    // and the function returns false.
    public boolean findInList(E target)
    {
		//*** Task #13: implement this method, making sure to observe the ideas noted above

        ListNode<E> tmp = head;
        while(tmp != null){
            if(tmp.data.equals(target)) {
                current = tmp;

                return true;
            }
            tmp = tmp.link;
            position++;
        }
        current = null;
        return false;
    }

    public boolean onList(E target)
    {
		//*** Task #14: implement this method
        ListNode<E> tmp = head;
        while(tmp != null){
            if(tmp.equals(target)) {
                return true;
            }
            tmp = tmp.link;
        }
        return false;
    }

    private ListNode<E> Find(E target)
    {
		//*** Task #15: implement this method
        ListNode<E> tmp = head;
        ListNode<E> found;
        while(tmp != null){
            if(tmp.equals(target)) {
                found = tmp;
                return found;
            }
            tmp = tmp.link;
        }
        return null;
    }

	// method that displays the list
    public void showList()
    {
		//*** Task #16: irrespective of navigation through the list, the display remains the same
        // start from the head and move through the list to show all elements.
        ListNode<E> temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.link;
        }
    }

    // Method useful during testing and debugging, that allows control over the nodes.
    public void showListState()
    {
        System.out.println("Head: " + (head == null ? "null" : head.data)
                           + " Current: " + (current == null ? "null" : current.data)
                           + " Tail: " + (tail == null ? "null" : tail.data)
                           + " " + length() + " items");
    }

    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static class ListNode<E>
    {
		// instance variables
        private E data;
        private ListNode<E> link;
        private ListNode<E> previous;

        // constructor - default
        public ListNode()
        {
            //*** Task #17: implement this constructor
            data = null;
            link = null;
            previous = null;
		}

		// constructor, fully defining the list
        public ListNode(E newData, ListNode<E> linkValue, ListNode<E> previousValue)
        {
            //*** Task #18: implement this constructor
            setData(newData);
            setLink(linkValue);
            setPrevious(previousValue);
        }

        // mutator for data
        public void setData(E newData)
        {
		//*** Task #19: implement this method
            data = newData;
		}

		// accessor for data
        public E getData()
        {
		//*** Task #20: implement this method
            return data;
		}

		// mutator for the node
        public void setLink(ListNode<E> newLink)
        {
		//*** Task #21: implement this method
            link = newLink;
		}

		// mutator for the previous node
        public void setPrevious(ListNode<E> newPrevious)
        {
		//*** Task #22: implement this method
            previous = newPrevious;
		}

		// accessor for the current node
        public ListNode<E> getLink()
        {
		//*** Task #23: implement this method
            return link;
		}

		// accessor for the previous node
        public ListNode<E> getPrevious()
        {
		//*** Task #24: implement this method
            return previous;
		}

    }
}