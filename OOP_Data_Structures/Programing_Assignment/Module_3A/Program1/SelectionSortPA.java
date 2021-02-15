package Mod3BPA.Program1;

public class SelectionSortPA {
    public static void main(String[] args) {
        int N = 10;
        int[] array = randomFillNumberArray(N);
        showArray(array);
        System.out.println("\nIs Array sorted before: " + isSorted(array));
        selectionSort(array);
        System.out.println("\nIs Array sorted before: " + isSorted(array) +"\n");
        showArray(array);
    }
    public static void selectionSort(int[] array) {
        System.out.println("");
        for (int i = 0; i < array.length; i++) {
            int small = i;

            for (int j = i + 1; j < array.length; j++) {

                if (array[j] < array[small]) {
                    small = j;
                }
            }
            if (small != i) {
                int temp = array[i];
                array[i] = array[small];
                array[small] = temp;
            }
            showArray(array);
        }
    }
    public static int[] randomFillNumberArray(int N) {
        int[] array = new int[N];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);    //Integer.MAX_VALUE
        }
        return array;
    }
    public static void showArray(int[] array) {
        for (int j : array) {
                System.out.print(j + " ");
        }
        System.out.println("");
    }
    public static Boolean isSorted(int[] arr){
        for(int i=1; i<arr.length; i++){
            if(arr[i] < arr[i-1])
                return false;
        }
        return true;
    }
}
