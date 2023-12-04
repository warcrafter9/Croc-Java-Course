package ru.wjs.volodin.practicaltasks8.task16.baseclasses;


import java.util.ArrayList;
import java.util.List;

public class Pet {

    private Integer medcardId;
    private String name;
    private Integer age;
    private List<Client> owners;
    public Pet(String name, Integer age,Integer medcardId) {
        this.medcardId =medcardId;
        this.name = name;
        this.age = age;
        this.owners = new ArrayList<>();
    }

    public List<Client> getOwners() {
        return owners;
    }

    @Override
    public String toString() {
        return String.format("<< Питомец: medcardId:%d, имя: %s, возраст: %d >> ",medcardId,name,age);
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

}
