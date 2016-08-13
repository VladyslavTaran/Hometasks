package week6.myHashTable;

import java.util.Map;

/**
 * Created by Vladislav on 11.08.2016.
 */
public class Node<K,V> implements Map.Entry{
    private K key;
    private V value;
    private Node next = null;

    public Node(K key, V value) {
        this.value = value;
        this.key = key;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public Object setValue(Object value) {
        this.value = (V) value;
        return value;
    }
}
