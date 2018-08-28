package ZRestAssured;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/**
 * Created by pravin.kumbhare on 31-07-2018.
 */
 class ReusableMethods {


    public static JsonPath rawToJson(Response res){

        String stringResponse = res.asString();
        JsonPath jsonPath = new JsonPath(stringResponse);

        return jsonPath;
    }
}
