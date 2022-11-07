package examples.examples_post_put_patch;

import base_url.JsonplaceholderBaseUrl;
import org.junit.Test;

public class Delete01 extends JsonplaceholderBaseUrl {

          /*
        Given
            https://jsonplaceholder.typicode.com/todos/198
        When
         I send DELETE Request to the Url
      Then
         Status code is 200
         And Response body is { }
     */

    @Test
    public void test01() {

        //set the url
        spec.pathParams("first","todos","second",198);

        //set the expected data



    }
}
