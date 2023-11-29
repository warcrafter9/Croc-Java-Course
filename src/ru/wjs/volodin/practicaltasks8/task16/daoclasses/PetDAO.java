package ru.wjs.volodin.practicaltasks8.task16.daoclasses;

import ru.wjs.volodin.practicaltasks8.task15.DataBaseWorker;
import ru.wjs.volodin.practicaltasks8.task16.IllegalPositionException;
import ru.wjs.volodin.practicaltasks8.task16.baseclasses.Client;
import ru.wjs.volodin.practicaltasks8.task16.baseclasses.Pet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static ru.wjs.volodin.practicaltasks8.task15.VeterinaryClinicImporter.checkNotExistPrimaryKey;

public class PetDAO {
   private static final DataBaseWorker dataBaseWorker = new DataBaseWorker();
   public static Pet createPet(String name, Integer age, List<Client> clients) throws SQLException {
      int medcardId = 0;
       try (Statement statement = dataBaseWorker.getConnection().createStatement()) {
           for (Client client : clients) {
               String sqlInserting = String.format("insert into pets(client_id,name_pet,age_pet) values('%d','%s','%d')",
                       client.getId(), name, age);  // но так для одного питомца будет создаваться две медкарты
               statement.execute(sqlInserting);
               medcardId = Statement.RETURN_GENERATED_KEYS;
           }
       }
       return new Pet(name,age,medcardId);
   }
    public static Pet findPet(Integer medcardId){
        String sqlSelector = String.format("select * from pets where medcard_id = %d", medcardId);
        try (Statement statement = dataBaseWorker.getConnection().createStatement()) {
            if (!checkNotExistPrimaryKey(statement, "pets", "medcard_id", Integer.toString(medcardId))) {
                ResultSet resultSet = statement.executeQuery(sqlSelector);
                if (resultSet.next()) {
                    return new Pet(
                            resultSet.getString("name_pet"),
                            resultSet.getInt("age_pet"),
                            resultSet.getInt("medcard_id"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

  public static void deletePet(Integer medcardId){
      String sqlDeleter = String.format("delete from pets where MEDCARD_ID = %d", medcardId);
      try (Statement statement = dataBaseWorker.getConnection().createStatement()) {
          if (!checkNotExistPrimaryKey(statement, "pets", "medcard_id", String.valueOf(medcardId))) {
              statement.execute(sqlDeleter);
          }else{
              throw new IllegalPositionException("Питомца с такой медкартой не существует: ", medcardId);
          }
      } catch (SQLException e) {
          throw new RuntimeException(e);
      }
  }
    //TODO
   // public List<String> findClientPhoneNumbersBy(Pet pet){

   // }
   // public List<Pet> getAllPetsOf(Client client){
//
  //  }
}
