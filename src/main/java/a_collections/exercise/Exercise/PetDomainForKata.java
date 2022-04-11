package a_collections.exercise.Exercise;

import a_collections.exercise.model.Person;
import a_collections.exercise.model.PetType;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;
import java.util.NoSuchElementException;

public abstract class PetDomainForKata {
    protected List<Person> people;

    @BeforeEach
    public void setUp() throws Exception
    {
        this.people = List.of(
                new Person("Mary", "Smith").addPet(PetType.CAT, "Tabby", 2),
                new Person("Bob", "Smith")
                        .addPet(PetType.CAT, "Dolly", 3)
                        .addPet(PetType.DOG, "Spot", 2),
                new Person("Ted", "Smith").addPet(PetType.DOG, "Spike", 4),
                new Person("Jake", "Snake").addPet(PetType.SNAKE, "Serpy", 1),
                new Person("Barry", "Bird").addPet(PetType.BIRD, "Tweety", 2),
                new Person("Terry", "Turtle").addPet(PetType.TURTLE, "Speedy", 1),
                new Person("Harry", "Hamster")
                        .addPet(PetType.HAMSTER, "Fuzzy", 1)
                        .addPet(PetType.HAMSTER, "Wuzzy", 1),
                new Person("John", "Doe")
        );
    }

    public Person getPersonNamed(String fullName)
    {
        return this.people.stream().filter(e->e.getFirstName().equals(fullName)).findAny().orElseThrow(()->new NoSuchElementException("aradığınız kişi bulunamıştır. "));
    }
}
