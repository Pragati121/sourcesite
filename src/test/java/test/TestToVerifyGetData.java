package test;

import org.testng.annotations.Test;

import java.io.IOException;

public class TestToVerifyGetData extends Baseclass{
    @Test
    public void Testing() throws IOException {
        Setup();
        pageFactory.getLoginobject().USerMethod();
    }
}
