package Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
public class LoginPage  {
    List<WebElement> allElementDisplay;
    static WebDriver driver;
    WebDriverWait wait;
    String[] arr ={"Elements","Forms","Alerts,Frames & Windows","Widgets","Interaction","Book Store Element"};
    By verifyallsixitems= By.xpath("//h5");
    String verifyingallitems = "//div[@class='category-cards']//div[@class='card mt-4 top-card']";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    public void USerMethod() {
        allElementDisplay = driver.findElements(By.xpath(verifyingallitems));
        for (WebElement allElements : allElementDisplay) {
            {
                String StrLinkText = allElements.getText();
                System.out.println(StrLinkText);
            }
        }
    }
    public void PageVerification(){

    }
}
