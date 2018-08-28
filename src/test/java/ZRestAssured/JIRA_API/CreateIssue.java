package ZRestAssured.JIRA_API;

import SetupConfig.BaseTestScript;
import ZRestAssured.Reusable.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import ZRestAssured.payLoad;

/**
 * Created by pravin.kumbhare on 01-08-2018.
 */
public class CreateIssue extends BaseTestScript {

    @Test
    public void createIssueInJira(){

        RestAssured.baseURI = prop.getProperty("JIRABASEURL");

        Response res = given().header("Content-Type","application/json").
                header("cookie","JSESSIONID="+ReusableMethods.getSessionID()).
                body(payLoad.getPostDataToCreateIssue()).
                when().
                post("/rest/api/2/issue/").
                then().assertThat().statusCode(201).extract().response();

        JsonPath js = ReusableMethods.rawToJson(res);
        String id = js.get("id");
        String key = js.get("key");
        System.out.println("Issue id is : "+id +"   Issue key is : "+key);
    }
}
