/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RookieRank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author chinemeremenumah
 */
public class ServerRoomSafety {
    
    static String checkAll(int n, int[] height, int[] position) {
        
        int len = n-1;
        //List<Integer> pos = Arrays.stream(position).boxed().collect(Collectors.toList());
        Map<Integer, Boolean> leftPos = new HashMap<>();
        Map<Integer, Boolean> rightPos = new HashMap<>();

        for(int i=0; i<len; i++){
            for(int k=i+1; k<=len; k++){
                if(leftFalls(position[i], height[i], position[k])){
                    if(leftPos.get(position[k]) == null){
                        leftPos.put(position[k], true);
                    }
                } else {
                    break; 
                }
            }
        }
        boolean left = leftPos.values().size() != len;

        for(int i=len; i>0; i--){
            for(int j=i-1; j>=0; j--){
                if(rightFalls(position[i], height[i], position[j])){
                    if(rightPos.get(position[j])==null){
                        rightPos.put(position[j], true);
                    }
                } else {
                    break; 
                }
            }
        }
        boolean right = rightPos.values().size() != len;
  
        if(!left && !right){
            return "BOTH";
        } else if(right && !left){
            return "LEFT";
        } else if(left && !right){
            return "RIGHT";
        } else{
            return "NONE";
        }
    }
    
    static boolean leftFalls(int p1, int h, int p2){
        
        return p1+h >= p2;
    }
    
    static boolean rightFalls(int p1, int h, int p2){
        
        return p1-h <= p2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] position = new int[n];
//        for(int position_i = 0; position_i < n; position_i++){
//            position[position_i] = in.nextInt();
//        }
//        int[] height = new int[n];
//        for(int height_i = 0; height_i < n; height_i++){
//            height[height_i] = in.nextInt();
//        }

        int[] position = new int[] {1,2,3,4,8};
        int[] height = new int[] {1,1,1,1,1};
        String ret = checkAll(5, height, position);
        System.out.println(ret);
        in.close();
    }
}
