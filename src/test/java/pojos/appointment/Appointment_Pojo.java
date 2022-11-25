package pojos.appointment;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Appointment_Pojo {

    private  String createdBy;
    private  String createdDate;
    private  int id;
    private  String startDate;
    private  String endDate;
    private  String status;
    private  Object anamnesis;
    private  Object treatment;
    private  Object diagnosis;
    private  Object prescription;
    private  Object description;
    private Appointment_physician_Pojo physician;
    private Appointment_patient_Pojo patient;
    private Object ctests;

    public Appointment_Pojo(String createdBy, String createdDate, int id, String startDate, String endDate,
                            String status, Object anamnesis, Object treatment, Object diagnosis,
                            Object prescription, Object description, Appointment_physician_Pojo physician,
                            Appointment_patient_Pojo patient, Object ctests) {

        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.anamnesis = anamnesis;
        this.treatment = treatment;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
        this.description = description;
        this.physician = physician;
        this.patient = patient;
        this.ctests = ctests;
    }

    public Appointment_Pojo() {
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getAnamnesis() {
        return anamnesis;
    }

    public void setAnamnesis(String anamnesis) {
        this.anamnesis = anamnesis;
    }

    public Object getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public Object getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Object getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Appointment_physician_Pojo getPhysician() {
        return physician;
    }

    public void setPhysician(Appointment_physician_Pojo physician) {
        this.physician = physician;
    }

    public Appointment_patient_Pojo getPatient() {
        return patient;
    }

    public void setPatient(Appointment_patient_Pojo patient) {
        this.patient = patient;
    }

    public Object getCtests() {
        return ctests;
    }

    public void setCtests(String ctests) {
        this.ctests = ctests;
    }

    @Override
    public String toString() {
        return "Appointment_Pojo{" +
                "createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", id='" + id + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", status='" + status + '\'' +
                ", anamnesis='" + anamnesis + '\'' +
                ", treatment='" + treatment + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", prescription='" + prescription + '\'' +
                ", description='" + description + '\'' +
                ", physician=" + physician +
                ", patient=" + patient +
                ", ctests='" + ctests + '\'' +
                '}';
    }
}
