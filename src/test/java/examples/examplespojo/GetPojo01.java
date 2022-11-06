package examples.examplespojo;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingPojo;
import pojos.TodosUserPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetPojo01 extends JsonplaceholderBaseUrl {


    //  https://jsonplaceholder.typicode.com/todos/198
    /*
    {
    "userId": 10,
    "id": 198,
    "title": "quis eius est sint explicabo",
    "completed": true
}
     */

    @Test
    public void GetPojo01() {

        //First Step:Set the Url
        spec.pathParams("first","todos","second",198);

        //Second Step:Set The Expected Data(Payload)
        TodosUserPojo expecteddata=new TodosUserPojo(10,198,"quis eius est sint explicabo",true);
        System.out.println("expecteddata = " + expecteddata);

        //Third Step:Send The Request and Get The Response
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Fourth Step:Do Assertion
        TodosUserPojo actualdata= response.as(TodosUserPojo.class);
        System.out.println("actualdata = " + actualdata);

        assertEquals(200,response.statusCode());
        assertEquals(expecteddata.getUserId(),actualdata.getUserId());
        assertEquals(expecteddata.getId(),actualdata.getId());
        assertEquals(expecteddata.getTitle(),actualdata.getTitle());
        assertEquals(expecteddata.getCompleted(),actualdata.getCompleted());
    }
}
