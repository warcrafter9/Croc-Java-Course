package ru.wjs.volodin.practicaltasks8.task15.exceptions;

public class DataBaseConnectionException extends RuntimeException{
    public DataBaseConnectionException(String message){
        super(message);
    }
}
