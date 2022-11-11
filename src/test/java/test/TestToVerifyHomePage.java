package test;

import org.testng.annotations.Test;

import java.io.IOException;

public class TestToVerifyHomePage extends Baseclass {
    @Test(priority = 0)
    public void loginTest() throws IOException {
        Setup();
        pageFactory.getLoginobject().USerMethod();

    }

    @Test(priority = 1)
    public void BookTest() throws IOException {
        pageFactory.getBookObject().book();
    }
}
