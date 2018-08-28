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
public class CreateNewCard extends BaseTestScript {
    //public static String cardID = "", cardName = "";
    //String list_ID = CreateNewListOnBoard.list_ID;

    @Test
    public void createCard(){

        RestAssured.baseURI = prop.getProperty("TRELLOURL");
        Response res = given().
                header("Content-Type","application/json").
                queryParam("key","b0f65bebc19142609140c4a634f44c74").
                queryParam("token","e0b3c473e64a8dbacb34f79084c12e04c5401e20f37c6293d700760b0b4cf996").
                queryParam("name","Pravin_Card").
                queryParam("idList",list_ID).     // 5b6938fbf4c44e632afe4aa4
                when().
                post("https://api.trello.com/1/cards").
                then().assertThat().statusCode(200).extract().response();

        JsonPath js = ReusableMethods.rawToJson(res);
        cardID = js.get("id");
        cardName = js.get("name");
        System.out.println("New cardID is : "+cardID);          //5b693b4a30372416e56264e1
        System.out.println("New card Name is : "+cardName);
    }


    @Test
    public void postComment(){

        RestAssured.baseURI = prop.getProperty("TRELLOURL");
        Response res = given().
                header("Content-Type","application/json").
                queryParam("key","b0f65bebc19142609140c4a634f44c74").
                queryParam("token","e0b3c473e64a8dbacb34f79084c12e04c5401e20f37c6293d700760b0b4cf996").
                queryParam("text","Pravin commented on the post...").
                when().
                post("/1/cards/" + cardID + "/actions/comments").   //5b693b4a30372416e56264e1
                then().assertThat().statusCode(200).extract().response();

        JsonPath js = ReusableMethods.rawToJson(res);
        String comment = js.get("data.text");
        System.out.println("Comment on a card is : "+comment);
    }


    @Test
    public void addAttachment(){

        RestAssured.baseURI = prop.getProperty("TRELLOURL");
        Response res = given().
                header("Content-Type","application/json").
                queryParam("key","b0f65bebc19142609140c4a634f44c74").
                queryParam("token","e0b3c473e64a8dbacb34f79084c12e04c5401e20f37c6293d700760b0b4cf996").
                queryParam("url","C:\\Users\\pravin.kumbhare\\Desktop\\Pravin.txt").
                when().
                post("/1/cards/" +cardID+ "/attachments").      //5b693b4a30372416e56264e1
                then().assertThat().statusCode(200).extract().response();

        JsonPath js = ReusableMethods.rawToJson(res);
        String url = js.get("url");
        System.out.println("URL is : "+url);
    }


    @Test
    public void postCheckList(){

        RestAssured.baseURI = prop.getProperty("TRELLOURL");
        Response res = given().
                header("Content-Type","application/json").
                queryParam("key","b0f65bebc19142609140c4a634f44c74").
                queryParam("token","e0b3c473e64a8dbacb34f79084c12e04c5401e20f37c6293d700760b0b4cf996").
                queryParam("idCard",cardID).  //5b693b4a30372416e56264e1
                queryParam("name","Pravin_CheckList").
                when().
                post("/1/checklists").then().assertThat().statusCode(200).extract().response();

        JsonPath js = ReusableMethods.rawToJson(res);
        String checkListName = js.get("name");
        System.out.println("checkListName is : "+checkListName);
    }
}
