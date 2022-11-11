package AuthenticationOfRequests;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File(System.getProperty("user.dir") + "/data.json");
        JsonElement fileElement = JsonParser.parseReader(new FileReader(input));
        JsonObject fileObject = fileElement.getAsJsonObject();


        JsonArray jsonArrayOfNamendEmail = fileObject.get("books").getAsJsonArray();
        List<Pojoclass> StoreValue= new ArrayList();

        for (JsonElement NameElement : jsonArrayOfNamendEmail.getAsJsonArray()) {
            JsonObject EmailJsonObject = NameElement.getAsJsonObject();

            String Name =  EmailJsonObject.get("isbn").getAsString();
            String Email =  EmailJsonObject.get("title").getAsString();
            String Name1=  EmailJsonObject.get("subTitle").getAsString();
            String Email3 =  EmailJsonObject.get("author").getAsString();

            Pojoclass obj = new Pojoclass(Name,Email,Name1,Email3);
            StoreValue.add(obj);
        }
        System.out.println("Names are"+ StoreValue);
    }
}
