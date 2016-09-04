package acp14.week1;

/**
 * Created by Vladislav on 03.09.2016.
 */
public class Run {
    private TaskController controller;

    public static void main(String[] args) {

    }

    void init(){
        DataBase.getTaskTemplates().add(1, new Task("FirstTask", "C\\TaskTemplate1.java", 1));
        User user = new User("Ivan");
        Task taskTemplate = DataBase.getTaskTemplates().get(1);
        user.addTask(new UserTask("C\\TaskUser1.java", taskTemplate));
    }
}
