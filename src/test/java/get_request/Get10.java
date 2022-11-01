package get_request;

import base_url.GorestBaseUrl;
import org.junit.Test;

public class Get10 extends GorestBaseUrl {

     /*
   Given
       https://gorest.co.in/public/v1/users/2986
   When
       User send GET Request to the URL
   Then
       Status Code should be 200
   And
       Response body should be like
    "meta": null,
    "data": {
        "id": 2986,
        "name": "Navin Talwar",
        "email": "navin_talwar@mclaughlin.name",
        "gender": "male",
        "status": "inactive"
    }
*/

    @Test
    public void test10() {

        //First Step:Set the Url
        //Second Step:Set The Expected Data(Payload)
        //Third Step:Send The Request and Get The Response
        //Fourth Step:Do Assertion
    }




}
