package ru.wjs.volodin.practicaltasks8.task16.baseclasses;

public class Client {
    private Integer id;
    private String name;
    private String surname;
    private String phoneNumber;

    public Client(Integer id, String surname, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    @Override
    public String toString() {
        return String.format("Клиент: id:%d, %s %s, номер телефона: %s", id, surname, name, phoneNumber);
    }
}
