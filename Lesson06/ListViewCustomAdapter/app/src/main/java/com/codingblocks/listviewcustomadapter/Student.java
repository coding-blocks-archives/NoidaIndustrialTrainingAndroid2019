package com.codingblocks.listviewcustomadapter;

public class Student {

    private String name,surName,address,contact;

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }

    public Student(String name, String surName, String address, String contact) {
        this.name = name;
        this.surName = surName;
        this.address = address;
        this.contact = contact;
    }
}
