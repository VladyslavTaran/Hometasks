package week5.arrayStack;

import week5.arrayStack.MyArrayStack;

/**
 * Created by Vladislav on 05.08.2016.
 */
public class TestMyStack {
    public static boolean testPush(){

        IMyStack<String> stringMyArrayStack = new MyArrayStack<>(10);
        stringMyArrayStack.push("first");
        return !stringMyArrayStack.empty();
    }

    public static boolean testEmpty(){
        IMyStack<String> stringMyArrayStack = new MyArrayStack<>(10);
        return stringMyArrayStack.empty();
    }

    public static boolean testPop(){
        IMyStack<String> stringMyArrayStack = new MyArrayStack<>(10);
        stringMyArrayStack.push("first");
        stringMyArrayStack.push("second");
        stringMyArrayStack.pop();
        return stringMyArrayStack.pop().equals("first");
    }

    public static boolean testPeek(){
        IMyStack<String> stringMyArrayStack = new MyArrayStack<>(10);
        stringMyArrayStack.push("first");
        stringMyArrayStack.push("second");
        return stringMyArrayStack.peek().equals("second");
    }

    public static boolean testSearch(){
        IMyStack<Object> stringMyArrayStack = new MyArrayStack<>(10);
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();
        Object obj4 = new Object();
        stringMyArrayStack.push(obj1);
        stringMyArrayStack.push(obj2);
        stringMyArrayStack.push(obj3);
        stringMyArrayStack.push(obj4);
        return (stringMyArrayStack.search(obj1) == 3);
    }
}
