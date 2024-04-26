package com.example.wcutodo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteToFileText {
    public static void main(String[] args) {
        Todo t = new Todo(1,"test","test");
        List<Todo> list = new ArrayList<>();
        for(int i=0;i<8_000_000;i++)
        list.add(new Todo(i,"test","test"));

        String filePath = "output.text";
        try(Writer br = new BufferedWriter(new FileWriter(filePath))){
//                String content = t.getId()+ "," + t.getDescription()+"," + t.getNote();
            for(Todo t1:list){
            String content = t1.toString();
                br.write(content+"\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        try(Reader r = new BufferedReader(new FileReader(filePath))){
            int character;
            while( (character = r.read())!=-1){

                sb.append((char) character);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(sb);
    }
}
