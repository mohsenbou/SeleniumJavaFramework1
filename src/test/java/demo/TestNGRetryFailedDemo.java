package demo;

import listeners.RetryAnalyser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGRetryFailedDemo {

    @Test
    public void one(){
        System.out.println("I am inside test 1");
    }
    @Test
    public void two(){
        System.out.println("I am inside test 2");
        int i = 1/0;
    }

    @Test(retryAnalyzer = listeners.RetryAnalyser.class)
    public void three(){
        System.out.println("I am inside test 3");
        Assert.assertTrue(0>1);
    }

}
