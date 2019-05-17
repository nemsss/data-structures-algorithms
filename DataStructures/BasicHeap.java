package DataStructures;

import java.util.Arrays;
import java.util.List;

public class BasicHeap  {

    private int[] data;
    private int size;

    public static void main (String[] args){
        List<Integer> list = Arrays.asList(1,2);
        System.out.println(Arrays.toString(list.toArray(new Integer[]{})));
    }

    public BasicHeap(int capacity) {
        this.data = new int[capacity];
    }

    public void insert(int item) {
        ensureMinCapacity(size + 1);
        data[size++] = item;
        heapifyUp(size);
    }

    private void heapifyUp(int idx) {
        while(hasParent(idx) && data[idx] > getParent(idx)){
            swap(idx, getParentIdx(idx));
        }
    }

    private void swap(int idx1, int idx2){
        int temp = data[idx1];
        data[idx1] = data[idx2];
        data[idx2] = temp;
    }

    public int peek(){
        if(size == 0) {
            throw new IllegalStateException();
        }
        return data[0];
    }

    private boolean hasParent(int idx) {
        return getParentIdx(idx) >= 0;
    }

    private boolean hasLeft(int idx) {
        return getLeftIdx(idx) < size;
    }

    private boolean hasRight(int idx) {
        return getRightIdx(idx) < size;
    }

    private int getParentIdx(int idx) {
        return (idx - 1)/2;
    }

    private int getLeftIdx(int idx) {
        return 2 * idx + 1;
    }

    private int getRightIdx(int idx) {
        return 2 * idx + 2;
    }

    private int getParent(int idx) {
        return data[getParentIdx(idx)];
    }

    private int getLeft(int idx) {
        return data[getLeftIdx(idx)];
    }

    private int getRight(int idx) {
        return data[getRightIdx(idx)];
    }

    private void ensureMinCapacity(int size) {
        if (size >= data.length) {
            this.data = Arrays.copyOf(data, data.length * 2);
        }
    }
}
