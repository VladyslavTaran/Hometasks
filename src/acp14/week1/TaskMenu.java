package acp14.week1;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Vladislav on 04.09.2016.
 */
public class TaskMenu {
    private List<Task> tasks;
    private Scanner scanner = new Scanner(System.in);
    private User user;

    public TaskMenu(List<Task> tasks, User user) {
        this.tasks = tasks;
        this.user = user;
    }

    public void run(){

        while(true) {
            int i = 1;
            System.out.println("Choose task:");
            for (Task task : tasks) {
                System.out.println(task.getId() + ". " + task.getTaskName());
            }
            System.out.println("0. Exit");

            int choice = scanner.nextInt();

            if (choice == 0) break;
            else user.addTask(new UserTask("", null));
        }

    }
}
