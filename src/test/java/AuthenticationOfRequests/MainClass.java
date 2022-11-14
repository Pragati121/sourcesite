//package AuthenticationOfRequests;
//
//import com.google.gson.JsonArray;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//import io.restassured.RestAssured;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//import io.restassured.response.ResponseBody;
//import io.restassured.specification.RequestSpecification;
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//
//
//public class MainClass {
//    public static void main(String[] args) throws FileNotFoundException {
//        RequestSpecification requestSpecification = RestAssured.given();
//        Response response = requestSpecification.get("https://demoqa.com/BookStore/v1/Books");
//        ResponseBody responseBody = response.getBody();
//        String responseBod = responseBody.asString();
//        JsonPath jsonPath = response.jsonPath();
//        String s = jsonPath.get("books").toString();
//        JsonElement fileElement = JsonParser.parseString(responseBod);
//        JsonObject fileObject = fileElement.getAsJsonObject();
//        JsonArray jsonArrayOfBooks = fileObject.get("books").getAsJsonArray();
//        ArrayList<Pojoclass> books = new ArrayList<>();
//        for (JsonElement booksElement : jsonArrayOfBooks.getAsJsonArray()) {
//            JsonObject JsonObject = booksElement.getAsJsonObject();
//            Pojoclass booksData = new Pojoclass(JsonObject.get("title").getAsString(), JsonObject.get("author").getAsString(), JsonObject.get("publisher").getAsString());
//            books.add(booksData);
//        }
//    }
//}
