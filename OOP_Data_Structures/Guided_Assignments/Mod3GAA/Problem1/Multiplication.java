package Mod3GAA.Problem1;

public class Multiplication {

    /*
    The Base-Case Question: Is there a non-recursive way out of the algorithm, and does the algorithm work correctly for this base case?

    Yes, if a or b = 0, then 0 is returned

    The Smaller-Caller Question: Does each recursive call to the algorithm involve a smaller case of the original problem, leading inescapably to the base case?

    Yes, Recursive calls of a will reduce by a-1 until it equals 0, which is the base case.


    The General-Case Question: Assuming the recursive call(s) to the smaller case(s) works correctly, does the algorithm work correctly for the general case?

    yes, the base case id b + (a-1, b) which will return a * b for any positive value of a or b.


     */

    public static void main(String[] args) {

        int test = multiplication(5, 5);
        System.out.println(test);

    }

    public static int multiplication(int a, int b) {
        //Precondition a and b are positive numbers

        int solution;

        if (a == 0 || b == 0)

            solution = 0;

        else {

            solution = b + multiplication(a-1, b);

        }

        return solution;
    }
}
