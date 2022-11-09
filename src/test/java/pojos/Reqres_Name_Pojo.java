package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Reqres_Name_Pojo {

    private  String name;

    public Reqres_Name_Pojo(String name) {
        this.name = name;
    }

    public Reqres_Name_Pojo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Reqres_Name_Pojo{" +
                "name='" + name + '\'' +
                '}';
    }
}
