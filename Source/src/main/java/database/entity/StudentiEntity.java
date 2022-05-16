package database.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "studenti", schema = "public", catalog = "d4l5m503cets9j")
public class StudentiEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nr_matricol")
    private String nrMatricol;
    @Basic
    @Column(name = "nume")
    private String nume;
    @Basic
    @Column(name = "prenume")
    private String prenume;
    @Basic
    @Column(name = "an")
    private Integer an;
    @Basic
    @Column(name = "grupa")
    private String grupa;
    @Basic
    @Column(name = "data_nastere")
    private String dataNastere;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "medie")
    private BigDecimal medie;
    @Basic
    @Column(name = "inregistrat")
    private Boolean inregistrat;
    @ManyToOne
    @JoinColumn(name = "id_camin", referencedColumnName = "id")
    private CamineEntity camineByIdCamin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNrMatricol() {
        return nrMatricol;
    }

    public void setNrMatricol(String nrMatricol) {
        this.nrMatricol = nrMatricol;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public Integer getAn() {
        return an;
    }

    public void setAn(Integer an) {
        this.an = an;
    }

    public String getGrupa() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    public String getDataNastere() {
        return dataNastere;
    }

    public void setDataNastere(String dataNastere) {
        this.dataNastere = dataNastere;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getMedie() {
        return medie;
    }

    public void setMedie(BigDecimal medie) {
        this.medie = medie;
    }

    public Boolean getInregistrat() {
        return inregistrat;
    }

    public void setInregistrat(Boolean inregistrat) {
        this.inregistrat = inregistrat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentiEntity that = (StudentiEntity) o;

        if (id != that.id) return false;
        if (nrMatricol != null ? !nrMatricol.equals(that.nrMatricol) : that.nrMatricol != null) return false;
        if (nume != null ? !nume.equals(that.nume) : that.nume != null) return false;
        if (prenume != null ? !prenume.equals(that.prenume) : that.prenume != null) return false;
        if (an != null ? !an.equals(that.an) : that.an != null) return false;
        if (grupa != null ? !grupa.equals(that.grupa) : that.grupa != null) return false;
        if (dataNastere != null ? !dataNastere.equals(that.dataNastere) : that.dataNastere != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (medie != null ? !medie.equals(that.medie) : that.medie != null) return false;
        if (inregistrat != null ? !inregistrat.equals(that.inregistrat) : that.inregistrat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nrMatricol != null ? nrMatricol.hashCode() : 0);
        result = 31 * result + (nume != null ? nume.hashCode() : 0);
        result = 31 * result + (prenume != null ? prenume.hashCode() : 0);
        result = 31 * result + (an != null ? an.hashCode() : 0);
        result = 31 * result + (grupa != null ? grupa.hashCode() : 0);
        result = 31 * result + (dataNastere != null ? dataNastere.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (medie != null ? medie.hashCode() : 0);
        result = 31 * result + (inregistrat != null ? inregistrat.hashCode() : 0);
        return result;
    }

    public CamineEntity getCamineByIdCamin() {
        return camineByIdCamin;
    }

    public void setCamineByIdCamin(CamineEntity camineByIdCamin) {
        this.camineByIdCamin = camineByIdCamin;
    }
}
