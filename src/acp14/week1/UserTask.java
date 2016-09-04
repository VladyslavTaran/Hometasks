package acp14.week1;

/**
 * Created by Vladislav on 04.09.2016.
 */
public class UserTask{
    private String userTaskPath;
    private Task templateTask;

    public UserTask(String userTaskPath, Task templateTask) {
        this.userTaskPath = userTaskPath;
        this.templateTask = templateTask;
    }
}
