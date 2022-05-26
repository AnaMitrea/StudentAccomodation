package database.repository;

import database.managerfactory.EntityManager;

import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Objects;


public class ValidationDataRepository {
    private String lastName;
    private String firstName;
    private String an;
    private String grupa;
    private String emailAdress;
    public String matricol;
    private String medie;
    private String dataNastere;
    private String femaleGender;
    private String maleGender;
    private int camin;
    private double medie_buna=0.0;
    javax.persistence.EntityManager entityManager = EntityManager.getEntityManagerFactory().createEntityManager();

    EntityTransaction transaction = entityManager.getTransaction();


    public ValidationDataRepository(String lastName, String firstName, String an, String grupa, String emailAdress, String matricol, String medie, String dataNastere, String femaleGender, String maleGender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.an = an;
        this.grupa = grupa;
        this.emailAdress = emailAdress;
        this.matricol = matricol;
        this.medie = medie;
        this.dataNastere = dataNastere;
        this.femaleGender = femaleGender;
        this.maleGender = maleGender;
    }

    private String formDate(String date) {
        String newDate;
        String month = null;
        newDate = date.substring(0, 2);
        newDate += "-";
        if (date.startsWith("01", 3)) {
            month = "JAN";
        } else if (date.startsWith("02", 3)) {
            month = "FEB";
        } else if (date.startsWith("03", 3)) {
            month = "MAR";
        } else if (date.startsWith("04", 3)) {
            month = "APR";
        } else if (date.startsWith("05", 3)) {
            month = "MAY";
        } else if (date.startsWith("06", 3)) {
            month = "JUN";
        } else if (date.startsWith("07", 3)) {
            month = "JUL";
        } else if (date.startsWith("08", 3)) {
            month = "AUG";
        } else if (date.startsWith("09", 3)) {
            month = "SEP";
        } else if (date.startsWith("10", 3)) {
            month = "OCT";
        } else if (date.startsWith("11", 3)) {
            month = "NOV";
        } else if (date.startsWith("12", 3)) {
            month = "DEC";
        }
        newDate += month;
        newDate += "-";
        newDate += date.substring(8, 10);

        return newDate;
    }

    public String validare() {
        System.out.println("aiciDodan");
        String gen1;
        int anInt = Integer.parseInt(an);
        double medieDouble = Double.parseDouble(medie);
        dataNastere = formDate(dataNastere);

        if (Objects.equals(femaleGender, "true"))
            gen1 = "F";
        else
            gen1 = "M";

        System.out.println("..." + dataNastere + "..." + dataNastere.length());

        int count = Math.toIntExact((long) entityManager.createNamedQuery("StudentValidation")
                .setParameter("nr_matricol", matricol)
                .setParameter("nume", lastName)
                .setParameter("prenume", firstName)
                .setParameter("gen", gen1)
                .setParameter(1, anInt)
                .setParameter("grupa", grupa)
                .setParameter("datanastere", dataNastere)
                .setParameter("email", emailAdress)
                .setParameter(2, medieDouble)
                .getSingleResult());
        System.out.println(count);

        if (count > 0) {
            if (!verificareInregistrat(matricol)) {

                if (verifica_camin(matricol)) {
                    System.out.println("Continuat pas 1");
                    transaction.begin();
                    entityManager.createNativeQuery("UPDATE studenti SET inregistrat=true WHERE nr_matricol=:matricol")
                            .setParameter("matricol", matricol)
                            .executeUpdate();
                    transaction.commit();
                    System.out.println("Continuat pas 2");

                    System.out.println("Pas adaugat");

                    transaction.begin();
                    int c = (int) entityManager.createNamedQuery("UpdateCamin3")
                            .setParameter("matricol", matricol)
                            .getSingleResult();
                    transaction.commit();

                    System.out.println("count2 " + "" + c);
                    transaction.begin();
                    entityManager.createNativeQuery("UPDATE studenti SET id_camin=:camin WHERE nr_matricol=:matricol")
                            .setParameter("camin", c)
                            .setParameter("matricol", matricol)
                            .executeUpdate();
                    System.out.println(camin);
                    transaction.commit();
                    System.out.println("Continuat pas 3");
                    transaction.begin();
                    count = Math.toIntExact((int) entityManager.createNamedQuery("GetNumber")
                            .setParameter(1, c)
                            .getSingleResult());
                    transaction.commit();


                    System.out.println("nr_locuri_camin_inainte" + " " + "Continuat pas 4" + " " + count);
                    count--;
                    transaction.begin();
                    entityManager.createNativeQuery("UPDATE camine SET capacitate_totala=:count WHERE id=:camin")
                            .setParameter("count", count)
                            .setParameter("camin", c)
                            .executeUpdate();
                    transaction.commit();
                    System.out.println("nr_locuri_camin_dupa" + " " + "Continuat pas 4" + " " + count);
                    entityManager.close();
                    return "Ai aplicat cu succes!";
                }

                return "Esti in asteptare!";
            }
            return "Esti deja inregistrat!";
        }
        return "Informatii invalide!";
    }

