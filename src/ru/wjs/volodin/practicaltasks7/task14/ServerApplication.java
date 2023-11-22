package ru.wjs.volodin.practicaltasks7.task14;

import javax.management.MBeanServerConnection;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServerApplication {
    static List<BufferedWriter> clients = new ArrayList<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(2021)) {

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Connected");
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                clients.add(writer);

              new Thread(new Handler(socket, writer)).start();
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }


    }


        }

