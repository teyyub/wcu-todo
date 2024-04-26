package com.example.wcutodo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UserManager {
    private Map<String , User> users = new HashMap<>();
    public void userRegister(String username, String password){
        users.put(username,new User(username,password));
    }

    public User authenticateUser(String username,String password){
          User user = users.get(username);
          if(Objects.equals(user.getPassword(), password)){
              return user;
          } else {
              return null;
          }

    }
}
