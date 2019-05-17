package DataStructures;

public class DoublyLinkedList {

    //https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list/problem?h_l=interview&playlist
    // _slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=linked-lists&h_r=next-challenge&h_v=zen

    DoublyLinkedListNode head;

    public DoublyLinkedList(DoublyLinkedListNode head) {
        this.head = head;
    }

    public static void main(String [] args){
        DoublyLinkedListNode head = null;
        head = sortedInsert(head,1);
        head = sortedInsert(head,4);
        head = sortedInsert(head,1);
        head = sortedInsert(head,3);
        head = sortedInsert(head,3);
        head = sortedInsert(head,4);
        head = sortedInsert(head,10);

//        System.out.println(head);

//        DoublyLinkedList linkedList = new DoublyLinkedList(head);
//        linkedList.recursiveReverse(head);
//        System.out.println(linkedList.head);

    }

    private static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        if(head == null){
            head = new DoublyLinkedListNode(data);
            return head;
        }

        DoublyLinkedListNode curr = head;
        while(curr != null){ //tail addition
            if(curr.data == data){
                return head;
            }

            if(data > curr.data && curr.next == null){
                curr.next = new DoublyLinkedListNode(data);
                curr.next.prev = curr;
                return head;
            }

            if(data < curr.data && curr.prev == null){ //new head
                curr.prev = new DoublyLinkedListNode(data);
                head = curr.prev;
                head.next = curr;
                return head;
            }

            if(data > curr.data && curr.next!=null && data<= curr.next.data){
                DoublyLinkedListNode node = new DoublyLinkedListNode(data);
                node.prev = curr;
                node.next = curr.next;
                curr.next.prev = node;
                curr.next = node;
                return head; // > insertion
            }

            if(data <= curr.data && curr.prev!=null && data> curr.prev.data){
                DoublyLinkedListNode node = new DoublyLinkedListNode(data);
                curr.prev.next = node;
                curr.prev = node;
                return head; // <insertion
            }

            curr = curr.next;
        }

        return head;
    }

    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        if(head == null){
            return head;
        }

        DoublyLinkedListNode curr = head;
        DoublyLinkedListNode handled = null;
        DoublyLinkedListNode nextNode;
        while(curr != null){
            nextNode = curr.next;
            curr.next = handled;
            curr.prev = nextNode;
            handled = curr;
            curr = nextNode;
        }

        return handled;
    }

    private void recursiveReverse(DoublyLinkedListNode node){
        if(node.next == null){
            head = node;
            return;
        }
        recursiveReverse(node.next);
        DoublyLinkedListNode next = node.next;
        next.next = node;
        node.next = null;
    }
}

class DoublyLinkedListNode {
    int data;
    DoublyLinkedListNode next;
    DoublyLinkedListNode prev;

    DoublyLinkedListNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        DoublyLinkedListNode node = this;
        StringBuilder sb = new StringBuilder();
        while (node != null){
            sb.append(node.data + " -> ");
            node = node.next;
        }
        return sb.toString();
    }
}
