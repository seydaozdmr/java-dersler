package b_generics.ocp;

import java.util.List;
import java.util.Objects;

public class LongTailAnimal {
    public void chew (List<Object> input){}

    /**
     * 'chew(List<Object>)' clashes with 'chew(List<Double>)'; both methods have same erasure
     * @param input
     */
    //public void chew(List<Double> input){}

}
