package week5.arrayStack;

import week5.arrayStack.MyArrayStack;

/**
 * Created by Vladislav on 05.08.2016.
 */
public class TestMyStack {
    public static boolean testPush(){

        MyArrayStack<String> stringMyArrayStack = new MyArrayStack<>(String.class, 10);
        stringMyArrayStack.push("first");
        return !stringMyArrayStack.empty();
    }

    public static boolean testEmpty(){
        MyArrayStack<String> stringMyArrayStack = new MyArrayStack<>(String.class, 10);
        return stringMyArrayStack.empty();
    }

    public static boolean testPop(){
        MyArrayStack<String> stringMyArrayStack = new MyArrayStack<>(String.class, 10);
        stringMyArrayStack.push("first");
        stringMyArrayStack.push("second");
        stringMyArrayStack.pop();
        return stringMyArrayStack.pop().equals("first");
    }

    public static boolean testPeek(){
        MyArrayStack<String> stringMyArrayStack = new MyArrayStack<>(String.class, 10);
        stringMyArrayStack.push("first");
        stringMyArrayStack.push("second");
        return stringMyArrayStack.peek().equals("second");
    }

    public static boolean testSearch(){
        MyArrayStack<Object> stringMyArrayStack = new MyArrayStack<>(Object.class, 10);
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();
        stringMyArrayStack.push(obj1);
        stringMyArrayStack.push(obj2);
        stringMyArrayStack.push(obj3);
        return (stringMyArrayStack.search(obj2) == obj2);
    }
}
