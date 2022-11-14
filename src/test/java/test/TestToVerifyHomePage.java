package test;

import org.testng.annotations.Test;

import java.io.IOException;

public class TestToVerifyHomePage extends Baseclass {
    @Test
    public void loginTest() throws IOException {
        Setup();
        pageFactory.getLoginobject().USerMethod();
        pageFactory.getBookobject().book();
        pageFactory.getBookobject().Retrievingthedata();
    }
}


