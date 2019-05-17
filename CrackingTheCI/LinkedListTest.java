/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingTheCI;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chinemeremenumah
 */

class Node {
     int data;
     Node next;
}

public class LinkedListTest {
    
    boolean has_cycle(Node head) {
    
        List<Node> nodes = new ArrayList<>();
        
        while(true){
            if(head==null){
                return false;
            }
            if(head.next == null){
                return false;
            }
            if(nodes.contains(head)) { 
                return true; 
            } else {
                nodes.add(head);
                head = head.next;

            }

        }
    }


}
