package d_optinals;

import java.util.function.Function;

public class OptionalsMaybeString {
    private static abstract class MaybeString{
        public abstract MaybeString toUpperCase();
        //Burada istekler artabilir örneğin MaybeString toLowerCase(),MaybeString concat gibi yeni method istekleri gelebilir
        //Bunun önüne geçmek için:
        public abstract MaybeString map(Function<String,String> transform);
        public abstract String orElse (String substitute);
    }

    private static class Some extends MaybeString{
        private String content;

        public Some(String content) {
            this.content = content;
        }

        @Override
        public MaybeString toUpperCase() {
            return new Some(this.content.toUpperCase());
        }

        @Override
        public MaybeString map(Function<String, String> transform) {
            return new Some(transform.apply(content));
        }

        @Override
        public String orElse(String substitute) {
            return this.content;
        }
    }

    private static class None extends MaybeString{

        public None() {
        }


        @Override
        public MaybeString toUpperCase() {
            return this;
        }

        @Override
        public MaybeString map(Function<String, String> transform) {
            return this;
        }

        @Override
        public String orElse(String substitute) {
            return substitute;
        }
    }

    private static void display(MaybeString maybeString){
        MaybeString upperCase = maybeString.toUpperCase();
        String result = upperCase.orElse("Nothing show");
        System.out.println(result);
    }

    private static void changeString(MaybeString maybeString,Function<String,String> mapper){
        MaybeString mapped = maybeString.map(mapper);
        String result = mapped.orElse("Void response");
        System.out.println(result);
    }

    public static void main(String[] args) {
        display(new None());
        display(new Some("Test"));
        changeString(new Some("Test.Testci"),e->e.split("\\.")[0].concat(e.split("\\.")[1]));
    }
}
