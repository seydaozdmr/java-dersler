package f_exceptions;

public class FormatService {

    private String text;
    private String result;
    public FormatService(String text) {
        this.text = text;
    }

    public void format() throws GlobalFormatException {

        if(this.text.equals("test")){
            throw new GlobalFormatException("benim hatam şu şu şu");

        }else{
            throw new GlobalFormatException("benim hatam bu");
        }
    }

}
