package com.example.wcutodo;

import java.io.*;

public class WriteToFile {
    public static void main(String[] args) {

        File file = new File("todo.bin");

        try(FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream os =  new ObjectOutputStream(fos) ){
            Todo t = new Todo(1,"test","test");
            //Todo t1 = new Todo(11,"test","test");
            os.writeObject(t);
            //os.writeObject(t1);
//            os.flush();
        } catch (Exception ex){
            ex.printStackTrace();
        }

        try(FileInputStream fin = new FileInputStream(file);
            ObjectInputStream oin = new ObjectInputStream(fin)){
            //while(true){
                try {
                    Todo t1 = (Todo) oin.readObject();
                    System.out.println(t1);
                } catch (EOFException e){
                    //break;
                }
            //}
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
