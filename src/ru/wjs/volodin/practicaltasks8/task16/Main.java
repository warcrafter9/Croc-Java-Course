package ru.wjs.volodin.practicaltasks8.task16;

import ru.wjs.volodin.practicaltasks8.task15.DataBaseWorker;
import ru.wjs.volodin.practicaltasks8.task15.VeterinaryClinicImporter;
import ru.wjs.volodin.practicaltasks8.task16.baseclasses.Client;
import ru.wjs.volodin.practicaltasks8.task16.daoclasses.ClientDAO;
import ru.wjs.volodin.practicaltasks8.task16.daoclasses.PetDAO;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        DataBaseWorker dataBaseWorker = new DataBaseWorker();
        Statement statement = dataBaseWorker.getConnection().createStatement();
        VeterinaryClinicImporter.createTables(statement);
        Client client1 = new Client(1, "Иванов", "Иван", "+79193412871");
        Client client2 = new Client(2, "Лимощенко", "Дмитрий", "+79193412871");
       ClientDAO.createClient(client1);
       ClientDAO.createClient(client2);
        System.out.println("До удаления: ");
        System.out.println(ClientDAO.findClient(1));
        System.out.println(ClientDAO.findClient(2));
       ClientDAO.deleteClient(1);
        System.out.println("После удаления: ");
        System.out.println(ClientDAO.findClient(1));
        System.out.println(ClientDAO.findClient(2));
          ClientDAO.createClient(client1);

          client1 = new Client(1, "Володин", "Валерий", "+79823412872"); // переделываем клиента для обновления
          ClientDAO.updateClient(client1);
        System.out.println();
        System.out.println("Обновление(Иванов -> Володин): ");

        System.out.println(ClientDAO.findClient(1));
        System.out.println(ClientDAO.findClient(2));
        List<Client> ownersLord = Arrays.asList(client1,client2);
        PetDAO.createPet("Лорд",14,ownersLord);
        System.out.println(PetDAO.findPet(1));
        PetDAO.deletePet(1);
        System.out.println("После удаления питомца: "+ PetDAO.findPet(1));
        org.h2.tools.Console.main("-web", "-browser"); // открывает бд в браузере(локально)
        dataBaseWorker.getConnection().close();
    }
}
