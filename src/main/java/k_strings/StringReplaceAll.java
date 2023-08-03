package k_strings;

public class StringReplaceAll {
    public static void main(String[] args) {
        String one = "-";
        String regex = "["+one+"_]";

        String randomString = "seyda- öz_demir";
        System.out.println(randomString.replaceAll(regex,""));
    }
}
