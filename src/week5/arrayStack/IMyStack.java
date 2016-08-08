package week5.arrayStack;

/**
 * Created by Vladislav on 06.08.2016.
 */
public interface IMyStack<T> {
    T push(T element);
    T pop();
    T peek();
    boolean empty();
    T search(T element);
}
