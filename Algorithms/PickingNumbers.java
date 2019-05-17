package Algorithms;

import Util.NemeList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PickingNumbers {

    public static void main (String [] args){
        List<Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(6);
        numbers.add(5);
        numbers.add(3);
        numbers.add(3);
        numbers.add(1);

//        numbers.add(1);
//        numbers.add(1);
//        numbers.add(2);
//        numbers.add(2);
//        numbers.add(4);
//        numbers.add(4);
//        numbers.add(4);
//        numbers.add(5);
//        numbers.add(5);
        System.out.println(pickingNumbers(numbers));
    }

    private static int pickingNumbers(List<Integer> a) {
        // Write your code here
        int limit = a.size() - 1;
        NemeList<Integer> pointCuts = new NemeList<>();
        pointCuts.add(0);
        List<Integer> interim = new ArrayList<>();

        for(int i=0; i<limit; i++){
            interim.addAll(a.subList(pointCuts.getLast(), i+1));
            if((Collections.max(interim) - Collections.min(interim)) > 1){
                pointCuts.add(i+1);
            }
            interim.clear();
        }
        if(!pointCuts.get(pointCuts.size() - 1).equals(a.get(limit))){
            pointCuts.add(limit+1);
        }
        int res = 0;
        limit = pointCuts.size()-1;
        for(int i=0; i<limit; i++){
            int diff = pointCuts.get(i+1) - pointCuts.get(i);
            res = diff > res ? diff : res;
        }

        return res;
    }
}
