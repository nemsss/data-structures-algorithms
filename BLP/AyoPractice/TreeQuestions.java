package BLP.AyoPractice;

import DataStructures.BSTNode;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Created by cenumah on 24/05/2019
 */
public class TreeQuestions {

    public static void main (String [] args){
        int num1 = 0;
        int num2 = 9;
        BSTNode node1 = new BSTNode(7);
        BSTNode node2 = new BSTNode(8);
        System.out.println(findLowestCommonAncestor(node1, node2));
    }

    private static BSTNode findLowestCommonAncestor(BSTNode node1, BSTNode node2) {
        Set<BSTNode> nodeSet = new HashSet<>();
        while (node1!= null){
            nodeSet.add(node1.parent);
            node1 = node1.parent;
        }

        while(node2!= null){
            if(nodeSet.contains(node2)){
                return node2;
            }
            node2 = node2.parent;
        }

        throw new NoSuchElementException("!");
    }
}
