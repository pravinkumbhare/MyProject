package ZRestAssured.JIRA_API;

import SetupConfig.BaseTestScript;
import ZRestAssured.Reusable.ReusableMethods;
import common.Constants;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by pravin.kumbhare on 03-08-2018.
 */
public class Get_Current_UserName extends BaseTestScript {

    @Test
    public void current_UserName(){

        RestAssured.baseURI = prop.getProperty("JIRABASEURL");
        Response res = given().
                header("Content-Type","application/json").
                header("Cookie","JSESSIONID=" + ReusableMethods.getSessionID() + "").
                when().
                get("/rest/auth/1/session").
                then().assertThat().statusCode(Constants.PASSED_STATUS_CODE).extract().response();

        JsonPath js = ReusableMethods.rawToJson(res);
        String username = js.get("name");
        System.out.println(username);
    }
}
