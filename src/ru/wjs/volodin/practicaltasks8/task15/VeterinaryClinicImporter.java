package ru.wjs.volodin.practicaltasks8.task15;

import ru.wjs.volodin.practicaltasks8.task15.exceptions.DataBaseConnectionException;
import ru.wjs.volodin.practicaltasks8.task15.exceptions.FileReadException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

public class VeterinaryClinicImporter {
    private VeterinaryClinicImporter() {
        // Конструктор задан только для того, чтобы экземпляр класса случайно не создали
    }

    /**
     * Метод, позволяющий импортировать данные csv-файла в БД.
     *
     * @param pathCSVFile путь к файлу, который должен передаваться через параметры в командной строке
     */
    public static void importCSVData(Statement statement, String pathCSVFile) throws SQLException {
        try (BufferedReader reader = new BufferedReader(new FileReader(pathCSVFile))) {

            String str;
            while ((str = reader.readLine()) != null) {
                if (str.isBlank()) {
                    continue;
                }
                ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(str.split(",")));
                insertToTable(statement, arrayList);
            }

        } catch (IOException e) {
            throw new FileReadException("Неверно указан путь к csv-файлу");
        }
    }

    /**
     * Метод, вставляющий список слов в таблицы
     *
     * @param list список слов в строке, разделенных запятыми.
     */
    private static void insertToTable(Statement statement, ArrayList<String> list) throws SQLException {
        String insertingClientsStr = "INSERT INTO clients (CLIENT_ID,SURNAME,name,phone_number) "
                + String.format("VALUES ('%d','%s','%s','%s')", Integer.parseInt(list.get(0)), list.get(1), list.get(2), list.get(3));
        String insertingPetsStr = "INSERT INTO pets (medcard_id,name_pet,age_pet) " +
                String.format("VALUES ('%d','%s','%s' )", Integer.parseInt(list.get(4)), list.get(5), list.get(6));
        String insertingPetsClients = "insert into clients_pets(client_id,medcard_id)" +
                String.format("values('%d','%d')", Integer.parseInt(list.get(0)), Integer.parseInt(list.get(4)));
        if (checkNotExistPrimaryKey(statement, "CLIENTS", "CLIENT_ID", list.get(0))) {
            statement.execute(insertingClientsStr);
        }
        if (checkNotExistPrimaryKey(statement, "PETS", "MEDCARD_ID", list.get(4))) {
            statement.execute(insertingPetsStr);
        }
        statement.execute(insertingPetsClients);
    }


    /**
     * Метод, проверяющий существование записи с определенным primary key
     *
     * @param table      таблица, в которой происходит проверка
     * @param primaryKey значение ключа
     * @param column     колонка primary key
     * @return true, если клиент/питомец с таким primary key ещё не существует.
     */
    public static boolean checkNotExistPrimaryKey(Statement statement, String table, String column, String primaryKey) throws SQLException {
        String existSQL = String.format("SELECT COUNT(*) FROM %s WHERE %s = %s", table, column, primaryKey);
        try {
            ResultSet resultSet = statement.executeQuery(existSQL);
            if (resultSet.next()) { // берем строку из resultSet
                int count = resultSet.getInt(1); // количество строк, если !=0, то такой клиент/медкарта уже есть(primary key)
                return count == 0;
            }
        } catch (SQLException e) {
            throw new DataBaseConnectionException("Проверьте доступ к БД или наличие соответствующих колонок");
        }
        return true;
    }


    public static void createTables(Statement statement) throws SQLException {

        String clientsTable = " create table IF NOT EXISTS clients(" +
                "client_id integer primary key," +
                "SURNAME varchar not null," +
                "NAME varchar not null," +
                "PHONE_NUMBER varchar not null)";
        String petsTable = "CREATE TABLE IF NOT EXISTS pets (" +
                "MEDCARD_ID INTEGER primary key AUTO_INCREMENT, " +
                "name_pet VARCHAR(255) not null, " +
                "age_pet INTEGER not null)";
        String clientPetsTable = " create table  IF NOT EXISTS clients_pets(" +
                "owner_id integer not null," +
                "pet_id integer not null," +
                "PRIMARY KEY (pet_id, owner_id)," +
                "FOREIGN KEY (owner_id) REFERENCES clients(client_id)," +
                "FOREIGN KEY (pet_id) REFERENCES pets(medcard_id))";
        statement.execute(clientsTable);
        statement.execute(petsTable);
        statement.execute(clientPetsTable);

    }
}
