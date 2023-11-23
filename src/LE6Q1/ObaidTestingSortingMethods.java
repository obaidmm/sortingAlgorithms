package LE6Q1;

import java.util.*;
import java.util.List;

public class ObaidTestingSortingMethods {

    // Generic method to perform insertion sort
    public static < T extends Comparable <? super T >> long insertionSort(T[] a){
        long startTime = System.nanoTime(); // Start time for performance measurement

        int n = a.length; // Length of the array

        // Main loop for insertion sort
        for (int i = 1; i < n; i++) {
            T key = a[i];
            int j = i - 1;

            // Moving elements greater than key to one position ahead
            while (j >= 0 && a[j].compareTo(key) > 0) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }

        long endTime = System.nanoTime(); // End time for performance measurement
        return endTime - startTime; // Return the time taken for sorting
    }

    // Generic method to perform bubble sort
    public static < T extends Comparable <? super T >> long bubbleSort(T[] a){
        long startTime = System.nanoTime(); // Start time for performance measurement
        int n = a.length;

        // Main loop for bubble sort
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                // Comparing adjacent elements and swapping if necessary
                if(a[j].compareTo(a[j+1]) >0){
                    T temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }

        long endTime = System.nanoTime(); // End time for performance measurement
        return endTime - startTime; // Return the time taken for sorting
    }

    // Generic method to perform selection sort
    public static < T extends Comparable <? super T >> long selectionSort(T[] a){
        long startTime = System.nanoTime(); // Start time for performance measurement

        int n = a.length;

        // Main loop for selection sort
        for (int outerIndex = 0; outerIndex < n - 1; outerIndex++) {
            int indexOfNextSmallest = outerIndex;

            // Find the index of the smallest element
            for (int innerIndex = outerIndex + 1; innerIndex < n; innerIndex++) {
                if (a[innerIndex].compareTo(a[indexOfNextSmallest]) < 0) {
                    indexOfNextSmallest = innerIndex;
                }
            }

            // Swap the found smallest element with the current element
            T temp = a[outerIndex];
            a[outerIndex] = a[indexOfNextSmallest];
            a[indexOfNextSmallest] = temp;

        }

        long endTime = System.nanoTime(); // End time for performance measurement
        return endTime - startTime; // Return the time taken for sorting
    }

    // Generic method to perform merge sort
    public static <T extends Comparable<? super T>> long mergeSort(T[] S){
        long startTime = System.nanoTime(); // Start time for performance measurement

        int n = S.length;
        if (n < 2) return 0; // Base condition for recursion

        // Divide the array into two halves
        int mid = n / 2;
        T[] S1 = Arrays.copyOfRange(S, 0, mid);
        T[] S2 = Arrays.copyOfRange(S, mid, n);

        // Recursively sort both halves
        mergeSort(S1);
        mergeSort(S2);

        // Merge the sorted halves
        int i = 0, j = 0;
        while (i + j < S.length) {
            if (j == S2.length || (i < S1.length && S1[i].compareTo(S2[j]) < 0)) {
                S[i + j] = S1[i++];
            } else {
                S[i + j] = S2[j++];
            }
        }

        long endTime = System.nanoTime(); // End time for performance measurement
        return endTime - startTime; // Return the time taken for sorting
    }

    // Generic method to perform quick sort
    public static <T extends Comparable<? super T>> long quickSort(T[] S, int a, int b){
        long startTime = System.nanoTime(); // Start time for performance measurement

        if (a >= b) {
            return 0; // Base condition for recursion
        }

        // Pivot selection and partitioning logic
        T p = S[b];
        int l = a; // Left pointer
        int r = b - 1; // Right pointer

        while (l <= r) {
            // Find elements to swap
            while (l <= r && S[l].compareTo(p) <= 0) {
                l++;
            }
            while (l <= r && S[r].compareTo(p) >= 0) {
                r--;
            }
            if (l < r) {
                // Swap elements
                T temp = S[l];
                S[l] = S[r];
                S[r] = temp;
                l++;
                r--;
            }
        }

        // Final placement of the pivot
        T temp = S[l];
        S[l] = S[b];
        S[b] = temp;

        // Recursive calls for subarrays
        quickSort(S, a, l - 1);
        quickSort(S, l + 1, b);

        long endTime = System.nanoTime(); // End time for performance measurement
        return endTime - startTime; // Return the time taken for sorting
    }

