package ZRestAssured.JIRA_API;

import SetupConfig.BaseTestScript;
import ZRestAssured.Reusable.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static SetupConfig.BaseTestScript.prop;
import static io.restassured.RestAssured.given;

/**
 * Created by pravin.kumbhare on 01-08-2018.
 */
public class UpdatingIssueComment extends BaseTestScript{

   @Test
    public void updatingIssueComment(){
       RestAssured.baseURI = prop.getProperty("JIRABASEURL");
       Response res = given().
               header("Content-Type", "application/json").
               header("cookie", "JSESSIONID=69A3FB001D474757BEC89AC2EE049EBC").
               body("{\n" +
                       "    \"body\": \"UPDATING COMMENTS in 10020 dynamically..\",\n" +
                       "    \"visibility\": {\n" +
                       "        \"type\": \"role\",\n" +
                       "        \"value\": \"Administrators\"\n" +
                       "    }\n" +
                       "}").
               when().
               put("/rest/api/2/issue/10028/comment/10020").
               then().assertThat().statusCode(200).extract().response();

       JsonPath js = ReusableMethods.rawToJson(res);
       String comment_ID = js.get("id");
       System.out.println("Comment is : "+comment_ID);
   }
}
