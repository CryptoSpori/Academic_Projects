package Mod8PA.Problem2;
/**
* @author EMILIA BUTU
* version 1.0
* since   2020-06
*
* Student name:  John Stelly
* Completion date: 12/03/2020
*
*	Random10K.txt: download and save as Random10K.java
*	
*	Uses the SortedABPriQ, building priority queues in increasing and decreasing order
*
* 	Student tasks: complete tasks specified in the file
*/

public class Random10K
{
  public static void main(String[] args)
  {
		//*** Task #1: declare a variable pq of PriQueueInterface type, and instantiate it as
		//		SortedABPriQ, in which you insert the elements in increasing order
	  PriQueueInterface<Integer> pq = new SortedABPriQ<>();

		//*** Task #2: declare a variable rpq of PriQueueInterface type, and instantiate it as
		//		SortedABPriQ, in which you insert the elements in decreasing order
	  PriQueueInterface<Integer> rpq = new SortedABPriQ<>();

	Integer n=0;

	  int tempNumber = 0;


    for (int i=0;i<100;i++)
    {
		//*** Task #3: assign a random integer between 1 and 10000 to n
		tempNumber = (int) (Math.random() * 10000) + 1;

		//tempNumber = tempNumber + i;

		//*** Task #4: add the element to pq using the regular enqueue
		pq.enqueue(tempNumber);

		//*** Task #5: add the element to rpq using the renqueue method
		rpq.renqueue(tempNumber);
	}

		//*** Task #6: display the priority queue with elements in increasing order
		System.out.println(pq.toString());
	  	System.out.println();
		//*** Task #7: display size of priority queue pq
		System.out.println("Number of element: " + pq.size());
		System.out.println();
		System.out.println("Priority Queue in Reverse Order:");

		//*** Task #8: display the priority queue with elements in decreasing order
		System.out.println(rpq.toString());

		//*** Task #9: display size of priority queue pq
	  	System.out.println("Number of element: " + rpq.size());

 }
}