package c_stream.builtinfunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<String> elem=String::new;
        Supplier<List<String>> list= ArrayList::new;


    }
}
