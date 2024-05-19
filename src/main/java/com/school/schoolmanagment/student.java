package com.school.schoolmanagment;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "student")
public class student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    public student(){

    }
    public student(String firsName,String lastName,String email){
        this.firstName = firsName;
        this.lastName = lastName;
        this.email = email;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getFirsName(){
        return firstName;
    }
    public void setFirsName(String firsName){
        this.firstName = firsName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    @Override
    public String toString(){
        return "student [id=" + id  + " , firstName=" + firstName +" , lastName=" + lastName + " , email=" + email +"]";
    }
}
