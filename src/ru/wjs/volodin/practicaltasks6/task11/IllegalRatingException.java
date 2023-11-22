package ru.wjs.volodin.practicaltasks6.task11;

public class IllegalRatingException extends RuntimeException {

  public  IllegalRatingException(String message){
      super();

  }
    public  IllegalRatingException(int rating){
        super("Неверно установлен: "+ rating +" - введите число от 0 до 100.");

    }
}
