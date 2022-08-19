package a_collections.exercise.Exercise;

import a_collections.exercise.model.Person;
import a_collections.exercise.model.Pet;
import a_collections.exercise.model.PetType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

public class Exercise4 extends PetDomainForKata{
//    @Test
//    @Tag("KATA")
//    public void getAgeStatisticsOfPets()
//    {
//        //Assertions.fail("Refactor to Eclipse Collections. Don't forget to comment this out or delete it when you are done.");
//
//        // Try to use a MutableIntList here instead
//        // Hints: flatMap = flatCollect, map = collect, mapToInt = collectInt
//        var petAges = null;
//
//        // Try to use an IntSet here instead
//        var uniqueAges = Set.copyOf(petAges);
//
//        // IntSummaryStatistics is a class in JDK 8 - Look at MutableIntList.summaryStatistics().
//        var stats = null;
//
//        // Is a Set<Integer> equal to an IntSet?
//        // Hint: Try IntSets instead of Set as the factory
//        var expectedSet = Set.of(1, 2, 3, 4);
//        Assertions.assertEquals(expectedSet, uniqueAges);
//
//        // Try to leverage minIfEmpty, maxIfEmpty, sum, averageIfEmpty on IntList
//        Assertions.assertEquals(stats.getMin(), petAges.stream().mapToInt(i -> i).min().orElse(0));
//        Assertions.assertEquals(stats.getMax(), petAges.stream().mapToInt(i -> i).max().orElse(0));
//        Assertions.assertEquals(stats.getSum(), petAges.stream().mapToInt(i -> i).sum());
//        Assertions.assertEquals(stats.getAverage(), petAges.stream().mapToInt(i -> i).average().orElse(0.0), 0.0);
//        Assertions.assertEquals(stats.getCount(), petAges.size());
//
//        // Hint: JDK xyzMatch = Eclipse Collections xyzSatisfy
//        Assertions.assertTrue(petAges.stream().allMatch(i -> i > 0));
//        Assertions.assertFalse(petAges.stream().anyMatch(i -> i == 0));
//        Assertions.assertTrue(petAges.stream().noneMatch(i -> i < 0));
//    }
//
//    @Test
//    @Tag("KATA")
//    public void streamsToECRefactor1()
//    {
//        Assertions.fail("Refactor to Eclipse Collections. Don't forget to comment this out or delete it when you are done.");
//
//        //find Bob Smith
//        Person person = null;
//
//        //get Bob Smith's pets' names
//        String names = null;
//
//        Assertions.assertEquals("Dolly & Spot", names);
//    }
//
//    @Test
//    @Tag("KATA")
//    public void streamsToECRefactor2()
//    {
//        Assertions.fail("Refactor to Eclipse Collections. Don't forget to comment this out or delete it when you are done.");
//
//        // Hint: Try to replace the immutable Map<PetType, Long> with an Set<PetType>
//        Map<PetType, Long> counts =
//                null;
//
//        Assertions.assertEquals(Long.valueOf(2L), counts.get(PetType.CAT));
//        Assertions.assertEquals(Long.valueOf(2L), counts.get(PetType.DOG));
//        Assertions.assertEquals(Long.valueOf(2L), counts.get(PetType.HAMSTER));
//        Assertions.assertEquals(Long.valueOf(1L), counts.get(PetType.SNAKE));
//        Assertions.assertEquals(Long.valueOf(1L), counts.get(PetType.TURTLE));
//        Assertions.assertEquals(Long.valueOf(1L), counts.get(PetType.BIRD));
//    }
//
//    /**
//     * The purpose of this test is to determine the top 3 pet types.
//     */
//    @Test
//    @Tag("KATA")
//    public void streamsToECRefactor3()
//    {
//        Assertions.fail("Refactor to Eclipse Collections. Don't forget to comment this out or delete it when you are done.");
//
//        // Hint: The result of groupingBy/counting can almost always be replaced by a Bag
//        // Hint: Look for the API on Bag that might return the top 3 pet types
//        var favorites = null;
//
//        Assertions.assertEquals(3, favorites.size());
//
//        // Hint: Look at PrimitiveTuples.pair(Object, int)
////        Assertions.assertEquals(new AbstractMap.SimpleEntry<>(PetType.CAT, Long.valueOf(2)), favorites.contains());
////        Verify.assertContains(new AbstractMap.SimpleEntry<>(PetType.DOG, Long.valueOf(2)), favorites);
////        Verify.assertContains(new AbstractMap.SimpleEntry<>(PetType.HAMSTER, Long.valueOf(2)), favorites);
//    }
//
//    @Test
//    @Tag("KATA")
//    public void getMedianOfPetAges()
//    {
//        Assertions.fail("Refactor to Eclipse Collections. Don't forget to comment this out or delete it when you are done.");
//
//        // Try to use a MutableIntList here instead
//        // Hints: flatMap = flatCollect, map = collect, mapToInt = collectInt
//        var petAges = null;
//
//        // Try to refactor the code block finding the median the JDK way
//        // Use the EC median method
//        var sortedPetAges = null;
//
//        double median;
//        if (0 == sortedPetAges.size() % 2)
//        {
//            // The median of a list of even numbers is the average of the two middle items
//            median = sortedPetAges.stream().skip((sortedPetAges.size() / 2) - 1).limit(2L).mapToInt(i -> i).average().getAsDouble();
//        }
//        else
//        {
//            // The median of a list of odd numbers is the middle item
//            median = sortedPetAges.get(abs(sortedPetAges.size() / 2)).doubleValue();
//        }
//
//        Assertions.assertEquals(2.0, median, 0.0);
//    }
}
