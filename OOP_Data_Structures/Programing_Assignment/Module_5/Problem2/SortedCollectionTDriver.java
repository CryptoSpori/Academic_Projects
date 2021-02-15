package Mod5PA.Problem2;
/**
 * professor EMILIA BUTU
 * since   CS-202 (FALL 2020)
 *
 * @author Student name:  John C Stelly
 * Completion date: 11/06/2020
 *
 * SortedCollectionTDriver.java
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class SortedCollectionTDriver<T> {
    public static void main(String[] args) throws FileNotFoundException {
        File someFile = new File(args[0]);
        Scanner fileStream = new Scanner(someFile);
        SortedCollectionT<String> wordSortedCollection = new SortedCollectionT<>();
        fileStream.useDelimiter("[^a-zA-Z']");
        System.out.println("Word list is empty: " + wordSortedCollection.isEmpty());
        System.out.println("Size: " +         wordSortedCollection.size());
        while (fileStream.hasNext()) {
            String textWord= fileStream.next();
            wordSortedCollection.add(textWord);
        }
        wordSortedCollection.sort();
        wordSortedCollection.print();
        System.out.println("Word list is full: " + wordSortedCollection.isEmpty());
        System.out.println("Size: " +         wordSortedCollection.size());
        System.out.println("Remove D");
        wordSortedCollection.remove("D");
        System.out.println("Remove P");
        wordSortedCollection.remove("P");
        System.out.println("Remove h");
        wordSortedCollection.remove("h");
        wordSortedCollection.size();
        System.out.println("Add X");
        wordSortedCollection.add("X");
        System.out.println("Add Q");
        wordSortedCollection.add("Q");
        wordSortedCollection.sort();
        wordSortedCollection.print();
        System.out.println("Clear collection");
        wordSortedCollection.clear();
        wordSortedCollection.print();

    }
}
