package ui;

import com.google.gson.Gson;
import model.*;
import model.PriorityQueue;

import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.*;

public class Main {

    public static ArrayList<Patient> arrayPatients = new ArrayList<>();
    public static HashTable<String> hashTableDB = new HashTable<>(100000000);
    public static STack<Patient> stackHematologia = new STack<>();
    public static STack<Patient> stackPropositoGeneral = new STack<>();
    public static PriorityQueue<Patient> PQHematologia = new PriorityQueue<>();
    public static PriorityQueue<Patient> PQPropositoGeneral = new PriorityQueue<>();
    public static Patient[] deletedOnes = new Patient[100000000];

    public Scanner sc;
    public static int option;

    public Main() {
        sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        System.out.println("STARTING APLICATION");

        loadDB();

        Main myMain = new Main();

        do {
            option = myMain.showMenu();
            myMain.executeOperation(option);
        } while (option != 0);

        System.out.println("FINISHED THE APLICATION");

    }

    public int showMenu() {
        int chooseOption;

        System.out.print(
                """
                        *-----------------------------------*
                        |     MENU CLINICAL LABORATORY      |
                        | (1) Add Patient                   |
                        | (2) Search Patient                |
                        | (3) Undo                          |
                        | (4) Attend Patient                |
                        *-----------------------------------*
                        Choose option:\s"""
        );

        chooseOption = sc.nextInt();
        return chooseOption;
    }

    public void executeOperation(int i) {
        switch (i) {
            case 1 -> addPatient();
            case 2 -> searchPatient();
            case 3 -> undo();
            case 4 -> attendPatient();
            case 5 -> option = 0;
            default -> System.out.println("Error, invalid option");
        }
    }


    public void addPatient() {
        System.out.println("REGISTER PATIENT");

        String name, lastName, id, gender, contDecision;
        int age, contP, priority = 0;

        id = JOptionPane.showInputDialog("Enter your id");

        Patient validationPatient = hashTableDB.search(id);

        if (validationPatient == null) {
            name = JOptionPane.showInputDialog("Enter your name");
            lastName = JOptionPane.showInputDialog("Enter your last name");
            gender = JOptionPane.showInputDialog("Enter your gender (M for male and F female)");
            age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age"));
            if (age > 60) priority++;
            contDecision = JOptionPane.showInputDialog("You have any disease?");
            if (contDecision.equalsIgnoreCase("Yes")) priority++;
            if (gender.equals("F")) contDecision = JOptionPane.showInputDialog("You are pregnant?");
            if (contDecision.equalsIgnoreCase("Yes")) priority++;

            Patient p = new Patient(name, lastName, age, gender, id, priority);
            arrayPatients.add(p);
            fillDB();
            loadDB();
        } else {
            JOptionPane.showMessageDialog(null, "The patient is already register");
        }

    }

    public void searchPatient() {

        String id;
        id = JOptionPane.showInputDialog("Enter your id");
        Patient validationPatient = hashTableDB.search(id);

        if (validationPatient == null) {
            addPatient();
        } else {
            String descition = "";
            descition = JOptionPane.showInputDialog("The patient was found, do you want to send him/her to any laboratory unit (YES OR NO)");
            if (descition.equalsIgnoreCase("Yes")) sendPatient(validationPatient);
        }

    }

    public void sendPatient(Patient patient) {
        String decision = JOptionPane.showInputDialog("Write the laboratory unit you want to send the patient (Hematologia or PropositoGeneral)");
        if (decision.equalsIgnoreCase("Hematologia")) {
            stackHematologia.push(patient);
            PQHematologia.insertElement(patient.getPriority(), patient);
        }
        if (decision.equalsIgnoreCase("PropositoGeneral")) {
            stackPropositoGeneral.push(patient);
            PQPropositoGeneral.insertElement(patient.getPriority(), patient);
        }
    }

    public void undo() {
        String decision = "";
        decision = JOptionPane.showInputDialog("You want to undo the entry?(YES or NO)");
        if (decision.equalsIgnoreCase("Yes")) {
            String respuesta = JOptionPane.showInputDialog("In wich laboratory the patient do the entry? (HEMATOLOGIA or PROPOSITOGENERAL)");
            if (respuesta.equalsIgnoreCase("Hematologia")) {
                if(PQHematologia.contPatient() > 0) {
                    NodeStack p = stackHematologia.pop();
                    Patient a = (Patient) p.getPatient();
                    PQHematologia.deleteElement(a);
                } else {
                    JOptionPane.showMessageDialog(null, "You cant undo the egress because you havent do the egress!!!!");
                }
            } else if (respuesta.equalsIgnoreCase("PropositoGeneral")) {
                if(PQPropositoGeneral.contPatient() > 0) {
                    NodeStack p = stackPropositoGeneral.pop();
                    Patient a = (Patient) p.getPatient();
                    PQPropositoGeneral.deleteElement(a);
                } else {
                    JOptionPane.showMessageDialog(null, "You cant undo the egress because you havent do the egress!!!!");
                }
            }
        }
        String decision2 = JOptionPane.showInputDialog("You want to undo the egress?(YES or NO)");
        if (decision2.equalsIgnoreCase("Yes")) {
            if (deletedOnes[0] != null) {
                String respuesta = JOptionPane.showInputDialog("In which laboratory unit was the patient(HEMATOLOGIA or PROPOSITOGENERAL)");
                if (respuesta.equalsIgnoreCase("Hematologia")) {
                    Patient p = deletedOnes[deletedOnes.length - 1];
                    stackHematologia.push(p);
                    PQHematologia.insertElement(p.getPriority(), p);
                } else if (respuesta.equalsIgnoreCase("PropositoGeneral")) {
                    Patient p = deletedOnes[deletedOnes.length - 1];
                    stackPropositoGeneral.push(p);
                    PQPropositoGeneral.insertElement(p.getPriority(), p);
                }
            } else {
                JOptionPane.showMessageDialog(null, "You cant undo the egress because you havent do the egress!!!!");
            }
        }
    }

    public void attendPatient() {

        String decision = JOptionPane.showInputDialog("in wich laboratory unit you want to attend the patients? (HEMATOLOGIA or PROPOSITOGENERAL)");
        if (decision.equalsIgnoreCase("Hematologia")) {
            Patient p = PQHematologia.extractMax();
            System.out.println(p.toString());
        } else if (decision.equalsIgnoreCase("PropositoGeneral")) {
            Patient p = PQPropositoGeneral.extractMax();
            System.out.println(p.toString());
        }

    }

    public void fillDB() {
        Gson gson = new Gson();
        String json = gson.toJson(arrayPatients);
        System.out.println(json);

        try {
            FileOutputStream fos = new FileOutputStream(new File("data.json"));
            fos.write(json.getBytes(StandardCharsets.UTF_8));
            fos.close();

            /*FileOutputStream fos = new FileOutputStream(new File("object.txt"));
            fos.write(json.getBytes(StandardCharsets.UTF_8));
            fos.close();*/
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadDB() {
        try {
            File file = new File("data.json");
            // System.out.println("Existe:" + file.exists());
            FileInputStream fis = new FileInputStream(file);

            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

            String json = "";
            String line;
            while ((line = reader.readLine()) != null) {
                json += line;
            }
            fis.close();
            // System.out.println(json);

            Gson gson = new Gson();
            Patient[] patients = gson.fromJson(json, Patient[].class);

            for (Patient p : patients) {
                arrayPatients.add(p);
                hashTableDB.insert(p.getId(), p);
                // System.out.println(p);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
