package acp14.week1;

/**
 * Created by Vladislav on 03.09.2016.
 */
public class Task {
    private String taskTemplatePath;
    private String taskName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public Task(String taskName, String taskTemplatePath, int id) {
        this.taskName = taskName;
        this.taskTemplatePath = taskTemplatePath;
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskTemplatePath() {
        return taskTemplatePath;
    }

    public void setTaskTemplatePath(String taskTemplatePath) {
        this.taskTemplatePath = taskTemplatePath;
    }
}
