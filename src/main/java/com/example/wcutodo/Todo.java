package com.example.wcutodo;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Todo implements Serializable  {
//    private static final long serialVersionUID = 1L;
    static List<Todo> todos = new ArrayList<>();
    static List<Todo> foundTodo = new ArrayList<>();
    private Integer id;
    private String description;
    private LocalDateTime createdAt;
    private String note;
    private String status="Pending";

    public Todo(Integer id) {
        this.id = id;
    }

    public Todo(Integer id, String description, String note) {
        this.id = id;
        this.description = description;
        this.createdAt = LocalDateTime.now();
        this.note = note;
    }

    public Todo(Integer id, String description, LocalDateTime createdAt, String note) {
        this.id = id;
        this.description = description;
        this.createdAt = createdAt;
        this.note = note;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getNote() {
        return note;
    }

    public String getStatus() {
        return status;
    }

    @Override
   public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj==null) return false;
        Todo todo = (Todo) obj;
       return todo.id==this.id && todo.description==this.description;
   }


    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", note='" + note + '\'' +
                ", status= '" + status + '\'' +
                '}';
    }

    public static void writeToFile(List<Todo> todo, File file) throws FileNotFoundException {
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(todo);
            oos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeToFile(Todo todo, File file) throws FileNotFoundException {
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
             oos.writeObject(todo);
             oos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Todo> readFromFile() throws FileNotFoundException {
        File file = new File("todos.bin");
        List<Todo> todos = new ArrayList<>();
       try (FileInputStream fis = new FileInputStream(file);
               ObjectInputStream ois = new ObjectInputStream(fis)) {
           List<Todo> loadedTodos = (List<Todo>) ois.readObject();
           todos.addAll(loadedTodos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
        return todos;
    }

    public static Todo readTodoFromFile() throws FileNotFoundException {
        File file = new File("todo.txt");

        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (Todo) ois.readObject();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    String [] names1 = { };
   static List<Integer> names = new ArrayList<>();

    public static void main(String[] args) throws RuntimeException {

        Scanner input = new Scanner(System.in);

        char choice =0;
        while(choice!='q'){
            System.out.println("MENU:");
            System.out.println("1.Add");
            System.out.println("2.Delete");
            System.out.println("3.Edit");
            System.out.println("4.List all");
            System.out.println("5 Todo status");
            System.out.println("6 Todo search");
            System.out.println("7. save to file" );
            System.out.println("8. read from file");
            System.out.println("9. save todo");
            System.out.println("q quit");
            System.out.println("Enter your choice:");
            choice = input.nextLine().charAt(0);

            switch (choice) {
                case '1':
                    System.out.println("addding todo");
                    System.out.println("Enter description for todo:");
                    String desc = input.nextLine();
                    System.out.println("Enter note for todo:");
                    String note = input.nextLine();
                    int id = todos.size() + 1;
                    Todo todo =
                            new Todo(id, desc, LocalDateTime.now(), note);
                    todos.add(todo);
                    break;
                case '2':
                    System.out.println("Enter id of todo:");

                    int readId = input.nextInt();
                    input.nextLine();
                    for (Todo t : todos) {
                        if (t.id.equals(readId)) {
                            todos.remove(t);
                            break;
                        }
                    }

                    break;
                case '3':

                    System.out.println("Enter id of todo:");
                    int readEditId = input.nextInt();
                    input.nextLine();
                    System.out.println("enter description for edit:");
                    String descEdit = input.nextLine();
                    String noteEdit = input.nextLine();
                    for (Todo t : todos) {
                        if (t.id.equals(readEditId)) {
                            t.description = descEdit;
                            t.note = noteEdit;
                            break;
                        }
                    }

                    break;

                case '4':
//                    input.nextLine();
                    System.out.println("Listing all todos:");
                    for (Todo t : todos) {
                        System.out.println(t);
                    }
                    break;

                case '5':
                    System.out.println("Enter id of todo:");
                    int readIdforStatus = input.nextInt();
                    input.nextLine();
                    for (Todo t : todos) {
                        if (t.id.equals(readIdforStatus)) {
                            t.status = "Completed";
                            break;
                        }
                    }
                    break;

                case '6':
                    System.out.println("Enter description of todo ");
                    String descForSearch = input.nextLine();

                    for(Todo t: todos){
                        if(t.description.equalsIgnoreCase(descForSearch.trim())){
                             foundTodo.add(t);
                            break;
                        }
                    }
                    if(foundTodo.isEmpty()){
                        System.out.println("not found:");
                    } else {
                        System.out.println(foundTodo);
                    }
                    break;

                case '7':
                    if(todos.isEmpty()) {
                        System.out.println("List is empty ");
                    } else {
                     File file = new File("todos.bin");
                    try{
                        writeToFile(todos,file);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    }
                    break;

                case '8' :
                    try {
                        List<Todo> reads = readFromFile();
                        System.out.println(reads.size());
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case '9':
                        Todo t = new Todo(1,"a",LocalDateTime.now(),"sss");
                        File f = new File("todo.txt");
                    try {
                        writeToFile(t,f);
                        Todo todo1 = readTodoFromFile();
                        System.out.println(todo1);
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    break;
            }

        }



//        System.out.println("enter description for todo:");
//        String desc =  input.nextLine();
//
//        System.out.println("enter note for todo:");
//        String note = input.nextLine();
//
//       Todo todo1 =
//                    new Todo(1,desc,
//                    LocalDateTime.now(),
//                    note);
//            Todo todo2 = new Todo(2,"test2",
//                    LocalDateTime.now(),
//                    "this is test2 ");

//            todos.add(todo1);
//            todos.add(todo2);

//         System.out.println(todos);

    }
}
