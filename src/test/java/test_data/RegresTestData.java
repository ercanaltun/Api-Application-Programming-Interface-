package test_data;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.Map;
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegresTestData {



    public  Map<String,String>reqresMethodMap(String name,String job){

        Map<String,String>reqresMap=new HashMap<>();
        reqresMap.put("name",name);
        reqresMap.put("job",job);

        return reqresMap;
    }

    public Map<String,String>ReqresTekParametreliMap(String name){

        Map<String,String>TekParametreliMap=new HashMap<>();
          TekParametreliMap.put("name",name);
          return TekParametreliMap;
    }




    public String dataInString(String name,String job ){
        String expectedData="       {\n" +
                "                \"name\": \"morpheus\",\n" +
                "                \"job\": \"leader\"\n" +
                "                } ";
        return expectedData;
    }

    public String TekParametreliDataInString(String name ){
        String expectedDatas="       {\n" +
                "                \"name\": \"neo\"\n" +
                "                } ";
        return expectedDatas;
    }

}
