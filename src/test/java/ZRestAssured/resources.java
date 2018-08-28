package ZRestAssured;

/**
 * Created by pravin.kumbhare on 30-07-2018.
 */
public class resources {

    public static String getReadResourceData(){
        String resource = "/maps/api/place/nearbysearch/json";

        if(!resource.isEmpty()){

            return resource;
        }else {
            System.out.println("Resource is not proper : "+resource);
            return resource;
        }
    }

    /**
     *  getPostResourceData through json
     * @return
     */
    public static String getPostResourceData(){
        String postResourceData = "/maps/api/place/add/json";

        if(!postResourceData.isEmpty()){
            System.out.println("Resource for a POST Request is OK");
            return postResourceData;
        }else {
            System.out.println("Resource for a POST Request is not proper..");
            return postResourceData;
        }
    }


    /**
     *  getPostResourceData through json
     * @return
     */
    public static String getPostResourceData_XML(){
        String postResourceData = "/maps/api/place/add/xml";

        if(!postResourceData.isEmpty()){
            System.out.println("Resource for a POST Request is OK");
            return postResourceData;
        }else {
            System.out.println("Resource for a POST Request is not proper..");
            return postResourceData;
        }
    }

    public static String getDeleteResourceData(){
        String deleteResourceDate = "/maps/api/place/delete/json";

        if(!deleteResourceDate.isEmpty()){
            System.out.println("Resource for a DELETE Request is Ok");
            return deleteResourceDate;
        }else {
            System.out.println("Resource for a DELETE Request is not proper.");
            return deleteResourceDate;
        }
    }

}
