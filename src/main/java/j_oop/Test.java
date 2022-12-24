package j_oop;

public class Test {
    public static void main(String[] args) {
        Meyve meyve=new Elma();
        System.out.println(meyve.name);
        System.out.println(meyve.getName());

        AbstractMeyve meyve1=new MeyveImplErik();
        System.out.println(meyve1.name);
        System.out.println(meyve1.getName());

        String fileName ="asd a ? *^ .^sd.)s/.jpg";
        String output = fileName.replaceAll("[^\\w\\.]|\\s", "-");
        System.out.println(output);

    }
}
