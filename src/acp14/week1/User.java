package acp14.week1;

import java.util.List;

/**
 * Created by Vladislav on 03.09.2016.
 */
public class User{
    private String name;
    private List<UserTask> tasks;

    public User(String name) {
        this.name = name;
    }

    public List<UserTask> getTasks() {
        return tasks;
    }

    public void setTasks(List<UserTask> tasks) {
        this.tasks = tasks;
    }

    public void addTask(UserTask task){

    }

    public void getTask(int Id){

    }
}
