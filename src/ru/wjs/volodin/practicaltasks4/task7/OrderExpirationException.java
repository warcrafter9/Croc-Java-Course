package ru.wjs.volodin.practicaltasks4.task7;

public class OrderExpirationException extends RuntimeException{
    public OrderExpirationException(String message){
        super(message);
    }
}
