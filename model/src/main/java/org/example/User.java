package org.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class User {
    private String name;
    private int age;
    private String address;
    private String contactNo;
    private String employmentStatus;
    private boolean isAdmin;

    public User(String name, int age, String address, String contactNo, String employmentStatus, boolean isAdmin) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.contactNo = contactNo;
        this.employmentStatus = employmentStatus;
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return String.format("{name: %s, age: %d, address: %s, contactNo: %s, employmentStatus: %s, isAdmin: %b}", this.name, this.age, this.address, this.contactNo, this.employmentStatus, this.isAdmin);
    }
}
