package week6.myHashTable;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Vladislav on 11.08.2016.
 */
public class MyHashTable<K,V> implements Map, Iterable<Node<K,V>>{

    private Node<K,V>[] array;
    private int elementsCount;
    private float loadFactor;
    private int arraySize;
    private HashSet<K> keysSet;
    private List<V> valuesList;
    private Iterator<Node<K, V>> iterator;

    public MyHashTable(float loadFactor, int arraySize) {
        array = (Node<K,V>[]) Array.newInstance(Node.class, arraySize);
        this.loadFactor = loadFactor;
        this.arraySize = arraySize;
        keysSet = new HashSet<>();
        valuesList = new ArrayList<>();
    }

    private int getIndex(Node node){
        return Math.abs(node.getKey().hashCode() % arraySize);
    }

    @Override
    public int size() {
        return elementsCount;
    }

    private int findFirstNotNull(int start){
        for (; start < array.length && array[start] == null; start++) {
        }
        return start;
    }

    @Override
    public boolean isEmpty() {
        return elementsCount == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return keysSet.contains((K)key);
    }

    @Override
    public boolean containsValue(Object value) {
        return valuesList.contains((V)value);
    }

    @Override
    public Object get(Object key) {
        if (containsKey((K)key)){
            for (Node<K,V> node : this) {
                if (node.getKey().equals((K)key)){
                    return node.getValue();
                }
            }
        }
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        if (key != null && value != null) {
            Node<K,V> node = new Node(key, value);
            if (elementsCount / arraySize >= loadFactor) rehashing();
            int index = key.hashCode() % arraySize;

            if (array[index] != null) {
                if (array[index].getKey().equals((K) key)) {
                    node.setNext(array[index].getNext());
                } else {
                    node.setNext(array[index]);
                }
            }

            array[index] = node;

            elementsCount++;
            keysSet.add((K) key);
            valuesList.add((V) value);
            iterator = iterator();  //Once I've removed this code, I got NullPointerException (I faced that error before while debugging my code)
            return value;           //because after rehashing my array automatically increased.
        }                           //Hence, I need to re-define iterator after adding new element because rehashibg may happen.
        return null;
    }

    private void rehashing(){
        arraySize *= 2;
        elementsCount = 0;
        Node<K,V>[] temp = (Node<K,V>[]) Array.newInstance(Node.class, arraySize);
        Set<Map.Entry> set = entrySet();

        array = temp;

        for (Entry entry : set) {
            put(entry.getKey(), entry.getValue());
        }

        iterator = iterator();
    }

    @Override
    public Object remove(Object key) {
        Node node = array[findFirstNotNull(0)];

        while (node != null){
            if (node.getKey().equals(key)) {
                iterator.remove();
                elementsCount--;
                keysSet.remove((K)key);
                valuesList.remove((V)node.getValue());
                return node.getValue();
            }
            node = iterator.next();
        }

        return null;
    }

    @Override
    public void putAll(Map m) {
        MyHashTable map = (MyHashTable<K,V>)m;
        Set<Map.Entry> set = map.entrySet();

        for (Entry entry : set) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear() {
        array = null;
    }

    @Override
    public Set keySet() {
        return keysSet;
    }

    @Override
    public Collection values() {
        return valuesList;
    }

    @Override
    public Set<Entry> entrySet() {
        Set<Map.Entry> set = new HashSet<>(elementsCount, loadFactor);
        Node<K,V> node;

        for (int i = 0; i < array.length; i++) {
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

    public Node<K, V>[] getArray() {
        return array;
    }

    @Override
    public Iterator<Node<K, V>> iterator() {
        return new MyHashTableIterator();
    }

    private class MyHashTableIterator implements Iterator<Node<K,V>>{

        private Node<K,V> currNode;
        private int currBucketPos;

        public MyHashTableIterator() {
            if(!isEmpty()){
                currBucketPos = findFirstNotNull(0);
                currNode = array[currBucketPos];
            }
        }

        public Node<K, V> getCurrNode() {
            return currNode;
        }

        @Override
        public boolean hasNext() {
            return currNode != null;
        }

        @Override
        public Node<K, V> next() {
            Node<K,V> nodeRes = currNode;

            if (currNode.getNext() != null) {
                currNode = currNode.getNext();
            } else {
                int indexNext = findFirstNotNull(currBucketPos + 1);
                if (indexNext == (arraySize)){
                    currNode = null;
                } else {
                    currBucketPos = indexNext;
                    currNode = array[indexNext];
                }
            }

            return currNode;
        }

        @Override
        public void remove() {                  //I've left as it is since I did'nt get your point from the comment
            if (currNode.getNext() != null) {   //Should I remove value from collection only here? And what about node itself if so?
                currNode = currNode.getNext();  //Or you might meant that I should have removed value only in this method (iterator remove method)
            } else {                            // and node itself in remove method from MyHashTable?
                currNode = null;
            }
        }
    }
}
