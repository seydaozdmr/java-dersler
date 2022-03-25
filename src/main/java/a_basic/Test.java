package a_basic;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Employee employee1=new Employee(10,"ali");
        Employee employee2=new Employee(1,"hasan");
        Employee employee3=new Employee(1,"hüseyin");
        Employee employee4=new Employee(5,"mehmet");

        List<Employee> list=new ArrayList<>();

        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        list.add(employee4);
        list.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getId()>o2.getId())
                    return 1;
                else if (o2.getId()>o1.getId())
                    return -1;
                else
                    return o1.getName().compareTo(o2.getName());
            }
        });
        //Collections.sort(list);

        for (Employee eleman: list) {
            System.out.println(eleman);
        }

//        for (int j=0; j<list.size(); j++ )
//        {
//            if (list.get(j).getId()<3) {
//                System.out.println(list.get(j));
//
//            }
//
//        }












//        int[] dizi=new int[20];
//        Collections.sort(list);
//        System.out.println(list);
//        Collections.sort(list, Comparator.comparing(Employee::getName).thenComparing(Employee::getId));
//        System.out.println(list);
//        Collections.sort(list,(e1,e2)-> e1.getName().compareTo(e2.getName()));
//
//
//        List<String > list2=new ArrayList<>();
//        list2.add("asd");
//        list2.add("dgfdg");

//        for(String s:list2){
//            System.out.println(s);
//            list2.add("rwer");
//        }
    }
}
