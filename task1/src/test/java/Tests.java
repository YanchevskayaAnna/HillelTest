import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Tests {
    @Test
    public void test1() {
        Set<String> result = new HashSet<String>();
        result.add("test1");
        Assert.assertEquals(result, Parsing.Parse(Arrays.asList("     test1   ")));
    }
    @Test
    public void test2() {
        Set<String> result = new HashSet<String>();
        result.add("test1");
        Assert.assertEquals(result, Parsing.Parse(Arrays.asList("     test1.,/-;:   ")));
    }
}
