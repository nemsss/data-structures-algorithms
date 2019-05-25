package BLP.AyoPractice;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by cenumah on 25/05/2019
 */
public class HashQuestions {
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory();
        browserHistory.visitUrl("dodo.com");
        browserHistory.visitUrl("yaml.co");
        browserHistory.visitUrl("dodo.com");
        browserHistory.visitUrl("yaml.co");
        browserHistory.visitUrl("nutz.com");
        browserHistory.visitUrl("fyno.com");

        browserHistory.printHistory();
    }


    static class BrowserHistory {

        //a b c d d e b

        BrowserHistory() {
        }

        private Set<String> uniqueUrls = new HashSet<>(); //a,b,c,d,e,
        private LinkedList<String> visitedUrls = new LinkedList<>(); //a,c,d,e,b

        void visitUrl(String url) { // b
            if (uniqueUrls.contains(url)) {
                visitedUrls.remove(url);
            } else {
                uniqueUrls.add(url);
            }
            visitedUrls.add(url);
        }

        void printHistory() {
            for(int i= visitedUrls.size(); i>0; i--){
                System.out.println(visitedUrls.get(i-1));
            }
        }
    }


    static class NLinkedList {

        private ListNode head;
        private ListNode tail;

        void add(String url) {
            if (head == null) {
                head = tail = new ListNode(url);
                return;
            }

            ListNode latest = new ListNode(url, tail);
            tail.next = latest;
            tail = latest;
        }

        boolean remove(String url) {
            if (head.url.equals(url)) {
                head = head.next;
                head.prev = null;
                return true;
            }
            if (tail.url.equals(url)) {
                tail = tail.prev;
                tail.next = null;
                return true;
            }

            ListNode node = head;
            while (node.next != null) {
                if (node.next.url.equals(url)) {
                    node.next = node.next.next;
                    return true;
                }
            }
            return false;
        }

        void printList() {
            ListNode node = tail;
            while (node != null) {
                System.out.println(node.url);
                node = node.prev;
            }
        }
    }

    static class ListNode {
        String url;
        ListNode next;
        ListNode prev;

        ListNode(String url) {
            this.url = url;
        }

        ListNode(String url, ListNode prev) {
            this.url = url;
            this.prev = prev;
        }
    }

}


