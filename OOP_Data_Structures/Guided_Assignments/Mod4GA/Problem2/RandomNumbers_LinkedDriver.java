package Mod4GA.Problem2;

import Mod4PA.Program1.QueueInterface;

/**
* @author EMILIA BUTU
* version 1.0
* since   2020-03
*
* Student name:  xxxxx
* Completion date: xxxx
*
* RandomNumbers_LinkedDriver.txt: template file for RandomNumbers_LinkedDriver.java
* Implements the application for RandomNumbers_Linked class, using queue.
* Buids a queue of random numbers and displays the content of the queue,
* adding a message for the values divisible by 5
*
* Students need to complete the tasks as marked
*/

public class RandomNumbers_LinkedDriver
{
  public static void main(String[] args)
  {
		//*** Task #1: define a queue with elements of type Integer using QueueInterface
    //*** Task #2: instantiate the queue as RandomNumbers_Linked object
        QueueInterface<Integer> numbers = new RandomNumbers_Linked<>();

		//*** Task #3: fill the queue with 20 integer values randomly generated in a range from 1 to 100
        for (int i = 0; i < 20; i++) {
          Integer randomNumbers = (int) (Math.random() * 100);
          numbers.enqueue(randomNumbers);
        }

		//*** Task #4: displays the content of the queue,
		//	for numbers divisible by 5, add the message "is divisible by 5"
        System.out.println("Random Numbers are: ");
          while (!numbers.isEmpty()) {
            int temNumber = numbers.dequeue();
            System.out.print(temNumber);
             temNumber = temNumber % 5;
             if (temNumber == 0)
              System.out.println("      is divisible by 5");
              else
                System.out.println("");;
       }
  }
}