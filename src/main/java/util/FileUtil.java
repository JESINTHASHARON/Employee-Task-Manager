package util;

import model.*;

import java.io.*;
import java.util.*;

public class FileUtil {

    public static void saveTasks(Collection<Task> tasks) {

        try {

            FileWriter writer = new FileWriter("tasks.txt");

            for(Task t : tasks) {

                writer.write(
                        t.getId()+","+
                                t.getDescription()+","+
                                t.getPriority()+","+
                                t.getStatus()+","+
                                t.getEmployee()+"\n"
                );
            }

            writer.close();

        } catch(IOException e) {

            e.printStackTrace();
        }
    }


    public static Map<Integer,Task> loadTasks() {

        Map<Integer,Task> tasks = new HashMap<>();

        try {

            File file = new File("tasks.txt");

            if(!file.exists())
                return tasks;

            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;

            while((line = br.readLine()) != null) {

                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                String desc = parts[1];
                Priority p = Priority.valueOf(parts[2]);
                Status s = Status.valueOf(parts[3]);
                String emp = parts[4];

                Task task = new Task(id,desc,p,emp);
                task.setStatus(s);

                tasks.put(id,task);
            }

            br.close();

        } catch(Exception e) {

            e.printStackTrace();
        }

        return tasks;
    }
}