package c_stream.lambdas;

import java.util.List;

public class LambdaSearch {

    public static void main(String[] args) {
        List<Animal> animals=List.of(new Animal("fish",false,true)
                ,new Animal("kangaroo",true,false)
                ,new Animal("rabbit",true,false)
                ,new Animal("turtle",false,true));

//        CheckTrait checkTrait=new CheckTrait() {
//            @Override
//            public boolean test(Animal a) {
//                return a.isCanHop();
//            }
//        };
//
//
//
//        CheckTrait isSwimTest=a -> a.isSwim();
//
//        printCanHop(animals,checkTrait);
//
//        printCanHop(animals,a->a.isSwim());
//
//        printCanHop(animals,a->a.isCanHop());
//
//
//        CheckWheterKangarooAndSwim test=(Animal a,String name)-> {
//            if(a.getName().equals(name)){
//                System.out.println(a);
//            }
//        };
//        CheckWheterKangarooAndSwim test3=(a,s)->{
//            if(a.getName().equals(s)){
//                System.out.println(a);
//            }
//        };
//
//        CheckWheterKangarooAndSwim test2=new CheckWheterKangarooAndSwim() {
//            @Override
//            public void check(Animal a, String name) {
//
//            }
//        };
//
//        CheckSomething checkSomething=()-> System.out.println("merhaba dünya");
//        checkSomething.write();
//
//        TestClassForLambda testClassForLambda=new TestClassForLambda();
//        testClassForLambda.write();

        printCanHop(animals, new CheckTrait() {
            @Override
            public boolean test(Animal a) {
                return a.isCanHop();
            }
        });

    }
    private static void printCanHop(List<Animal> animals,CheckTrait checkTrait){
        for(Animal a:animals){
            if(checkTrait.test(a))
                System.out.println(a);
        }
    }

    private static void testMethod(){
        System.out.println("12jlşfdjad");
        System.out.println("test method");
    }
}
