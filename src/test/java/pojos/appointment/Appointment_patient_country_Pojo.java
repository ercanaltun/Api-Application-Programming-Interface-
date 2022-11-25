package pojos.appointment;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Appointment_patient_country_Pojo {

    private int id;
    private String name;

    public Appointment_patient_country_Pojo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Appointment_patient_country_Pojo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Appointment_patient_country_Pojo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
