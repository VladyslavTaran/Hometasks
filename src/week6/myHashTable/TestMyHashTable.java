package week6.myHashTable;

/**
 * Created by Vladislav on 11.08.2016.
 */
public class TestMyHashTable {
    public static boolean testSize(){
        MyHashTable<KeyClass, String> myHashTable = new MyHashTable<>(0.75f, 10);
        myHashTable.put(new KeyClass("field1", 12, 1f), "string1");
        myHashTable.put(new KeyClass("field2", 13, 2f), "string2");
        myHashTable.put(new KeyClass("field3", 14, 3f), "string3");
        myHashTable.put(new KeyClass("field4", 15, 4f), "string4");
        myHashTable.put(new KeyClass("field5", 16, 5f), "string5");
        myHashTable.put(new KeyClass("field6", 17, 6f), "string6");
        myHashTable.put(new KeyClass("field7", 18, 7f), "string7");
        myHashTable.put(new KeyClass("field8", 19, 8f), "string8");

        return myHashTable.size() == 8;
    }
    public static boolean testIsEmpty(){
        MyHashTable<KeyClass, String> myHashTable = new MyHashTable<>(0.75f, 10);
        myHashTable.put(new KeyClass("field1", 12, 1f), "string1");
        myHashTable.put(new KeyClass("field2", 13, 2f), "string2");
        myHashTable.put(new KeyClass("field3", 14, 3f), "string3");
        myHashTable.put(new KeyClass("field4", 15, 4f), "string4");
        myHashTable.put(new KeyClass("field5", 16, 5f), "string5");
        myHashTable.put(new KeyClass("field6", 17, 6f), "string6");
        myHashTable.put(new KeyClass("field7", 18, 7f), "string7");
        myHashTable.put(new KeyClass("field8", 19, 8f), "string8");

        return myHashTable.isEmpty() == false;
    }
    public static boolean testPut(){
        MyHashTable<KeyClass, String> myHashTable = new MyHashTable<>(0.75f, 5);
        myHashTable.put(new KeyClass("field1", 12, 1f), "string1");
        myHashTable.put(new KeyClass("field2", 13, 2f), "string2");
        myHashTable.put(new KeyClass("field3", 14, 3f), "string3");
        myHashTable.put(new KeyClass("field4", 15, 4f), "string4");
        myHashTable.put(new KeyClass("field5", 16, 5f), "string5");
        myHashTable.put(new KeyClass("field6", 17, 6f), "string6");
        myHashTable.put(new KeyClass("field7", 18, 7f), "string7");
        myHashTable.put(new KeyClass("field8", 19, 8f), "string8");

        return (myHashTable.size() > 0) && (myHashTable.size() == 8);
    }
    public static boolean testContainsKey(){
        MyHashTable<KeyClass, String> myHashTable = new MyHashTable<>(0.75f, 10);
        myHashTable.put(new KeyClass("field1", 12, 1f), "string1");
        myHashTable.put(new KeyClass("field2", 13, 2f), "string2");
        myHashTable.put(new KeyClass("field3", 14, 3f), "string3");
        KeyClass kc = new KeyClass("field4", 15, 4f);
        myHashTable.put(kc, "string4");
        myHashTable.put(new KeyClass("field5", 16, 5f), "string5");
        myHashTable.put(new KeyClass("field6", 17, 6f), "string6");
        myHashTable.put(new KeyClass("field7", 18, 7f), "string7");
        myHashTable.put(new KeyClass("field8", 19, 8f), "string8");

        return myHashTable.containsKey(kc) == true;
    }
    public static boolean testContainsValue(){
        MyHashTable<KeyClass, String> myHashTable = new MyHashTable<>(0.75f, 10);
        myHashTable.put(new KeyClass("field1", 12, 1f), "string1");
        myHashTable.put(new KeyClass("field2", 13, 2f), "string2");
        myHashTable.put(new KeyClass("field3", 14, 3f), "string3");
        myHashTable.put(new KeyClass("field4", 15, 4f), "string4");
        myHashTable.put(new KeyClass("field5", 16, 5f), "string5");
        myHashTable.put(new KeyClass("field6", 17, 6f), "string6");
        myHashTable.put(new KeyClass("field7", 18, 7f), "string7");
        myHashTable.put(new KeyClass("field8", 19, 8f), "string8");

        return myHashTable.containsValue("string4") == true;
    }
}
