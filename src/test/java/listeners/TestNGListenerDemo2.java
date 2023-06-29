package listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGListeners.class)
public class TestNGListenerDemo2 {
    @Test
    public void test4(){
        System.out.println("I am inside test 4");
    }
    @Test
    public void test5(){
        System.out.println("I am inside test 5");

    }
    @Test
    public void test6(){
        System.out.println("I am inside test 6");
        Assert.fail();
    }
}
