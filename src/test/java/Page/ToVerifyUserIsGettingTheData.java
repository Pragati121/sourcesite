package Page;
import org.openqa.selenium.WebDriver;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class ToVerifyUserIsGettingTheData {
    WebDriver driver;

    public ToVerifyUserIsGettingTheData(WebDriver driver) {
        this.driver = driver;
    }

    public void BookData() throws IOException {
        String urlName = "https://demoqa.com/BookStore/v1/Books";
        URL urlForGetReq = new URL(urlName);
        String read;
        HttpURLConnection connection = (HttpURLConnection) urlForGetReq.openConnection();
        connection.setRequestMethod("GET");
        int codeResponse = connection.getResponseCode();
        if (codeResponse == HttpURLConnection.HTTP_OK)
        {
            InputStreamReader isrObj = new InputStreamReader(connection.getInputStream());
            BufferedReader bf = new BufferedReader(isrObj);
            StringBuffer responseStr = new StringBuffer();
            while ((read = bf .readLine()) != null)
            {
                responseStr.append(read);
            }
            bf.close();
            connection.disconnect();
            System.out.println("JSON String Result is: \n" + responseStr.toString());
        }
        else
        {
            System.out.println("GET Request did not work");
        }
    }
}


