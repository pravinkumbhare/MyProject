package ZRestAssured;


import SetupConfig.BaseTestScript;
import common.Constants;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import ZRestAssured.payLoad;

import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;

/**
 * Created by pravin.kumbhare on 30-07-2018.
 */
public class DeleteRequest extends BaseTestScript{

    @Test
    public void addAndDeletePlace(){

        RestAssured.baseURI = prop.getProperty("BaseURL");

        //Grab the response
        Response response = given().
                queryParam("key",prop.getProperty("KEY")).
                body(payLoad.getPostData()).
                when().
                post(resources.getPostResourceData()).
                then().statusCode(Constants.PASSED_STATUS_CODE).and().contentType(ContentType.JSON).and().
                body("status", equalTo("OK")).extract().response();

        String responseString = response.asString();
        System.out.println(responseString);
        //step 2: Grab the Place ID fro the response
        JsonPath js = new JsonPath(responseString);
        String placeID = js.get("results[0].place_id");    // It will not work because Google Place Map deprecated to add and delete
        System.out.println(placeID);

        //Step 3: place this placeId in the Delete request
        given().
                queryParam("key",prop.getProperty("KEY")).

                body("{\n" +
                        "  \"place_id\": \"placeID\"\n" +
                        "}").
                when().
                post(resources.getDeleteResourceData()).
                then().statusCode(Constants.PASSED_STATUS_CODE).and().contentType(ContentType.JSON).and().
                body("status", equalTo("OK"));
    }
}
