package c_stream.methodreferancing;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestPersonClass {
    private static List<Person> people=Arrays.asList(new Person("ali", LocalDate.of(1990,01,10)),
            new Person("hasan",LocalDate.of(1980,10,01)),
            new Person("mehmet",LocalDate.of(1999,8,10)),
            new Person("hüseyin",LocalDate.of(1986,5,13)));
    class PersonComparator implements Comparator<Person>{

        @Override
        public int compare(Person o1, Person o2) {
            return o1.getBirthday().compareTo(o2.getBirthday());
        }
    }

    private void printListDescByAge(List<Person> personList, Comparator<Person> comparator){
        Collections.sort(personList,comparator);
        //Collections.sort(personList,Person::compareByAge);
        personList.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        TestPersonClass testPersonClass=new TestPersonClass();
        testPersonClass.printListDescByAge(people,testPersonClass.new PersonComparator());
    }

}
