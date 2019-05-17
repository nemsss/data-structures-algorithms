package BLP;

import java.util.*;

// stack
// arraylist ->
//          [a, b, c] <-
// linkedList ->
//          [a] <-> [b] <-> [c]

public class BrowserHistory {
    private ArrayList<String> listOfUrls;
    private int HighestKey = 0;

    BrowserHistory(ArrayList<String> arrayList){
        this.listOfUrls = arrayList;
    }

    BrowserHistory(){
        this.listOfUrls = new ArrayList<String>();
    }

    // hashmap -> O(1)
    // does not keep the order


    // linkedlist ->  bbc <-> cnn <-> bbg
    // time = 0
    // { "bbc": *bbc, "cnn": *cnn, "bbg": *bbg}
    // bbc
    // { "bbc": *bbc, "cnn": *cnn, "bbg": *bbg}
    // cnn <-> bbg <-> bbc

    private void addUrlToArrayList(ArrayList<String> arrayList, String url){
        // find O(N) -> O(1) ? hashmap, hashset
        // remove O(N) -> O(1) ? hashmap, hashset
        //      [1 2 3 4 5 6]
        //      remove 1
        //      [1 2 3 4 5 6]
        //       ^
        //      [2 3 4 5 6]
        // append O(1)
        arrayList.add(url);
    }

    // extract the keys -> O(N)
    // sort them according value {K -> V} O(N logN)
    // print

    // cnn <-> bbg <-> bbc O(N)

    //Multithreading - Concurrency? - Split data to prevent deadlocks
    //

    private void printUrlsInChronologicalOrder(){
        int lengthOfList = this.listOfUrls.size();

        for(int i = listOfUrls.size()-1; i == 0; i-- ){
            System.out.println(listOfUrls.get(i));
        }
    }

    protected void visit(String url){
        this.listOfUrls.add(url);
    }

    protected void hist(){
        this.printUrlsInChronologicalOrder();
    }

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        ChromeHistory hist = new ChromeHistory();
        hist.visit("bbc");
        hist.visit("cnn");
        hist.getHistory(); // print to stdout -> "cnn -> bbc"
    }
}

class ChromeHistory {
    private List<Node<String>> history = new LinkedList<>();

    void visit (String url){
        history.add(new Node<>(url));
    }

    void getHistory(){
        List<Node<String>> history = new LinkedList<>(this.history);
        Collections.reverse(history);
        System.out.println(history);;
    }
}

class Node <T>{
    private T val;
    public T next;
    public T prev;

    Node (T obj){
        val = obj;
    }

    @Override
    public String toString() {
        return val.toString();
    }
}

