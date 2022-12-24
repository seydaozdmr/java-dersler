package j_oop.basics;

public class Inner {
    private int a=10;

    class A{
        /**
         * As explained, an inner class has access to all of the members of its enclosing class, but the reverse is not true.
         * Members of the inner class are known only within the scope of the inner class and may not be used by the outer class.
         * For example,
         */
        void print(){
            System.out.println(a);
        }

        void test() {
            for(int i=0; i<10; i++) {
                class InnerLoop {
                    void display() {
                        System.out.println("display: outer_x = " + a);
                    }
                }
                InnerLoop inner = new InnerLoop();
                inner.display();
            }
        }
    }

    private class B{
        void print(){
            System.out.println(a);
        }
    }

    static class C{
        int a=4;
        static int b=4;
        void print(){
            System.out.println(a);
        }
        static void prints(){
            System.out.println(b);
        }

    }

    public static class D{
        static{
            System.out.println("d yaratıldı");
        }
    }

    void print(){
        int c = 12;
        //inner bir sınıf outerda olan bir static sınıfı extends edebiliyor
        class I extends D{
            private int b=123;
            void print(){
                System.out.println(a);
                System.out.println(b);
                System.out.println(c);
            };
        }
    }
}
