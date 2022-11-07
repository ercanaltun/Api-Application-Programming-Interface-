package pojos;

public class Reqres_ResponsePOjo {

    private Reqres_DataPojo data;
    private Reqres_SupportPojo support;

    public Reqres_ResponsePOjo(Reqres_DataPojo data, Reqres_SupportPojo support) {
        this.data = data;
        this.support = support;
    }

    public Reqres_ResponsePOjo() {
    }

    public Reqres_DataPojo getData() {
        return data;
    }

    public void setData(Reqres_DataPojo data) {
        this.data = data;
    }

    public Reqres_SupportPojo getSupport() {
        return support;
    }

    public void setSupport(Reqres_SupportPojo support) {
        this.support = support;
    }

    @Override
    public String toString() {
        return "Reqres_ResponsePOjo{" +
                "data=" + data +
                ", support=" + support +
                '}';
    }
}
