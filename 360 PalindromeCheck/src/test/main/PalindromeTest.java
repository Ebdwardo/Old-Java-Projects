// Name of Author: Eduardo Teodosio Campuzano

package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Contains test cases to make sure isPalindrome() works correctly
 */
class PalindromeTest {

    /**
     *Checks to see is string contains an int
     */
    @Test
    void NumTest() {
        Palindrome palindrome = new Palindrome("123456");
        boolean expectedOutput = false;
        boolean actualOutput = palindrome.isPalindrome();
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     *Checks to see if given string is palindrome
     */
    @Test
    void isPalindrome(){
        Palindrome palindrome = new Palindrome("abba");
        boolean expectedOutput = true;
        boolean actualOutput = palindrome.isPalindrome();
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Checks to make suer string is not palindrome
     */
    @Test
    void isNotPalindrome(){
        Palindrome palindrome = new Palindrome("abda");
        boolean expectedOutput = false;
        boolean actualOutput = palindrome.isPalindrome();
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Checks to see if a palindrome with integers is flagged as not a palindrome
     */
    @Test
    void isPalindromeButWithNums(){
        Palindrome palindrome = new Palindrome("12aa21");
        boolean expectedOutput = false;
        boolean actualOutput = palindrome.isPalindrome();
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Checks to see if one letter is read as a palindrome
     */
    @Test
    void oneLetterPalindrome(){
        Palindrome palindrome = new Palindrome("a");
        boolean expectedOutput = true;
        boolean actualOutput = palindrome.isPalindrome();
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Checks to see if a single integer is read as a palindrome
     */
    @Test
    void oneNumPalindrome(){
        Palindrome palindrome = new Palindrome("1");
        boolean expectedOutput = false;
        boolean actualOutput = palindrome.isPalindrome();
        assertEquals(expectedOutput, actualOutput);
    }
}