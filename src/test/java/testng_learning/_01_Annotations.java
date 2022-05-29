package testng_learning;

import org.testng.annotations.*;

public class _01_Annotations {
/*
    @BeforeSuite //runs first before anything and runs one time
    public void beforeSuite(){
        System.out.println("This is BEFORE SUITE");
    }

    @AfterSuite //runs last after everything and runs one time
    public void afterSuite(){
        System.out.println("This is AFTER SUITE");
    }

    @BeforeTest //runs before the class and runs 1 time
    public void beforeTest(){
        System.out.println("This is BEFORE TEST");
    }

    @AfterTest //runs after the class and runs 1 time
    public void afterTest(){
        System.out.println("This is AFTER TEST");
    }

    @BeforeClass //executed 1 time before everything in class executed
    public void beforeClass(){
        System.out.println("This is BEFORE CLASS"); //ex "Apple test is running
    }

    @AfterClass //executed 1 time after everything in class executed
    public void afterClass(){
        System.out.println("This is AFTER CLASS"); //ex: Apple test is completed
    }

    @BeforeMethod // runs for each test
    public void beforeMethod(){
        System.out.println("This is BEFORE METHOD");
    }


    @AfterMethod // runs for each test
    public void afterMethod(){
        System.out.println("This is AFTER METHOD");
    }


    @Test
    public void test1(){
        System.out.println("This is TEST1");
    }

    @Test
    public void test2(){
        System.out.println("This is TEST2");
    }

     EXPECTED OUTPUT:
    This is BEFORE SUITE
    This is BEFORE TEST
    This is BEFORE CLASS
    This is BEFORE METHOD
    This is TEST1
    This is AFTER METHOD
    This is BEFORE METHOD
    This is TEST2
    This is AFTER METHOD
    This is AFTER CLASS
    This is AFTER TEST
    This is AFTER SUITE
 */
}