    private boolean verifica_camin(String matricol) {
        setMatricol(matricol);
        medie_buna=0.0;
        int idCamin;
        double minim=99999.0;
        System.out.println("Am intrat");
        String nr_matricolAdiacent = null;
        transaction.begin();
        int count1 = Math.toIntExact((int) entityManager.createNamedQuery("GetNumberC1")
                .setParameter("nume", "C1")
                .getSingleResult());
        transaction.commit();

        System.out.println("aici" + count1);

        if (count1 > 0) {
            System.out.println("inca e disponibil");

            transaction.begin();
            idCamin = (int) entityManager.createNamedQuery("GetIdCamin")
                    .setParameter("nume", "C1")
                    .getSingleResult();
            transaction.commit();

            transaction.begin();
            entityManager.createNativeQuery("UPDATE studenti SET id_camin=:camin WHERE nr_matricol=:matricol")
                    .setParameter("camin", idCamin)
                    .setParameter("matricol", matricol)
                    .executeUpdate();
            transaction.commit();
            return true;


        } else {
            System.out.println("am intrat in cazul2");
            transaction.begin();
            List name = entityManager.createNamedQuery("UpdateCamin")
                    .getResultList();
            transaction.commit();

            for (Object index: name) {
                transaction.begin();
                double medie1 = (double) entityManager.createNamedQuery("UpdateCamin2")
                        .setParameter("matricol", index)
                        .getSingleResult();
                System.out.println("--------"+medie1);
                transaction.commit();
                if (medie1 < Double.parseDouble(medie)) {
                    if(Double.parseDouble(medie)<minim) {
                        medie_buna = medie1;
                        nr_matricolAdiacent = index.toString();
                        System.out.println("cat e index="+index);
                        minim=Double.parseDouble(medie);
                    }
                }
            }
            System.out.println("--------"+medie_buna);
            if (medie_buna > 0.0) {


                transaction.begin();
                idCamin = (int) entityManager.createNamedQuery("GetIdCamin")
                        .setParameter("nume", "C1")
                        .getSingleResult();
                transaction.commit();

                transaction.begin();
                entityManager.createNativeQuery("UPDATE studenti SET inregistrat=true WHERE nr_matricol=:matricol")
                        .setParameter("matricol", matricol)
                        .executeUpdate();
                transaction.commit();

                transaction.begin();
                entityManager.createNativeQuery("UPDATE studenti SET id_camin=:camin WHERE nr_matricol=:matricol")
                        .setParameter("camin", idCamin)
                        .setParameter("matricol", matricol)
                        .executeUpdate();
                transaction.commit();

                System.out.println("+++++++++++++++++++"+nr_matricolAdiacent);
                transaction.begin();
                entityManager.createNativeQuery("UPDATE studenti SET id_camin=0 WHERE nr_matricol=:matricol")
                        .setParameter("matricol", nr_matricolAdiacent)
                        .executeUpdate();
                transaction.commit();
                System.out.println("+++++++++++++++++++dupa"+nr_matricolAdiacent);
                verifica_camin(nr_matricolAdiacent);
                return true;

            }

        }
        minim=99999.0;
        transaction.begin();
        int count2 = Math.toIntExact((int) entityManager.createNamedQuery("GetNumberC2")
                .setParameter("nume", "C2")
                .getSingleResult());
        transaction.commit();
        medie_buna=0.0;
        if (count2 > 0) {
            System.out.println("suntem la camin c2 pe primul caz");

            transaction.begin();
            idCamin = (int) entityManager.createNamedQuery("GetIdCamin")
                    .setParameter("nume", "C2")
                    .getSingleResult();
            transaction.commit();

            transaction.begin();
            entityManager.createNativeQuery("UPDATE studenti SET id_camin=:camin WHERE nr_matricol=:matricol")
                    .setParameter("camin", idCamin)
                    .setParameter("matricol", matricol)
                    .executeUpdate();
            transaction.commit();
            return true;
        } else

        {
            transaction.begin();
            List name = entityManager.createNamedQuery("UpdateCamin")
                    .getResultList();
            transaction.commit();

            for (Object index: name) {
                transaction.begin();
                double medie1 = (double) entityManager.createNamedQuery("UpdateCamin2")
                        .setParameter("matricol", index)
                        .getSingleResult();
                transaction.commit();
                if (medie1 < Double.parseDouble(medie)) {
                    if(Double.parseDouble(medie)<minim) {
                        medie_buna = medie1;
                        nr_matricolAdiacent = index.toString();
                        minim=Double.parseDouble(medie);
                    }
                }
            }
            if (medie_buna > 0.0) {

                transaction.begin();
                idCamin = (int) entityManager.createNamedQuery("GetIdCamin")
                        .setParameter("nume", "C2")
                        .getSingleResult();
                transaction.commit();

                transaction.begin();
                entityManager.createNativeQuery("UPDATE studenti SET inregistrat=true WHERE nr_matricol=:matricol")
                        .setParameter("matricol", matricol)
                        .executeUpdate();
                transaction.commit();

                transaction.begin();
                entityManager.createNativeQuery("UPDATE studenti SET id_camin=:camin WHERE nr_matricol=:matricol")
                        .setParameter("camin", idCamin)
                        .setParameter("matricol", matricol)
                        .executeUpdate();
                transaction.commit();

                transaction.begin();
                entityManager.createNativeQuery("UPDATE studenti SET id_camin=0 WHERE nr_matricol=:matricol")
                        .setParameter("matricol", nr_matricolAdiacent)
                        .executeUpdate();
                transaction.commit();
                verifica_camin(nr_matricolAdiacent);
                return true;
            }
        }

        medie_buna=0.0;
        minim=9999.0;
        transaction.begin();
        int count3 = Math.toIntExact((int) entityManager.createNamedQuery("GetNumberC3")
                .setParameter("nume", "C3")
                .getSingleResult());
        transaction.commit();

        if (count3 > 0) {

            transaction.begin();
            idCamin = (int) entityManager.createNamedQuery("GetIdCamin")
                    .setParameter("nume", "C3")
                    .getSingleResult();
            transaction.commit();

            transaction.begin();
            entityManager.createNativeQuery("UPDATE studenti SET id_camin=:camin WHERE nr_matricol=:matricol")
                    .setParameter("camin", idCamin)
                    .setParameter("matricol", matricol)
                    .executeUpdate();
            transaction.commit();
            return true;
        } else {

            transaction.begin();
            List name = entityManager.createNamedQuery("UpdateCamin")
                    .getResultList();
            transaction.commit();

            for (Object index: name) {
                transaction.begin();
                double medie1 = (double) entityManager.createNamedQuery("UpdateCamin2")
                        .setParameter("matricol", index)
                        .getSingleResult();
                transaction.commit();
                if (medie1 < Double.parseDouble(medie)) {
                    if(Double.parseDouble(medie)<minim) {
                        medie_buna = medie1;
                        nr_matricolAdiacent = index.toString();
                        minim=Double.parseDouble(medie);
                    }
                }
            }
            if (medie_buna > 0.0) {

                transaction.begin();
                idCamin = (int) entityManager.createNamedQuery("GetIdCamin")
                        .setParameter("nume", "C3")
                        .getSingleResult();
                transaction.commit();

                transaction.begin();
                entityManager.createNativeQuery("UPDATE studenti SET inregistrat=true WHERE nr_matricol=:matricol")
                        .setParameter("matricol", matricol)
                        .executeUpdate();
                transaction.commit();

                transaction.begin();
                entityManager.createNativeQuery("UPDATE studenti SET id_camin=:camin WHERE nr_matricol=:matricol")
                        .setParameter("camin", idCamin)
                        .setParameter("matricol", matricol)
                        .executeUpdate();
                transaction.commit();

                transaction.begin();
                entityManager.createNativeQuery("UPDATE studenti SET id_camin=0 WHERE nr_matricol=:matricol")
                        .setParameter("matricol", nr_matricolAdiacent)
                        .executeUpdate();
                transaction.commit();
                verifica_camin(nr_matricolAdiacent);
                return true;
            }

        }

        medie_buna=0.0;
        minim=9999.0;
        transaction.begin();
        int count4 = Math.toIntExact((int) entityManager.createNamedQuery("GetNumberC4")
                .setParameter("nume", "C4")
                .getSingleResult());
        transaction.commit();

        if (count4 > 0) {

            transaction.begin();
            idCamin = (int) entityManager.createNamedQuery("GetIdCamin")
                    .setParameter("nume", "C4")
                    .getSingleResult();
            transaction.commit();

            transaction.begin();
            entityManager.createNativeQuery("UPDATE studenti SET id_camin=:camin WHERE nr_matricol=:matricol")
                    .setParameter("camin", idCamin)
                    .setParameter("matricol", matricol)
                    .executeUpdate();
            transaction.commit();
            return true;

        } else {

            transaction.begin();
            List name = entityManager.createNamedQuery("UpdateCamin")
                    .getResultList();
            transaction.commit();

            for (Object index: name) {
                transaction.begin();
                double medie1 = (double) entityManager.createNamedQuery("UpdateCamin2")
                        .setParameter("matricol", index)
                        .getSingleResult();
                transaction.commit();
                if (medie1 < Double.parseDouble(medie)) {
                    if(Double.parseDouble(medie)<minim) {
                        medie_buna = medie1;
                        nr_matricolAdiacent = index.toString();
                        minim=Double.parseDouble(medie);
                    }
                }
            }
            if (medie_buna > 0.0) {

                transaction.begin();
                idCamin = (int) entityManager.createNamedQuery("GetIdCamin")
                        .setParameter("nume", "C4")
                        .getSingleResult();
                transaction.commit();


                transaction.begin();
                entityManager.createNativeQuery("UPDATE studenti SET inregistrat=true WHERE nr_matricol=:matricol")
                        .setParameter("matricol", matricol)
                        .executeUpdate();
                transaction.commit();

                transaction.begin();
                entityManager.createNativeQuery("UPDATE studenti SET id_camin=:camin WHERE nr_matricol=:matricol")
                        .setParameter("camin", idCamin)
                        .setParameter("matricol", matricol)
                        .executeUpdate();
                transaction.commit();

                transaction.begin();
                entityManager.createNativeQuery("UPDATE studenti SET id_camin=0 WHERE nr_matricol=:matricol")
                        .setParameter("matricol", nr_matricolAdiacent)
                        .executeUpdate();
                transaction.commit();
                verifica_camin(nr_matricolAdiacent);
                return true;

            }

        }

        medie_buna=0.0;
        minim=9999.0;
        transaction.begin();
        int count5 = Math.toIntExact((int) entityManager.createNamedQuery("GetNumberC5")
                .setParameter("nume", "C5")
                .getSingleResult());
        transaction.commit();
        if (count5 > 0) {

            transaction.begin();
            idCamin = (int) entityManager.createNamedQuery("GetIdCamin")
                    .setParameter("nume", "C5")
                    .getSingleResult();
            transaction.commit();

            transaction.begin();
            entityManager.createNativeQuery("UPDATE studenti SET id_camin=:camin WHERE nr_matricol=:matricol")
                    .setParameter("camin", idCamin)
                    .setParameter("matricol", matricol)
                    .executeUpdate();
            transaction.commit();
            return true;

        } else {
            transaction.begin();
            List name = entityManager.createNamedQuery("UpdateCamin")
                    .getResultList();
            transaction.commit();

            for (Object index: name) {
                transaction.begin();
                double medie1 = (double) entityManager.createNamedQuery("UpdateCamin2")
                        .setParameter("matricol", index)
                        .getSingleResult();
                transaction.commit();
                if (medie1 < Double.parseDouble(medie)) {
                    if(Double.parseDouble(medie)<minim) {
                        medie_buna = medie1;
                        nr_matricolAdiacent = index.toString();
                        minim=Double.parseDouble(medie);
                    }
                }
            }
            if (medie_buna > 0.0) {

                transaction.begin();
                idCamin = (int) entityManager.createNamedQuery("GetIdCamin")
                        .setParameter("nume", "C5")
                        .getSingleResult();
                transaction.commit();

                transaction.begin();
                entityManager.createNativeQuery("UPDATE studenti SET inregistrat=true WHERE nr_matricol=:matricol")
                        .setParameter("matricol", matricol)
                        .executeUpdate();
                transaction.commit();

                transaction.begin();
                entityManager.createNativeQuery("UPDATE studenti SET id_camin=:camin WHERE nr_matricol=:matricol")
                        .setParameter("camin", idCamin)
                        .setParameter("matricol", matricol)
                        .executeUpdate();
                transaction.commit();

                transaction.begin();
                entityManager.createNativeQuery("UPDATE studenti SET id_camin=0 WHERE nr_matricol=:matricol")
                        .setParameter("matricol", nr_matricolAdiacent)
                        .executeUpdate();
                transaction.commit();
                verifica_camin(nr_matricolAdiacent);
                return true;
            }

        }


        return false;
    }


    private boolean verificareInregistrat(String matricol) {

        boolean count = (boolean) entityManager.createNamedQuery("CheckRegister")
                .setParameter("nrMatricol", matricol)
                .getSingleResult();
        return count;
    }

    public void setCamin(int camin) {
        this.camin = camin;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAn() {
        return an;
    }

    public void setAn(String an) {
        this.an = an;
    }

    public String getGrupa() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public String getMatricol() {
        return matricol;
    }

    public void setMatricol(String matricol) {
        this.matricol = matricol;
    }

    public String getMedie() {
        return medie;
    }

    public void setMedie(String medie) {
        this.medie = medie;
    }

    public String getDataNastere() {
        return dataNastere;
    }

    public void setDataNastere(String dataNastere) {
        this.dataNastere = dataNastere;
    }

    public String getFemaleGender() {
        return femaleGender;
    }

    public void setFemaleGender(String femaleGender) {
        this.femaleGender = femaleGender;
    }

    public String getMaleGender() {
        return maleGender;
    }

    public void setMaleGender(String maleGender) {
        this.maleGender = maleGender;
    }
}