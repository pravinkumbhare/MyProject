package ZRestAssured;

import SetupConfig.BaseTestScript;
import common.Constants;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

/**
 * Created by pravin.kumbhare on 31-07-2018.
 */
public class GetRequestWithJsonParameter extends BaseTestScript{
    Constants constants = new Constants();

  @Test
    public void getRequestWithJsonParameter(){

      RestAssured.baseURI = prop.getProperty("BaseURL");

      Response res = given().
              param("location",prop.getProperty("LOCATION")).
              param("radius",prop.getProperty("RADIUS")).
              param("key",prop.getProperty("KEY")).

              when().log().all().
              get(resources.getReadResourceData()).
              then().//log().body().
              assertThat().statusCode(Constants.PASSED_STATUS_CODE).and().contentType(ContentType.JSON).
              //log().ifValidationFails().
              body("results[0].name",equalTo(constants.SYDNEY_TEXT)).and().
              body("results[0].place_id", equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).extract().response();


      JsonPath js = ReusableMethods.rawToJson(res);
      int count = js.get("results.size");
      System.out.println("Result array count is : "+count);
      for(int i=0; i<count; i++){

      //    String place_Name = js.get("results[0].name");
          System.out.println("Place Name =========="+js.get("results["+ i +"].name"));
          System.out.println("Place ID =========="+js.get("results["+ i +"].id"));
          System.out.println(""+js.get("results["+i+"].geometry.location.lat"));
          System.out.println(""+js.get("results["+i+"].geometry.location.lng"));
      }

  }
}

