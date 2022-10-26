package k_strings;

import java.util.HashMap;
import java.util.Map;

public class StringTestClass {
    public static final Map<String,String> Params = new HashMap<>();
    public static void main(String[] args) {
        String date = "2021-11-19 14:55:52.112";
        System.out.println(formatSignalDate(date));
        Params.put("Test","%s başlıklı sinyaliniz %s'de yönetici onayı beklenmektedir.");
        System.out.println(formatString(Params.get("Test")));

    }
    private static String formatSignalDate(String signalDate){
        String[] signalDateAndTime = signalDate.split(" ");
        return signalDateAndTime[0] + " tarafından "+signalDateAndTime[1].substring(0,8);
    }
    private static String formatString(String source){
        return String.format(source,"asd","dfg");
    }
}
