package DataStructures;

public class BasicStack<T> {

    public static void main(String[] args) {
        BasicStack<Integer> stack = new BasicStack<>(0);
        stack.push(3);
        stack.peek();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.size();
        stack.isEmpty();
    }

    private StackNode<T> head;
    private int size;

    BasicStack(T obj){
        this.head = new StackNode<>(obj, null);
        size++;
    }

    BasicStack(StackNode node){
        this.head = node;
        size++;
    }

    public void push(T obj) {
        if (head == null) {
            head = new StackNode<>(obj, null);
        } else {
            head = new StackNode<>(obj, head);
        }
        size++;
    }

    public T peek() {
        if(head == null) return null;
        return head.data;
    }

    public T pop() {
        if(head == null){
            return null;
        }

        T deleted = head.data;
        head = head.next;
        size--;
        return deleted;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    class StackNode<T> {
        T data;
        StackNode next;

        public StackNode(T data, StackNode next) {
            this.data = data;
            this.next = next;
        }
    }
}
