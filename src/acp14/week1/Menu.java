package acp14.week1;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Vladislav on 04.09.2016.
 */
public class Menu {
    private Scanner scanner;
    private List<Task> tasks;
    private User user;

    public Menu(List<Task> tasks, User user) {
        scanner = new Scanner(System.in);
        this.tasks = tasks;
        this.user = user;
    }

    public void run(ITaskController taskController){

    }
    private void chooseAction(){
        System.out.println("Choose further action:\n1. Choose Task\n2. Exit");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                TaskMenu taskMenu = new TaskMenu(tasks, user);
                taskMenu.run();
                break;
            case 0:
                break;
        }

    }
}
