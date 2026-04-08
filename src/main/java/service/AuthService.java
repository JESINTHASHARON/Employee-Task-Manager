package service;

import model.User;
import java.util.*;

public class AuthService {

    private Map<String,User> users = new HashMap<>();

    public AuthService() {

        users.put("manager", new User(1,"manager","123","MANAGER"));
        users.put("alice", new User(2,"alice","123","EMPLOYEE"));
        users.put("bob", new User(3,"bob","123","EMPLOYEE"));
    }

    public User login(String username,String password) {

        User u = users.get(username);

        if(u!=null && u.getPassword().equals(password))
            return u;

        return null;
    }
}