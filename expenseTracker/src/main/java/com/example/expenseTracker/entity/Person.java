package com.example.expenseTracker.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long person_id; // Changing id to person_id to match the schema
    private String name; // Changing studentName to name
    private String emailaddress; // Changing studentEmail to emailaddress
    private String mobilenumber; // Adding mobilenumber to match the schema
    // Add other relevant columns for person details

    public Person() {
        super();
    }

    public Person(long person_id, String name, String emailaddress, String mobilenumber) {
        super();
        this.person_id = person_id;
        this.name = name;
        this.emailaddress = emailaddress;
        this.mobilenumber = mobilenumber;
    }

    // Copy constructor
    public Person(Person other) {
        this.person_id = other.person_id;
        this.name = other.name;
        this.emailaddress = other.emailaddress;
        this.mobilenumber = other.mobilenumber;
    }

    public long getPersonId() {
        return person_id;
    }

    public void setPersonId(long person_id) {
        this.person_id = person_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailaddress;
    }

    public void setEmailAddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getMobileNumber() {
        return mobilenumber;
    }

    public void setMobileNumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    @Override
    public String toString() {
        return "Person [person_id=" + person_id + ", name=" + name + ", emailaddress=" + emailaddress
                + ", mobilenumber=" + mobilenumber + "]";
    }
}
