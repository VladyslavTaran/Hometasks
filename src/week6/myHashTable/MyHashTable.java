package week6.myHashTable;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Vladislav on 11.08.2016.
 */
public class MyHashTable<K,V> implements Map, Iterator {

    private Node<K,V>[] array;
    private int elementsCount;
    private float loadFactor;
    private int arraySize;

    public MyHashTable(float loadFactor, int arraySize) {
        array = (Node<K,V>[]) Array.newInstance(Node.class, arraySize);
        this.loadFactor = loadFactor;
        this.arraySize = arraySize;
    }


    private int getIndex(Node node){
        return node.getKey().hashCode() % arraySize;
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
        if (elementsCount/arraySize >= loadFactor) rehashing();
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

        elementsCount++;
        return value;
    }

    private void rehashing(){
        arraySize *= 2;
        Node<K,V>[] temp = (Node<K,V>[]) Array.newInstance(Node.class, arraySize);
        Node nodeTmp;
        for (int i = 0; i < array.length; i++) {
            Node node = array[i];
            if (node != null){
                if (node.getNext() != null){
                    while(node != null){
                        int index = getIndex(node);
                        nodeTmp = node.getNext();
                        node.setNext(null);
                        if (temp[index] == null){
                            temp[index] = node;
                        } else {
                            temp[index].setNext(node);
                        }
                        node.setNext(nodeTmp);
                        node = node.getNext();
                    }
                } else {
                    int index = getIndex(node);
                    if (temp[index] == null){
                        temp[index] = node;
                    } else {
                        temp[index].setNext(node);
                    }
                }
            }
        }
        array = temp;
    }

    @Override
    public Object remove(Object key) {
        Object value = null;
        Node node;
        for (int i = 0; i < arraySize; i++) {
            node = array[i];
            if (node != null) {
                if (node.getNext() == null){
                    if (node.getKey().equals(key)) {
                        value = (V) node.getValue();
                        array[i] = null;
                        break;
                    }
                } else {
                    if (node.getKey().equals(key)){
                        value = (V) node.getValue();
                        array[i] = node.getNext();
                        break;
                    } else {
                        node = node.getNext();
                        while (node != null) {
                            if (node.getKey().equals(key)) {
                                value = (V) node.getValue();
                                array[i] = node.getNext();
                                break;
                            }
                            node = node.getNext();
                        }
                    }
                }
            }
        }
        elementsCount--;
        return value;
    }

    @Override
    public void putAll(Map m) {
        MyHashTable map = (MyHashTable<K,V>)m;
        Node[] arrayIn = map.getArray();
        Node node;
        Node tmp;

        for (int i = 0; i < arrayIn.length; i++) {
            node = arrayIn[i];
            if (node != null){
                if (node.getNext() != null){
                    while(node != null){
                        tmp = node.getNext();
                        node.setNext(null);
                        put(node.getKey(), node.getValue());
                        node.setNext(tmp);
                        node = node.getNext();
                    }
                } else {
                    put(node.getKey(), node.getValue());
                }
            }
        }
    }

    @Override
    public void clear() {
        array = null;
    }

    @Override
    public Set keySet() {
        Set<K> set = new HashSet<>(elementsCount, loadFactor);
        Node<K,V> node;

        for (int i = 0; i < arraySize; i++) {
            node = array[i];
            if (node != null) {
                while(node != null) {
                    set.add(node.getKey());
                    node = node.getNext();
                }
            }
        }

        return set;
    }

    @Override
    public Collection values() {
        Set<V> set = new HashSet<>(elementsCount, loadFactor);
        Node<K,V> node;

        for (int i = 0; i < arraySize; i++) {
            node = array[i];
            if (node != null) {
                while(node != null) {
                    set.add(node.getValue());
                    node = node.getNext();
                }
            }
        }

        return set;
    }

    @Override
    public Set<Entry> entrySet() {
        Set<Map.Entry> set = new HashSet<>(elementsCount, loadFactor);
        Node<K,V> node;

        for (int i = 0; i < arraySize; i++) {
            node = array[i];
            if (node != null) {
                while(node != null) {
                    set.add(node);
                    node = node.getNext();
                }
            }
        }

        return set;
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

    public Node<K, V>[] getArray() {
        return array;
    }
}
