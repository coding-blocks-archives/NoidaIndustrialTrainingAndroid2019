package com.codingblocks.networkingokhttp;

class Student {

    private String name, batch, surname, contact, address, bloodGroup, age, standard, fatherName, motherName, gender;

    private Student() {
    }

    public static class Builder {

        public Builder() {
        }

        Student student = new Student();

        public Builder setName(String name) {
            student.name = name;
            return this;
        }

        public Builder setBatch(String batch) {
            student.batch = batch;
            return this;
        }

        public Builder setAge(String age) {
            student.age = age;
            return this;
        }

        public Builder setSurname(String surname) {
            student.surname = surname;
            return this;
        }

        public Builder setContact(String contact) {
            student.contact = contact;
            return this;
        }

        public Student build() {
            return student;
        }

    }

}
