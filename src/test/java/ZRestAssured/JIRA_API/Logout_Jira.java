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
public class Logout_Jira extends BaseTestScript {
    String projectKey = "", projectDescription = "";

    @Test(priority = 1)
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
        System.out.println("Current session Username is : "+username);
    }


    @Test(priority = 2)
    public void createProject(){

        RestAssured.baseURI = prop.getProperty("JIRABASEURL");
        Response res = given().
                header("Content-Type","application/json").
                header("Cookie","JSESSIONID=" + ReusableMethods.getSessionID() + "").
                body("{\n" +
                        "    \"key\": \"OOO\",\n" +
                        "    \"name\": \"OOOAA\",\n" +
                        "    \"projectTypeKey\": \"business\",\n" +
                        "    \"projectTemplateKey\": \"com.atlassian.jira-core-project-templates:jira-core-project-management\",\n" +
                        "    \"description\": \"OOOAA\",\n" +
                        "    \"lead\": \"pravin.kumbhare\",\n" +
                        "    \"url\": \"http://atlassian.com\",\n" +
                        "    \"assigneeType\": \"PROJECT_LEAD\",\n" +
                        "    \"avatarId\": 10200\n" +
                        "   \n" +
                        "}").
                when().
                post("/rest/api/2/project").
                then().assertThat().statusCode(201).extract().response();

        JsonPath js = ReusableMethods.rawToJson(res);
       // String projectName = js.get("name");
        String projectKey = js.get("key");
        System.out.println("New Project Key created successfully.."+projectKey);
    }



    @Test(priority = 3)
    public void updateInProject(){

        RestAssured.baseURI = prop.getProperty("JIRABASEURL");
        Response res = given().
                header("Content-Type","application/json").
                header("Cookie","JSESSIONID=" + ReusableMethods.getSessionID() + "").
                body("{\n" +
                        "    \"key\": \"UPDATE\",\n" +
                        "    \"name\": \"UpdateUpdateUpdate\",\n" +
                        "    \"projectTypeKey\": \"business\",\n" +
                        "    \"projectTemplateKey\": \"com.atlassian.jira-core-project-templates:jira-core-project-management\",\n" +
                        "    \"description\": \"Update\",\n" +
                        "    \"lead\": \"pravin.kumbhare\",\n" +
                        "    \"url\": \"http://atlassian.com\",\n" +
                        "    \"assigneeType\": \"PROJECT_LEAD\",\n" +
                        "    \"avatarId\": 10200\n" +
                        "   \n" +
                        "}").
                when().
                put("/rest/api/2/project/" + projectKey + "").
                then().assertThat().statusCode(200).extract().response();

        JsonPath js = ReusableMethods.rawToJson(res);
        String projectName = js.get("name");
        projectKey = js.get("key");
        projectDescription = js.get("description");
        System.out.println("Updating Project : "+projectName);
        System.out.println("Updating Key : "+projectKey);
        System.out.println("Project Description : "+projectDescription);
    }



    @Test(priority = 4)
    public void getRoleInProject(){

        RestAssured.baseURI = prop.getProperty("JIRABASEURL");
        Response res = given().
                header("Content-Type","application/json").
                header("Cookie","JSESSIONID=" + ReusableMethods.getSessionID() + "").
                when().
                get("/rest/api/2/project/" +projectKey+ "/role").
                then().assertThat().statusCode(200).extract().response();

        JsonPath js = ReusableMethods.rawToJson(res);
        String developerName = js.get("Developers");
        System.out.println("Developer Name : "+developerName);
    }


    @Test(priority = 5)
    public void deleteProject(){

        RestAssured.baseURI = prop.getProperty("JIRABASEURL");
        Response res = given().
                header("Content-Type","application/json").
                header("Cookie","JSESSIONID=" + ReusableMethods.getSessionID() + "").
                when().
                delete("/rest/api/2/project/ABC").
                then().assertThat().statusCode(204).extract().response();

        System.out.println("Project is deleted successfully..");
    }


    @Test (priority = 6)
    public void jira_Logout(){

        RestAssured.baseURI = prop.getProperty("JIRABASEURL");
        Response res = given().
                header("Content-Type","application/json").
                header("Cookie","JSESSIONID=" + ReusableMethods.getSessionID() + "").
                when().
                delete("/rest/auth/1/session").
                then().assertThat().statusCode(204).extract().response();

        System.out.println("Logout done successfully..");

    }
}
