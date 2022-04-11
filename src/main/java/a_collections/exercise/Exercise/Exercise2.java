package a_collections.exercise.Exercise;

import a_collections.exercise.model.Person;
import a_collections.exercise.model.PetType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

public class Exercise2 extends PetDomainForKata{

    @Test
    public void doAnyPeopleHaveCats()
    {
        Predicate<Person> predicate = null; //replace null with a Predicate lambda which checks for PetType.CAT
        Assertions.assertTrue(this.people.stream().anyMatch(predicate));
    }

    @Test
    public void doAllPeopleHavePets()
    {
        Predicate<Person> predicate = Person::isPetPerson;
        boolean result = true; //replace with a method call send to this.people that checks if all people have pets
        Assertions.assertFalse(result);
    }

    @Test
    public void howManyPeopleHaveCats()
    {
        int count = 0;
        Assertions.assertEquals(2, count);
    }

    @Test
    public void findMarySmith()
    {
        Person result = null;
        Assertions.assertEquals("Mary", result.getFirstName());
        Assertions.assertEquals("Smith", result.getLastName());
    }

    @Test
    public void getPeopleWithPets()
    {
        List<Person> petPeople = this.people; // replace with only the pet owners
        Assertions.assertEquals(7, petPeople.size());
    }

    @Test
    public void getAllPetTypesOfAllPeople()
    {
        Function<Person, Iterable<PetType>> function = Person::getPetTypes;
        Set<PetType> petTypes = null;

        var expectedSet = Set.of(PetType.CAT, PetType.DOG, PetType.TURTLE, PetType.HAMSTER, PetType.BIRD, PetType.SNAKE);
        Assertions.assertEquals(expectedSet, petTypes);
    }

    @Test
    public void getFirstNamesOfAllPeople()
    {
        List<String> firstNames = null;  // Transform this.people into a list of first names

        var expectedList = List.of("Mary", "Bob", "Ted", "Jake", "Barry", "Terry", "Harry", "John");
        Assertions.assertEquals(expectedList, firstNames);
    }

    @Test
    public void doAnyPeopleHaveCatsRefactor()
    {
        //pericate'e göre hiç kedi sahibi olan var mı bunu method referans kullanarak yazınız
        boolean peopleHaveCatsLambda = this.people.stream().anyMatch(person -> person.hasPet(PetType.CAT));
        Assertions.assertTrue(peopleHaveCatsLambda);

        //use method reference, NOT lambdas, to solve the problem below
        boolean peopleHaveCatsMethodRef = false;
        Assertions.assertTrue(peopleHaveCatsMethodRef);
    }

    @Test
    public void doAllPeopleHaveCatsRefactor()
    {
        boolean peopleHaveCatsLambda = this.people.stream().anyMatch(person -> person.hasPet(PetType.CAT));
        Assertions.assertFalse(peopleHaveCatsLambda);

        //use method reference, NOT lambdas, to solve the problem below
        boolean peopleHaveCatsMethodRef = true;
        Assertions.assertFalse(peopleHaveCatsMethodRef);
    }

    @Test
    public void getPeopleWithCatsRefactor()
    {
        //use method reference, NOT lambdas, to solve the problem below
        List<Person> peopleWithCatsMethodRef = null;
        Assertions.assertEquals(2, peopleWithCatsMethodRef.size());
    }

    @Test
    public void getPeopleWithoutCatsRefactor()
    {
        //use method reference, NOT lambdas, to solve the problem below
        List<Person> peopleWithoutCatsMethodRef = null;
        Assertions.assertEquals(6, peopleWithoutCatsMethodRef.size());
    }
}
