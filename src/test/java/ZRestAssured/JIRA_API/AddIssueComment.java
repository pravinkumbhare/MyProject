package ZRestAssured.JIRA_API;

import SetupConfig.BaseTestScript;
import ZRestAssured.Reusable.ReusableMethods;
import ZRestAssured.payLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by pravin.kumbhare on 01-08-2018.
 */
public class AddIssueComment extends BaseTestScript {

    @Test
    public void addingIssueInJira(){

        RestAssured.baseURI = prop.getProperty("JIRABASEURL");
        Response res = given().
                header("Content-Type", "application/json").
                header("cookie", "JSESSIONID=69A3FB001D474757BEC89AC2EE049EBC").
                body("{\n" +
                        "    \"body\": \"Adding comment dynamically..\",\n" +
                        "    \"visibility\": {\n" +
                        "        \"type\": \"role\",\n" +
                        "        \"value\": \"Administrators\"\n" +
                        "    }\n" +
                        "}").
                when().
                post("/rest/api/2/issue/" + ReusableMethods.createIssueInJiraAndGenerateKey() + "/comment").
                then().assertThat().statusCode(201).extract().response();

        JsonPath js = ReusableMethods.rawToJson(res);
        String comment_ID = js.get("id");
        System.out.println("Comment is : "+comment_ID);
    }

}
