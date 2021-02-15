package Mod3APA.Problem4;
/**
* @author YINGJIN CUI
* @version 1.0
* since   2020-02
*
* Student name:  xxxxx
* Completion date: xxxx
*
* AreaFill.txt: the template file of AreaFill.java
* Student tasks: implement tasks #1, #2 and #3 as specified in this file
*/


import java.util.Scanner; 
import java.io.*;
 
public class AreaFill{
     
      public static void main(String[] args) throws Exception{ 
         // YOU ARE NOT SUPPOSED TO MAKE ANY CHANGES HERE
        char[][] matrix=buildMetrix(new File(args[0]));
        System.out.println("Original Matrix:");
        print(matrix);
        int row=Integer.parseInt(args[1]);
        int col=Integer.parseInt(args[2]);
        fill(matrix,row,col,matrix[row][col]);
        System.out.println("after filling\n");
        print(matrix);
      } 

     public static char[][] buildMetrix(File file) throws FileNotFoundException {
     // *** Student task #1 ***  

      /*
      Requirements:
      This method reads data from the file and build and return a 2D char array.
      The first line in the data file contains two numbers R and C, followed by R lines
      and each line contains C characters.

       *** Enter your code below ***
     */

         Scanner fileReader = new Scanner(file);
         String textData = fileReader.nextLine();
         String[] cords = textData.split(" ");
         int r = Integer.parseInt(cords[0]);
         int c = Integer.parseInt(cords[1]);
         char[][] matrix = new char[r][c];

         int index = 0;
         while (fileReader.hasNextLine()) {
             textData = fileReader.nextLine();
             for (int i = 0; i < c; i++) {
                 matrix[index][i] = textData.charAt(i);
             }
             index++;
         }

         return matrix;

     }

     public static void fill(char[][] grid, int row, int col, char ch){
      // *** Student task #2 ***
      /* 
      Requirements: 
      This is a recursive method. It fills the cell at [row, col] 
      with * if matrix[row][col] is ch, then recurs up, down, left, and right, 
      (but NOT diagonally) and replaces similar characters with ‘*’.
      
       *** Enter your code below ***       
      */
         if(row == 0 && col == 0)
             grid[row][col] = '*';
         else if (grid[row][col] == ch) {
             grid[row][col] = '*';
             if (row > 0)
                 fill(grid, row - 1, col, ch);
             if (row < grid.length - 1)
                 fill(grid, row + 1, col, ch);
             if (col > 0 ) {
                 fill(grid, row, col - 1, ch);
             }
             if (col < grid[row].length - 1)
             {
                 fill(grid, row, col + 1, ch);
             }
         }
     }

     public static void print(char[][] area){
     
      // *** Student task #3 ***  

      /* 
      Requirements: 
      This method prints the matrix in a table format as shown below:
         ....00
         .0..00
         ..0000

       *** Enter your code below *** 
     */
         for (int i = 0; i < area.length - 1; i++) {
             for (int j = 0; j < area[i].length - 1; j++) {
                 System.out.print(area[i][j]);
             }
             System.out.println("");
         }
     }
} 
