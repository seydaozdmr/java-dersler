package c_stream.methodreferancing;

public class Duckling {
    private static void makeSound(String sound){
        LearnToSpeak learnToSpeak=(s)-> System.out.println(s);
        LearnToSpeak learnToSpeak1= System.out::println;
        DuckHelper.teacher(sound,learnToSpeak);

        /**
         * There are four formats for method references:
         * ■■ static methods
         * ■■ Instance methods on a particular object
         * ■■ Instance methods on a parameter to be determined at runtime
         * ■■ Constructors
         */
    }

    public static void main(String[] args) {
        makeSound("hello world");
    }
}
