package a_collections.exercise.Exercise;

import a_collections.exercise.model.Person;
import a_collections.exercise.model.Pet;
import a_collections.exercise.model.PetType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class Exercise1 extends PetDomainForKata{

    @Test
    public void getFirstNamesOfAllPeople()
    {
        // Replace null, with a transformation method on List.
        //List<String> firstNames = this.people.stream().map(Person::getFirstName).collect(Collectors.toList()); // this.people...
        List<String> firstNames = this.people.stream()
                .map(e-> e.getFirstName())
                .collect(Collectors.toList()); //Burası sizin yapmanız gereken yer

        var expectedFirstNames = List.of("Mary", "Bob", "Ted", "Jake", "Barry", "Terry", "Harry", "John");
        Assertions.assertEquals(expectedFirstNames, firstNames);
    }

    @Test
    @Tag("KATA")
    public void getNamesOfMarySmithsPets()
    {
//        Person person = this.getPersonNamed("Mary Smith");
//        List<Pet> pets = person.getPets();

        // Replace null, with a transformation method on List.
        List<String> names = getPersonNamed("Mary").getPets().stream()
                .map(Pet::getName)
                .collect(Collectors.toList());


        Assertions.assertEquals("[Tabby]", names.toString());
    }

    @Test
    @Tag("KATA")
    public void getPeopleWithCats()
    {
        // Replace null, with a positive filtering method on List.
        List<Person> peopleWithCats = people.stream()
                .filter(e ->e.hasPet(PetType.CAT)).collect(Collectors.toList());

        Assertions.assertEquals(2,peopleWithCats.size());
    }

    @Test
    @Tag("KATA")
    public void getPeopleWithoutCats()
    {
        // Replace null, with a negative filtering method on List.
        List<Person> peopleWithoutCats = people.stream()
                .filter(e ->!e.hasPet(PetType.CAT)).collect(Collectors.toList());

        Assertions.assertEquals(6,peopleWithoutCats.size());
    }


}
