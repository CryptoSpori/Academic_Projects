package Mod7PA.Program2;

public class tester {

    public static void main(String[] args) {



        MyIntBSTTree tree = new MyIntBSTTree();


        int[] numbers = {80, 17, 81, 85, 55, 12, 45};

        for (int i = 0; i < numbers.length; i++) {
            tree.add(numbers[i]);
        }

        System.out.println(tree.height());
        tree.display();

        System.out.println(tree.comparisons(200));










    }
}
