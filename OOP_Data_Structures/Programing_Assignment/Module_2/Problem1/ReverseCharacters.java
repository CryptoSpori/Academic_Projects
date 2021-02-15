package Mod2PA.Problem1;
/**
 * professor EMILIA BUTU
 * since   CS-202 (FALL 2020)
 *
 * @author Student name:  John C Stelly
 * Completion date 10/11/2020:
 *
 * ArrayBaseStack.java
 */
import java.util.Scanner;

public class ReverseCharacters {

    public static void main(String[] args) {

        //Set variables for keyboard input
        Scanner kb = new Scanner(System.in);
        String sentence;


        //Prompt user of input
        System.out.println("Enter a sentence:");
        sentence = kb.nextLine();

        //Return initial sentence to user
        System.out.println("\nInitial Sentence: \n" + sentence);

        //Implement array based stack
        StackInterface<Character> sentenceStack = new ArrayBaseStack<>(sentence.length());

        //Load sentence string to stack, char by char.
        for (int i = 0; i < sentence.length(); i++) {
            char temp = sentence.charAt(i);
            sentenceStack.push(temp);
        }

        //Return sentence in reverse order
        System.out.println("\nSentence with reverse characters in each words:");
        for (int i = 0; i < sentence.length(); i++) {
            System.out.print(sentenceStack.top());
            sentenceStack.pop();
        }
    }
}
