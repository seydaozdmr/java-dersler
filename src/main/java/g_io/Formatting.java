package g_io;

import java.sql.SQLOutput;

public class Formatting {
    public static void main(String[] args) {
        String country="Almanya";
        String country2 ="US";
        int country1Code=49;
        int country2Code=1;
//        System.out.print(country+" "+country1Code+"\n");
//        System.out.println(country2+" "+country2Code"\n");
        System.out.printf("%-15s%d%n",country,country1Code);
        System.out.printf("%-15s%d%n",country2,country2Code);
        int a=5,b=55,c=555;
        System.out.printf("%03d%n",a);
        System.out.printf("%03d%n",b);
        System.out.printf("%03d%n",c);

        StringBuilder builder=new StringBuilder();
        String a1=String.format("%03d%n",a);
        String a2=String.format("%03d%n",b);
        String a3=String.format("%03d%n",c);
        builder.append(a1);
        builder.append(a2);
        builder.append(a3);
        System.out.println(builder);
    }
}
