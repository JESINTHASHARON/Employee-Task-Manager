package org.example;

import model.User;
import service.*;
import thread.*;

import java.util.Scanner;

public class WorkflowSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AuthService auth = new AuthService();
        TaskService taskService = new TaskService();

        System.out.println("Username:");
        String user = sc.next();

        System.out.println("Password:");
        String pass = sc.next();

        User u = auth.login(user,pass);

        if(u==null) {

            System.out.println("Invalid Login");
            return;
        }

        if(u.getRole().equals("MANAGER")) {

            Thread manager = new Thread(new ManagerUser(taskService));
            manager.start();
        }

        else {

            Thread emp = new Thread(new EmployeeUser(u.getName(),taskService));
            emp.start();
        }
    }
}