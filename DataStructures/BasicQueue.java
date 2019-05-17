package DataStructures;

public class BasicQueue<T> {

    public static void main (String [] args){
        BasicQueue<Integer> queue = new BasicQueue<>();
        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.peek();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.size();
    }

    private QueueNode head;
    private QueueNode tail;
    private int size;

    BasicQueue(){}

    BasicQueue(T obj){
        head = tail = new QueueNode<>(obj);
    }

    public T peek(){
        return (T) head.data;
    }

    public void enqueue(T obj){
        if(head == null){
            head = tail = new QueueNode<>(obj);
        } else {
            QueueNode node = new QueueNode<>(obj);
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public T dequeue(){
        T delete = null;
        if(size == 0){
            return null;
        } else if(size == 1){
            head = tail = null;
        } else {
            delete = (T) head;
            head = head.next;
        }
        size--;
        return delete;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    class QueueNode<T> {
        T data;
        QueueNode next;

        QueueNode(T data) {
            this.data = data;
        }

        QueueNode(T data, QueueNode next) {
            this.data = data;
            this.next = next;
        }
    }
}
