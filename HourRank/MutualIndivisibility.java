/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HourRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author chinemeremenumah
 */
public class MutualIndivisibility {
    
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        for(int a0 = 0; a0 < t; a0++){
//            int a = in.nextInt();
//            int b = in.nextInt();
//            int x = in.nextInt();
//            
//            System.out.println((checkIndivisibility(a,b,x)));
//        }
//        in.close();
        
        System.out.println((checkIndivisibility(4,10,7)));
    }
    
    static boolean isAllowed(int a, int b){
        
        if(a%b == 0 || b%a == 0) {
            return false;
        } else{
            System.out.println(a + " " +b);
            return true;
        }
    }
    
    
    static Set<Integer> checkIndivisibility(int a, int b, int x){
        
        Set<Integer> res = new HashSet<>();
        List<Integer> danger = new ArrayList<>();
        
        for(int i=a; i<=b; i++){
            for(int j=a; j<=b; j++){
               
               res.add(i);
               if(isAllowed(i,j) && !danger.contains(j)) {
                   res.add(j);
               }
               
               if(res.size()==x){
                   System.out.println(a);
                   System.out.println(danger);
                   return res;
               }
            }
            res.clear();
            danger.add(i); 
        }  
        return res;
    }
}
