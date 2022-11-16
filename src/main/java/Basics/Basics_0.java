package Basics;

public class Basics_0 {
    public static int print(int a,int b,int c){
        int result=a+b+c;
        return result;
    }

    public static int myInt(){
        return 10;
    }
    public static int deger;

    public static void main(String[] args) {
        System.out.println(print(1,2,3));
        int a = print(2,3,4);
        int b = print(10,20,6);
        System.out.println(a);
        System.out.println(b);
        deger= 10;
        System.out.println(deger);
        System.out.println(myInt());
        int boundry= 2147483646;
        System.out.println(++boundry);

        int _2313=4;
        int firstStudentNumber= 5;
        double PI = 3.14;
        System.out.println(++PI);

//        int y = 1;
//        int deger = y++;
//        System.out.println(deger);
//        int x = ++y; //2 -> oluşan son değeri verip atar
//        int z = y++; //3 -> oluşan ilk değeri verip sonra arttırım yapar
//        System.out.println("z:"+z);
//        y++; //3 + 1 -> 4
//        ++x;
//        System.out.println("y:" + ++y);
//        System.out.println("y:" + y);
//        z = y--;  //5 - 1 = 4
//        System.out.println("z:" + z);
//        System.out.println("y:" + y);
//
//        x+=y; //5
//        System.out.println(x);
//
//
//
//
//
//
//
//
//        String value="Hello world";
//        System.out.println(value);
//
//        float a1= 10;
//        System.out.println(a1);
//
//        System.out.println(x);
//        System.out.println(y);
//
//
////        for(int i=0;i<10;++i){
////            System.out.println(i);
////        }
    }
    public static void test(String[] args){
        System.out.println("Hello world");
    }
}
