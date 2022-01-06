/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;



import java.io.Serializable;


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

    public String date_of_birth;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return  age;
    }

    public void setAge(int age) {
        this.age = age;
    }

   

  

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
