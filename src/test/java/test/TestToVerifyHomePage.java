package test;

import org.testng.annotations.Test;

import java.io.IOException;

public class TestToVerifyHomePage extends Baseclass {
    @Test(priority = 0)
    public void loginTest() throws IOException {
        Setup();
        pageFactory.getLoginobject().USerMethod();
        pageFactory.getBookobject().book();
        pageFactory.getBookobject().Retrievingthedata();
    }
}


