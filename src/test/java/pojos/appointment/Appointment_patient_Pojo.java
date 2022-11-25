package pojos.appointment;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Appointment_patient_Pojo {

    private  String createdBy;
    private  String createdDate;
    private  int id;
    private  String firstName;
    private  String lastName;
    private  String birthDate;
    private  String phone;
    private  String gender;
    private  String bloodGroup;
    private  Object adress;
    private  String email;
    private  Object description;
    private  Appointment_patient_user_Pojo user;
    private Object inPatients;
    private  Appointment_patient_country_Pojo country;
    private  Object cstate;

    public Appointment_patient_Pojo(String createdBy, String createdDate, int id, String firstName, String lastName,
                                    String birthDate, String phone, String gender, String bloodGroup, Object adress,
                                    String email, Object description, Appointment_patient_user_Pojo user, Object inPatients,
                                    Appointment_patient_country_Pojo country, Object cstate) {

        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.adress = adress;
        this.email = email;
        this.description = description;
        this.user = user;
        this.inPatients = inPatients;
        this.country = country;
        this.cstate = cstate;
    }

    public Appointment_patient_Pojo() {
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Object getAdress() {
        return adress;
    }

    public void setAdress(Object adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Appointment_patient_user_Pojo getUser() {
        return user;
    }

    public void setUser(Appointment_patient_user_Pojo user) {
        this.user = user;
    }

    public Object getInPatients() {
        return inPatients;
    }

    public void setInPatients(Object inPatients) {
        this.inPatients = inPatients;
    }

    public Appointment_patient_country_Pojo getCountry() {
        return country;
    }

    public void setCountry(Appointment_patient_country_Pojo country) {
        this.country = country;
    }

    public Object getCstate() {
        return cstate;
    }

    public void setCstate(Object cstate) {
        this.cstate = cstate;
    }

    @Override
    public String toString() {
        return "Appointment_patient_Pojo{" +
                "createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", adress='" + adress + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                ", user=" + user +
                ", inPatients='" + inPatients + '\'' +
                ", country=" + country +
                ", cstate='" + cstate + '\'' +
                '}';
    }
}
