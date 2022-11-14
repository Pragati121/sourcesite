package test;
import Page.BookPage;
import Page.LoginPage;
import Page.ToVerifyUserIsGettingTheData;
import org.openqa.selenium.WebDriver;

public class Pagefactory {
    public LoginPage Loginobject;
    public BookPage BookObject;
    WebDriver driver;

    public Pagefactory(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginobject() {
        if (Loginobject == null) {
            Loginobject = new LoginPage(driver);
        }
        return Loginobject;
    }

    public BookPage getBookobject() {
        if (BookObject == null) {
            BookObject = new BookPage(driver);
        }
        return BookObject;
    }
    }


