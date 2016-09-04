package acp14.week1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladislav on 03.09.2016.
 */
public class DataBase {
    private static List<User> users;
    private static List<Task> taskTemplates;
    private static List<Task> userTasks;

    static {
        users = new ArrayList<>();
        taskTemplates = new ArrayList<>();
        userTasks = new ArrayList<>();
    }

    public static List<User> getUsers() {
        return users;
    }

    public static void setUsers(List<User> users) {
        DataBase.users = users;
    }

    public static List<Task> getTaskTemplates() {
        return taskTemplates;
    }

    public static void setTaskTemplates(List<Task> taskTemplates) {
        DataBase.taskTemplates = taskTemplates;
    }

    public static List<Task> getUserTasks() {
        return userTasks;
    }

    public static void setUserTasks(List<Task> userTasks) {
        DataBase.userTasks = userTasks;
    }
}
