package Mod8GA.Problem1;

/**
* @author EMILIA BUTU
* version 1.0
* since   2020-06
*
* Student name:  John Stelly
* Completion date: 12/02/2020
*
* MapExample.txt: save the file as MapExample.java:
* Demonstrates the use of methods offered by MapInterface, with an implementation of the map using
* array lists.
*
* The file contains basic operations related to Map ADT
*
* Student tasks: complete tasks specified in the file
*/



public class MapExample
{
	public static void main(String[] args)
	{
		//*** Task #1: declare a variable of MapInterface type, with type of elements of your choice
		//*** Task #2: instantiate the variable declared above using the ArrayListMap constructor
		MapInterface<Character, String> barn = new ArrayListMap<>();

		//*** Task #3: check if the map is  empty, and print out the answer you get
		System.out.println("Is map empty: "  + barn.isEmpty());

		//*** Task #4: use the appropriate method, and display the size of the map 
		System.out.println("Map Size: "  + barn.size());
		System.out.println();

		//*** Task #5: use the appropriate method to populate the map with 4-5 entries
		System.out.println("ADD: dog");
		System.out.println("ADD: cat");
		System.out.println("ADD: horse");
		System.out.println("ADD: pig");
		System.out.println("ADD: bull");
		barn.put('D', "dog");
		barn.put('C', "cat");
		barn.put('H', "horse");
		barn.put('P', "pig");
		barn.put('B', "bull");
		System.out.println();

		//*** Task #6: check if the map is  empty, and print out the answer you get 
		System.out.println("Is map empty: "  + barn.isEmpty());

		//*** Task #7: use the appropriate method, and display the size of the map 
		System.out.println("Map Size: "  + barn.size());
		System.out.println();

		//*** Task #8: check if certain values belong to the map, and replace some of them
		System.out.println("Check map for dog: " + barn.contains('D'));
		System.out.println("Check map for bull: " + barn.contains('B'));
		System.out.println("Check map for kitten: " + barn.contains('K'));
		System.out.println("Replace dog with DAD");
		barn.put('D', "DAD");
		System.out.println("Replace bull with BAD");
		barn.put('B', "BAD");
		System.out.println();

		//*** Task #9: display the content of the map
		System.out.println("\nView of Map:");
		for (MapEntry<Character, String> m: barn){
			System.out.print(m.getValue() + " ");
		}
		System.out.println();

		//*** Task #10: remove a number of elements from the map
		System.out.println("\nRemove horse");
		barn.remove('H');
		System.out.println("\nRemove cat");
		barn.remove('C');

		//*** Task #11: display the new content of the map
		System.out.println("\n\nView of Map:");
		for (MapEntry<Character, String> m: barn){
			System.out.print(m.getValue() + " ");
		}

	}
}