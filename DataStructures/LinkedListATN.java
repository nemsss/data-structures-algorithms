package DataStructures;

// Java program to add two linked lists

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LinkedListATN {
    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    Node addTwoLists(Node first, Node second) {
        Node res = null; // res is head Node of the resultant list 
        Node prev = null;
        Node temp = null;
        int carry = 0, sum;


        while (first != null || second != null) //while both lists exist 
        {
            // Calculate value of next digit in resultant list. 
            // The next digit is sum of following things 
            // (i)  Carry 
            // (ii) Next digit of first list (if there is a next digit) 
            // (ii) Next digit of second list (if there is a next digit) 
            sum = carry + (first != null ? first.val : 0)
                    + (second != null ? second.val : 0);

            // update carry for next calulation 
            carry = (sum >= 10) ? 1 : 0;

            // update sum if it is greater than 10 
            sum = sum % 10;

            // Create a new Node with sum as data 
            temp = new Node(sum);

            // if this is the first Node then set it as head of 
            // the resultant list 
            if (res == null) {
                res = temp;
            } else // If this is not the first Node then connect it to the rest. 
            {
                prev.next = temp;
            }

            // Set prev for next insertion 
            prev = temp;

            // Move first and second pointers to next nodes 
            if (first != null) {
                first = first.next;
            }
            if (second != null) {
                second = second.next;
            }
        }

        if (carry > 0) {
            temp.next = new Node(carry);
        }

        // return head of the resultant list 
        return res;
    }

    // Function to print linked list
    void printlist(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    private Node head1, head2, result;
    private int carry;

    /* A utility function to push a value to linked list */
    void push(int val, int list) {
        Node newnode = new Node(val);
        if (list == 1) {
            newnode.next = head1;
            head1 = newnode;
        } else if (list == 2) {
            newnode.next = head2;
            head2 = newnode;
        } else {
            newnode.next = result;
            result = newnode;
        }

    }

    // Adds two linked lists of same size represented by
    // head1 and head2 and returns head of the resultant
    // linked list. Carry is propagated while returning
    // from the recursion
    void addsamesize(Node n, Node m) {
        // Since the function assumes linked lists are of
        // same size, check any of the two head pointers
        if (n == null)
            return;

        // Recursively add remaining nodes and get the carry
        addsamesize(n.next, m.next);

        // add digits of current nodes and propagated carry
        int sum = n.val + m.val + carry;
        carry = sum / 10;
        sum = sum % 10;

        // Push this to result list
        push(sum, 3);

    }

    Node cur;

    // This function is called after the smaller list is
    // added to the bigger lists's sublist of same size.
    // Once the right sublist is added, the carry must be
    // added to the left side of larger list to get the
    // final result.
    void propogatecarry(Node head1) {
        // If diff. number of nodes are not traversed, add carry
        if (head1 != cur) {
            propogatecarry(head1.next);
            int sum = carry + head1.val;
            carry = sum / 10;
            sum %= 10;

            // add this Node to the front of the result
            push(sum, 3);
        }
    }

    int getsize(Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    // The main function that adds two linked lists
    // represented by head1 and head2. The sum of two
    // lists is stored in a list referred by result
    void addlists() {
        // first list is empty
        if (head1 == null) {
            result = head2;
            return;
        }

        // first list is empty
        if (head2 == null) {
            result = head1;
            return;
        }

        int size1 = getsize(head1);
        int size2 = getsize(head2);

        // Add same size lists
        if (size1 == size2) {
            addsamesize(head1, head2);
        } else {
            // First list should always be larger than second list.
            // If not, swap pointers
            if (size1 < size2) {
                Node temp = head1;
                head1 = head2;
                head2 = temp;
            }
            int diff = Math.abs(size1 - size2);

            // move diff. number of nodes in first list
            Node temp = head1;
            while (diff-- >= 0) {
                cur = temp;
                temp = temp.next;
            }

            // get addition of same size lists
            addsamesize(cur, head2);

            // get addition of remaining first list and carry
            propogatecarry(head1);
        }
        // if some carry is still there, add a new Node to
        // the front of the result list. e.g. 999 and 87
        if (carry > 0)
            push(carry, 3);

    }

    // Driver program to test above functions
    public static void main(String args[]) {
        LinkedListATN list = new LinkedListATN();
        list.head1 = null;
        list.head2 = null;
        list.result = null;
        list.carry = 0;
        int arr1[] = {9, 9, 9};
        int arr2[] = {1, 8};

        // Create first list as 9->9->9
        for (int i = arr1.length - 1; i >= 0; --i)
            list.push(arr1[i], 1);

        // Create second list as 1->8
        for (int i = arr2.length - 1; i >= 0; --i)
            list.push(arr2[i], 2);

        list.addlists();

        list.printlist(list.result);
    }


}

// This code is contributed by Rishabh Mahrsee

