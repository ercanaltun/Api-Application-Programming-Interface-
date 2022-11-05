package test_data;

import java.util.HashMap;
import java.util.Map;

public class RestfulTestData {

    public  Map<String,String>bookingdatesMethod(String checkin,String checkout){
             Map<String,String>bookingdatesMap=new HashMap<>();
             bookingdatesMap.put("checkin",checkin);
             bookingdatesMap.put("checkout",checkout);

             return bookingdatesMap;
    }

    public Map<String,Object>restfulMethod(String firstname,String lastname,Integer totalprice,Boolean depositpaid,Map<String,String> bookingdates){
            Map<String,Object>expecteddata=new HashMap<>();
            expecteddata.put("firstname",firstname);
            expecteddata.put("lastname",lastname);
            expecteddata.put("totalprice",totalprice);
            expecteddata.put("depositpaid",depositpaid);
            expecteddata.put("bookingdates",bookingdates);
            return expecteddata;

    }


}
