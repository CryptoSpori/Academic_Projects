package Mod3GAB.Problem1;

public class MysterySort {

    public static void main(String[] args) {

        //Use the number N to create N-element int array.
        int N = Integer.parseInt(args[0]);
        int[] numberArray = new int[N];

        //Assign random number 0 through MAX_VALUE
        for (int i = 0; i < numberArray.length; i++) {
            numberArray[i] = (int) (Math.random() * Integer.MAX_VALUE);
        }

        //Call isSorted method to test if the array is sorted
        System.out.println("Is Array sorted before:" + isSorted(numberArray));

        //Print the array elements.
        displayArrayElements(numberArray);

        //Sort Array with mysterySort method
        mysterySort(numberArray);

        //Call isSorted method to test if the array is sorted
        System.out.println("Is Array sorted after:" + isSorted(numberArray));

        //Print the array elements.
        displayArrayElements(numberArray);
    }

    //Mystery sort implementation
    public static void mysterySort(int[] arr){
        for(int i=0; i<arr.length; i++){
            for(int k=0; k<arr.length-i-1; k++){
                if(arr[k]>arr[k+1]){ //swap
                    int hold=arr[k+1];
                    arr[k+1]=arr[k];
                    arr[k]=hold;
                }
            }
        }
    }
    public static Boolean isSorted(int[] arr){
        for(int i=1; i<arr.length; i++){
            if(arr[i] < arr[i-1])
                return false;
        }
        return true;
    }
    public static void displayArrayElements(int[] someArray) {
        System.out.println();
        System.out.print("[");
        for (int j : someArray) {
            System.out.print(j + ", ");
        }
        System.out.println("]");
    }
}
