package ZRestAssured;

import SetupConfig.BaseTestScript;
import common.Constants;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;

/**
 * Created by pravin.kumbhare on 29-07-2018.
 */
public class PostRequest extends BaseTestScript{

    @Test
    public void postRequest(){

        RestAssured.baseURI = prop.getProperty("BaseURL");
        given().
                queryParam("key",prop.getProperty("KEY")).
                body(payLoad.getPostData()).
                when().
                post(resources.getPostResourceData()).
                then().
                statusCode(Constants.PASSED_STATUS_CODE).and().contentType(ContentType.JSON).and().
                body("status", equalTo("OK"));
    }
}
