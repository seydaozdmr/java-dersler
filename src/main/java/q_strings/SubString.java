package q_strings;

public class SubString {
    public static void main(String[] args) {
        System.out.println(removeCountyCode("+905434455566"));
        System.out.println(removeCountyCode("05434455566"));
    }
    private static String removeCountyCode(String value){
        return value.substring(value.length()-10);
    }
}
