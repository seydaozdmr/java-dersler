package j_oop.dynamicdispatch;

class Caller {
    public static void main(String[] args) {
        A a=new A();
        B b=new B();
        C c=new C();

        A caller=a;
        caller.print();
        caller=b;
        caller.print();;
        caller=c;
        caller.print();

        D d = new E();

    }
}
