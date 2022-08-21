package b_generics.ocp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Anteater extends LongTailAnimal{

    @Override
    public void chew(List<Object> input) {}

    public void chew(ArrayList<Double> input){}
}
