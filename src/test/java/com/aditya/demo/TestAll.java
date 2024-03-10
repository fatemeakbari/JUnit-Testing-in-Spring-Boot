package com.aditya.demo;

//import org.junit.runner.RunWith;
//import org.junit.runners.Suite;
//
//@RunWith(Suite.class)
//@Suite.SuiteClasses({CalculatorTest.class, GreetingTest.class})
//public class TestAll {
//
//}

import static org.junit.Assert.assertEquals;
        import static org.junit.Assert.assertFalse;

        import java.util.ArrayList;

        import org.junit.After;
        import org.junit.AfterClass;
        import org.junit.Before;
        import org.junit.BeforeClass;
        import org.junit.Ignore;
        import org.junit.Test;

public class TestAll {

    private ArrayList<String> list;

    @BeforeClass
    public static void m1() {
        System.out.println("Using @BeforeClass , executed before all test cases ");
    }

    @Before
    public void m2() {
        list = new ArrayList<String>();
        System.out.println("Using @Before annotations ,executed before each test cases ");
    }

    @AfterClass
    public static void m3() {
        System.out.println("Using @AfterClass ,executed after all test cases");
    }

    @After
    public void m4() {
        list.clear();
        System.out.println("Using @After ,executed after each test cases");
    }

    @Test
    public void m5() {
        list.add("test");
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());

        System.out.println("test m5 passes-----------");
    }

    @Ignore
    public void m6() {
        System.out.println("Using @Ignore , this execution is ignored");
    }

    @Test
    public void m7() {
        System.out.println("test m7 passes-----------");
    }

//    @Test(expected = NoSuchMethodException.class)
//    public void m8() {
//        System.out.println("Using @Test(expected) ,it will check for specified exception during its execution");
//
//    }

}