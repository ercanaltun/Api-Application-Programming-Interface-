package post_requests;

import base_url.JsonplaceholderBaseUrl;
import org.junit.Test;

public class Post01 extends JsonplaceholderBaseUrl {

       /*
    Given
      1) https://jsonplaceholder.typicode.com/todos
      2)
   When
       I send POST Request to the Url
   Then
       Status code is 201 {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false
                         }
   And
       response body is like {
                               "userId": 55,
                               "title": "Tidy your room",
                               "completed": false,
                               "id": 201
                               }
*/


    @Test
    public void test01() {


        //First Step:Set the Url
        //Second Step:Set The Expected Data(Payload)
        //Third Step:Send The Request and Get The Response
        //Fourth Step:Do Assertion

    }
}
