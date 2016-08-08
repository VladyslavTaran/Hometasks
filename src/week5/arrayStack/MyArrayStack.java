package week5.arrayStack;


import java.lang.reflect.Array;

/**
 * Created by Vladislav on 06.08.2016.
 */
public class MyArrayStack<T> implements IMyStack<T> {

    private T[] array;
    private int top = 0;

    public MyArrayStack(Class<T> type, int length) {
        array = (T[]) Array.newInstance(type, length);
    }

    @Override
    public T push(T element) {          //http://www.tutorialspoint.com/java/java_stack_class.htm
        if (top < array.length) {       //Pushes element onto the stack. element is also returned.
            array[top++] = element;
            return array[top - 1];
        }
        return null;
    }

    @Override
    public T pop() {
        if (!empty()) {
            T element = array[--top];
            array[top] = null;
            return element;
        } else {
            return null;
        }
    }

    @Override
    public T peek() {
        if (!empty()) return array[top - 1];
        else return null;
    }

    @Override
    public boolean empty() {
        return (top == 0) && (array[top] == null);
    }

    @Override
    public int indexOf(T element) {
        if (element != null) {
            for (int i = 0; i <= (top - 1); i++) {
                if (array[i].equals(element)) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i <= (top - 1); i++) {
                if (array[i] == null){
                    return i;
                }
            }
        }
        return -1;
    }
}