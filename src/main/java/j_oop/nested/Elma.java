package j_oop.nested;

public class Elma {
    /**
     * An inner class, also called a member inner class, is a non-static
     * type defined at the member
     * level of a class (the same level as the methods, instance variables, and constructors).
     */
    private String greeting="Hi";


    class Cekirdek{
/**
 * Can be declared public, protected, package, or private
 * ■■ Can extend a class and implement interfaces
 * ■■ Can be marked abstract or final
 * ■■ Can access members of the outer class, including private members
 */
        private int count=20;
        public int repeat=3;
        public void enter(){
            for(int i=0;i<repeat;i++){
                greet(greeting);
            }
        }
        private void greet(String message){
            System.out.println(message);
        }
    }
    static class Kabuk{
        static int a=10;
        String name="meyve kabuğu";
    }


    public void enterRomm(){
        var cekirdek=new Cekirdek();
        cekirdek.enter();
        int a=10;
        class Test{
            void write(){
                System.out.println(a);
            }
        }
        abstract class Test2{
            abstract void write();
        }

        Test t=new Test(){
            void write(){
                System.out.println("test anonymous class");
            }
        };
        t.write();

        Test2 t2=new Test2() {
            @Override
            void write() {
                System.out.println("test anonymous class test2");
            }
        };
        t2.write();

    }

    public static void main(String[] args) {
        var elma= new Elma();
        elma.enterRomm();
        Cekirdek test=elma.new Cekirdek();
        test.enter();
        Kabuk k=new Kabuk();
        System.out.println(k.name);
    }
}


