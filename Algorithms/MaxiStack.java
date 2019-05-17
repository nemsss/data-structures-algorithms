package Algorithms;

import java.util.Scanner;
import java.util.Stack;

public class MaxiStack {

    private static Stack<Integer> stack = new Stack<>();
    private static Stack<Integer> max = new Stack<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i=0; i<n; i++){
            int q = in.nextInt();
            if(q == 1){
                doQuery1(q , in.nextInt());
            } else {
                doQuery1(q, null);
            }
        }
        in.close();
    }

    private static Stack<MaxNode> maxi = new Stack<>();
    private static void doQuery1(Integer q, Integer num){
        switch (q){
            case 1:
                if(maxi.isEmpty() || num > maxi.peek().data){
                    maxi.push(new MaxNode(num, 0));
                } else {
                    maxi.peek().elementsAbove++;
                }
                break;
            case 2:
                if(!maxi.isEmpty() && maxi.peek().elementsAbove==0){
                    maxi.pop();
                } else {
                    maxi.peek().elementsAbove--;
                }
                break;
            case 3:
                if(!maxi.isEmpty()){
                    System.out.println(maxi.peek().data);
                }
                break;
            default:
                return;
        }
    }

    static class MaxNode {
        int data;
        int elementsAbove;

        public MaxNode(int data, int elementsAbove) {
            this.data = data;
            this.elementsAbove = elementsAbove;
        }
    }

    private static void doQuery(Integer q, Integer num){
        switch (q){
            case 1:
                stack.push(num);
                if(max.isEmpty() || num > max.peek()){
                    max.push(num);
                }
                break;
            case 2:
                if(!max.isEmpty() && !stack.isEmpty()&& stack.peek().equals(max.peek())){
                    stack.pop();
                    max.pop();
                } else {
                    stack.pop();
                }
                break;
            case 3:
                if(!max.isEmpty()){
                    System.out.println(max.peek());
                }
                break;
            default:

        }
    }
}
