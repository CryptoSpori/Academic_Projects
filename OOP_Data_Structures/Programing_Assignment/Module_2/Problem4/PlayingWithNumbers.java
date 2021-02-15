package Mod2PA.Problem4;
/**
 * professor EMILIA BUTU
 * since   CS-202 (FALL 2020)
 *
 * @author Student name:  John C Stelly
 * Completion date 10/11/2020:
 *
 * PlayingWithNumbers.java
 */
import java.util.Scanner;

public class PlayingWithNumbers {

    public static void main(String[] args) {

        //Variables
        Scanner inputInt = new Scanner(System.in);
        int age, average;
        int max = 0;
        int min = 0;
        int count = 0;
        int sum = 0;
        NumberStack<Integer> numbers;
        NumberStack<Integer> tempStack;

        //User input age
        System.out.print("Enter your age: ");
        age = inputInt.nextInt();
        numbers = new NumberStack<Integer>(age);
        tempStack = new NumberStack<>(age);

        //Generate Random Stack 1 to 1000
        int index = 0;
        while(age != index) {
            int temp = (int) (Math.random() * 1000);
            if (temp > 0) {
                numbers.push(temp);
                index++;
            }
        }
        //Get int max and min values
        max = numbers.top();
        min = numbers.top();

        for (int i = 0; i < age; i++) {
            int temp = numbers.top();
            tempStack.push(temp);
            sum = sum + temp;


            //Calculate Minimum Numbers
            if (min > temp) {
                min = numbers.top();
            }
            //Calculate Maximum numbers
            if (max < temp) {
                max = numbers.top();
            }
            //Number of odd numbers
            int remainder = temp % 2;
            if (remainder != 0)
                count++;

            //Pop value
            numbers.pop();
        }

        for (int i = 0; i < age; i++) {
            numbers.push(tempStack.top());
            tempStack.pop();
        }

        //Average Value of stack
        average = sum / age;

        //Display stack and results
        System.out.println(numbers);
        System.out.println("Minimum value in stack: " + min);
        System.out.println("Maximum value in stack: " + max);
        System.out.println("Average value of numbers in stack: " + average);
        System.out.println("Number of odd numbers " + count);
    }
}
