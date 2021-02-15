package Mod8PA.Problem1;

import java.util.HashMap;

/**
 * professor EMILIA BUTU
 * since   CS-202 (FALL 2020)
 *
 * @author Student name:  John C Stelly
 * Completion date: 12/03/2020
 *
 * .java
 */

public class LuckyBet {

    public static void main(String[] args) {

        HashMap<Integer, Integer> someMap = new HashMap<>();

        int count = 1;

        for (int i = 0; i < 100; i++) {
            int number = (int) (Math.random() * 6) + 1;
            if (someMap.get(number) != null)
            count =  someMap.get(number) + 1;
            someMap.put(number, count);
        }

        printHashMap(someMap);

    }
    public static void printHashMap(HashMap<Integer, Integer> someMap) {

        System.out.println("The histogram contains: ");

        for (int i = 0; i < 6; i++) {

            System.out.println("The number " + (i + 1) + " occurs " + someMap.get(i + 1) + " times");

        }
    }
}