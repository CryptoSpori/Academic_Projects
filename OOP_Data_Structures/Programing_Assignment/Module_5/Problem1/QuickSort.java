package Mod5PA.Problem1;
/**
* @author YINGJIN CUI
* @version 1.0
* since   2020-03
*
* QuickSort.java:  QuickSort class
*/

public class QuickSort<T>{
   
   public void quickSort(T[] arr){
      quickSortRec(arr, 0, arr.length-1);
   }

   private void quickSortRec(T[] arr, int first, int last){
      if(first<last){
         int loc=partition(arr, first, last);
         quickSortRec(arr, first, loc-1);
         quickSortRec(arr, loc+1, last);
      }
   }

   private int partition (T arr[], int low, int high){
    // pivot (Element to be placed at right position)
       T pivot = arr[high];  
       int i = (low - 1);  // Index of smaller element
       for (int j = low; j <= high- 1; j++){
        // If current element is smaller than or
        // equal to pivot
          if (((Comparable)(arr[j])).compareTo(pivot)<=0){
            i++;    // increment index of smaller element
            T tmp= arr[j];
            arr[j]=arr[i];
            arr[i]=tmp;
           }
        }
       T tmp=arr[i+1];
       arr[i+1]=arr[high];
       arr[high]=tmp;
       return (i + 1);
   }
}
