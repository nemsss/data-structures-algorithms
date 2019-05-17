package Algorithms;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

    static Stack<Character> stack;

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (!corresponds(c)) {
                    return "NO";
                }
                stack.pop();
            }
        }
        System.out.println();
        System.out.println(stack);
        return stack.size() == 0 ? "YES" : "NO";
    }

    private static boolean corresponds(char c) {
        switch (c) {
            case ')':
                return stack.peek() == '(';
            case '}':
                return stack.peek() == '{';
            case ']':
                return stack.peek() == '[';
            default:
                return false;
        }
    }

    public static void main(String[] args) {

        System.out.println(isBalanced("{{[[(())]]}}"));
        System.out.println(isBalanced("{[(])}"));
        System.out.println(isBalanced("{[]}"));
    }
}

