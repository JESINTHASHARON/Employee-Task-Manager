package thread;

import model.*;
import service.TaskService;

import java.util.*;

public class EmployeeUser implements Runnable {

    private String name;
    private TaskService service;

    public EmployeeUser(String name,TaskService service) {
        this.name=name;
        this.service=service;
    }

    @Override
    public void run() {

        Scanner sc=new Scanner(System.in);

        while(true) {

            System.out.println("\nEmployee "+name+" Menu");
            System.out.println("1 View Tasks");
            System.out.println("2 Update Task");
            System.out.println("3 Exit");

            int ch=sc.nextInt();

            if(ch==1) {

                List<Task> tasks=service.getEmployeeTasks(name);

                for(Task t:tasks)
                    System.out.println(t);
            }

            else if(ch==2) {

                System.out.println("Enter Task ID:");
                int id=sc.nextInt();
                service.updateStatus(id,Status.COMPLETED);
            }

            else
                break;
        }
    }
}