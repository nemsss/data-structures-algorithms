package DataStructures;

import java.util.Arrays;

public class Queue {

    private Integer [] data;
    private int front = -1;
    private int rear = -1;

    Queue(int size){
        data = new Integer[size];
    }

     void enqueue(int num){
        if(front==rear && front==-1){
            rear = 0;
            front = rear;
            data[rear] = num;
            return;
        }

        if(rear == data.length-1) {
            if(data[0] == null){
                rear = 0;
            } else {
                throw new ArrayIndexOutOfBoundsException("FULL QUEUE");
            }
        } else {
            rear = (rear+1)%data.length;
        }

        if(front == rear){
            throw new ArrayIndexOutOfBoundsException("FULL QUEUE");
        }
        data[rear] = num;
    }

    int dequeue(){
        if(front==-1 || front==data.length){
            throw new ArrayIndexOutOfBoundsException("EMPTY QUEUE");
        }
        int out = data[front];
        data[front] = null;
        if(front == rear){
            front = -1;
            rear = -1;
            return out;
        }
        front = (front + 1) % data.length;
        return out;
    }

    boolean isEmpty() {
        return front == -1 && rear ==-1;
    }

    int peek () {
        return data[rear];
    }

    private void print(){
        System.out.println(Arrays.toString(data));
    }

    public static void main (String[] args){
        Queue queue = new Queue(10);
        queue.enqueue(3);
        queue.enqueue(3);
        queue.enqueue(8);
        queue.enqueue(8);
        queue.enqueue(8);
        queue.enqueue(8);
        queue.enqueue(8);
        queue.enqueue(8);
        queue.print();System.out.println();

        //next = (i+1)%n
        //prev = (i+n-1)%n

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.print();System.out.println();

        queue.enqueue(9);
        queue.enqueue(9);
        queue.enqueue(9);
        queue.enqueue(9);
        queue.print();System.out.println();

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.print();System.out.println();
    }
}
