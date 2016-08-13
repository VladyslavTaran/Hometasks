package week6.myHashTable;

/**
 * Created by Vladislav on 12.08.2016.
 */
public class Run {
    public static void main(String[] args) {
        System.out.println("Test MyHashTable.size method: " + TestMyHashTable.testSize());
        System.out.println("Test MyHashTable.isEmpty method: " + TestMyHashTable.testIsEmpty());
        System.out.println("Test MyHashTable.put method: " + TestMyHashTable.testPut());
        System.out.println("Test MyHashTable.containsKey method: " + TestMyHashTable.testContainsKey());
        System.out.println("Test MyHashTable.containsValue method: " + TestMyHashTable.testContainsValue());
        System.out.println("Test MyHashTable.putAll method: " + TestMyHashTable.testPutAll());
        System.out.println("Test MyHashTable.remove method: " + TestMyHashTable.testRemove());
        System.out.println("Test MyHashTable.keySet method: " + TestMyHashTable.testKeySet());
        System.out.println("Test MyHashTable.entrySet method: " + TestMyHashTable.testEntrySet());
    }
}
