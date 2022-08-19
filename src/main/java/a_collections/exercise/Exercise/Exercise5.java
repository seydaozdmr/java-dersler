package a_collections.exercise.Exercise;

import a_collections.exercise.model.Person;
import a_collections.exercise.model.Pet;
import a_collections.exercise.model.PetType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exercise5 {


    @Test
    @Tag("KATA")
    public void getOldestPet()
    {
        Pet oldestPet = null;
        Assertions.assertEquals(PetType.DOG, oldestPet.getType());
        Assertions.assertEquals(4, oldestPet.getAge());
    }

    @Test
    @Tag("KATA")
    public void getAveragePetAge()
    {
        double averagePetAge = 0;
        Assertions.assertEquals(1.8888888888888888, averagePetAge, 0.00001);
    }

    @Test
    @Tag("KATA")
    public void addPetAgesToExistingSet()
    {
        // Hint: Use petAges as a target collection
        Set<Integer> petAges = null;

        var expectedSet = Set.of(1, 2, 3, 4, 5);
        Assertions.assertEquals(expectedSet, petAges);
    }

    @Test
    @Tag("KATA")
    public void refactorToEclipseCollections()
    {
        Assertions.fail("Refactor to Eclipse Collections");

        // Replace List and ArrayList with Eclipse Collections types
        var people = new ArrayList<Person>();
        people.add(new Person("Mary", "Smith").addPet(PetType.CAT, "Tabby", 2));
        people.add(new Person("Bob", "Smith")
                .addPet(PetType.CAT, "Dolly", 3)
                .addPet(PetType.DOG, "Spot", 2));
        people.add(new Person("Ted", "Smith").addPet(PetType.DOG, "Spike", 4));
        people.add(new Person("Jake", "Snake").addPet(PetType.SNAKE, "Serpy", 1));
        people.add(new Person("Barry", "Bird").addPet(PetType.BIRD, "Tweety", 2));
        people.add(new Person("Terry", "Turtle").addPet(PetType.TURTLE, "Speedy", 1));
        people.add(new Person("Harry", "Hamster")
                .addPet(PetType.HAMSTER, "Fuzzy", 1)
                .addPet(PetType.HAMSTER, "Wuzzy", 1));
        people.add(new Person("John", "Doe"));

        // Replace Set and HashSet with Eclipse Collections types
        var petAges = new HashSet<Integer>();
        for (Person person : people)
        {
            for (Pet pet : person.getPets())
            {
                petAges.add(pet.getAge());
            }
        }

        //extra bonus - convert to a primitive collection
        var expectedSet = Set.of(1, 2, 3, 4);
        Assertions.assertEquals(expectedSet, petAges, "Extra Credit - convert to a primitive collection");
    }
}
