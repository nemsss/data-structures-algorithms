package Algorithms;

public class SwitchNumbers {

    public static void main(String[] args){
        int a = 2;
        int b = 5;

        a = a^b; //2 ^ 5
        b = a^b; //(2^5)^5  = 2
        a = a^b; //((2^5)^5) ^ (2^5) = 5

        System.out.println(a);
        System.out.println(b);
    }
}
