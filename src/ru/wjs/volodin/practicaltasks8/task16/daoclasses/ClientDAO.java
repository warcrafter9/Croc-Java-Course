package ru.wjs.volodin.practicaltasks8.task16.daoclasses;

import ru.wjs.volodin.practicaltasks8.task15.DataBaseWorker;
import ru.wjs.volodin.practicaltasks8.task16.IllegalPositionException;
import ru.wjs.volodin.practicaltasks8.task16.baseclasses.Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static ru.wjs.volodin.practicaltasks8.task15.VeterinaryClinicImporter.checkNotExistPrimaryKey;

public class ClientDAO {
    private static DataBaseWorker dataBaseWorker = new DataBaseWorker();

    public static Client createClient(Client client) throws SQLException {
        String sqlInserting = String.format("insert into clients(client_id,name,surname,phone_number) values('%d','%s','%s','%s')",
                client.getId(), client.getName(), client.getSurname(), client.getPhoneNumber());
        try (Statement statement = dataBaseWorker.getConnection().createStatement()) {
            if (checkNotExistPrimaryKey(statement, "clients", "client_id", Integer.toString(client.getId()))) {
                statement.execute(sqlInserting);
            } else {
                throw new IllegalPositionException("Клиент с таким id уже существует: ", client.getId());
            }

        }
        return client;
    }

    public static Client findClient(Integer id) {
        String sqlSelector = String.format("select * from clients where client_id = %d", id);
        try (Statement statement = dataBaseWorker.getConnection().createStatement()) {
            if (!checkNotExistPrimaryKey(statement, "clients", "client_id", Integer.toString(id))) {
                ResultSet resultSet = statement.executeQuery(sqlSelector);
                if (resultSet.next()) {
                    return new Client(
                            resultSet.getInt("client_id"),
                            resultSet.getString("SURNAME"),
                            resultSet.getString("NAME"),
                            resultSet.getString("PHONE_NUMBER"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void deleteClient(Integer id) throws SQLException {
        String sqlDeleter = String.format("delete from clients where client_id = %d", id);
        try (Statement statement = dataBaseWorker.getConnection().createStatement()) {
            if (!checkNotExistPrimaryKey(statement, "clients", "client_id", String.valueOf(id))) {
                statement.execute(sqlDeleter);
            }else{
                throw new IllegalPositionException("Клиент с таким id не существует: ", id);
            }
        }
    }

    public static void updateClient(Client client) {
        String sqlUpdater = String.format("update clients" +
                " set surname = '%s'," +
                "name = '%s'," +
                "phone_number = '%s'" +
                "where client_id =%d",client.getSurname(),client.getName(),client.getPhoneNumber(),client.getId());
        try(Statement statement = dataBaseWorker.getConnection().createStatement()){
            if(!checkNotExistPrimaryKey(statement,"clients","client_id",String.valueOf(client.getId()))){
                statement.execute(sqlUpdater);
            }else{
                throw new IllegalPositionException("Клиент с таким id не существует: ", client.getId());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
