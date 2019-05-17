package DataStructures;

import java.util.*;

public class BasicMap<K,V> {

    public static void main (String[] args){

    }

    private int size;
    private int capacity = 10;
    private MapEntry[] data;

    public BasicMap(){
        data = new MapEntry[this.capacity];
    }

    public BasicMap(int capacity){
        this.capacity = capacity;
        data = new MapEntry[this.capacity];
    }

    public void put(K key, V value){
        int hash = calculateHashLProbing(key);
        data[hash] = new MapEntry<>(key, value);
        size++;
    }

    public V get(K key){
        int hash = calculateHashLProbing(key);
        return data[hash] == null ? null : (V) data[hash].getValue();
    }

    public void replace(K key, V value){
        int hash = calculateHashLProbing(key);
        data[hash] = new MapEntry<>(key, value);
    }

    public boolean containsKey(K key){
        int hash = calculateHashLProbing(key);
        return data[hash] != null && data[hash].getKey()==key;
    }

    public boolean containsValue(V value){
        for(MapEntry entry : data){
            if(entry != null && entry.getValue() == value){
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void clear(){
        data = new MapEntry[capacity];
    }

    public V delete(K key){
        V value = get(key);
        if(value != null){
            int hash = calculateHashLProbing(key);
            data[hash] = null;
            size--;
            hash = (hash+1) % capacity;

            // re-put all following non-empty slots to ensure the hash is still pristine
            while(data[hash] != null){
                MapEntry entry = data[hash];
                data[hash] = null;
                put((K)entry.getKey(), (V)entry.getValue());
                size --; //reduce size after each addition
                hash = (hash+1) % capacity;
            }
        }
        return value;
    }

    public Set<K> keySet(){
        Set set = new HashSet(Arrays.asList(data));
        set.remove(null);
        return set;
    }

    public Collection<V> values(){
        List list = Arrays.asList(data);
        list.stream().filter(Objects::nonNull);
        return list;
    }

    private int calculateHashLProbing(K key){
        int hash = key.hashCode() % capacity;
        while(data[hash]!=null && !data[hash].getKey().equals(key)){
            hash = (hash+1)%capacity;
        }
        return hash;
    }

    //BUCKET STYLE

    public V getLinked(K key){
        int hash = key.hashCode()%capacity;
        if(data[hash] != null){
            MapEntry entry = data[hash];
            while(entry!= null){
                if(entry.getKey().equals(key)){
                    return (V)entry.getValue();
                } else {
                    entry = entry.next;
                }
            }
        }
        return null;
    }

    public void putLinked(K key, V value){
        int hash = key.hashCode()%capacity;
        if(data[hash] == null){
            data[hash] = new MapEntry<>(key, value);
        } else {
            MapEntry entry = data[hash];
            while(entry.next!= null){
                entry = entry.next;
            }
            entry.next = new MapEntry<>(key, value);
        }
        size++;
    }

    public V deleteLinked(K key){
        int hash = key.hashCode()%capacity;
        V value = getLinked(key);

        if(data[hash] != null){
            MapEntry prev = null;
            MapEntry entry = data[hash];
            while(entry != null){
                if(entry.getKey().equals(key)){
                    if(prev == null){
                        data[hash] = entry.next;
                    } else {
                        prev.next = entry.next;
                    }
                    break;
                }
                prev = entry;
                entry = entry.next;
            }
        }
        size--;
        return value;
    }

    public void replaceLinked(K key, V value){
        int hash = key.hashCode()%capacity;
        if(data[hash] != null){
            MapEntry<K,V> entry = data[hash];
            if(entry.getKey().equals(key)){
                data[hash] = new MapEntry<>(key, value, entry.next);
                return;
            }

            MapEntry<K,V> prev = entry;
            entry = prev.next;
            while(entry != null){
                if(entry.getKey().equals(key)){
                    entry = new MapEntry<>(key, value, entry.next);
                    prev.next = entry;
                    return;
                }
                prev = entry;
                entry = entry.next;
            }
        }
    }

    class MapEntry<K, V>{
        private K key;
        private V value;
        private MapEntry<K,V> next;

        MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public MapEntry(K key, V value, MapEntry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
