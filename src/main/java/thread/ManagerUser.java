package thread;

import model.*;
import service.TaskService;

import java.util.Scanner;

public class ManagerUser implements Runnable {

    private TaskService service;

    public ManagerUser(TaskService service) {
        this.service=service;
    }
    @Override
    public void run() {

        Scanner sc = new Scanner(System.in);

        while(true) {

            System.out.println("\nManager Menu");
            System.out.println("1 Create Task");
            System.out.println("2 View All Tasks");
            System.out.println("3 Exit");

            int choice = sc.nextInt();

            if(choice == 1) {

                System.out.println("Task ID:");
                int id = sc.nextInt();

                sc.nextLine();

                System.out.println("Description:");
                String desc = sc.nextLine();

                System.out.println("Priority (HIGH MEDIUM LOW):");
                Priority p = Priority.valueOf(sc.next());

                System.out.println("Assign Employee:");
                String emp = sc.next();

                Task task = new Task(id,desc,p,emp);

                service.addTask(task);
            }

            else if(choice == 2) {

                for(Task t : service.getAllTasks()) {
                    System.out.println(t);
                }
            }

            else
                break;
        }
    }
}