package c_stream.lambdas;

public class DoubleNumericExample {

    public static void main(String[] args) throws EmptyArrayException {
        double [] values = new double[0];

        DoubleNumericArrayFunc avarage= (n)->{
            double sum=0;

            if(n.length==0)
                throw new EmptyArrayException();
            for(int i=0;i<n.length;i++){
                sum+=n[i];
            }
            return sum/n.length;
        };

        System.out.println(avarage.func(values));
    }
}
