import org.junit.Assert;
import org.junit.Test;


public class Tests {
    @Test
    public void test1() {

        IncrementSynchronize is = new IncrementSynchronize();
        Assert.assertEquals(1, is.getNextValue1());
        try {
            is.getNextValue2();
            Assert.assertEquals(2, is.getValue());
            Assert.assertEquals(3, is.getNextValue3());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

