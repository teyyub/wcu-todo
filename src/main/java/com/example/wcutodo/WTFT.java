package com.example.wcutodo;

import java.io.*;

public class WTFT {
    public static void main(String[] args) {
        String path="output.txt";
        try(Writer w = new BufferedWriter(new FileWriter(path))){
            String content = " hello world ";
            w.write(content);
        } catch (IOException e){
            e.printStackTrace();
        }

        try(Reader r = new BufferedReader(new FileReader(path))){
            int character;
            while((character = r.read())!=-1){
                System.out.println((char)character);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
