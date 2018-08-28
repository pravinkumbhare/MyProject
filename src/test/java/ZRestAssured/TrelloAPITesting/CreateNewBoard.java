package ZRestAssured.TrelloAPITesting;

import SetupConfig.BaseTestScript;
import ZRestAssured.Reusable.ReusableMethods;
import common.Constants;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by pravin.kumbhare on 07-08-2018.
 */
public class CreateNewBoard extends BaseTestScript {
   // public static String boardID = "", boardName = "";

    @Test
    public void createNewBoard(){

        RestAssured.baseURI = prop.getProperty("TRELLOURL");
        Response res = given().
                header("Content-Type","application/json").
                queryParam("key","b0f65bebc19142609140c4a634f44c74").
                queryParam("token","e0b3c473e64a8dbacb34f79084c12e04c5401e20f37c6293d700760b0b4cf996").
                queryParam("name","AmitBoard").
                when().
                post("/boards/").
                then().assertThat().statusCode(200).extract().response();

        JsonPath js = ReusableMethods.rawToJson(res);
        boardID = js.get("id");
        boardName = js.get("name");
        System.out.println("Board Name : "+boardName+" Board ID : "+boardID);
        System.out.println("New Board is created successfully "+boardName);
    }

/*
    @Test
    public void updateNewBoard(){

        RestAssured.baseURI = prop.getProperty("TRELLOURL");
        Response res = given().
                header("Content-Type","application/json").
                queryParam("key","b0f65bebc19142609140c4a634f44c74").
                queryParam("token","e0b3c473e64a8dbacb34f79084c12e04c5401e20f37c6293d700760b0b4cf996").
                queryParam("name","AutoBoard").
                when().
                put("https://api.trello.com/1/boards/" + boardID + " ").
                then().assertThat().statusCode(Constants.PASSED_STATUS_CODE).extract().response();

        JsonPath js = ReusableMethods.rawToJson(res);
        boardName = js.get("name");
        System.out.println("Board Name is updated successfully "+boardName);

    }*/

}
