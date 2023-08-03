package q_strings;

public class FormatExample {
    private static String CONTENT="Verilen örnekte {x} ve {y} şehirleri yazılacak";
    public static void main(String[] args) {
        String city1="Antalya";
        String city2="Burdur";

        String result = String.format(CONTENT,city1,city2);
        System.out.println(result);

        String replaceResult = CONTENT.replace("{x}",city1).replace("{y}",city2);
        System.out.println(replaceResult);


        String url = "";
//        url=url.substring(url.indexOf("asd")-1);
//        System.out.println(url);

        url = "/deneme/hobi-oyun/dijital-urunler/deneme-urun";

        String[] parts = url.split("deneme\\.com\\.tr", 2);

        String path = parts[parts.length - 1];
    }
}
