package DailyProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PairsToSum {
//    Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
//
//    For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
//
//    Bonus: Can you do this in one pass?

    public static void main (String [] args){

        int val = 11;
        List<Integer> nums = new ArrayList<>();
        //Collections.addAll(nums, 1,3,4,8);
        boolean found = false;
        
        for(int num : nums){
            int comp = val - num;
            if(comp == num){
                if(nums.indexOf(comp) != nums.lastIndexOf(comp)){
                    System.out.println("True");
                    found = true;
                    break;
                }
            } else {
                if(nums.contains(comp)){
                    System.out.println("true");
                    found = true;
                    break;
                }
            }
        }
        if(!found) System.out.println("false");
    }
}
