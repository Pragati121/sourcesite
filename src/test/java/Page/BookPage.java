package Page;
import Enum.LoginEnum;
import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static Enum.LoginEnum.Book;

public class BookPage {
    WebDriver driver;
    String clickonBookElement = "//div[@class='card-body']/h5[contains(text(),'%s')]";
    String verifybooks = "//div[@class='main-header'][contains(text(),'Book Store')]";



    public BookPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void book() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0, 1000)");
        driver.findElement(By.xpath(String.format(clickonBookElement, Book.getResourcesName()))).click();
        String actual = driver.findElement(By.xpath(verifybooks)).getText();
       System.out.println(actual);
     Assert.isTrue(actual.equals(verifybooks), "Expected result does not match with actual result");
    }
}


