package ru.wjs.volodin.practicaltasks8.task16.daoclasses;


import ru.wjs.volodin.practicaltasks8.task16.IllegalPositionException;
import ru.wjs.volodin.practicaltasks8.task16.baseclasses.Client;
import ru.wjs.volodin.practicaltasks8.task16.baseclasses.Pet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static ru.wjs.volodin.practicaltasks8.task15.VeterinaryClinicImporter.checkNotExistPrimaryKey;

public class PetDAO {
    private Connection connection;

    public PetDAO(Connection connection) {
        this.connection = connection;
    }

    public Pet createPet(String name, Integer age, List<Client> clients) throws SQLException {
        String sqlInserting = "insert into pets(name_pet,age_pet) values(?,?)";
        String insertingPetsClients = "insert into clients_pets(owner_id,pet_id) values(?,?)";
        PreparedStatement preparedStatementPet = connection.prepareStatement(sqlInserting, Statement.RETURN_GENERATED_KEYS);
        PreparedStatement preparedStatementPetClient = connection.prepareStatement(insertingPetsClients);
        preparedStatementPet.setString(1, name);
        preparedStatementPet.setInt(2, age);
        preparedStatementPet.executeUpdate();
        ResultSet resultSet = preparedStatementPet.getGeneratedKeys();
        resultSet.next();
        int medcardId = resultSet.getInt(1);  // теперь возвращает не только 1 =)
        Pet newPet = new Pet(name, age, medcardId);
        for (Client client : clients) {
            preparedStatementPetClient.setInt(1, client.getId());
            preparedStatementPetClient.setInt(2, medcardId);
            newPet.getOwners().add(client);
            preparedStatementPetClient.addBatch(); // чтоб каждый раз не выполнять executeUpdate и потом разом добавить
        }
        preparedStatementPetClient.executeBatch();
        return newPet;
    }

    public Pet findPet(Integer medcardId) throws SQLException {
        Statement statement = connection.createStatement();
        String sqlSelector = String.format("select * from pets where medcard_id = %d", medcardId);
        if (!checkNotExistPrimaryKey(statement, "pets", "medcard_id", Integer.toString(medcardId))) {
            ResultSet resultSet = statement.executeQuery(sqlSelector);
            if (resultSet.next()) {
                return new Pet(
                        resultSet.getString("name_pet"),
                        resultSet.getInt("age_pet"),
                        resultSet.getInt("medcard_id"));
            }
        }
        return null;
    }

    public void deletePet(Integer medcardId) throws SQLException {
        Statement statement = connection.createStatement();
        String sqlDeleteClientsPets = String.format("delete from clients_pets where pet_id = %d", medcardId);
        String sqlDeleter = String.format("delete from pets where MEDCARD_ID = %d", medcardId);
        if (!checkNotExistPrimaryKey(statement, "pets", "medcard_id", String.valueOf(medcardId))) {
            statement.execute(sqlDeleteClientsPets);
            statement.execute(sqlDeleter);
        } else {
            throw new IllegalPositionException("Питомца с такой медкартой не существует: ", medcardId);
        }
    }


    public List<String> findClientPhoneNumbersByPet(Pet pet) throws SQLException {
        List<String> phoneNumbers = new ArrayList<>();
        String sqlSelector = "select phone_number from clients_pets join clients on owner_id = client_id" +
                " where pet_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlSelector);
        preparedStatement.setInt(1, pet.getMedcardId());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            phoneNumbers.add(resultSet.getString(1));
        }
        return phoneNumbers;
    }

    public Pet updatePet(Pet pet) throws SQLException {
        final String updatePet = "update pets set name_pet = ?, age_pet = ? where medcard_id = ?";
        final String deletingOld = "delete from clients_pets where pet_id = ?";
        final String insertingNew = "insert into clients_pets values(?, ?)";

        //connection.setAutoCommit(false);
        PreparedStatement preparedStatement = connection.prepareStatement(updatePet);
        preparedStatement.setString(1, pet.getName());
        preparedStatement.setInt(2, pet.getAge());
        preparedStatement.setInt(3, pet.getMedcardId());
        preparedStatement.executeUpdate();


        PreparedStatement preparedStatementDelete = connection.prepareStatement(deletingOld);
        PreparedStatement preparedStatementCreate = connection.prepareStatement(insertingNew);

        preparedStatementDelete.setInt(1, pet.getMedcardId());
        preparedStatementDelete.execute();

        for (Client client : pet.getOwners()) {
            preparedStatementCreate.setInt(1, client.getId());
            preparedStatementCreate.setInt(2, pet.getMedcardId());
            preparedStatementCreate.addBatch();
        }
        preparedStatementCreate.executeBatch();
        // connection.commit();
        // connection.setAutoCommit(true);

        return pet;
    }

}
