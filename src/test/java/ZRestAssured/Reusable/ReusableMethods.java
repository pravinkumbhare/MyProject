package ZRestAssured.Reusable;

import SetupConfig.BaseTestScript;
import ZRestAssured.payLoad;
import common.Constants;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

/**
 * Created by pravin.kumbhare on 01-08-2018.
 */
public class ReusableMethods extends BaseTestScript{

    /**
     *  Converting from Raw data to JSON Path
     * @param res
     * @return
     */
    public static JsonPath rawToJson(Response res){

        String stringResponse = res.asString();
        JsonPath jsonPath = new JsonPath(stringResponse);

        return jsonPath;
    }


    /**
     * This method returns session ID
     * @return
     */
    public static String getSessionID(){
        String sessionID = "";
        JsonPath js=null;

        try{

            RestAssured.baseURI = prop.getProperty("JIRABASEURL");

            if(!sessionID.isEmpty() || sessionID!=null){
                Response res = given().header("Content-Type","application/json").
                        body("{ \"username\": \"pravin.kumbhare\", \"password\": \"95527014300\" }").
                        when().
                        post("/rest/auth/1/session").
                        then().assertThat().statusCode(Constants.PASSED_STATUS_CODE).extract().response();

                js = ReusableMethods.rawToJson(res);
                sessionID = js.get("session.value");
            }

            if(!sessionID.isEmpty()){
                System.out.println("Session ID is : "+sessionID);
                return sessionID;
            }

        }catch (Exception e){
            System.out.println(e);
        }

        System.out.println("Session ID is not proper or empty : "+sessionID);
        return sessionID;
    }



    public static String createIssueInJiraAndGenerateKey(){
        String issueKey = "", issueID="";

        RestAssured.baseURI = prop.getProperty("JIRABASEURL");

        Response res = given().header("Content-Type","application/json").
                header("cookie","JSESSIONID="+ReusableMethods.getSessionID()).
                body(payLoad.getPostDataToCreateIssue()).
                when().
                post("/rest/api/2/issue/").
                then().assertThat().statusCode(201).extract().response();

        JsonPath js = ReusableMethods.rawToJson(res);
        issueID = js.get("id");
        issueKey = js.get("key");
        if(!issueID.isEmpty()){

            System.out.println("Issue id is : "+issueID +"   Issue key is : "+issueKey);
        }else {
            System.out.println("Issue id is empty or not proper : "+issueID +"   Issue key is empty: "+issueKey);
        }
        return issueID;
    }




    public static String updatingIssueComment(){
        String issueKey = "", issueID="";

        RestAssured.baseURI = prop.getProperty("JIRABASEURL");

        Response res = given().header("Content-Type","application/json").
                header("cookie","JSESSIONID="+ReusableMethods.getSessionID()).
                body("{\n" +
                        "    \"body\": \"UPDATING COMMENTS in 10020\",\n" +
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
        if(!comment_ID.isEmpty()){

            System.out.println("Comment is : "+comment_ID);
        }else {
            System.out.println("Comment is empty or not proper : "+comment_ID);
        }
        return comment_ID;
    }


}
