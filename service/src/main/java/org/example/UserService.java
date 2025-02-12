package org.example;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    private ArrayList<User> users = new ArrayList<User>();

    public UserService() {
        users.add(new User("name", 20, "address", "09150890181", "employed", false));
    }

    public void addUser(User u) {
        users.add(u);
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
