package ru.wjs.volodin.practicaltasks7.task13;



import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader lotReader = new BufferedReader(new FileReader("lot.txt"));
             BufferedReader readerParticipants = new BufferedReader(new FileReader("participants.txt"))) {
            String lotName = lotReader.readLine();
            int startPrice = Integer.parseInt(lotReader.readLine());
            AuctionLot testLot = new AuctionLot(lotName, startPrice, 10000);

            List<String> participants = new ArrayList<>();
            String username;
            while ((username = readerParticipants.readLine()) != null) {
                System.out.println(username);
                participants.add(username);
            }
            List<Thread> threadsOfParticipants = new ArrayList<>();
            for (String participant : participants) {
                Thread thread = new Thread(new AuctionParticipant(participant, testLot));
                threadsOfParticipants.add(thread);
            }
            for(Thread thread:threadsOfParticipants){
                thread.start();
            }
            for (Thread thread: threadsOfParticipants){
                thread.join();
            } System.out.println("Лот - \" "+testLot.getName() +"\"; победитель: "+testLot.getWinner());

        } catch (InterruptedException e) {
            // TODO exception
            throw new RuntimeException(e);
        }

    }
}


