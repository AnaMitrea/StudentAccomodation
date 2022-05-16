package main;

import database.entity.StudentiEntity;
import database.repository.StudentRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("--FORM--");
            System.out.print("Nr matricol: ");
            String nrMatricol = br.readLine();
            System.out.print("Nume: ");
            String nume = br.readLine();
            System.out.print("Prenume: ");
            String prenume = br.readLine();
            System.out.print("An: ");
            int an = Integer.parseInt(br.readLine());
            System.out.print("Grupa: ");
            String grupa = br.readLine();
            System.out.print("Data nastere: ");
            String dataNastere = br.readLine();
            System.out.print("Email: ");
            String email = br.readLine();
            System.out.print("Medie: ");
            double medie = Double.parseDouble(br.readLine());

            System.out.println(nrMatricol + " " + nume + " " + prenume + " " + an + " " + grupa + " " + dataNastere + " " + email + " " + medie);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
