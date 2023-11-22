package ru.wjs.volodin.practicaltasks7.task13;

import java.util.Random;

/**
 * Класс, реализующий участника аукциона.
 */
public class AuctionParticipant implements Runnable {
    private String username;
    private AuctionLot lot;
    public AuctionParticipant(String username,AuctionLot lot){
        this.username=username;
        this.lot=lot;
    }


    @Override
    public void run() {
        Random random = new Random((System.currentTimeMillis()));
        for (int i = 0; i < 100; i++) {
            lot.makeBet(username, random.nextInt(100000) +100000);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                // TODO exception
                throw new RuntimeException(e);
            }
        }
    }
}
