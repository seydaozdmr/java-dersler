package c_stream;

import java.util.Arrays;
import java.util.List;

public class Stream_ornek {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("abc1", "abc2", "abc3");

        long size = list.stream().skip(1)
                .map(element -> element.substring(0, 3)).sorted().count();
        System.out.println(size);
    }
}
