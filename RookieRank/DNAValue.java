/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RookieRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author chinemeremenumah
 */
public class DNAValue {
    
    static List<Integer>getDNAValue(String s){
        
        int len = s.length();
        int k_max = len-1;
        List<Integer> res= new ArrayList<>();
        for(int i=0; i<len; i++){
            for(int k=k_max; k>=0; k--){
                System.out.println(s.substring(i - k + 1,i+1)+ " "+ s.substring(i, i + k)+ " "+s.substring(0, k)+" :"+k);
                
                       
                if (s.substring(i - k + 1,i+1).equals(s.substring(i, i + k)) && s.substring(i, i + k).equals(s.substring(0, k))){
                   res.add(k);
                   break;
                }
            }
        }
        return res;
    }
    
    static void main (String[] args){
        try (Scanner in = new Scanner(System.in)) {
            String s = in.next();
            
            System.out.println(getDNAValue(s));
        }
    }

}
