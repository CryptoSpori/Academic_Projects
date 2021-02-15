package Mod6GA.Problem4;

/**
* @author EMILIA BUTU
* version 1.0
* since   2020-03 
*
* Student name:  John Stelly
* Completion date: 11/11/2020
*
* LinkedListDriver.txt: template file of LinkedListDriver.java
* Student tasks: complete tasks specified in the file. 
*/

class LinkedListDriver
{
    public static void main(String [] args)
    {
		//*** Task #1: create a LinkedList object named colorList

        LinkedList colorList = new LinkedList();

		//*** Task #2: add color "red" to the list

        colorList.add("red");

		//*** Task #3: add color "blue" to the list
        colorList.add("blue");

        //*** Task #4: add color "white" at index 0 in the list

        colorList.add(0, "white");

		//*** Task #5: add color "green" at index 2 in the list

         colorList.add(2, "green");

		//*** Task #6 add color "magenta" at index 4 in the list

        colorList.add(4, "magenta");

		System.out.println("The colors in my list are:");
		//*** Task #7: print the list of colors

        System.out.println(colorList.toString());


    }
}