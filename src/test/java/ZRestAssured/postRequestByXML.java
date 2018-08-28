package ZRestAssured;

import SetupConfig.BaseTestScript;

import common.Constants;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by pravin.kumbhare on 30-07-2018.
 */
public class postRequestByXML extends BaseTestScript{
    // Not able to execute as Post Response output is deprecated in Google Place Map

    @Test
    public void postRequestXML() throws IOException {

        String postData = GenerateStringFromResource("D:\\Solaris Project\\solaris\\Appium_Android_Project\\src\\test\\resources\\postRequest.xml");
        System.out.println("++++++++++++++"+postData+"+++++++++++++++");

        RestAssured.baseURI = prop.getProperty("BaseURL");
        Response res = (Response) given().
                queryParam("key",prop.getProperty("KEY")).
                body(postData).
                when().
                post(resources.getPostResourceData_XML()).
                then().
                statusCode(Constants.PASSED_STATUS_CODE).and().contentType(ContentType.XML).extract().response();

        String stringResponse = res.toString();
        System.out.println("==============="+stringResponse);

        // Not able to execute as Post Response output is deprecated in Google Place Map
        XmlPath x = new XmlPath(stringResponse);
        System.out.println("******"+x.get("PlaceAddRequest.accuracy"));
    }


    //This method is used to read data from XML file
    public static String GenerateStringFromResource(String path) throws IOException{

        return new String(Files.readAllBytes(Paths.get(path)));
    }

}
