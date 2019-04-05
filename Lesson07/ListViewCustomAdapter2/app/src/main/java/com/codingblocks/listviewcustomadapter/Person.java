package com.codingblocks.listviewcustomadapter;

import java.util.ArrayList;

public class Person {

    private String name, dateOfBirth, address, photoUrl, phoneNumber;

    private static ArrayList<Person> people;

    public Person(String name, String dateOfBirth, String address, String photoUrl, String phoneNumber) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.photoUrl = photoUrl;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    static ArrayList<Person> getRandomPeople() {
        if (people == null) {
            people = new ArrayList<>();
            people.add(new Person("Kylie Ruiz",
                    "5/6/1972",
                    "2017 Shady Ln Dr",
                    "https://randomuser.me/api/portraits/women/50.jpg",
                    "(167)-508-9227"));
            people.add(new Person("Nellie Ward",
                    "8/7/1978",
                    "8901 Marsh Ln",
                    "https://randomuser.me/api/portraits/women/51.jpg",
                    "(146)-256-8662"));
            people.add(new Person("Stephen Newman",
                    "4/1/1975",
                    "2495 Bay Ave",
                    "https://randomuser.me/api/portraits/men/50.jpg",
                    "(167)-508-9227"));
            people.add(new Person("Craig Vargas",
                    "12/1/1977",
                    "1354 Airport Ave",
                    "https://randomuser.me/api/portraits/men/94.jpg",
                    "(283)-860-7341"));
            people.add(new Person("Irene Kuhn",
                    "7/5/1976",
                    "3316 Cavour Ave",
                    "https://randomuser.me/api/portraits/women/2.jpg",
                    "(531)-237-4031"));
            people.add(new Person("Dwayne Watts",
                    "10/4/1983",
                    "5420 W Lone Mountain Rd",
                    "https://randomuser.me/api/portraits/men/97.jpg",
                    "(991)-954-1738"));
        }
        return people;
    }

}
