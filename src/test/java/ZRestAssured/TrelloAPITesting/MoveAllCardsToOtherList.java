package ZRestAssured.TrelloAPITesting;

import SetupConfig.BaseTestScript;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by pravin.kumbhare on 07-08-2018.
 */
public class MoveAllCardsToOtherList extends BaseTestScript {
    //String boardID = CreateNewBoard.boardID;
    //String list_ID = CreateNewListOnBoard.list_ID;


    @Test
    public void moveCardsToOtherList(){

        RestAssured.baseURI = prop.getProperty("TRELLOURL");
        Response res = given().
                header("Content-Type","application/json").
                queryParam("key","b0f65bebc19142609140c4a634f44c74").
                queryParam("token","e0b3c473e64a8dbacb34f79084c12e04c5401e20f37c6293d700760b0b4cf996").
                queryParam("idBoard",boardID).  //    5b6908623cb3906376b8a1fe
                queryParam("idList",list_ID).                     // 5b6910dde50d51634c88f2a7
                when().
                post("/1/lists/" + list_ID + "/moveAllCards").
                then().assertThat().statusCode(200).extract().response();

        System.out.println("All Cards moved successfully..");
    }
}
