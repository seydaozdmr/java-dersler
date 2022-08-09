package x_interview;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class TestClass {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        Date test;
        test=ft.parse("2020-06-23");
        Project p1=new Project(test);
        test=ft.parse("2020-01-02");
        Project p2=new Project(test);
        test=ft.parse("2025-12-12");
        Project p3=new Project(test);
        Collection<Project> myList= List.of(p1,p2,p3);
        System.out.println(findProjectWithLatestDate(myList));

        LocalDate localDate=LocalDate.of(2020,06,23);
        LocalDate localDate1=LocalDate.of(2020,01,02);


        LocalDate localDate2=LocalDate.of(2025,12,12);

        ProjectWithLocalDate projectWithLocalDate1=new ProjectWithLocalDate(localDate);
        ProjectWithLocalDate projectWithLocalDate2=new ProjectWithLocalDate(localDate1);
        ProjectWithLocalDate projectWithLocalDate3=new ProjectWithLocalDate(localDate2);
        ProjectWithLocalDate projectWithLocalDate4=new ProjectWithLocalDate(LocalDate.of(2026,01,12));

        List<ProjectWithLocalDate> projectWithLocalDates=List.of(projectWithLocalDate1,projectWithLocalDate2,projectWithLocalDate3,projectWithLocalDate4);

        System.out.println(findProjectWithLatestDate(projectWithLocalDates));

        List<String> testList=new ArrayList<>();

//        testList.add("asda");
//        testList.add("asda1");
//        testList.add("asda2");
//        testList.add("asda3");
//
//        int count=0;
//        while(!testList.isEmpty()){
//            System.out.println(testList.remove(count));
//        }

        Queue<String> kuyruk=new LinkedList<>();
        kuyruk.offer("asd");
        kuyruk.offer("as1");
        kuyruk.offer("asd2");
        kuyruk.offer("asd");
        kuyruk.offer("as1");
        kuyruk.offer("asd2");

        while(!kuyruk.isEmpty()){
            //FIFO -> ilk giren ilk çıkar
            System.out.println(kuyruk.poll());
        }

    }

    public static  ProjectWithLocalDate findProjectWithLatestDate(List<ProjectWithLocalDate> projects){
        return projects.stream()
                .sorted((p1,p2)->p2.localDate.compareTo(p1.localDate))
                .findFirst()
                .get();
    }

    public static Project findProjectWithLatestDate(Collection<Project> projects){
        return projects.stream()
                .sorted()
                .findFirst()
                .get();
    }
    /**
     * P1: 2020.06.23
     * P2: 2020.01.02
     * P3: 2025.12.12
     */
}
