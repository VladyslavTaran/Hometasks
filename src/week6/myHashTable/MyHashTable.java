package week6.myHashTable;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Vladislav on 11.08.2016.
 */
public class MyHashTable<K,V> implements Map, Iterator {

    private Node<K,V>[] array;
    private int elementsCount;
    private float loadFactor;
    private int arraySize;

    public MyHashTable(float loadFactor, int arraySize) {
        array = (Node<K,V>[]) Array.newInstance(Node.class, arraySize);//new Object[arraySize];
        this.loadFactor = loadFactor;
        this.arraySize = arraySize;
    }

    @Override
    public int size() {
        return elementsCount;
    }

    @Override
    public boolean isEmpty() {
        return elementsCount == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        for (int i = 0; i < arraySize; i++) {
            Node node = array[i];
            if (node != null) {
                if (node.getKey().equals(key)) return true;
                while (node.getNext() != null) {
                    node = node.getNext();
                    if (node.getKey().equals(key)) return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (int i = 0; i < arraySize; i++) {
            Node node = array[i];
            if (node != null) {
                if (node.getValue().equals(value)) return true;
                while (node.getNext() != null) {
                    node = node.getNext();
                    if (node.getValue().equals(value)) return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object get(Object key) {
        for (int i = 0; i < arraySize; i++) {
            Node node = array[i];
            if (node != null) {
                if (node.getKey().equals(key)) return node.getValue();
                while (node.getNext() != null) {
                    node = node.getNext();
                    if (node.getKey().equals(key)) return node.getValue();
                }
            }
        }
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        Node node = new Node(key, value);
        if (elementsCount/arraySize < loadFactor) {
            int index = key.hashCode() % arraySize;
            if (array[index] == null) {
                array[index] = node;
            } else {
                Node subNode = array[index].getNext();
                if (subNode != null) {
                    while (subNode != null) {
                        if (subNode.getNext() != null) {
                            subNode = subNode.getNext();
                        } else break;
                    }
                    subNode.setNext(node);
                } else {
                    array[index].setNext(node);
                }
            }
        } else {
            rehashing();
            int index = key.hashCode() % arraySize;
            if (array[index] != null){
                array[index].setNext(node);
            } else {
                array[index] = node;
            }
        }
        elementsCount++;
        return value;
    }

    private void rehashing(){
        arraySize *= 2;
        Node<K,V>[] temp = (Node<K,V>[]) Array.newInstance(Node.class, arraySize);
        for (int i = 0; i < array.length; i++) {
            Node node = array[i];
            if (node != null){
                if (node.getNext() != null){
                    while(node != null){
                        int index = node.getKey().hashCode() % arraySize;
                        if (temp[index] == null) temp[index] = node;
                        else temp[index].setNext(node);
                        node = node.getNext();
                    }
                } else {
                    int index = node.getKey().hashCode() % arraySize;
                    if (temp[index] == null) temp[index] = node;
                    else temp[index].setNext(node);
                }
            }
        }
        array = temp;
    }

    @Override
    public Object remove(Object key) {
        Object value = null;
        for (int i = 0; i < arraySize; i++) {
            Node node = array[i];
            if (node != null) {
                if (node.getNext() == null){
                    if (node.getKey().equals(key)) {
                        value = (V) node.getValue();
                        node = null;
                        break;
                    }
                } else {
                    if (node.getKey().equals(key)){
                        value = (V) node.getValue();
                        node = node.getNext();
                        break;
                    } else {
                        while (node.getNext() != null) {
                            node = node.getNext();
                            if (node.getKey().equals(key)) {
                                value = (V) node.getValue();
                                node = node.getNext();
                                return value;
                            }
                        }
                    }
                }
            }
        }
        return value;
    }

    @Override
    public void putAll(Map m) {
        //will be implemented till Saturday
    }

    @Override
    public void clear() {
        array = null;
    }

    @Override
    public Set keySet() {
        //will be implemented till Saturday
        return null;
    }

    @Override
    public Collection values() {
        //will be implemented till Saturday
        return null;
    }

    @Override
    public Set<Entry> entrySet() {
        //will be implemented till Saturday
        return null;
    }

    @Override
    public boolean hasNext() {
        //will be implemented till Saturday
        return false;
    }

    @Override
    public Object next() {
        //will be implemented till Saturday
        return null;
    }

    @Override
    public void remove() {
        //will be implemented till Saturday
    }
}
