/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCI;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author chinemeremenumah
 */
public class LonelyInteger {
        
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for(int a_i=0; a_i < n; a_i++){
            int a = in.nextInt();
            if(map.containsKey(a)){
                map.remove(a);
            } else {
                map.put(a, 1);
            }
        }
        
        System.out.println(map.keySet().iterator().next());
        
    }
    
}
