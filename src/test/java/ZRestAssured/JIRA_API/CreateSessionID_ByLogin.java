package ZRestAssured.JIRA_API;

import SetupConfig.BaseTestScript;
import ZRestAssured.Reusable.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by pravin.kumbhare on 01-08-2018.
 */
public class CreateSessionID_ByLogin extends BaseTestScript{

    @Test
    public void Jira_Login(){

        RestAssured.baseURI = prop.getProperty("JIRABASEURL");

        Response res = given().header("Content-Type","application/json").
                body("{ \"username\": \"pravin.kumbhare\", \"password\": \"95527014300\" }").
                when().
                post("/rest/auth/1/session").
                then().assertThat().statusCode(200).extract().response();

        JsonPath js = ReusableMethods.rawToJson(res);
        String sessionID = js.get("session.value");
        System.out.println("Session ID is : "+sessionID);

    }
}
