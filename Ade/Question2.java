/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ade;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author chinemeremenumah
 */
public class Question2 {
    
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        long res;
        int _n;
        _n = Integer.parseInt(in.nextLine().trim());
        
        res = countSteps(_n);
        bw.write(String.valueOf(res));
        bw.newLine();
        
        bw.close();
    }
    
    static long countSteps(int n) {
        if (n==0){
            return 0;
        }
        else if (n==1){
            return 1;
        }
        else if(n==2){
            return 2;
        }
        
        return countSteps(n-1)+countSteps(n-2)+countSteps(n-3);
        
    }
}
