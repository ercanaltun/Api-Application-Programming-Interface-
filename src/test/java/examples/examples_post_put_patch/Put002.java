package examples.examples_post_put_patch;

import base_url.DummyRestApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import pojos.DummyRestApiDataPojo;
import pojos.DummyRestApiResponseBodyPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Put002 extends DummyRestApiBaseUrl {

         /*
        URL: https://dummy.restapiexample.com/api/v1/update/21
       HTTP Request Method: PUT Request
       Request body: {
                        "employee_name": "Ali Can",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image"
                     }
       Test Case: Type by using Gherkin Language
       Assert:
                i) Status code is 200
                ii) Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Ali Can",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image"
                        },
                        "message": "Successfully! Record has been updated."
                    }
     */
    /*
    Given
         https://dummy.restapiexample.com/api/v1/update/21
                     {
                        "employee_name": "Ali Can",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image"
                      }

    Then
       User Send The PUT Request

    And
       i) Status code is 200

    And
       ii) Response body should be like the following
       {
        "status": "success",
        "data": {
            "employee_name": "Dilaver Delifişek",
            "employee_salary": 12000,
            "employee_age": 44,
            "profile_image": "Perfect image"
        },
        "message": "Successfully! Record has been updated."
       }
     */

    @Test
    public void put02() {
        spec.pathParams("1","update","2",21);

        DummyRestApiDataPojo dataPojo=new DummyRestApiDataPojo("Dilaver Delifişek",12000,44,"Perfect image");
        DummyRestApiResponseBodyPojo expectedData=new DummyRestApiResponseBodyPojo("success",dataPojo,"Successfully! Record has been updated.");
        System.out.println("expectedData = " + expectedData);

        Response response=given().spec(spec).contentType(ContentType.JSON).body(dataPojo).when().put("/{1}/{2}");
        response.prettyPrint();

       DummyRestApiResponseBodyPojo actualData= ObjectMapperUtils.convertJsonToJava(response.asString(),DummyRestApiResponseBodyPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getStatus(),actualData.getStatus());
        assertEquals(expectedData.getMessage(),actualData.getMessage());
        assertEquals(expectedData.getMessage(),actualData.getMessage());

        assertEquals(expectedData.getData().getEmployee_name(),actualData.getData().getEmployee_name());
        assertEquals(expectedData.getData().getEmployee_salary(),actualData.getData().getEmployee_salary());
        assertEquals(expectedData.getData().getEmployee_age(),actualData.getData().getEmployee_age());
        assertEquals(expectedData.getData().getProfile_image(),actualData.getData().getProfile_image());

    }
}
