package AuthenticationOfRequests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
@Test
public class GetRequest {
    public void GetRequest() {
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        RestAssured.given()
                .when()
                .get()
                .then().log().all();
    }
}
