package examples.secondweek;

import base_url.GoRestBaseUrl;
import org.junit.Test;

public class Example10A extends GoRestBaseUrl {

         /*
        Given
            https://gorest.co.in/api/users/2986
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
            /*
            {
        "meta": null,
        "data": {
            "id": 2986,
            "name": "Navin Talwar",
            "email": "navin_talwar@mclaughlin.name",
            "gender": "male",
            "status": "inactive"
              }
         }
     */

    @Test
    public void test10A() {

        //First Step:Set the Url
        spec.pathParams("first","users","second",2986);

        //Second Step:Set The Expected Data(Payload)




        //Third Step:Send The Request and Get The Response
        
        //Fourth Step:Do Assertion
    }
}
