package edu.course.lab01;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CourseToolkitTest {

    @Test
    void returnsTrueForEvenNumber() {
        boolean result = CourseToolkit.isEven(8);

        assertTrue(result);
    }

    @Test
    void returnsFalseForOddNumber() {
        boolean result = CourseToolkit.isEven(7);

        assertFalse(result);
    }
    @Test
    void returnsTrueForPositiveEvenNumber() {
        assertTrue(CourseToolkit.isEven(4));
    }

    @Test
    void returnsFalseForPositiveOddNumber() {
        assertFalse(CourseToolkit.isEven(5));
    }

    @Test
    void returnsTrueForNegativeEvenNumber() {
        assertTrue(CourseToolkit.isEven(-8));
    }

    @Test
    void isPrimeReturnsFalseForNumbersLessThanTwo() {
        assertFalse(CourseToolkit.isPrime(-7));
        assertFalse(CourseToolkit.isPrime(0));
        assertFalse(CourseToolkit.isPrime(1));
    }

    @Test
    void isPrimeReturnsTrueForTwoAndOddPrimes() {
        assertTrue(CourseToolkit.isPrime(2));
        assertTrue(CourseToolkit.isPrime(3));
        assertTrue(CourseToolkit.isPrime(13));
        assertTrue(CourseToolkit.isPrime(97));
    }

    @Test
    void isPrimeReturnsFalseForCompositeNumbers() {
        assertFalse(CourseToolkit.isPrime(4));
        assertFalse(CourseToolkit.isPrime(9));
        assertFalse(CourseToolkit.isPrime(15));
        assertFalse(CourseToolkit.isPrime(100));
    }

    @Test
    void isPrimeReturnsFalseForSquareOfPrime() {
        assertFalse(CourseToolkit.isPrime(49));
        assertFalse(CourseToolkit.isPrime(121));
    }

    @Test
    void isPalindromeReturnsTrueForExactPalindrome() {
        assertTrue(CourseToolkit.isPalindrome("level"));
        assertTrue(CourseToolkit.isPalindrome(""));
        assertTrue(CourseToolkit.isPalindrome("a"));
    }

    @Test
    void isPalindromeIsCaseSensitive() {
        assertFalse(CourseToolkit.isPalindrome("Level"));
    }

    @Test
    void isPalindromeTreatsSpacesAsSignificant() {
        assertFalse(CourseToolkit.isPalindrome("never odd or even"));
        assertFalse(CourseToolkit.isPalindrome("ab a"));
    }

    @Test
    void isPalindromeThrowsForNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> CourseToolkit.isPalindrome(null)
        );
    }

    @Test
    void averageReturnsFractionalResult() {
        assertEquals(2.5, CourseToolkit.average(new int[]{1, 2, 3, 4}), 1e-9);
    }

    @Test
    void averageHandlesNegativeValues() {
        assertEquals(-3.0, CourseToolkit.average(new int[]{-2, -4}), 1e-9);
    }

    @Test
    void averageDoesNotModifyInputArray() {
        int[] values = {1, 2, 3};

        CourseToolkit.average(values);

        assertArrayEquals(new int[]{1, 2, 3}, values);
    }

    @Test
    void averageThrowsForNullOrEmptyArray() {
        assertThrows(
                IllegalArgumentException.class,
                () -> CourseToolkit.average(null)
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> CourseToolkit.average(new int[]{})
        );
    }

    @Test
    void minReturnsSmallestValue() {
        assertEquals(-5, CourseToolkit.min(new int[]{3, -5, 10}));
    }

    @Test
    void maxReturnsLargestValue() {
        assertEquals(10, CourseToolkit.max(new int[]{3, -5, 10}));
    }

    @Test
    void minAndMaxThrowForNullOrEmptyArray() {
        assertThrows(
                IllegalArgumentException.class,
                () -> CourseToolkit.min(null)
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> CourseToolkit.max(new int[]{})
        );
    }
}