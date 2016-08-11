package week6.myHashTable;

/**
 * Created by Vladislav on 11.08.2016.
 */
public class Node<K,V>{
    private K key;
    private V value;

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

    private Node next;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
