package LE6Q2;

import java.util.Collections;
import java.util.Vector;

public class Obaid_SortNameAndGrade {

    public static void main(String[] args) {
        // Displaying header information for the program
        myHeader(6,2);

        // Initializing arrays with student first names, last names, and randomly generated grades
        String[] fnArray = {"Hermione", "Ron", "Harry", "Luna", "Ginny", "Draco", "Dean", "Fred"};
        String[] lnArray = {"Granger", "Weasley", "Potter", "Lovegood", "Weasley", "Malfoy", "Thomas", "Weasley"};
        Integer[] grd = {(int)(60 + Math.random() * 26), (int)(60 + Math.random() * 26),
                (int)(60 + Math.random() * 26), (int)(60 + Math.random() * 26),
                (int)(60 + Math.random() * 26), (int)(60 + Math.random() * 26),
                (int)(60 + Math.random() * 26), (int)(60 + Math.random() * 26)};

        // Creating a vector to store StudentGrade objects
        Vector<StudentGrade> sg = new Vector<>();

        // Populating the vector with StudentGrade objects created from the arrays
        for (int i = 0; i < fnArray.length; i++) {
            sg.add(new StudentGrade(fnArray[i], lnArray[i], grd[i]));
        }

        // Displaying the unsorted list of students
        System.out.println("The Unsorted Array ................");
        System.out.println(sg+"\b\b"); // Displaying using vector's toString method

        // Sorting the vector by grades (assumes StudentGrade implements Comparable)
        Collections.sort(sg);
        System.out.println("\nSorted by Grades ..................");
        System.out.println(sg+"\b\b"); // Displaying the sorted list

        // Converting the vector to an array for further sorting
        StudentGrade[] arr = new StudentGrade[fnArray.length];
        sg.copyInto(arr);

        // Sorting by first name using insertion sort and displaying the results
        insertionSort(arr, 1);
        System.out.println("\nSorted by First Name ..............");
        printArray(arr);

        // Sorting by last name using insertion sort and displaying the results
        insertionSort(arr, 2);
        System.out.println("\nSorted by Last Names ..............");
        printArray(arr);

        // Displaying footer information for the program
        myFooter(6,2);

    }

    // Method for insertion sort on StudentGrade array
    public static void insertionSort(StudentGrade[] a, int key){
        // Sorting based on first name
        if (key == 1){
            for (int i = 1; i < a.length; i++) {
                StudentGrade key1 = a[i];
                int j = i - 1;
                while (j >= 0 && a[j].getFirstName().compareTo(key1.getFirstName()) > 0) {
                    a[j+1] = a[j];
                    j--;
                }
                a[j+1] = key1;
            }
        }
        // Sorting based on last name
        else if (key == 2){
            for (int i = 1; i < a.length; i++) {
                StudentGrade key2 = a[i];
                int j = i - 1;
                while (j >= 0 && a[j].getLastName().compareTo(key2.getLastName()) > 0) {
                    a[j+1] = a[j];
                    j--;
                }
                a[j+1] = key2;
            }
        }
    }

    // Method to print elements of the StudentGrade array
    public static void printArray(StudentGrade[] array){
        for (StudentGrade item : array) {
            System.out.print(item);
        }
        System.out.println();
    }

    // Method to print the header information
    public static void myHeader(int a, int b) {
        System.out.print("=======================================================\n");
        System.out.printf("Lab Exercise %d-Q%d\n", a, b);
        System.out.print("Prepared By: Obaid Mohiuddin\n");
        System.out.print("Student Number: 251276594\n");
        System.out.print("Goal of this Exercise: Comparing the Grades and Names of Students!\n");
        System.out.print("=======================================================\n");
    }

    // Method to print the footer information
    public static void myFooter(int a, int b) {
        System.out.print("=======================================================\n");
        System.out.printf("Completion of Lab Exercise %d-Q%d is successful!%n", a, b);
        System.out.print("Signing off - Obaid.\n");
        System.out.print("=======================================================");
    }
}
