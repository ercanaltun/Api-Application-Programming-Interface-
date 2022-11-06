package get_requests;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;
import test_data.utils.ObjectMapperUtils;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get14ObjectMapper_Map extends JsonplaceholderBaseUrl {

    /*
        Given
	        https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send GET Request to the URL
	 	Then
	 		Status code is 200
	 		And response body is like {
									    "userId": 10,
									    "id": 198,
									    "title": "quis eius est sint explicabo",
									    "completed": true
									  }
     */

    @Test
    public void get14Map() {


        //First Step:Set the Url
        spec.pathParams("first","todos","second",198);

        //Second Step:Set The Expected Data(Payload)
        String expectedDataInString=new JsonPlaceHolderTestData().expectedDataInString(10,"quis eius est sint explicabo",true);
        Map expectedData= ObjectMapperUtils.convertJsonToJava(expectedDataInString, Map.class);
        System.out.println("expectedData = " + expectedData);

        //Third Step:Send The Request and Get The Response
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Fourth Step:Do Assertion
        Map actualdata= ObjectMapperUtils.convertJsonToJava(response.asString(),Map.class);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.get("userId"),actualdata.get("userId"));
        assertEquals(expectedData.get("title"),actualdata.get("title"));
        assertEquals(expectedData.get("completed"),actualdata.get("completed"));
    }
}
