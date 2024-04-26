package com.example.wcutodo;

import java.io.Console;
import java.util.Scanner;

public class TodoLoginApp {
    UserManager userManager = new UserManager();
//    Scanner scanner = new Scanner(System.in);
    Console input = System.console();
    public static void main(String[] args) {
        new TodoLoginApp().run();
    }
    public void run(){


        boolean menuRun = true;
        while(menuRun){
            System.out.println("1. login");
            System.out.println("2. register");
            System.out.println("3. exit");
            System.out.println("your choice");
            String choice =  input.readLine();
            switch (choice) {
                case "1":
                    login();
                    break;
                case "2":
                    register();
                    break;
                case "3":
                    menuRun = false;
                    break;
            }
        }

    }

    private void register(){
        System.out.println("enter username:");
        String username = input.readLine();
        System.out.println("enter pass");
        char[] password = input.readPassword();
        userManager.userRegister(username,String.valueOf(password));
    }

    private void login(){
//        System.out.println("enter username:");
//        String username = scanner.nextLine();
//        System.out.println("enter pass");
//        String password = scanner.nextLine();
//        User user = userManager.authenticateUser(username,password);
//        if(user!=null){
//            System.out.println(user);
//        }
    }
}