    // Generic method to perform bucket sort
    public static long bucketSort(Integer[] a, int first, int last, int maxDigits) {
        long startTime = System.nanoTime(); // Start time for performance measurement

        Vector<Integer>[] bucket = new Vector[10]; // Array of buckets

        // Initialize buckets
        for (int i = 0; i < 10; i++)
            bucket[i] = new Vector<>();

        // Sorting logic
        for (int i = 0; i < maxDigits; i++) {
            for (int j = 0; j < 10; j++) {
                bucket[j].removeAllElements();
            }

            for (int index = first; index <= last; index++) {
                Integer digit = findDigit(a[index], i);
                bucket[digit].add(a[index]);
            }

            // Collecting elements from buckets
            int index = 0;
            for (int m = 0; m < 10; m++) {
                for (int n = 0; n < bucket[m].size(); n++) {
                    a[index++] = bucket[m].get(n);
                }
            }
        }

        long endTime = System.nanoTime(); // End time for performance measurement
        return endTime - startTime; // Return the time taken for sorting
    }

    // Helper method to find a digit in a specific position
    public static Integer findDigit(Integer number, int i) {
        int target = 0;
        for (int k = 0; k <= i; k++) {
            target = number % 10;
            number = number / 10;
        }
        return target;
    }


    public static void main(String[] args) {

/*        myHeader(6,1);

        Integer sz = 5, backUp = 5;

        // populate the array with random values from 13-93
        Integer[] randomNumbers = new Integer[sz];
        Integer[] backUpArray = new Integer[sz];

        for (int i = 0; i < sz; i++) {
            randomNumbers[i] = (int) (Math.random() * (93 - 13 + 1) + 13);
        }

        // this will copy the array
        System.arraycopy(randomNumbers, 0, backUpArray, 0, sz);

        List<Integer> list = Arrays.asList(randomNumbers);

        System.out.println("Testing execution time of different sorting methods for sorting 5 random numbers: ");

        // Print both the sorted and unsorted arrays
        System.out.println("The unsorted list: " + list);

        // calling collections methods
        long startTime = System.nanoTime();
        Collections.sort(list);
        long endTime = System.nanoTime();

        System.out.printf("Collections' Sorting Time: %.2f milliseconds%n", (endTime - startTime) / 1_000_000.0);
        System.out.println("The sorted list with Collections-sort: " + list);

        System.out.println("");
        //copying the backup array
        System.arraycopy(backUpArray, 0, randomNumbers, 0, sz);
        // call the selectionSort method
        System.out.println("The unsorted list: " + Arrays.asList(randomNumbers));
        long selectionSortTime = selectionSort(randomNumbers);
        System.out.printf("My Selection-Sort Time: %.2f milliseconds%n", selectionSortTime / 1_000_000.0);
        System.out.println("The sorted list with Selection-sort: " + Arrays.asList(randomNumbers));


        System.arraycopy(backUpArray, 0, randomNumbers, 0, sz);
        // call the bubble
        System.out.println("\nThe unsorted list: " + Arrays.asList(randomNumbers));
        long bubbleSortTime = bubbleSort(randomNumbers);
        System.out.printf("My Bubble-Sort Time: %.2f milliseconds%n", bubbleSortTime / 1_000_000.0);
        System.out.println("The sorted list with Bubble-sort: " + Arrays.asList(randomNumbers));


        System.arraycopy(backUpArray, 0, randomNumbers, 0, sz);
        // call the insertion
        System.out.println("\nThe unsorted list: " + Arrays.asList(randomNumbers));
        long insertionSortTime = insertionSort(randomNumbers);
        System.out.printf("My Insertion-Sort Time: %.2f milliseconds%n", insertionSortTime / 1_000_000.0);
        System.out.println("The sorted list with Insertion-sort: " + Arrays.asList(randomNumbers));


        System.arraycopy(backUpArray, 0, randomNumbers, 0, sz);
        System.out.println("\nThe unsorted list: " + Arrays.asList(randomNumbers));
        long mergeSortTime = mergeSort(randomNumbers);
        System.out.printf("My Merge-Sort Time: %.2f milliseconds%n", mergeSortTime / 1_000_000.0);
        System.out.println("The sorted list with Merge-sort: " + Arrays.asList(randomNumbers));


        System.arraycopy(backUpArray, 0, randomNumbers, 0, sz);
        System.out.println("\nThe unsorted list: " + Arrays.asList(randomNumbers));
        long quickSortTime = quickSort(randomNumbers, 0, sz - 1);
        System.out.printf("My Quick-Sort Time: %.2f milliseconds%n", quickSortTime / 1_000_000.0);
        System.out.println("The sorted list with Quick-sort: " + Arrays.asList(randomNumbers));


        System.arraycopy(backUpArray, 0, randomNumbers, 0, sz);
        System.out.println("\nThe unsorted list: " + Arrays.asList(randomNumbers));
        long bucketSortTime = bucketSort(randomNumbers, 0, sz - 1, sz);

        System.out.printf("My Bucket-Sort Time: %.2f milliseconds%n", bucketSortTime / 1_000_000.0);
        System.out.println("The sorted list with Bucket-sort: " + Arrays.asList(randomNumbers));*/

        Integer sz = 50000;

        // populate the array with random values from 13-93
        Integer[] randomNumbers = new Integer[sz];
        Integer[] backUpArray = new Integer[sz];

        for (int i = 0; i < sz; i++) {
            randomNumbers[i] = (int) (Math.random() * (93 - 13 + 1) + 13);
        }

        System.arraycopy(randomNumbers, 0, backUpArray, 0, sz);

        List<Integer> list = Arrays.asList(randomNumbers);

        System.out.println("Testing execution time of different sorting methods for sorting 5 random numbers: ");


        // calling collections methods
        long startTime = System.nanoTime();
        Collections.sort(list);
        long endTime = System.nanoTime();

        System.out.printf("Collections' Sorting Time: %.2f milliseconds%n", (endTime - startTime) / 1_000_000.0);

        //copying the backup array
        System.arraycopy(backUpArray, 0, randomNumbers, 0, sz);
        // call the selectionSort method
        long selectionSortTime = selectionSort(randomNumbers);
        System.out.printf("My Selection-Sort Time: %.2f milliseconds%n", selectionSortTime / 1_000_000.0);

        System.arraycopy(backUpArray, 0, randomNumbers, 0, sz);
        // call the bubble
        long bubbleSortTime = bubbleSort(randomNumbers);
        System.out.printf("My Bubble-Sort Time: %.2f milliseconds%n", bubbleSortTime / 1_000_000.0);

        System.arraycopy(backUpArray, 0, randomNumbers, 0, sz);
        // call the insertion
        long insertionSortTime = insertionSort(randomNumbers);
        System.out.printf("My Insertion-Sort Time: %.2f milliseconds%n", insertionSortTime / 1_000_000.0);

        System.arraycopy(backUpArray, 0, randomNumbers, 0, sz);
        long mergeSortTime = mergeSort(randomNumbers);
        System.out.printf("My Merge-Sort Time: %.2f milliseconds%n", mergeSortTime / 1_000_000.0);

        System.arraycopy(backUpArray, 0, randomNumbers, 0, sz);
        long quickSortTime = quickSort(randomNumbers, 0, sz - 1);
        System.out.printf("My Quick-Sort Time: %.2f milliseconds%n", quickSortTime / 1_000_000.0);

        System.arraycopy(backUpArray, 0, randomNumbers, 0, sz);

        long bucketStartTime = System.nanoTime();
        bucketSort(randomNumbers, 0, sz - 1, 5);
        long bucketEndTime = System.nanoTime();

        System.out.printf("My Bucket-Sort Time: %.2f milliseconds%n", (bucketEndTime - bucketStartTime)/ 1_000_000.0);

        myFooter(6,1);

    }

    public static void myHeader(int a, int b) {
        System.out.print("=======================================================\n");
        System.out.printf("Lab Exercise %d-Q%d\n", a, b);
        System.out.print("Prepared By: Obaid Mohiuddin\n");
        System.out.print("Student Number: 251276594\n");
        System.out.print("Goal of this Exercise: Testing compute times of sorting algorithms!\n");
        System.out.print("=======================================================\n");
    }

    public static void myFooter(int a, int b) {
        System.out.print("=======================================================\n");
        System.out.printf("Completion of Lab Exercise %d-Q%d is successful!%n", a, b);
        System.out.print("Signing off - Obaid.\n");
        System.out.print("=======================================================");
    }


}