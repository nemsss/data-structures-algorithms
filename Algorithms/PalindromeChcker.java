package Algorithms;

import java.util.Arrays;
import java.util.LinkedList;

public class PalindromeChcker {

    private char [] stack = new char[100];
    private int top = -1;

    void pushCharacter (char c) {
        stack[++top] = c;
    }

    char popCharacter () {
        return stack[top--];
    }

    private LinkedList<Character> queue = new LinkedList<>();

    void enqueueCharacter (char c) {
        queue.addLast(c);
    }

    char dequeueCharacter () {
        return queue.removeFirst();
    }

    public static void main (String[] args){

        PalindromeChcker p = new PalindromeChcker();

        char[] s = "racecar".toCharArray();
        for (char c : s) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length/2; i++) {
            char st = p.popCharacter();
            char qu = p.dequeueCharacter();
            if (st != qu) {
                isPalindrome = false;
                break;
            }
        }

        //Finally, print whether string s is palindrome or not.
        System.out.println( "The word, " + Arrays.toString(s) + ", is "
                + ( (!isPalindrome) ? "not a palindrome." : "a palindrome." ) );
    }
}
