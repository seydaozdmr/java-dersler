package k_strings;

public class StringReplaceAll {
    public static void main(String[] args) {
        String one = "-";
        String regex = "["+one+"|\\|]";

        String randomString = "seyda- öz|demir";
        System.out.println(randomString.replaceAll(regex,""));
    }
}
