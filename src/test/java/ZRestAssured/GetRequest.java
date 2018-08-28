package ZRestAssured;

import SetupConfig.BaseTestScript;
import com.sun.org.apache.xerces.internal.impl.xs.identity.Selector;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import common.Constants;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;
/*import static org.hamcrest.JMock1Matchers.equalTo;*/
import static org.hamcrest.Matchers.equalTo;


/**
 * Created by pravin.kumbhare on 28-07-2018.
 */
public class GetRequest extends BaseTestScript{
    Constants constants = new Constants();

    @Test
    public void getRequest(){

   /* public static void main(String[] args){*/
        //BaseURL or Host
       RestAssured.baseURI = prop.getProperty("BaseURL");
        given().
                param("location",prop.getProperty("LOCATION")).
                param("radius",prop.getProperty("RADIUS")).
                param("key",prop.getProperty("KEY")).

                when().
                get(resources.getReadResourceData()).
                then().assertThat().statusCode(Constants.PASSED_STATUS_CODE).and().contentType(ContentType.JSON).

                // Not able to use equalTo method
                body("results[0].name",equalTo(constants.SYDNEY_TEXT)).and().
                body("results[0].place_id", equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM"));

        //.and().body("results[0].place_id", equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM"));
        // .and().header("Server",equalTo("pablow"));


    }


}
