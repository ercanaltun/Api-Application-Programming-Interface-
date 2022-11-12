package examples.examples_get.secondweek;

import base_url.DummyRestApiBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyRestApiDataPojo;
import pojos.DummyRestApiResponseBodyPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Example14 extends DummyRestApiBaseUrl {

        /*
   Given
       URL: https://dummy.restapiexample.com/api/v1/employee/1
   When
       User sends GET Request
   Then
       Status code is 200
   And
       "employee_name" is "Tiger Nixon"
   And
       "employee_salary" is 320800
   And
       "employee_age" is 61
   And
       "status" is "success"
   And
       "message" is "Successfully! Record has been fetched."

    */

    @Test
    public void test14() {

        spec.pathParams("1","employee","2",1);

        DummyRestApiDataPojo data=new DummyRestApiDataPojo("Tiger Nixon",320800,61,"");
        DummyRestApiResponseBodyPojo expectedData=new DummyRestApiResponseBodyPojo("success",data,"Successfully! Record has been fetched.");
        System.out.println("expectedData = " + expectedData);

        Response response=given().spec(spec).when().get("/{1}/{2}");
        response.prettyPrint();

        DummyRestApiResponseBodyPojo actualData= ObjectMapperUtils.convertJsonToJava(response.asString(),DummyRestApiResponseBodyPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getStatus(),actualData.getStatus());
        assertEquals(expectedData.getMessage(),actualData.getMessage());

        assertEquals(data.getEmployee_name(),actualData.getData().getEmployee_name());
        assertEquals(data.getEmployee_salary(),actualData.getData().getEmployee_salary());
        assertEquals(data.getEmployee_age(),actualData.getData().getEmployee_age());
        assertEquals(data.getProfile_image(),actualData.getData().getProfile_image());



    }
}
