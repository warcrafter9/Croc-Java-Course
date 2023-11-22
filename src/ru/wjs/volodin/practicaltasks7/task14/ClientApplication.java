package ru.wjs.volodin.practicaltasks7.task14;

import java.io.*;
import java.net.Socket;

public class ClientApplication {
    public ClientApplication(Socket socket){

    }
    public static void main(String[] args) throws IOException {
       try(Socket socket = new Socket("127.0.0.1", 2021)){
          BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
          BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          BufferedWriter clientWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
           System.out.println("Введите никнейм: ");
          String nickname = consoleReader.readLine();
           new Thread(() -> {
               String serverMessage;
               try {
                   while ((serverMessage = serverReader.readLine()) != null) {
                       System.out.println(serverMessage);
                   }
               } catch (IOException e) {
                  throw new RuntimeException();
               }
           }).start();

           String inputMessage;
           while ((inputMessage = consoleReader.readLine()) != null) {
               clientWriter.write(inputMessage + "\n");
               clientWriter.flush();
           }
       }

    }

}
