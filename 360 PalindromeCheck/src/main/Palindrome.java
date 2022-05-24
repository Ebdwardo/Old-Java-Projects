// Name of Author: Eduardo Teodosio Campuzano

package main;

/**
 * Whenever you create a Palindrome object you must specify a string in the constructor.
 * Has the ability to check if the object is a palindrome
 */
public class Palindrome {
    private String testString;

    /**
     *Constructor
     * @param test Palindrome string
     */
    Palindrome(String test){
        testString = test;
    }

    /**
     *Goes through the string and checks if each letter is in the right position when reversed
     * @return true if the string is a palindrome and vice versa
     */
    public boolean isPalindrome(){
        int beginStr = 0, endStr = testString.length()-1;
        boolean palindrome = true;
        while( beginStr <= endStr ){
            if (testString.charAt(beginStr) != testString.charAt(endStr))
                palindrome = false;
            if (Character.isDigit(testString.charAt(beginStr)) || Character.isDigit(testString.charAt(endStr)) )
                palindrome = false;
            beginStr++;
            endStr--;
        }
        return palindrome;
    }
}

