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
        MyHashTable<KeyClass, String> myHashTable = new MyHashTable<>(0.75f, 10);
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
    public static boolean testPutAll(){
        MyHashTable<KeyClass, String> myHashTable = new MyHashTable<>(0.75f, 10);
        myHashTable.put(new KeyClass("field1", 12, 1f), "string1");
        myHashTable.put(new KeyClass("field2", 13, 2f), "string2");
        myHashTable.put(new KeyClass("field3", 14, 3f), "string3");
        myHashTable.put(new KeyClass("field4", 15, 4f), "string4");
        myHashTable.put(new KeyClass("field5", 16, 5f), "string5");
        myHashTable.put(new KeyClass("field6", 17, 6f), "string6");
        myHashTable.put(new KeyClass("field7", 18, 7f), "string7");
        myHashTable.put(new KeyClass("field8", 19, 8f), "string8");

        MyHashTable<KeyClass, String> myHashTablePut = new MyHashTable<>(0.85f, 8);
        myHashTablePut.put(new KeyClass("field9", 20, 9f), "string9");
        myHashTablePut.put(new KeyClass("field10", 21, 10f), "string10");
        KeyClass kc = new KeyClass("field11", 22, 11f);
        myHashTablePut.put(kc, "string12");
        myHashTablePut.put(new KeyClass("field12", 23, 12f), "string13");
        myHashTablePut.put(new KeyClass("field13", 25, 13), "string14");
        myHashTablePut.put(new KeyClass("field14", 25, 14), "string15");

        myHashTable.putAll(myHashTablePut);

        return (myHashTable.size() == 14) && (myHashTable.get(kc).equals("string12"));
    }
    public static boolean testRemove(){
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

        myHashTable.remove(kc);

        return (myHashTable.size() == 7) && (myHashTable.get(kc) == null);
    }
    public static boolean testKeySet(){
        MyHashTable<KeyClass, String> myHashTable = new MyHashTable<>(0.75f, 10);
        myHashTable.put(new KeyClass("field1", 12, 1f), "string1");
        myHashTable.put(new KeyClass("field2", 13, 2f), "string2");
        KeyClass kc = new KeyClass("field3", 14, 3f);
        myHashTable.put(kc, "string3");
        myHashTable.put(new KeyClass("field4", 15, 4f), "string4");
        myHashTable.put(new KeyClass("field5", 16, 5f), "string5");
        myHashTable.put(new KeyClass("field6", 17, 6f), "string6");
        myHashTable.put(new KeyClass("field7", 18, 7f), "string7");
        myHashTable.put(new KeyClass("field8", 19, 8f), "string8");

        return (myHashTable.keySet().size() == 8) && (myHashTable.keySet().contains(kc));
    }
    public static boolean testValues(){
        MyHashTable<KeyClass, String> myHashTable = new MyHashTable<>(0.75f, 10);
        myHashTable.put(new KeyClass("field1", 12, 1f), "string1");
        myHashTable.put(new KeyClass("field2", 13, 2f), "string2");
        myHashTable.put(new KeyClass("field3", 14, 3f), "string3");
        myHashTable.put(new KeyClass("field4", 15, 4f), "string4");
        myHashTable.put(new KeyClass("field5", 16, 5f), "string5");
        myHashTable.put(new KeyClass("field6", 17, 6f), "string6");
        myHashTable.put(new KeyClass("field7", 18, 7f), "string7");
        myHashTable.put(new KeyClass("field8", 19, 8f), "string8");

        return (myHashTable.values().size() == 8) && (myHashTable.values().contains("string3"));
    }
    public static boolean testEntrySet(){
        MyHashTable<KeyClass, String> myHashTable = new MyHashTable<>(0.75f, 10);
        myHashTable.put(new KeyClass("field1", 12, 1f), "string1");
        myHashTable.put(new KeyClass("field2", 13, 2f), "string2");
        myHashTable.put(new KeyClass("field3", 14, 3f), "string3");
        myHashTable.put(new KeyClass("field4", 15, 4f), "string4");
        myHashTable.put(new KeyClass("field5", 16, 5f), "string5");
        myHashTable.put(new KeyClass("field6", 17, 6f), "string6");
        myHashTable.put(new KeyClass("field7", 18, 7f), "string7");
        myHashTable.put(new KeyClass("field8", 19, 8f), "string8");

        return (myHashTable.entrySet().size() == 8);
    }
}
