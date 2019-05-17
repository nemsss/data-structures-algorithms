package DataStructures;

public class LinkedList {

    public static void main (String[] args){
        LinkedList list = new LinkedList();
        Node head = list.insert(null, 1);
        head = list.insert(head, 1);
        head = list.insert(head, 1);
        head = list.insert(head, 3);
        head = list.insert(head, 4);
        head = list.insert(head, 8);

        removeDuplicates(head);
        System.out.println(head);
    }

    static class Node {
        int val;
        Node next;

        Node(int val){
            this.val = val;
        }
    }

    Node insert(Node head, int val){
        if(head == null){
            return new Node(val);
        }

        Node node = head;
        while(node.next != null){
            node = node.next;
        }
        node.next = new Node(val);
        return head;
    }

    private static Node removeDuplicates(Node head){
        if(head == null) return head;

        return head;
    }

    static Node mergeLists(Node h1, Node h2) {
        if(h1 == null && h2 == null){
            return null;
        }

        if(h1 == null && h2!= null){
            return h2;
        }

        if(h1 != null && h2 == null){
            return h1;
        }

        Node head = h1.val > h2.val ? h2 : h1;
        Node node = head;

        while(h1!= null || h2!= null){
            if(h1 == null && h2!= null){
                node.next = h2;
                break;
            }

            if(h1 != null && h2 == null){
                node.next = h1;
                break;
            }

            if(h1.val > h2.val){
                node.next = h2;
                h2 = h2.next;
            } else {
                node.next = h1;
                h1 = h1.next;
            }
        }

        return head;
    }

}
