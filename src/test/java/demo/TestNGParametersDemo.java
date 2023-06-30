package demo;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParametersDemo {

    @Test
    @Parameters({"MyName"})
    public void Test(@Optional("not define with parameters in xml file") String name){

        System.out.println("Name is: "+ name);
    }

}
