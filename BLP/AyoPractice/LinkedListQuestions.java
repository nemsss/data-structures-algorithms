package BLP.AyoPractice;

import DataStructures.BasicQueue;

public class LinkedListQuestions {

    public static void main (String[] args){
        BasicQueue<Integer> p = new BasicQueue<>();
        p.enqueue(3); p.enqueue(5);
        p.enqueue(6); p.enqueue(7);
        BasicQueue<Integer> q = new BasicQueue<>();
        q.enqueue(3); q.enqueue(3);
        q.enqueue(6); q.enqueue(7);

        System.out.println(mergeSortedLists(p, q));
    }

    private static BasicQueue<Integer> mergeSortedLists(BasicQueue<Integer> h1, BasicQueue<Integer> h2) {

        if(h1.isEmpty() && h2.isEmpty()) return null;

        if(h1.isEmpty()) return h2;

        if(h2.isEmpty()) return h1;

        BasicQueue<Integer> result = new BasicQueue<>();
        while(h1.size()>0 || h2.size()>0){

            if(h1.isEmpty()) {
                result.enqueue(h2.dequeue());
                continue;
            }

            if(h2.isEmpty()) {
                result.enqueue(h1.dequeue());
                continue;
            }

            if(h1.peek() < h2.peek()){
                result.enqueue(h1.dequeue());
            } else {
                result.enqueue(h2.dequeue());
            }
        }
        return result;
    }


}
