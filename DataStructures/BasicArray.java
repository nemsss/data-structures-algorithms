package DataStructures;

import java.util.Arrays;

public class BasicArray<T> {

    private int size = -1;
    private int capacity = 10;
    private Object [] data;

    public static void main(String[] args){
        BasicArray<String> array = new BasicArray();
        array.add("okay");
        array.add("okay1");
        array.add("okay2");
        array.add("okay3");
        array.add("okay4");
        array.add("okay5");
        array.add("okay6");
        array.add("okay7");
        array.add("okay8");
        array.add("okay9");
        array.add("okay11",10);
        System.out.println(array);

        System.out.println(array.contains("okay4"));
        System.out.println(array.contains("okay17"));
        System.out.println(array.contains(null));

        array.remove("okay7");
        System.out.println(array);

        array.remove(0);
        System.out.println(array);
    }

    BasicArray (){
        this.data = new Object [this.capacity];
    }

    BasicArray (int capacity){
        this.capacity = capacity;
        this.data = new Object [this.capacity];
    }

    public int size(){
        return size+1;
    }

    public boolean add(T obj){
        if(size+1 == capacity){
            int newCapacity = this.capacity * 2;
            this.data = Arrays.copyOf(this.data, newCapacity);
            this.capacity = newCapacity;
        }
        data[++size] = obj;
        return true;
    }

    public boolean add(T obj, int idx){
        if(size+2 >= capacity){ //because of internal indices
            int newCapacity = this.capacity * 2;
            this.data = Arrays.copyOf(this.data, newCapacity);
            this.capacity = newCapacity;
        }

        if(idx == size+1){
            return add(obj);
        }


        System.arraycopy(this.data, idx, this.data, idx+1, (size()-idx));
        this.data[idx] = obj;
        size++;
        return true;
    }

    public boolean remove (T obj){
        int idx = -1;
        for(int i=0; i<=size; i++){
            Object item = data[i];
            if(item.equals(obj)){
                idx = i;
                break;
            }
        }

        return idx != -1 && remove(idx) == obj;
    }

    public T remove(int idx){
        Object obj = data[idx];
        System.arraycopy(this.data, idx+1, this.data, idx, (size-idx));
        this.data[size] = null;
        size--;
        return (T) obj;
    }

    public boolean contains(T obj){
        for(Object item : this.data){
            if(obj==null && item==null){
                return true;
            } else if(item!=null && item.equals(obj)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.data);
    }
}
