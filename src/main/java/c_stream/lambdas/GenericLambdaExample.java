package c_stream.lambdas;

public class GenericLambdaExample {
    public static void main(String[] args) {
        SomeFunc<String> reverse=(e)->{
            String result="";
            for(int i=e.length()-1;i>=0;i--){
                result+=e.charAt(i);
            }
            return result;
        };

        System.out.println(reverse.func("deneme"));

        SomeFunc<Integer> factorial=(n)->{
            int result=1;

            for(int i=1;i<=n;i++){
                result*=i;
            }
            return result;
        };
        System.out.println(factorial.func(5));


    }
}
