package br.com.sqs.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.io.Serializable;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String fistName;
    private String lastName;

    public Customer() {
    }

    private Customer(String fistName, String lastName) {
        this.fistName = fistName;
        this.lastName = lastName;
    }

    public static Customer of(String name, String email) {
        return new Customer(name, email);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
