import java.util.ArrayList;
import java.util.Random;

public class Main{

    public static void main(String[]args){
        System.out.println("Hello World");
    }


    /*Insertion Sort*/
    public int[] insertionSort(int[] arr){
        // Iterate from 1 to end of array
        for (int i = 1; i < arr.length; i++) { 
            // the variable we want to be moving into the "right" place
            int key = arr[i]; 
            // the last index of the unsorted portion fo the array
            int j = i - 1; 

            // We loop through the array backwards until key is no longer bigger than the value at index j, or j is at the first index
            while (j >= 0 && arr[j] > key) { 
                // Once we find where the key is bigger, we just swap it with value in front of it
                arr[j + 1] = arr[j]; 
                j -= 1; 
            } 
            //actually placing the key
            arr[j + 1] = key; 
        } 
        return arr;
    }



    /*Merge Sort*/
    public int[] mergeSort(int[] arr){

        return arr;
    }
}