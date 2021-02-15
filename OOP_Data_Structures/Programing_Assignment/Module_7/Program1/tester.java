package Mod7PA.Program1;



public class tester {

    public static void main(String[] args) {


        BXT tree = new BXT();

        String tester = "20 3 -4 + *";

        tree.buildTree(tester);

        tree.display();

        System.out.println(tree.evaluateTree());



    }
}
