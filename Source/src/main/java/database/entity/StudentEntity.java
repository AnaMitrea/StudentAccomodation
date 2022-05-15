package database.entity;

import javax.persistence.*;

@Entity
@NamedQuery(name = "FindAll", query = "SELECT s FROM StudentEntity s")
@NamedQuery(name = "CountStudents", query = "SELECT count(s.id) FROM StudentEntity s")
@Table(name = "studenti", schema = "public", catalog = "d4l5m503cets9j")
public class StudentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nr_matricol")
    private String serialNumber;
    @Basic
    @Column(name = "nume")
    private String surname;
    @Basic
    @Column(name = "prenume")
    private String name;
    @Basic
    @Column(name = "an")
    private Integer year;
    @Basic
    @Column(name = "grupa")
    private String group;
    @Basic
    @Column(name = "data_nastere")
    private String birthDate;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "medie")
    private Float gpa;
    @Basic
    @Column(name = "inregistrat")
    private Boolean isRegistered;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getGpa() {
        return gpa;
    }

    public void setGpa(Float gpa) {
        this.gpa = gpa;
    }

    public Boolean getRegistered() {
        return isRegistered;
    }

    public void setRegistered(Boolean registered) {
        isRegistered = registered;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentEntity that = (StudentEntity) o;

        if (id != that.id) return false;
        if (serialNumber != null ? !serialNumber.equals(that.serialNumber) : that.serialNumber != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (year != null ? !year.equals(that.year) : that.year != null) return false;
        if (group != null ? !group.equals(that.group) : that.group != null) return false;
        if (birthDate != null ? !birthDate.equals(that.birthDate) : that.birthDate != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (gpa != null ? !gpa.equals(that.gpa) : that.gpa != null) return false;
        if (isRegistered != null ? !isRegistered.equals(that.isRegistered) : that.isRegistered != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (serialNumber != null ? serialNumber.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (gpa != null ? gpa.hashCode() : 0);
        result = 31 * result + (isRegistered != null ? isRegistered.hashCode() : 0);
        return result;
    }
}
