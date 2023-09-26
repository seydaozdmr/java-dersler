package f_exceptions;

import j_oop.dynamicdispatch.E;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SystemExitExample {
    public SystemExitExample() throws FileNotFoundException {
    }

    public static void main(String[] args) {
//        try{
//            System.out.println("asd");
//            throw new RuntimeException("asdasd");
//        }catch (RuntimeException e){
//            System.out.println("run time exception");
//        }finally {
//            System.out.println("finally");
//        }
//        try {
//            method2();
//        } catch (Exception e) {
//            System.out.println("handled");
//        }

//        SystemExitExample systemExitExample = new SystemExitExample();
//        systemExitExample.printSay(new Child());

        try(FileReader fr = new FileReader("asdasd")){

        }catch(Exception e){}


    }

    static void method1() throws Exception {
        throw new Exception("runtime1");
    }

    static void method2() throws Exception {
        method1();
    }

//    void printSay (Parent p){
//        p.say();
//    }



}

class Parent{
    void say() throws Exception{
        System.out.println("parent");
    }
}

class Child extends Parent{
    void say() throws IOException{
        System.out.println("child");
    }
}
