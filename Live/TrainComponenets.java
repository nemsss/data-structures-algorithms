/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Live;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author chinemeremenumah
 */
public class TrainComponenets {
    
   
    static String berthType(int n) {
       
        //LB, MB, UB, SLB, SUB
        if(n<1 || n>72){
            return"";
        }
        switch (n%8) {
            case 0:
                return "SUB";
            case 7:
                return "SLB";
            case 5:
            case 2:
                return "MB";
            case 6:
            case 3:
                return "UB"; 
            default:
                return "LB";
        }

    }

    public static void main(String[] args) throws IOException {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();

        for(int i =1; i<=72;i++){
            System.out.println(berthType(i));
        }
        
        
    }
}
