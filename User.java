

import java.io.Serializable;
import java.time.LocalDate;

public class User implements Serializable
{


    private String email;
    private String name;
    private   String surname;
    private int age;


    public User(){}

    public User(String email, String name, String surname, int age)
    {

        this.age = age;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", date_of_birth=" + date_of_birth +
                '}';
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private LocalDate date_of_birth;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAge() {
        return "YOU ARE "+ this.age+" YEARS OLD";
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
