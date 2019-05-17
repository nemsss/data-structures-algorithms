/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author chinemeremenumah
 */
public class DynaArray {
    
    static int lastAnswer = 0;
    static int num_seq;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        num_seq = in.nextInt();
        List<Integer>[] seqList = (ArrayList<Integer>[]) new ArrayList[num_seq];
        for(int i=0; i<num_seq; i++){
            seqList[i] = new ArrayList<>();
        }
        
        int num_qrs = in.nextInt();

        for (int i = 0; i < num_qrs; i++) {
            int type = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();

            if (type == 1) {
                doQuery1(x, y, seqList);
            } else {
                doQuery2(x, y, seqList);
            }
        }

    }

    static void doQuery1(int x, int y, List<Integer>[] seqList) {
          
        int idx = (x^lastAnswer) % num_seq;
        seqList[idx].add(y);
    }

    static void doQuery2(int x, int y, List<Integer>[] seqList) {

        int idx = (x^lastAnswer) % num_seq;
        List<Integer> seq = seqList[idx];
        lastAnswer= seq.get(y%seq.size());
        System.out.println(lastAnswer);
    }
}
