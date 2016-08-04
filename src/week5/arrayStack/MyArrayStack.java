package week5.arrayStack;

import java.lang.reflect.Array;
import java.util.Stack;

/**
 * Created by Vladislav on 04.08.2016.
 */
public class MyArrayStack<T>{

    private T[] array;
    private int first = 0;
    private int last = 0;
    private int arrLen;

    public MyArrayStack(Class<T> type, int len) {
        array = (T[])Array.newInstance(type, len);
    }

    public T push(T item) {
        if (!empty()){
            if (first > 0){
                moveElements(-1);
                array[last] = item;
                first--;
            }
        } else {
            last = array.length - 1;
            first = last;
            arrLen++;
            array[last] = item;
        }
        return array[last];
    }

    public T pop() {
        T obj;
        obj = array[last];
        array[last] = null;
        if ((obj != null) && (first != last)) moveElements(1);
        first++;
        return obj;
    }

    public T peek() {
        return (empty() ? null : array[array.length - 1]);
    }

    public boolean empty() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) return false;
        }
        return true;
    }

    public int search(T o) {
        for (int i = first; i <= last; i++) {
            if (array[i] == o) return i;
        }
        return -1;
    }

    private void moveElements(int num){
        if (num > 0) {
            System.arraycopy(array, first, array, first + num, last - first);
            array[first] = null;
        } else {
            System.arraycopy(array, first, array, first + num, last - first + 1);
        }
    }
}
