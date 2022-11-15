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
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


import java.util.ArrayList;
import java.util.List;

import static Enum.LoginEnum.*;
import static org.testng.Assert.*;


public class BookPage {
    WebDriver driver;
    String clickonBookElement = "//div[@class='card-body']/h5[contains(text(),'%s')]";
    String verifybooks = "//div[@class='main-header'][contains(text(),'Book Store')]";
    String Title = "//a[contains(text(),'%s')]";
    String titleAuthor = "//div[contains(text(),'%s')]";
    By publisher =By.xpath("//div[contains(text(),\"O'Reilly Media\")]");


    public BookPage(WebDriver driver) {
        this.driver = driver;
    }

    public void book() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0, 1000)");
        driver.findElement(By.xpath(String.format(clickonBookElement, Book.getresourcesname()))).click();
        String actual = driver.findElement(By.xpath(verifybooks)).getText();
        System.out.println(actual);
        assertEquals(actual, Items.getresourcesname(), "Expected does not match");
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
        List<Pojoclass> books = new ArrayList<>();
        for (JsonElement booksElement : jsonArrayOfBooks.getAsJsonArray()) {
            JsonObject JsonObject = booksElement.getAsJsonObject();
            Pojoclass booksData = new Pojoclass(JsonObject.get("title").getAsString(), JsonObject.get("author").getAsString(), JsonObject.get("publisher").getAsString());
            books.add(booksData);
        }
        System.out.println(books);
        Pojoclass pojoclass = books.get(0);
        String titleofbook = books.get(0).getTitle();
        String authorname = books.get(0).getAuthor();
        String publishername = books.get(0).getPublisher();
        System.out.println(titleofbook);
        System.out.println(authorname);
        System.out.println(publishername);
        String actualTask = driver.findElement(By.xpath(String.format(Title, title.getresourcesname()))).getText();
        Assert.assertEquals(actualTask, titleofbook);
        String actualauthor = driver.findElement(By.xpath(String.format(titleAuthor, author.getresourcesname()))).getText();
        Assert.assertEquals(actualauthor, authorname);
        String publisherName = driver.findElement(publisher).getText();
        Assert.assertEquals(publishername, publisherName);
    }
}
