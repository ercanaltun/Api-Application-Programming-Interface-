package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Reqres_Name_Job_Pojo {

    private  String name;
    private  String job;

    public Reqres_Name_Job_Pojo(String name, String job) {
        this.name = name;
        this.job = job;
    }


    public Reqres_Name_Job_Pojo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Reqres_Name_JobPojo{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }

}
