package j_oop.basics;

public class A extends B implements TestInterface,Test2Interface{

    private int age;
    private String name;
    private String city;
    private String gender;

    private A(int age, String name, String city, String gender) {
        this.age = age;
        this.name = name;
        this.city = city;
        this.gender = gender;
    }

    public static A aBasic(int age,String name){
        return new A(age,name,null,null);
    }

    public static A fullA(int age, String name, String city, String gender){
        return new A(age,name,city,gender);
    }




    public void test(){
        System.out.println("A");
    }

    public void bTest(){
        this.show();
    }

    @Override
    public void show() {
        System.out.println("New method");
    }
}
