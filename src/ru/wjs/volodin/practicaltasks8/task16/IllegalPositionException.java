package ru.wjs.volodin.practicaltasks8.task16;

public class IllegalPositionException extends RuntimeException {
   public IllegalPositionException(String message,Integer id){
     super(message+id);
    }
}
