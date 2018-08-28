package ZRestAssured.TrelloAPITesting;

import SetupConfig.BaseTestScript;
import ZRestAssured.Reusable.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by pravin.kumbhare on 07-08-2018.
 */
public class CreateNewListOnBoard extends BaseTestScript {
//    public static String list_ID = "";
   // String boardID = CreateNewBoard.boardID;

    @Test
    public void createListOnBoard(){
        System.out.println("Tracking boardID is : "+boardID);

        RestAssured.baseURI = prop.getProperty("TRELLOURL");
        Response res = given().
                header("Content-Type","application/json").
                queryParam("key","b0f65bebc19142609140c4a634f44c74").
                queryParam("token","e0b3c473e64a8dbacb34f79084c12e04c5401e20f37c6293d700760b0b4cf996").
                queryParam("name","AmayaBoard").
                queryParam("idBoard",boardID).    //5b6931525bb2ed7f49b02a35
                when().
                post("https://api.trello.com/1/lists").
                then().assertThat().statusCode(200).extract().response();


        JsonPath js = ReusableMethods.rawToJson(res);
        list_ID = js.get("id");
        System.out.println("New List ID is : "+list_ID);

    }
}
