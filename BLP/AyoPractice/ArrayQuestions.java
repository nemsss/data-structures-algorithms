package BLP.AyoPractice;


import java.util.*;

public class ArrayQuestions {

    public static void main (String[] args){
        System.out.println(java.util.Arrays.deepToString(findSumPairs(new int[]{1, 2, 45, 5, 6}, 6)));
        System.out.println(java.util.Arrays.deepToString(findSumPairs(new int[]{0, 2, 4, 5, 9, 6}, 9)));

        System.out.println(averageOfMLengthSubArrays(new int[] {1,2,3,4,5}, 3));

        List<Range> ranges = Arrays.asList(new Range(1,2), new Range(1,5), new Range(3,9), new Range(4,8), new Range(9,15));
        System.out.println(mergeRanges(ranges));

        String res = Arrays.toString(findMissingString("This is my home now".split(" "), "This is my new home".split(" ")));
        System.out.println(res);

        System.out.println(firstUniqueElement(new int[] {1,2,3,4,2,1,5,4}));

        System.out.println(Arrays.toString(moveAllZeros(new int[]{0, 2, 3, 0, 6, 0, 7})));
    }

    private static Object[] findSumPairs(int[] array, int target) {
        if(array== null || array.length==0){
            throw new IllegalArgumentException("Array can no be empty");
        }

        //Add to checker set
        Map<Integer, Integer> result = new HashMap<>();
        Set<Integer> checker = new HashSet<>();
        for(int num : array){
            checker.add(num);
        }
        //Checking for pairs
        // Add to resulting set it there's a match

        // 0 2 4 5 9 6
        // 0 2 4 5 6 9
        for(int num : array){
            if(checker.contains(target - num)){
                int lesser = num < target-num ? num : target-num;
                int greater = num != lesser ? num : target-num;
                result.put(lesser, greater);
            }
        }

        return result.entrySet().toArray();
    }

    private static int averageOfMLengthSubArrays(int[] array, int m){
        //Check for null, empty array, m>array length, etc.

        int[] sums = new int[array.length - m + 1];
        for(int i=0; i<=array.length-m; i++){
            int sum = 0;
            for(int j=i; j<(m+i); j++){
                sum+=array[j];
            }
            sums[i] = sum;
        }

        int sum = 0;
        for(int num : sums){
            sum+= num;
        }

        return sum/sums.length;
    }

    private static List<Range> mergeRanges (List<Range> ranges){
        Collections.sort(ranges);
        List<Range> result = new ArrayList<>();
        Range current = null;
        for(Range range : ranges){

            // First pass
            if(current == null){
                current = range;
                continue;
            }

            //If new range contains current range
            if(range.contains(current.start) && range.contains(current.end)){
                current = range;

            //If new range is the next valid range
            } else if(range.contains(current.end)){
                result.add(current);
                current = range;
            }
        }

        //Add the final valid range
        result.add(current);
        return result;
    }

    static class Range implements Comparable<Range> {
        private int start;
        private int end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean contains (int target){
            return start <= target && end >= target;
        }

        @Override
        public int compareTo(Range r) {
            if(this.start < r.start){
                return -1;
            }

            if(this.start == r.start){
                if(this.end == r.end){
                    return 0;
                }
                return this.end > r.end ? 1 : -1;
            }

            return 1;
        }

        @Override
        public String toString() {
            return String.format("{Start=%d, End=%d}", start, end);
        }
    }

    private static String[] findMissingString(String[] s1, String[] s2) {

        Map<String, Integer> m1 = new HashMap<>();
        Map<String, Integer> m2 = new HashMap<>();

        for(String s : s1){
            if(m1.containsKey(s)){
                m1.replace(s, m1.get(s)+1);
            } else {
                m1.put(s,1);
            }
        }

        for(String s : s2){
            if(m2.containsKey(s)){
                m2.replace(s, m2.get(s)+1);
            } else {
                m2.put(s,1);
            }
        }

        Set<String> result = new HashSet<>();
        for(String s : m1.keySet()){
            if(!m2.containsKey(s)){
                result.add(s);
            }
        }
        for(String s : m2.keySet()){
            if(!m1.containsKey(s)){
                result.add(s);
            }
        }

        return result.toArray(new String[]{});
    }

    private static int firstUniqueElement(int[] array){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : array){
            if(map.containsKey(i)){
                map.replace(i, map.get(i)+1);
            } else {
                map.put(i,1);
            }
        }

        for(int i : array){
            if(map.get(i) == 1){
                return i;
            }
        }

        return -1;
    }

    private static int[] moveAllZeros(int[] array){
        int currIdx = 0;
        for(int i=0; i<array.length; i++){
            if(array[i] != 0){
                array[currIdx] = array[i];
                currIdx+=1;
            }
        }

        for(int i=currIdx; i<array.length; i++){
            array[i] = 0;
        }

        return array;
    }
}
