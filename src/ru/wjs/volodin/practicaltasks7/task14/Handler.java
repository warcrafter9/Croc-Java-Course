package ru.wjs.volodin.practicaltasks7.task14;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static ru.wjs.volodin.practicaltasks7.task14.ServerApplication.clients;

public class Handler implements Runnable {
    private Socket clientSocket;
    private BufferedWriter clientWriter;

    public Handler(Socket socket, BufferedWriter writer) {
        this.clientSocket = socket;
        this.clientWriter = writer;
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(clientSocket.getInputStream()); // TODO Сделай не через сканнер.
            while (scanner.hasNextLine()) {
                String message = scanner.nextLine();
                broadcastMessage(message);
            }
        } catch (IOException e) {
            //TODO
        }
    }

    public static void broadcastMessage(String message) {
        for (BufferedWriter clientWriter : clients) {
            try {
                clientWriter.write(message + "\n");
                clientWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
