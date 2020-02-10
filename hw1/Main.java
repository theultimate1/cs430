import java.util.ArrayList;
import java.util.Random;



public class Main{

    public static void main(String[]args){
 
        int[][] tests = createBatch();
        for(int[] test : tests){
            System.out.print("Input Size: " + test.length);
            System.out.println("");
            System.out.print("Merge Sort: "+time("merge", test)[1]+"ms");
            System.out.print(", ");
            System.out.print("Insertion Sort: "+time("insertion", test)[1]+"ms");
            System.out.println("");
            System.out.println("");
        }


    }


    /*Insertion Sort*/
    public static int[] insertionSort(int[] arr){
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
    public static int[] mergeSort(int[] arr){
        int length = arr.length;
        if(length == 1){
            return arr;
        }
        int middle = (length / 2);
        int[] arr1 = new int[middle];
        int[] arr2 = new int[length-middle];
        for(int i = 0; i < middle; i++){
            arr1[i] = arr[i];
        }
        for(int j = 0; j < length-middle; j++){
            arr2[j] = arr[middle + j];
        }
        return combine(mergeSort(arr1), mergeSort(arr2));

    }

    public static int[] combine(int[] arr1, int arr2[]){
        
        int newLength = arr1.length + arr2.length;
        int finalArr[] = new int[newLength];
        int ptr1 = 0, ptr2 = 0, ptr3 = 0;
 
        while(ptr1 < arr1.length && ptr2 < arr2.length){
            if(arr1[ptr1] <= arr2[ptr2]){
                finalArr[ptr3] = arr1[ptr1];
                ptr1++;
            }
            else{
                finalArr[ptr3] = arr2[ptr2];
                ptr2++;
            }
            ptr3++;            
        }
        if(ptr1 != arr1.length){
            while(ptr3 < newLength){
                finalArr[ptr3] = arr1[ptr1];
                ptr1++;
                ptr3++;
            }
        }
        else{
            while(ptr3 < newLength){
                finalArr[ptr3] = arr2[ptr2];
                ptr2++;
                ptr3++;
            }
        }

        return finalArr;
    }

    // Creates an individual test array with size paramter
    public static int[] genTest(int size){
        int[] test = new int[size];
        for(int i = 0; i < size; i++){
            Random rnd = new Random();
            test[i] = rnd.nextInt(20);
        }
        return test;
    }
    
    // Creates batch of tests using genTest function
    public static int[][] createBatch(){
        
        int[] sizes = new int[]{100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};
        int scalar = 100;
        int size = sizes.length;
        int[][] batch = new int[size][size];
        for(int i = 0; i < size; i++){
            batch[i] = genTest(sizes[i] * scalar);
        }
        return batch;
    }

    /* 
        Timer function that takes string representing sort method and array of numbers to be passed in
        Returns int array [<size of the input array>, <time in ms it took to complete sorting>]
    */
    public static int[] time(String method, int[] paramArr){
        int start = (int)(System.currentTimeMillis());
            if (method.equals("insertion")){
                insertionSort(paramArr);
            }
            else if (method.equals("merge")){
                mergeSort(paramArr);
            }
            else{
                System.out.println("INVALID INPUT");
            }

        int end = (int)System.currentTimeMillis(); 
        return new int[]{(paramArr.length), (end-start)};
    }
}