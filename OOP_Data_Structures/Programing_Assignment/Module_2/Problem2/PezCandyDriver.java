package Mod2PA.Problem2;
/**
 * professor EMILIA BUTU
 * since   CS-202 (FALL 2020)
 *
 * @author Student name:  John C Stelly
 * Completion date 10/11/2020:
 *
 * PezCandyDriver.java
 */

/*   Algorithm
*    -------------------------------------------------------------------------------------------------
*   [Start with stack A of 12 random candies that contain colors  [Red, blue, green , yellow ,red]
*   and stack B that is empty]
*
*    Display Stack A to screen
*
*    for each item in A do
*        if item = red
*             A.pop
*        else
*             Move item from A to B
*
*    Display Stack B on screen
*
*    for each item in Be do
*        B --> A
*        B.pop
*
*    Display updated Stack A
*
 */

public class PezCandyDriver {
    public static void main(String[] args) {

        //Set variables
        int position = 0;
        String color;

        //Implement stack for candy and a spare stack for sorting
        // Default capacity of 12 already set in PexCandy Class
        PezCandy<String> candyStack = new PezCandy<>();
        PezCandy<String> spareStack = new PezCandy<>();

        //Random fill candy stack with number 0 through 4 that corr. to colors
        while (position < candyStack.size()) {
            int temp = (int) (Math.random() * 10);
            if (temp < 5) {
                switch (temp) {
                    case 0:
                        color = "red";
                        candyStack.push(color);
                        break;
                    case 1:
                        color = "blue";
                        candyStack.push(color);
                        break;
                    case 2:
                        color = "green";
                        candyStack.push(color);
                        break;
                    case 3:
                        color = "yellow";
                        candyStack.push(color);
                        break;
                    case 4:
                        color = "pink";
                        candyStack.push(color);
                        break;
                }
                position++;
            }
        }
        System.out.println("Original content of Pez container");
        System.out.println(candyStack);

        //Remove top candy from stack and check color for red
        for (int i = 0; i < candyStack.size(); i++) {
            String temp = candyStack.top();
            if (temp.equalsIgnoreCase("red")) {
                System.out.println("Yum!!!...crunch, crunch, crunch..eat a red one");
                candyStack.pop();
            }
            else {
                //Load non-red colors to spare stack
                spareStack.push(temp);
                candyStack.pop();
            }
        }
        //Print spare stack to screen
        System.out.println(spareStack);
        //Transfer candy from spare srack back to primary stack.
        int tempIndex = spareStack.topIndex;
        for (int i = 0; i < tempIndex; i++) {
            String temp = spareStack.top();
            candyStack.push(temp);
            spareStack.pop();
        }

        //Display primary stack back to screen
        System.out.println("The content of Pez container after eating red candies:");
        System.out.println(candyStack);
    }
}
