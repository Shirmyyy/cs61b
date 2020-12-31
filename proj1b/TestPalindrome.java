import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } 
    
    @Test
    public void testisPalindrome() {
        assertTrue(palindrome.isPalindrome("b"));
        assertTrue(palindrome.isPalindrome("xoox"));
        assertTrue(palindrome.isPalindrome("  "));
        assertTrue(palindrome.isPalindrome("7887"));
        assertFalse(palindrome.isPalindrome("fgte"));
        assertTrue(palindrome.isPalindrome("sdds"));
        assertTrue(palindrome.isPalindrome("*^^*"));
        assertTrue(palindrome.isPalindrome(""));
        assertFalse(palindrome.isPalindrome("hgfd"));
        assertFalse(palindrome.isPalindrome("hytrf"));
    }
    
    @Test
    public void testisPalindrome2() {
        OffByOne o = new OffByOne();
        assertTrue(palindrome.isPalindrome("flake", o));
        assertTrue(palindrome.isPalindrome("3", o));
        assertTrue(palindrome.isPalindrome("", o));
        assertTrue(palindrome.isPalindrome("gabf", o));
        assertFalse(palindrome.isPalindrome("adda", o));
        assertFalse(palindrome.isPalindrome("  ", o));
        assertFalse(palindrome.isPalindrome("sssda", o));
        assertFalse(palindrome.isPalindrome("fjdsa", o));
    }

}
