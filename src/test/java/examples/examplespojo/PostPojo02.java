package examples.examplespojo;

import base_url.DummyRestApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyRestApiDataPojo;
import pojos.DummyRestApiResponseBodyPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PostPojo02 extends DummyRestApiBaseUrl {


         /*
       URL: https://dummy.restapiexample.com/api/v1/create
       HTTP Request Method: POST Request
       Request body:
                     {
                        "employee_name": "Eddie Murpy",
                        "employee_salary": 123456,
                        "employee_age": 65,
                     }
       Test Case: Type by using Gherkin Language
       Assert:
                i) Status code is 200
                ii) Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Eddie Murpy",
                            "employee_salary": 23456,
                            "employee_age": 65,
                            "profile_image": "Perfect image
                        },
                        "message": "Successfully! Record has been added."
                    }
     */

    /*

    Given => https://dummy.restapiexample.com/api/v1/create

    And   =>  {
        "employee_name": "Eddie Murpy",
        "employee_salary": 123456,
        "employee_age": 65,
          }
   When  => User send Post Request

   And   => Status code should be  200

   And   => Response body should be like following
                       {
                        "status": "success",
                        "data": {
                            "employee_name": "Eddie Murpy",
                            "employee_salary": 23456,
                            "employee_age": 65,
                            "profile_image": "Perfect image"
                        },
                        "message": "Successfully! Record has been added."
                    }
     */

    @Test
    public void test01() {

        //Set the Url
        spec.pathParam("first","create");

        //Set the Expected Data
        DummyRestApiDataPojo expextedData=new DummyRestApiDataPojo("Eddie Murpy",123456,65,"Perfect image");
        System.out.println("expextedData = " + expextedData);

        //Send the Request and get the Response
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expextedData).when().post("/{first}");

        //Do Assertion
        DummyRestApiResponseBodyPojo actualdata =ObjectMapperUtils.convertJsonToJava(response.asString(), DummyRestApiResponseBodyPojo.class);
        System.out.println("actualdata = " + actualdata);
        assertEquals(200,response.statusCode());
        assertEquals(expextedData.getEmployee_name(),actualdata.getData().getEmployee_name());
        assertEquals(expextedData.getEmployee_salary(),actualdata.getData().getEmployee_salary());
        assertEquals(expextedData.getEmployee_age(),actualdata.getData().getEmployee_age());
        assertEquals(expextedData.getProfile_image(),actualdata.getData().getProfile_image());

    }
}
