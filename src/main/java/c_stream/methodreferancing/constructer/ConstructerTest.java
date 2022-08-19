package c_stream.methodreferancing.constructer;

import java.util.ArrayList;
import java.util.List;

public class ConstructerTest {
    interface GetList{
        ArrayList<String> getList();
    }
    interface GetConstructer{
        ConstructerTest getTest();
    }
    public static void main(String[] args) {
        GetList list= ArrayList::new;
        List<String> instance=list.getList();
        GetConstructer getConstructer=ConstructerTest::new;
    }
}
