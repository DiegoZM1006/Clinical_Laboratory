package ui;
import com.google.gson.Gson;
import model.*;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("data.json");
            System.out.println("Existe:" + file.exists());
            FileInputStream fis = new FileInputStream(file);

            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

            String json = "";
            String line;
            while ((line = reader.readLine()) != null){
                json+=line;
            }
            fis.close();
            System.out.println(json);

            Gson gson = new Gson();
            Patient[] pets = gson.fromJson(json, Patient[].class);

            ArrayList<Patient> arrayPets = new ArrayList<>();
            for (Patient p:pets){
                arrayPets.add(p);
                System.out.println(p);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
