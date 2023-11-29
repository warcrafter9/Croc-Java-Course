package ru.wjs.volodin.practicaltasks8.task16.baseclasses;



public class Pet {

    private Integer medcardId;
    private String name;
    private Integer age;
    public Pet(String name, Integer age,Integer medcardId) {
        this.medcardId =medcardId;
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return String.format("Питомец: medcardId:%d, имя: %s, возраст: %d",medcardId,name,age);
    }

    public Integer getMedcardId() {
        return medcardId;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
/*
    public Pet createPet(String name, Integer age, List<Client> clients){
        String sql= String.format("INSERT INTO PETS(name),VALUES(",);
    }
    public Pet findPet(Integer medcardId){

    }
    public Pet updatePet(Pet pet){

    }
    public void deletePet(){

    }
    public List<String> findClientPhoneNumbersBy(Pet pet){

    }
    public List<Pet> getAllPetsOf(Client client){

    }

     */

}
