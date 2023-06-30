package demo;

import org.testng.annotations.Test;
@Test(groups = {"AllClassTests"})
public class TestNGGroupsDemo {
    @Test(groups={"sanity"})
    public void test1(){
        System.out.println("This is Test1");
    }
    @Test(groups={"sanity", "smoke"})
    public void test2(){
        System.out.println("This is Test2");
    }
    @Test(groups={"sanity","windows.regression"})
    public void test3Windows(){
        System.out.println("This is Test3");
    }
    @Test(groups={"sanity","linux.regression"})
    public void test3Linux(){
        System.out.println("This is Test3");
    }
    @Test
    public void test4(){
        System.out.println("This is Test4");
    }
}
