package k_strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveChars {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[^0-9.]+");
        Matcher matcher = pattern.matcher("10 TL");
        String cashPrice="";
        String campaignPrice="";
        if (matcher.find()){
            cashPrice= matcher.replaceAll("");
            matcher=pattern.matcher("10 TL");
            campaignPrice=matcher.replaceAll("");
        }

        else{
            matcher=pattern.matcher("10 TL");
            cashPrice=matcher.replaceAll("");
        }
        System.out.println(cashPrice);
    }
}
