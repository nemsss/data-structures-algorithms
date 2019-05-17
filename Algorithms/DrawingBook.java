/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import java.util.*;
import java.io.*;

/**
 *
 * @author chinemeremenumah
 */
public class DrawingBook {

    static int pageCount(int n, int page) {
        
        if(n%2==0){
            n++;
        }
        if(n-page > page){
            return page/2;
        } else {
            return (n-page)/2;
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = pageCount(n, p);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}


