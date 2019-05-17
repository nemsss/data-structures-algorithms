/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

/**
 *
 * @author chinemeremenumah
 */
public class Fibonacci {

    public static int fibonacci(int n) {

        switch (n) {
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                return fibonacci(n - 2) + fibonacci(n-1);
        }

    }
    
    public static void main(String[] args) {

        System.out.println(fibonacci(2));
    }

}
