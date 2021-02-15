package Mod5PA.Problem1;
/**
 * professor EMILIA BUTU
 * since   CS-202 (FALL 2020)
 *
 * @author Student name:  John C Stelly
 * Completion date: 11/06/2020
 *
 * VocabularyDensity.java
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VocabularyDensity<T> {
    public static void main(String[] args) throws FileNotFoundException {
        File someFile = new File(args[0]);
        Scanner fileStream = new Scanner(someFile);
        LinkedCollectionT<Word> wordCollection = new LinkedCollectionT<>();
        int wordCount = 0;
        double wordDensity = 0;
        fileStream.useDelimiter("[^a-zA-Z']");
        while (fileStream.hasNext()) {
            wordCount++;
            String textWord= fileStream.next();
            Word word = new Word(textWord);
            wordCollection.add(word);
        }
        wordDensity = wordCount / wordCollection.size();
        System.out.println("Vocabulary Density: " + wordDensity);
        System.out.println("\nBefore sorting: ");
        wordCollection.print();
        wordCollection.sort();
        System.out.println("\nAfter sorting: ");
        wordCollection.print();
    }
}
