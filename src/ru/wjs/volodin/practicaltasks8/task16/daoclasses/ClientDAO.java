package ru.wjs.volodin.practicaltasks8.task16.daoclasses;


import ru.wjs.volodin.practicaltasks8.task16.IllegalPositionException;
import ru.wjs.volodin.practicaltasks8.task16.baseclasses.Client;
import ru.wjs.volodin.practicaltasks8.task16.baseclasses.Pet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static ru.wjs.volodin.practicaltasks8.task15.VeterinaryClinicImporter.checkNotExistPrimaryKey;

public class ClientDAO {
    private final Connection connection;

    public ClientDAO(Connection connection) {
        this.connection = connection;
    }

    public Client createClient(Client client) throws SQLException {
        Statement statement = connection.createStatement();
        String sqlInserting = String.format("insert into clients(client_id,name,surname,phone_number) values('%d','%s','%s','%s')",
                client.getId(), client.getName(), client.getSurname(), client.getPhoneNumber());
        if (checkNotExistPrimaryKey(statement, "clients", "client_id", Integer.toString(client.getId()))) {
            statement.execute(sqlInserting);
        } else {
            throw new IllegalPositionException("Клиент с таким id уже существует: ", client.getId());
        }
        return client;
    }

    public Client findClient(Integer id) throws SQLException {
        Statement statement = connection.createStatement();
        String sqlSelector = String.format("select * from clients where client_id = %d", id);
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
        return null;
    }

    public void deleteClient(Integer id) throws SQLException {
        Statement statement = connection.createStatement();
        String sqlDeleter = String.format("delete from clients where client_id = %d", id);
        if (!checkNotExistPrimaryKey(statement, "clients", "client_id", String.valueOf(id))) {
            statement.execute(sqlDeleter);
        } else {
            throw new IllegalPositionException("Клиент с таким id не существует: ", id);
        }
    }


    public void updateClient(Client client) throws SQLException {
        Statement statement = connection.createStatement();
        String sqlUpdater = String.format("update clients" +
                " set surname = '%s'," +
                "name = '%s'," +
                "phone_number = '%s'" +
                "where client_id =%d", client.getSurname(), client.getName(), client.getPhoneNumber(), client.getId());
        if (!checkNotExistPrimaryKey(statement, "clients", "client_id", String.valueOf(client.getId()))) {
            statement.execute(sqlUpdater);
        } else {
            throw new IllegalPositionException("Клиент с таким id не существует: ", client.getId());
        }
    }

    public List<Pet> getAllPetsOf(Client client) throws SQLException {
        List<Pet> pets = new ArrayList<>();
        String sqlSelector = "select name_pet,age_pet, medcard_id from clients_pets join pets on pet_id=medcard_id" +
                " where owner_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlSelector);
        preparedStatement.setInt(1, client.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Pet pet = new Pet(resultSet.getString(1), resultSet.getInt(2), resultSet.getInt(3));
            pets.add(pet);
        }
        return pets;
    }
}