package acp14.week1;

/**
 * Created by Vladislav on 03.09.2016.
 */
public interface ITaskController {
    void addTask(Task task);
    Task getTask(int taskId);
}