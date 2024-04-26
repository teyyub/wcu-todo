package com.example.wcutodo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Todo_old extends Object{

    static List<Todo_old> todos = new ArrayList<>();

    private Integer id;
    private String description;
    private LocalDateTime createdAt;
    private String note;

    public Todo_old(Integer id, String description, LocalDateTime createdAt, String note) {
        this.id = id;
        this.description = description;
        this.createdAt = createdAt;
        this.note = note;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", note='" + note + '\'' +
                '}';
    }

    String [] names1 = { };
   static List<Integer> names = new ArrayList<>();



    public static void main(String[] args) {
//            Todo todo1 = new Todo(1,"test1", LocalDateTime.now(),"this is test1 ");
//            Todo todo2 = new Todo(2,"test2",LocalDateTime.now(),"this is test2 ");
//
//            todos.add(todo1);
//            todos.add(todo2);
//
//
//            System.out.println(todos);

//           Random r = new Random();
//           System.out.println(r.nextInt(900000)+100000);
           Scanner input = new Scanner(System.in);
           char choice=0;
           while(choice!='q'){
               System.out.println("1. add");
               System.out.println("2. delete");
               System.out.println("3. list all");
               System.out.println("q. quite");
               System.out.println("your choice:");
               choice = input.nextLine().charAt(0);
               switch (choice){
                   case '1' :
                       System.out.println("enter description:");
                       String ds = input.nextLine();
                       System.out.println("enter note");
                       String nt = input.nextLine();
                       Todo_old td = new Todo_old(1,ds,LocalDateTime.now(),nt);
                       todos.add(td);
                        break;
                   case '2':
                        break;
                   case '3':
                       System.out.println(todos);
                       break;

               }
           }
    }
}
