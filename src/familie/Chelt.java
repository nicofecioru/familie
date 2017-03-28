package familie;

public class Chelt
{
    private Integer id;
    private String tip;
    private Integer suma;
    private String descr;
    private String membru;



    @Override
    public String toString() {
        return "Chelt [id=" + id + ", tip=" + tip + ", suma=" + suma + ", descr=" + descr + ", membru=" + membru + "]";
    }
    public Chelt(Integer id, String tip, Integer suma, String descr, String membru) {
        super();
        this.id = id;
        this.tip = tip;
        this.suma = suma;
        this.descr = descr;
        this.membru = membru;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTip() {
        return tip;
    }
    public void setTip(String tip) {
        this.tip = tip;
    }
    public Integer getSuma() {
        return suma;
    }
    public void setSuma(Integer suma) {
        this.suma = suma;
    }
    public String getDescr() {
        return descr;
    }
    public void setDescr(String descr) {
        this.descr = descr;
    }
    public String getMembru() {
        return membru;
    }
    public void setMembru(String membru) {
        this.membru = membru;
    }

}
