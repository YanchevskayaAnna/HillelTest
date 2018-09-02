import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Tests {
    @Test
    public void test1() {

        String[] arr = new String[5];
        arr[0] = "one";
        arr[1] = "two";
        arr[2] = "three";
        arr[3] = "four";
        arr[4] = "five";

        List<String> ar = new ArrayList<>();
        ar.add("six");
        ar.add("seven");

        MyArrayList<String> myArrayList = new MyArrayList<>(arr);
        myArrayList.addAll(ar);

        Assert.assertEquals(myArrayList.size(), 7);
        Assert.assertEquals(myArrayList.get(6), "seven");
    }

}

