package ru.wjs.volodin.practicaltasks8.task16;

import ru.wjs.volodin.practicaltasks8.task15.DataBaseWorker;
import ru.wjs.volodin.practicaltasks8.task15.VeterinaryClinicImporter;
import ru.wjs.volodin.practicaltasks8.task16.baseclasses.Client;
import ru.wjs.volodin.practicaltasks8.task16.baseclasses.Pet;
import ru.wjs.volodin.practicaltasks8.task16.daoclasses.ClientDAO;
import ru.wjs.volodin.practicaltasks8.task16.daoclasses.PetDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        DataBaseWorker dataBaseWorker = new DataBaseWorker("jdbc:h2:~/test", "sa", "");
        Connection connection = dataBaseWorker.getConnection();
        ClientDAO clientDAO = new ClientDAO(connection);
        PetDAO petDAO = new PetDAO(connection);
        VeterinaryClinicImporter.createTables(connection.createStatement());
        Client client1 = new Client(1, "Иванов", "Иван", "+79193412871");
        Client client2 = new Client(2, "Лимощенко", "Дмитрий", "+79193412871");
        Client client3 = new Client(3, "Угрюмов", "Алексей", "+79193236571");
        clientDAO.createClient(client1);
        clientDAO.createClient(client2);
        clientDAO.createClient(client3);
        System.out.println("До удаления: ");
        System.out.println(clientDAO.findClient(1));
        System.out.println(clientDAO.findClient(2));
        clientDAO.deleteClient(1);
        System.out.println("После удаления: ");
        System.out.println(clientDAO.findClient(1));
        System.out.println(clientDAO.findClient(2));
        clientDAO.createClient(client1);

        client1 = new Client(1, "Володин", "Валерий", "+79823412872"); // переделываем клиента для обновления
        clientDAO.updateClient(client1);
        System.out.println();
        System.out.println("Обновление(Иванов -> Володин): "+ client1);

        System.out.println(clientDAO.findClient(1));
        System.out.println(clientDAO.findClient(2));

        List<Client> ownersLord = Arrays.asList(client1, client2); // клиент 2 тут

        Pet pet1 = petDAO.createPet("Барсик", 10, Arrays.asList(client3));
        Pet pet2 = petDAO.createPet("Лорд", 14, ownersLord); // клиент 2 хозяин Лорда
        Pet pet3 = petDAO.createPet("Ричард", 9, ownersLord); // И Ричарда
        System.out.println(petDAO.findPet(1));
        petDAO.deletePet(1);
        System.out.println("После удаления питомца: " + petDAO.findPet(1));
        System.out.println("Номера телефонов питомца 2 - Лорда");
        System.out.println(petDAO.findClientPhoneNumbersByPet(pet2));
        System.out.println("\n Питомцы клиента - 2: ");
        System.out.println(clientDAO.getAllPetsOf(client2));
        // Питомец для апдейта:
        Pet petForChange = new Pet("Шпиён",6,2);
        System.out.println("До апдейта: "+petDAO.findPet(2));
        petDAO.updatePet(petForChange);
        System.out.println("После апдейта: "+petDAO.findPet(2));
        org.h2.tools.Console.main("-web", "-browser"); // открывает бд в браузере(локально)
        dataBaseWorker.getConnection().close();
    }
}
