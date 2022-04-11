package a_collections.exercise.Exercise;

import a_collections.exercise.model.Person;
import a_collections.exercise.model.Pet;
import a_collections.exercise.model.PetType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Exercise3 extends PetDomainForKata{

    @Test
    public void getCountsByPetType()
    {
        List<PetType> petTypes = this.people.stream()
                                                .flatMap(e->e.getPets().stream())
                                                .map(Pet::getType)
                                                .collect(Collectors.toList());


        // Do you recognize this pattern?
        Map<PetType, Integer> petTypeCounts = new HashMap<>();
        for (PetType petType : petTypes)
        {
            Integer count = petTypeCounts.get(petType);
            if (count == null)
            {
                count = 0;
            }
            petTypeCounts.put(petType, count + 1);
        }

        Assertions.assertEquals(Integer.valueOf(2), petTypeCounts.get(PetType.CAT));
        Assertions.assertEquals(Integer.valueOf(2), petTypeCounts.get(PetType.DOG));
        Assertions.assertEquals(Integer.valueOf(2), petTypeCounts.get(PetType.HAMSTER));
        Assertions.assertEquals(Integer.valueOf(1), petTypeCounts.get(PetType.SNAKE));
        Assertions.assertEquals(Integer.valueOf(1), petTypeCounts.get(PetType.TURTLE));
        Assertions.assertEquals(Integer.valueOf(1), petTypeCounts.get(PetType.BIRD));

        // Hint: use the appropriate method on this.people to create a Bag<PetType>
        List<PetType> counts = null;
        Assertions.assertEquals(2, counts.stream().filter(p->p.equals(PetType.CAT)).count());
        Assertions.assertEquals(2, counts.stream().filter(p->p.equals(PetType.DOG)).count());
        Assertions.assertEquals(2, counts.stream().filter(p->p.equals(PetType.HAMSTER)).count());
        Assertions.assertEquals(1, counts.stream().filter(p->p.equals(PetType.SNAKE)).count());
        Assertions.assertEquals(1, counts.stream().filter(p->p.equals(PetType.TURTLE)).count());
        Assertions.assertEquals(1, counts.stream().filter(p->p.equals(PetType.BIRD)).count());
    }

    @Test
    public void getPeopleByLastName()
    {
        // Do you recognize this pattern?
        Map<String, List<Person>> lastNamesToPeople = new HashMap<>();
        for (Person person : this.people)
        {
            String lastName = person.getLastName();
            List<Person> peopleWithLastName = lastNamesToPeople.get(lastName);
            if (peopleWithLastName == null)
            {
                peopleWithLastName = new ArrayList<>();
                lastNamesToPeople.put(lastName, peopleWithLastName);
            }
            peopleWithLastName.add(person);
        }
        Assertions.assertEquals(3, lastNamesToPeople.get("Smith").size());

        // Hint: use the appropriate method on this.people to create a Multimap<String, Person>
        Map<String, List<Person>> byLastNameMultimap = null;

        Assertions.assertEquals(3, byLastNameMultimap.get("Smith").size());
    }

    @Test
    public void getPeopleByTheirPets()
    {
        // Do you recognize this pattern?
        Map<PetType, Set<Person>> peopleByPetType = new HashMap<>();

        for (Person person : this.people)
        {
            List<Pet> pets = person.getPets();
            for (Pet pet : pets)
            {
                PetType petType = pet.getType();
                Set<Person> peopleWithPetType = peopleByPetType.get(petType);
                if (peopleWithPetType == null)
                {
                    peopleWithPetType = new HashSet<>();
                    peopleByPetType.put(petType, peopleWithPetType);
                }
                peopleWithPetType.add(person);
            }
        }

        Assertions.assertEquals(2, peopleByPetType.get(PetType.CAT));
        Assertions.assertEquals(2, peopleByPetType.get(PetType.DOG));
        Assertions.assertEquals(1, peopleByPetType.get(PetType.HAMSTER));
        Assertions.assertEquals(1, peopleByPetType.get(PetType.TURTLE));
        Assertions.assertEquals(1, peopleByPetType.get(PetType.BIRD));
        Assertions.assertEquals(1, peopleByPetType.get(PetType.SNAKE));

        // Hint: use the appropriate method on this.people with a target collection to create a MutableSetMultimap<String, Person>
        // Hint: this.people is a MutableList, so it will return a MutableListMultimap without a target collection
        Map<PetType, List<Person>> multimap = null;

        Assertions.assertEquals(2, multimap.get(PetType.CAT).size());
        Assertions.assertEquals(2, multimap.get(PetType.DOG).size());
        Assertions.assertEquals(1, multimap.get(PetType.HAMSTER).size());
        Assertions.assertEquals(1, multimap.get(PetType.TURTLE).size());
        Assertions.assertEquals(1, multimap.get(PetType.BIRD).size());
        Assertions.assertEquals(1, multimap.get(PetType.SNAKE).size());
    }

}
