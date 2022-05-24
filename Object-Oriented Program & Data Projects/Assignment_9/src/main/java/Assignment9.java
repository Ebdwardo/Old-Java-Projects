//         Name: Eduardo Teodosio Campuzano
//  Description: Assignment #9 will be the construction of a program that reads in a sequence
//  of integers from standard input until 0 is read, and store them in an array (including 0).
//  This is done using iteration (choose one of for, while, or do while loop).
//  You may assume that there will not be more than 100 numbers.
//  Then compute the minimum number, count odd integers,
//  compute the sum of numbers that are larger than the first number in the array,
//  and compute the largest even integer in the sequence using recursion.
//  Thus, you will create recursive methods findMin, countOddNumbers, computeLargestEven,
//  and sumOfNumbersLargerThanFirst in Assignment9 class and they will be called by a main method.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Assignment9 {
    public static void main(String[] args) throws IOException {
        //Here I initialize the int array along with the input reader and buffered reader and other variables
        int[] arr = new int[100];
        InputStreamReader isr = new InputStreamReader(System.in);  //I create this input reader to pass to the buffered reader
        BufferedReader br = new BufferedReader(isr); // I pass it the InputStreamReader and I will use it to take input from the user.
        int start = 0;
        int end = 0;

        //Here is where i fill my array with values taken from the user by parsing whatever the buffered reader takes.
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            end++;
            if (arr[i] == 0) {             //Here is where if the user enters a zero it stops collecting numbers and proceeds to run display what the other methods find
                break;
            }
        }
        System.out.println("The minimum number is " + findMin(arr, start, end));                                                    //displays the min in the array
        System.out.println("The count of odd integers in the sequence is " + countOddNumbers(arr, start, end));                     //displays the number of odd integers in the array
        System.out.println("The largest even integer in the sequence is " + computeLargestEven(arr, start, end));                   //displays the largest even number
        System.out.println("The sum of numbers larger than the first is " + sumOfNumbersLargerThanFirst(arr, start, end, arr[0]));  //displays the sum of numbers larger than the first
    }// end of main

    public static int findMin(int[] numbers, int startIndex, int endIndex) {
        //Base case
        int min;
        if (startIndex == endIndex)
            return numbers[startIndex];

        else {
            //Here is the recursive part. We go to the end of the list and work our way backwards comparing each value to the one ahead and if it is less we pass that value to min and keep comparing until we get the minimum value
            min = findMin(numbers, startIndex + 1, endIndex);
            if (numbers[startIndex] <= min)
                return numbers[startIndex];
            else
                return min;
        }
    }


    public static int countOddNumbers(int[] elements, int startIndex, int endIndex) {
        //Base case
        if (elements.length == 1) {
            if (elements[0] % 2 != 0) {
                return 1;
            } else return 0;
        }
        if (startIndex == endIndex) {
            if (elements[startIndex] % 2 != 0) {
                return 1;
            }
            return 0;
        }
        // Here is the recursive part we go to the end of the list and and one whenever we get an odd number
        int oddNumbers = countOddNumbers(elements, startIndex + 1, endIndex);
        if (elements[startIndex] % 2 != 0) {
            oddNumbers += 1;
        }
        return oddNumbers;
    }


    public static int computeLargestEven(int[] elements, int startIndex, int endIndex) {
        //Base case
        if (elements.length == 1) {
            if (elements[0] % 2 == 0) return elements[0];
            return 0;
        }
        if (startIndex == endIndex) {
            if (elements[startIndex] % 2 == 0)
                return elements[startIndex];
            return Integer.MIN_VALUE;
        }

        // Here is the recursive part. We go to the end of the list, check it to see if it is even and if so we then compare it to our last biggest even number until we find the biggest even number
        int largestEven = computeLargestEven(elements, startIndex + 1, endIndex);
        if (elements[startIndex] % 2 == 0) {
            if (elements[startIndex] > largestEven)
                return elements[startIndex];
            return largestEven;

        }
        return largestEven;

    }


    public static int sumOfNumbersLargerThanFirst(int[] elements, int startIndex, int endIndex, int firstNumber) {

        //base case
        if (elements.length == 1)
            return 0;
        if (startIndex == endIndex) {
            if (elements[startIndex] > firstNumber)
                return elements[startIndex];
            return 0;
        }

        //Here is the recursive part. We go to the end of the list and start working our way back add all numbers larger than the first.
        int next = sumOfNumbersLargerThanFirst(elements, startIndex + 1, endIndex, firstNumber);
        if (elements[startIndex] > firstNumber)
            next += elements[startIndex];


        return next;
    }
}
