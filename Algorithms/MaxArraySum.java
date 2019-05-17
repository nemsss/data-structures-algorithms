package Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxArraySum {

    public static void main (String[] args){
        int[] arr = new int[]{3,5,-7,8,10};
        System.out.println(getMaxArrSum(arr));
    }

    //https://www.hackerrank.com/challenges/max-array-sum/problem?h_l=interview&
    // playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dynamic-programming

    private static int getMaxArrSum(int[] arr) {
        int length = arr.length;
        if(length <=2){
            return 0;
        }

        int max =0;
        for(int i=0; i<length; i++){
            List<List<Integer>> indexes = getIndexes(i, arr.length-1);
            for(List list: indexes){
                int sum = getSum(list, arr);
                max = sum > max ? sum : max;
            }
        }

        return max;
    }

    private static int getSum(List<Integer> indexes, int[] arr) {
        int sum = 0;
        for(int i : indexes){
            sum +=arr[i];
        }
        return sum;
    }

    private static List<List<Integer>> getIndexes (int start, int end){
        List<List<Integer>> list = new ArrayList<>();

        //2-length arrays
        List<Integer> pair = new ArrayList<>();
        int idx = start;
        while(idx < end){
            idx += list.size() > 0 ? 1 : 2;
            if(idx > end){
                break;
            }
            pair.add(start);
            pair.add(idx);
            list.add(pair);
            pair = new ArrayList<>();
        }

        //Longer sub-arrays
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> supp = new ArrayList<>();
        for(List<Integer> idxs : list){
            temp = new ArrayList<>();
            temp.addAll(idxs);
            int test = idxs.get(1);
            while(test+2 <= end){
                test+=2;
                temp.add(test);
                List<Integer> toAdd = new ArrayList<>(temp);
                supp.add(toAdd);
            }

        }
        list.addAll(supp);
        return list;
    }

    private static int oldMethod(int [] arr){
        int max = 0;

        int length = arr.length;
        if(length <=2){
            return 0;
        }

        for(int i=0; i<(length-2); i++){
            int sum = arr[i];
            int idx = i;
            int maxSubLen = (length-i) % 2 == 0 ? (length-i)/2 : ((length-i) + 1)/2;
            boolean jumped = false;
            for(int size=1; size<maxSubLen; size++){
                sum += arr[idx+(jumped? 2 : 1)];
                jumped = true;
                max = sum > max ? sum : max;
                idx += 2;
            }
        }

        return max;
    }
}
