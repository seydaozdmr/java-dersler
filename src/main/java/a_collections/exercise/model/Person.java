package a_collections.exercise.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person
{
    private final String firstName;
    private final String lastName;
    private final List<Pet> pets = new ArrayList<>();

    public Person(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public boolean named(String name)
    {
        return name.equals(this.firstName + ' ' + this.lastName);
    }

    public boolean hasPet(PetType petType)
    {
        return this.pets.stream().anyMatch(e->e.getType().equals(petType));
    }

    public List<Pet> getPets()
    {
        return this.pets;
    }

    public List<PetType> getPetTypes()
    {
        return this.pets.stream().map(Pet::getType).collect(Collectors.toList());
    }

    public Person addPet(PetType petType, String name, int age)
    {
        this.pets.add(new Pet(petType, name, age));
        return this;
    }

    public boolean isPetPerson()
    {
        return !this.pets.isEmpty();
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pets=" + pets +
                '}';
    }
}
