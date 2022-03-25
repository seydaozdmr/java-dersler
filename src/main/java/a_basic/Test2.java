package a_basic;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test2 {
    public static void main(String[] args) {
        Employee employee1=new Employee(1,"ali");
        Employee employee2=new Employee(10,"ahmet");
        Employee employee3=new Employee(5,"mehmet");
        Employee employee4=new Employee(20,"yusuf");

        Set<Employee> set=new HashSet<>();
        set.add(employee1);
        set.add(employee2);
        set.add(employee3);
        set.add(employee4);

        System.out.println(set);

        for(Employee elem:set){
            System.out.println(elem.hashCode());
        }
    }
}
