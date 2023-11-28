package ru.wjs.volodin.practicaltasks8.task15;
import ru.wjs.volodin.practicaltasks8.task15.exceptions.FileReadException;

import java.sql.*;

import static ru.wjs.volodin.practicaltasks8.task15.VeterinaryClinicImporter.createTables;
import static ru.wjs.volodin.practicaltasks8.task15.VeterinaryClinicImporter.importCSVData;

public class Main {
    public static void main(String[] args) throws SQLException {
        if(args.length==0){// или IllegalArgumentException? Ведь речь об аргументах идёт.
            throw new FileReadException("Необходимо передать путь к csv-файлу");
        }
        DataBaseWorker dataBaseWorker = new DataBaseWorker();
        Statement statement = dataBaseWorker.getConnection().createStatement();
        createTables(statement);
        importCSVData(statement,args[0]);

        org.h2.tools.Console.main("-web", "-browser"); // открывает бд в браузере(локально)
        dataBaseWorker.getConnection().close();
    }

}