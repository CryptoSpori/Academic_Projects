package Mod5GA.Problem1;

public class CollectionDriver {

    public static void main(String[] args) {

        CollectionT<Integer> numbers = new CollectionT<>();

       Integer[] bunchOfNumbers = {10, 5, 9, 3};

        System.out.println("Is collection empty? " + numbers.isEmpty());

        //Add ten numbers - max size of array
        for (int i = 0; i < bunchOfNumbers.length; i++) {
            numbers.add(bunchOfNumbers[i]);
        }
        numbers.print();
        System.out.println("Collection size: " + numbers.size());

        //Get number
        int getSome = numbers.get(bunchOfNumbers[2]);
        System.out.println("Get the number 9: " + getSome);

        //Get number by index
        int getAnother = numbers.get(1);
        System.out.println("Get the number @ at index 1: " + getAnother);

        //Remove by a number by index;
        numbers.remove(2);
        System.out.println("Remove index 2 -> Collection new size: " + numbers.size());
        numbers.print();

        //Remove by element
        numbers.remove(bunchOfNumbers[1]);
        System.out.println("Remove element 5 -> Collection new size: " + numbers.size());
        numbers.print();

        //Contains elements
        boolean test1 = numbers.contains(5);
        System.out.println("Contains 5: " + test1);
        boolean test2 = numbers.contains(11);
        System.out.println("Contains 11: " + test2);

        //Add to specific index
        numbers.add(33, 5);
        numbers.print();

    }
}
