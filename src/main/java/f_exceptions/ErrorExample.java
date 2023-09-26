package f_exceptions;

public class ErrorExample {

    public static void main(String[] args) {
        errorExample();
    }

    static void errorExample(){
        String asd = "asdas";
        for(int i=0;i<2;i++){
            errorExample();
        }
    }
}
