package service;

import model.*;
import util.*;
import java.util.*;

public class TaskService {
    private Map<Integer,Task> tasks = FileUtil.loadTasks();
    public synchronized void addTask(Task task) {

        tasks.put(task.getId(),task);
        FileUtil.saveTasks(tasks.values());
        System.out.println("Task created and assigned to "+task.getEmployee());
    }

    public synchronized List<Task> getEmployeeTasks(String name) {

        List<Task> list=new ArrayList<>();

        for(Task t:tasks.values()) {

            if(name.equals(t.getEmployee()))
                list.add(t);
        }

        return list;
    }

    public synchronized void updateStatus(int id, Status status) {

        Task t = tasks.get(id);

        if (t != null) {

            t.setStatus(status);
            FileUtil.saveTasks(tasks.values());
            System.out.println("Task " + id + " -> " + status);
        }
    }
    public synchronized Collection<Task> getAllTasks() {
        return tasks.values();
    }
}