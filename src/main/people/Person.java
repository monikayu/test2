package main.people;

import util.Generate;

import java.util.Objects;

public abstract class Person {
    private static int sequenceNumber = 10345;
    private String name;
    private int id;


    public Person() {
        this.name = Generate.name();
        id = ++sequenceNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }
}
