package Google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MockSession1 {

    // Get the minimum set of intervals from a list of intervals that contain a target interval.

    public static void main (String[] args){

        List<Interval> intervals = new ArrayList<>();

        intervals.add(new Interval(1,5));
//        intervals.add(new Interval(-3,8));
//        intervals.add(new Interval(2,9));
//        intervals.add(new Interval(5,15));
//        intervals.add(new Interval(4,9));
//        intervals.add(new Interval(4,5));

        System.out.println(getMinimumList(intervals, new Interval(20,100)));

    }

    static class Interval implements Comparable<Interval>{
        int start;
        int end;

        Interval(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval o) {
            if(this.start > o.start){
                return 1;
            } else if(this.start == o.start){
                if(this.end > o.end){
                    return 1;
                } else if(this.end < o.end){
                    return -1;
                } else {
                    return 0;
                }
            } else {
                return -1;
            }
        }

        public boolean contains(int searchVal){
            return this.start <= searchVal && this.end >=searchVal;
        }
    }

    static List<Interval> getMinimumList(List<Interval> intervals, Interval target){

        if(target == null || intervals.isEmpty()){
            return new ArrayList<>();
        }

        //PS can the target.end be < the target.start ?
        //Or can the targets be backwards instead of forwards generally?

        List<Interval> result = new ArrayList<>();

        Collections.sort(intervals);
        int searchval = target.start;
        List<Interval> potentials = new ArrayList<>();

        for(Interval interval : intervals){
            if(interval.contains(searchval)){
                potentials.add(interval);
            } else {
                if(!potentials.isEmpty()){
                    Interval lastAddition = potentials.get(potentials.size()-1);
                    searchval = lastAddition.end;
                    result.add(lastAddition);
                    potentials.clear();
                    if(searchval > target.end){
                        return result;
                    }
                }
            }
        }

        if(!potentials.isEmpty()){
            Interval lastAddition = potentials.get(potentials.size()-1);
            result.add(lastAddition);
        }
        return result;
    }
}
