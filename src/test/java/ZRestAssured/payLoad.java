package ZRestAssured;

/**
 * Created by pravin.kumbhare on 30-07-2018.
 */
public class payLoad {

    public static String getPostData(){
        String postData = "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -33.8669710,\n" +
                "    \"lng\": 151.1958750\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Google Shoes!\",\n" +
                "  \"phone_number\": \"(02) 9374 4000\",\n" +
                "  \"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\",\n" +
                "  \"types\": [\"shoe_store\"],\n" +
                "  \"website\": \"http://www.google.com.au/\",\n" +
                "  \"language\": \"en-AU\"\n" +
                "}";

        if(!postData.isEmpty()){
            System.out.println("JSON date for a POST Request is ok..");
            return postData;
        }else {
            System.out.println("JSON date for a POST Request is not proper..");
            return postData;
        }
    }



    public static String getPostDataToCreateIssue(){
        String postData = "{\n" +
                "    \n" +
                "    \"fields\": {\n" +
                "        \"project\": {\n" +
                "            \"key\": \"RES\"\n" +
                "        },\n" +
                "        \"summary\": \"Master Card Issue\",\n" +
                "        \"description\": \"Testing Issue for a Credit Card..\",\n" +
                "        \"issuetype\": {\n" +
                "            \"name\": \"Bug\"\n" +
                "        }\n" +
                "    }\n" +
                "}";

        if(!postData.isEmpty()){
            System.out.println("JSON data for a POST Request to create an issue is ok..");
            return postData;
        }else {
            System.out.println("JSON date for a POST Request to create an issue is not proper..");
            return postData;
        }
    }
}
