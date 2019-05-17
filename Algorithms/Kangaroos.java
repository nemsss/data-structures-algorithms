/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

/**
 *
 * @author chinemeremenumah
 */
import java.util.Scanner;

public class Kangaroos {

    // Complete the kangaroo function below.
    static String kangaroo(int x1, int v1, int x2, int v2) {
        
        if(x2>x1 && v2>v1){
            return "NO";
        } else if(x2<x1 && v2<v1){
            return "NO";
        } else {
            int ahead = x2 > x1 ? 2 : 1;
            
            while(true){
                x1+= v1;
                x2+= v2;
                
                System.out.println(ahead +"but x1:"+x1+" x2:"+x2);
                
                if(ahead==1 && x1<x2){
                    return "NO";
                }
                
                if(ahead==2 && x2<x1){
                    return "NO";
                }
                
                if(x2 == x1){
                    return "YES";
                }
            }
            
        }

    }

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] x1V1X2V2 = scanner.nextLine().split(" ");

        int x1 = Integer.parseInt(x1V1X2V2[0]);

        int v1 = Integer.parseInt(x1V1X2V2[1]);

        int x2 = Integer.parseInt(x1V1X2V2[2]);

        int v2 = Integer.parseInt(x1V1X2V2[3]);

        String result = kangaroo(x1, v1, x2, v2);
        
        System.out.println(result);

        scanner.close();
    }
}

