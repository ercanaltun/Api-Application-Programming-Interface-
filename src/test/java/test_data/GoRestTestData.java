package test_data;


import java.util.HashMap;
import java.util.Map;

public class GoRestTestData {

    public Map<String, String> dataKeyMap(String name, String email, String gender, String status) {
        Map<String, String> dataKeyMap = new HashMap<>();
        dataKeyMap.put("name", name);
        dataKeyMap.put("email", email);
        dataKeyMap.put("gender", gender);
        dataKeyMap.put("status", status);

        return dataKeyMap;
    }

    public Map<String, Object> expectedDataMethod(Object meta, Map<String, String> data) {

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("meta", meta);
        expectedData.put("data", data);

        return expectedData;

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////


    public static Map<String, String> dataMaps(String name, String email, String gender, String status) {
        Map<String, String> datasMap = new HashMap<>();
        datasMap.put("name", name);
        datasMap.put("email", email);
        datasMap.put("gender", gender);
        datasMap.put("status", status);


        return datasMap;

    }

    public static Map<String, Object> expectedDatas(String meta, Map<String, String> data) {

        Map<String, Object> expectedDatas = new HashMap<>();
        expectedDatas.put("meta", meta);
        expectedDatas.put("data", data);
        return expectedDatas;

    }


}





































