package c_stream.concat;

public class IgnoreCase {
    public static void main(String[] args) {

        System.out.println(test("DeSC"));
    }

    static boolean test(String value){
        return value.equalsIgnoreCase("DESC");
    }
}
