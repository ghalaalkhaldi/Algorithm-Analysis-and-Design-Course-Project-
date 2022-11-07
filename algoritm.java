/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ghala.
 */
import java.io.InputStream;
import java.util.Scanner;
public class algoritm {
        //generates random number
static int getRandomInRange(int low, int high)
    {
        return (int)(Math.random()*(high-low)) + low;
    }   
    
    // generates random array
static int[] getRandomArray(int n, int low, int high)
    {
        int arr[] = new int[n];
        for(int i=0; i<n; i++)
        arr[i] = getRandomInRange(low, high);
        return arr;
    }
    
    // sort array in ascending order
static int[] getIncreasingArray(int n)
    {
        int arr[] = new int[n];
        for(int i=0; i<n; i++)
        arr[i] = i+1;
        return arr;
    }
    
    // sort array in descending order
static int[] getDecreasingArray(int n)
    {
        int arr[] = new int[n];
        for(int i=0; i<n; i++)
        arr[i] = n-i+1;
        return arr;
    }
    
    // insertion sort
static void insertionSort(int arr[], int n)
    {
        for(int i=1; i<n; i++)
        {
            int j = i;
            int current = arr[j];
            arr[j] = arr[j-1];
            while(j > 0 && arr[j] > current)
            {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = current;
        }
    }
    
   //  merge sort merge step
    static void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1, n2 = r - m;
        int leftarr[] = new int[n1];
        int rightarr[] = new int[n2];
 
        for (int i = 0; i < n1; ++i)
        leftarr[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
        rightarr[j] = arr[m + 1 + j];
 
        int i = 0, j = 0;
 
        int k = l;
        while (i < n1 && j < n2)
        {
            if (leftarr[i] <= rightarr[j])
            {
                arr[k] = leftarr[i];
                i++;
            }
            else
            {
                arr[k] = rightarr[j];
                j++;
            }
            k++;
        }
 
        while (i < n1)
        {
            arr[k] = leftarr[i];
            i++;
            k++;
        }
 
        while (j < n2)
        {
            arr[k] = rightarr[j];
            j++;
            k++;
        }
    }
    
        //heapsort
 public static void heapsort(int arr[])
    {
        int N = arr.length;
 
        // Build heap (rearrange array)
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);
 
        // One by one extract an element from heap
        for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
    static void heapify(int arr[], int N, int i)
    {
        int largest = i; 
        int l = 2 * i + 1; 
        int r = 2 * i + 2; 
 
       
        if (l < N && arr[l] > arr[largest])
            largest = l;
 
     
        if (r < N && arr[r] > arr[largest])
            largest = r;
 
        
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
           
            heapify(arr, N, largest);
        }
    }
    // sorting step of merge sort
    static void mergeSort(int arr[], int l, int r)
    {
           if (l < r)
        {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void main(String[] args) {
		System.out.println("let start!!!!!");
               
		int n=500;
        long start, end;
        
        //for insertion sort
        int rArr[] = getRandomArray(n, 10, 1000);
    
        int iArr[] = getIncreasingArray(n);
        int dArr[] = getDecreasingArray(n);
        //for merge sort
        int rArr2[] = rArr.clone();
        int iArr2[] = iArr.clone();
        int dArr2[] = dArr.clone();
        // for heapsort
        int rArr3[] = rArr.clone();
        int iArr3[] = iArr.clone();
        int dArr3[] = dArr.clone();
        // for Quicksort
        int rArr4[] = rArr.clone();
        int iArr4[] = iArr.clone();
        int dArr4[] = dArr.clone();
        
        // sort all of them with different methods
        start = System.nanoTime();
        insertionSort(rArr, n);
        end = System.nanoTime();
        double insR = ((double)(end-start))/1000.0;
        start = System.nanoTime();
        insertionSort(iArr, n);
        end = System.nanoTime();
        double insI = ((double)(end-start))/1000.0;
        start = System.nanoTime();
        insertionSort(dArr, n);
        end = System.nanoTime();
        double insD = ((double)(end-start))/1000.0;
        start = System.nanoTime();
        mergeSort(rArr2, 0, n-1);
        end = System.nanoTime();
        double merR = ((double)(end-start))/1000.0;
        start = System.nanoTime();
        mergeSort(iArr2, 0, n-1);
        end = System.nanoTime();
        double merI = ((double)(end-start))/1000.0;
        start = System.nanoTime();
        mergeSort(dArr2, 0, n-1);
        end = System.nanoTime();
        double merD = ((double)(end-start))/1000.0;

        start = System.nanoTime();
        heapsort(rArr3);
        end = System.nanoTime();
        double heapR = ((double)(end-start))/1000.0;
         start = System.nanoTime();
        heapsort(iArr3);
        end = System.nanoTime();
        double heapI = ((double)(end-start))/1000.0;
         start = System.nanoTime();
        heapsort(dArr3);
        end = System.nanoTime();
        double heapD = ((double)(end-start))/1000.0;
        
//        start = System.nanoTime();
//        quickSort(rArr4, 0, n-1);
//        end = System.nanoTime();
//        double quickR = ((double)(end-start))/1000.0;
//         start = System.nanoTime();
//        quickSort(rArr4, 0, n-1);
//        end = System.nanoTime();
//        double quickI = ((double)(end-start))/1000.0;
//         start = System.nanoTime();
//        quickSort(rArr4, 0, n-1);
//        end = System.nanoTime();
//        double quickD = ((double)(end-start))/1000.0;
        System.out.println("\nn = "+n);
        System.out.println("\nTime taken for random array");
        System.out.println("Insertion sort: "+insR);
        System.out.println("Merge sort    :"+merR);
        System.out.println("Heap sort    :"+heapR);
        //System.out.println("Quick sort    :"+quickR);
        System.out.println("\nTime taken for increasing array");
        System.out.println("Insertion sort: "+insI);
        System.out.println("Merge sort    :"+merI);
        System.out.println("Heap sort    :"+heapI);
        //System.out.println("Quick sort    :"+quickI);
        System.out.println("\nTime taken for decreasing array");
        System.out.println("Insertion sort: "+insD);
        System.out.println("Merge sort    :"+merD);
        System.out.println("Heap sort    :"+heapD);
        //System.out.println("Quick sort    :"+quickD);
        
        
        
        System.out.println();

	}

   

}
