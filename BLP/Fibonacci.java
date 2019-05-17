package BLP;

public class Fibonacci {

    public static void main(String[] args){
        System.out.println(fibRecursive(9));
        System.out.println(fibIterative(9));
        System.out.println(fibFormula(9));
    }

    private static int fibIterative(int num) {
        if(num == 0) return 0;
        if(num == 1) return 1;

        int one = 0;
        int two = 1;
        int temp;
        for(int i=2; i<=num; i++){
            temp = one + two;
            one = two;
            two = temp;
        }

        return two;
    }

    private static int fibRecursive(int num) {
        if(num == 0) return 0;
        if(num == 1) return 1;
        return fibRecursive(num-1) + fibRecursive(num-2);
    }

    private static double fibFormula(int num){
        double phi = (1 + Math.sqrt(5))/2;
        return Math.round(Math.pow(phi, num) / Math.sqrt(5));
    }

}
