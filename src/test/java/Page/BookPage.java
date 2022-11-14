package Page;

import AuthenticationOfRequests.Pojoclass;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import Enum.LoginEnum;




import java.util.ArrayList;

import static Enum.LoginEnum.*;
import static org.testng.Assert.*;


public class BookPage {
    WebDriver driver;
    String clickonBookElement = "//div[@class='card-body']/h5[contains(text(),'%s')]";
    String verifybooks = "//div[@class='main-header'][contains(text(),'Book Store')]";
    String Title ="//a[contains(text(),'%s')]";
    String titleAuthor = "//div[contains(text(),'%s')]";


    public BookPage(WebDriver driver) {
        this.driver = driver;
    }

    public void book() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0, 1000)");
        driver.findElement(By.xpath(String.format(clickonBookElement, Book.getResourcesName()))).click();
        String actual = driver.findElement(By.xpath(verifybooks)).getText();
        System.out.println(actual);
        assertEquals(actual, Items.getResourcesName(), "Expected does not match");
    }

    public void Retrievingthedata() {
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.get("https://demoqa.com/BookStore/v1/Books");
        ResponseBody responseBody = response.getBody();
        String responseBod = responseBody.asString();
        JsonPath jsonPath = response.jsonPath();
        String s = jsonPath.get("books").toString();
        JsonElement fileElement = JsonParser.parseString(responseBod);
        JsonObject fileObject = fileElement.getAsJsonObject();
        JsonArray jsonArrayOfBooks = fileObject.get("books").getAsJsonArray();
        ArrayList<Pojoclass> books = new ArrayList<>();
        for (JsonElement booksElement : jsonArrayOfBooks.getAsJsonArray()) {
            JsonObject JsonObject = booksElement.getAsJsonObject();
            Pojoclass booksData = new Pojoclass(JsonObject.get("title").getAsString(), JsonObject.get("author").getAsString(), JsonObject.get("publisher").getAsString());
            books.add(booksData);
        }
        System.out.println(books);
        String actual = driver.findElement(By.xpath(String.format(Title, title.getResourcesName()))).getText();
        Assert.isTrue(actual.equals(title), "Expected result does not match actual result");
        String actual1 = driver.findElement(By.xpath(String.format(titleAuthor, author.getResourcesName()))).getText();
        Assert.isTrue(actual1.equals(author), "Expected result does not match actual result");
        String actual2 = driver.findElement(By.xpath(String.format(titleAuthor, publisher.getResourcesName()))).getText();
        Assert.isTrue(actual2.equals(publisher), "Expected result does not match actual result");
    }
}
