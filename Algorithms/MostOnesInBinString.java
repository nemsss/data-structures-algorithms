package Algorithms;

public class MostOnesInBinString {

    public static void main (String [] args){
        int res = mostOnes(6);
        System.out.println(res);
    }

    private static int mostOnes (int num) {
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            sb.append(num % 2);
            num = num/2;
        }

        StringBuilder test = new StringBuilder();
        for (int i=1; i<=sb.length(); i++){
            test.append('1');
            if(sb.indexOf(test.toString()) == -1){
                test.deleteCharAt(i-1);
                break;
            }
        }

        Double res = 0D;
        for(int i=0; i<test.length(); i++){
            res += Math.pow(2, i);
        }
        return res.intValue();
    }
}
