package Algorithms;

import java.util.Arrays;

public class MinimumBribes {

    static String minimumBribes(int[] queue) {

        queue = Arrays.stream(queue).map(prsn -> prsn-1).toArray();

        int len = queue.length-1;
        int bribes = 0;

        // 0 1 2 3 4 7 5 6
        // 0 1 2 3 4 5 6 7
        for(int i=len; i>=0; i--){

            if(queue[i] > i+2){
                return "Too Chaotic";
            }

            for(int chk=Math.max(0, queue[i]-1); chk<i; chk++){
                if(queue[chk] > queue[i]){
                    bribes++;
                }
            }
        }

        return String.valueOf(bribes);
    }

    public static void main (String [] args) throws InterruptedException {

        int[] q = {5, 1, 2, 3, 7, 8, 6, 4};
        String res = minimumBribes(q);
        //Thread.sleep(60000);
        System.out.println(res);

        q = new int[]{1, 2, 5, 3, 7, 8, 6, 4};
        //System.out.println(minimumBribes(q));

        long maxVal = (long) (Math.pow(2, 32)-1);
        System.out.println(3L ^ maxVal);


    }
}
