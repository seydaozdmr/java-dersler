package f_exceptions;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class MainController {
    static TextField result=new TextField();

    public static void main(String ... args){

        //Button'a bastığınız {

        FormatService formatService=new FormatService("test");

        try {
            formatService.format();
        } catch (GlobalFormatException e) {
            System.out.println(e.getMessage());
            result.setText(e.getMessage());
        }
        //}

        System.out.println(10/2);
        //System.out.println(1/0);

        File file=new File("/test.text");
        try {
            FileReader fileReader=new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
