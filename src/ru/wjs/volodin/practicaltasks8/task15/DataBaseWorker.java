package ru.wjs.volodin.practicaltasks8.task15;

import ru.wjs.volodin.practicaltasks8.task15.exceptions.DataBaseConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseWorker {
    private final static String URL = "jdbc:h2:~/test";
    private final static String USER = "sa";
    private final static String PASSWORD = "";
    private Connection connection;
    public DataBaseWorker(){
        try{
             connection = DriverManager.getConnection(URL,USER,PASSWORD);
        }catch (SQLException e){
            throw new DataBaseConnectionException("Не удалось соединиться с БД");
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
