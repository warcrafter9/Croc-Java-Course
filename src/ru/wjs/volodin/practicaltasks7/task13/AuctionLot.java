package ru.wjs.volodin.practicaltasks7.task13;

import java.time.LocalDateTime;

/**
 * Класс, реализующий аукционный лот
 */
public class AuctionLot {
    private final String name;
    private int currentPrice; // BigDecimal?
    private String usernameOfThisBet;
    private final LocalDateTime dateTimeEnd;

    public AuctionLot(String nameOfLot,int startPrice, long auctionTimeMillis) {
        this.name=nameOfLot;
        this.currentPrice = startPrice;
        this.dateTimeEnd = LocalDateTime.now().plusSeconds(auctionTimeMillis);
    }

    public String getName() {
        return name;
    }

    public synchronized void  makeBet(String usernameOfThisBet, int price) {
        if (LocalDateTime.now().isBefore(dateTimeEnd) && (price > currentPrice)) {
            currentPrice = price;
            this.usernameOfThisBet = usernameOfThisBet;
        }else {
            //TODO exception
        }
    }

    public int getCurrentPrice() {
        return currentPrice;
    }

    public String getWinner() {
        return usernameOfThisBet;
    }

    public LocalDateTime getDateTimeEnd() {
        return dateTimeEnd;
    }
}
