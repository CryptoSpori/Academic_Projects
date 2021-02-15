package Mod4PA.Program2;
/**
 * professor EMILIA BUTU
 * since   CS-202 (FALL 2020)
 *
 * @author Student name:  John C Stelly
 * Completion date: 10/31/2020
 *
 * CipherDriver.java
 */

import java.util.Scanner;

public class CipherDriver {

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        //Generated randomly with integers in a range that contains both positive and negative numbers
        int[] cipherKey = generateCipherKey(18,-10);

        //Two linked-list queues, one for encode and one for decode operations
        CipherQueue<Character> encoderQueue = new CipherQueue<>();     //Encodes String
        CipherQueue<Character> decoderQueue = new CipherQueue<>();     //Decodes String

        //Show cipher key
        showKey(cipherKey);

        //Load both with same cipher key
        encoderQueue.loadKey(cipherKey);
        decoderQueue.loadKey(cipherKey);

        //Read a message from the user and encode it
        System.out.print("Enter a message to be encoded: ");
        String message = kb.nextLine();
        System.out.println("********************************************************************");

        //Show original message
        System.out.print("\nOriginal message: ");
        System.out.println(message);

        //Load char into encoder queue for message encoding
        for (int i = 0; i < message.length(); i++) {
            encoderQueue.cipherEnqueue(message.charAt(i));
        }

        //Display encoded massage
        System.out.print("\nEncoded message: ");
        encoderQueue.display();

        //Read encode message from encoder queue and transfer to decoder queue for de-coding

        while (!encoderQueue.isEmpty()) {
           char cipherText =  encoderQueue.dequeue();
            decoderQueue.enqueue(cipherText);
        }

        //Display un-encoded message
        System.out.print("\nDecoded message: ");
        while (!decoderQueue.isEmpty()) {
            char cipherText =  decoderQueue.cipherDequeue();
            System.out.print(cipherText);
        }
    }

    //Helper methods
    public static int[] generateCipherKey(int range, int min) {
        // Generate key set with 7 values
        int[] key = new int[7];
        for (int i = 0; i < key.length; i++) {
            key[i] = (int) (Math.random() * range) + min;
        }
        return key;
    }

    public static void showKey(int[] keyArray) {
       //Display Key
        System.out.print("KeySet = {");
        for (int j : keyArray) {
            System.out.print(j + ",");
        }
        System.out.println("}");
    }
}

