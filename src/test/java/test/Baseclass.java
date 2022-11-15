package test;
import io.github.bonigarcia.wdm.WebDriverManager;;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
public abstract class Baseclass {
    static WebDriver driver;
    public Pagefactory pageFactory;
    public void Setup() throws IOException {
        FileReader reader = new FileReader("src/test/java/TestData/Resource.Properties");
        Properties data = new Properties();
        data.load(reader);
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.get(data.getProperty("URL"));
        driver.manage().window().maximize();
        pageFactory = new Pagefactory(driver);
    }
}

