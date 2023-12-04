package ru.wjs.volodin.practicaltasks8.task15;

import ru.wjs.volodin.practicaltasks8.task15.exceptions.DataBaseConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseWorker {
    private final String url;
    private final String user;
    private final String password;
    private Connection connection;
    public DataBaseWorker(String url,String user, String password){
        this.url = url;
        this.user = user;
        this.password = password;
        try{
             connection = DriverManager.getConnection(url,user,password);
        }catch (SQLException e){
            throw new DataBaseConnectionException("Не удалось соединиться с БД");
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
