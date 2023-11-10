package q_strings;

public class SubString {
    public static void main(String[] args) {
        System.out.println(removeCountyCode("+905434455566"));
        System.out.println(removeCountyCode("05434455566"));

        String test = "asdasd asdş kasşi - {selam}";
        System.out.println(test.substring(0,test.indexOf('-')));
    }
    private static String removeCountyCode(String value){
        return value.substring(value.length()-10);
    }
}
