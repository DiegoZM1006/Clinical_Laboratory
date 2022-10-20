package ui;
import com.google.gson.Gson;
import model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.*;

public class Main {

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
        } while(option != 0);

        System.out.println("FINISHED THE APLICATION");

    }

    public int showMenu() {
        int chooseOption;

        System.out.print(
                """
                        *-----------------------------------*
                        |     MENU CLINICAL LABORATORY      |
                        | (1) Add Patitent                  |
                        | (2) .....                         |
                        | (5) .....                         |
                        *-----------------------------------*
                        Choose option:\s"""
        );

        chooseOption = sc.nextInt();
        return chooseOption;
    }

    public void executeOperation(int i) {
        switch (i) {
            case 1 -> addPatient();
            case 5 -> option = 0;
            default -> System.out.println("Error, invalid option");
        }
    }

    public void addPatient(){
        System.out.println("REGISTER PATIENT");

        String name, lastName, id, gender, contDescition;
        int age, contP, contTotalP = 0;
        boolean priority = false;

        name = JOptionPane.showInputDialog("Enter your name");
        lastName = JOptionPane.showInputDialog("Enter your last name");
        id = JOptionPane.showInputDialog("Enter your id");
        gender = JOptionPane.showInputDialog("Enter your gender (M for male and F female)");
        age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age"));
        if (age > 60) priority = true;
        contDescition = JOptionPane.showInputDialog("You have any disease?");
        if(contDescition.equalsIgnoreCase("Si")) contTotalP++;
        contDescition = "";
        contDescition = JOptionPane.showInputDialog("You are pregnant?");
        if(contDescition.equalsIgnoreCase("Si")) contTotalP++;
        if (contTotalP > 0) priority = true;


    }

    public static void loadDB() {
        try {
            File file = new File("data.json");
            // System.out.println("Existe:" + file.exists());
            FileInputStream fis = new FileInputStream(file);

            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

            String json = "";
            String line;
            while ((line = reader.readLine()) != null){
                json+=line;
            }
            fis.close();
            // System.out.println(json);

            Gson gson = new Gson();
            Patient[] patients = gson.fromJson(json, Patient[].class);

            HashTable<String> hashTableDB = new HashTable<>(100000000);
            ArrayList<Patient> arrayPatients = new ArrayList<>();
            for (Patient p : patients){
                arrayPatients.add(p);
                hashTableDB.insert(p.getId(), p);
                // System.out.println(p);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
