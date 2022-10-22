package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {

    private PriorityQueue<Patient> patients;

    private void setUp1(){
        patients = new PriorityQueue<>();
    }
    private void setUp2(){
        patients = new PriorityQueue<>();

        Patient patientGines = new Patient("Gines", "Gonzales", 25, "F", "1234432234",0);
        Patient patientSaiao = new Patient("Saioa", "Matos", 32, "M", "1987654321",0);
        Patient patientEster = new Patient("Ester", "Navas", 76, "M", "1912567490",1);

        patients.insertElement(patientGines.getPriority(), patientGines);
        patients.insertElement(patientSaiao.getPriority(), patientSaiao);
        patients.insertElement(patientEster.getPriority(), patientEster);
    }

    private void setUp3() {

        patients = new PriorityQueue<>();

        Patient patientVioleta = new Patient("Violeta", "Echevarria", 37, "F", "1486729456",1);
        Patient patientAicha = new Patient("Aicha", "Zamora", 15, "F", "1879657435",3);
        Patient patientFeliciano = new Patient("Feliciano", "Godoy", 61, "M", "1234597689",2);

        patients.insertElement(patientVioleta.getPriority(), patientVioleta);
        patients.insertElement(patientAicha.getPriority(), patientAicha);
        patients.insertElement(patientFeliciano.getPriority(), patientFeliciano);
    }

    // TEST TO INSERT ELEMENT

    @Test
    public void insertElement1(){
        setUp1();

        Patient patient1 = new Patient("Eloisa", "Messeguer", 29, "F", "8765234564",1);

        patients.insertElement(patient1.getPriority(), patient1);
        assertEquals(patient1, patients.extractMax());
    }

    @Test
    public void insertElement2(){
        setUp1();

        Patient patient1 = new Patient("Leire", "Orellana", 19, "F", "9123435786",0);

        patients.insertElement(patient1.getPriority(), patient1);
        assertEquals(patient1, patients.extractMax());
    }

    @Test
    public void insertElement3(){
        setUp1();

        Patient patient1 = new Patient("Nahia", "Viera", 39, "F", "2123321456",1);

        patients.insertElement(patient1.getPriority(), patient1);
        assertEquals(patient1, patients.extractMax());
    }

    // TEST TO SHOW MAX

    @Test
    public void showMax1(){
        setUp2();
        assertEquals("Patient{name='Ester'lastName='Navas', age='76', gender='M', id='1912567490'", patients.showMax().toString());
    }

    @Test
    public void showMax2(){
        setUp2();

        Patient patient1 = new Patient("Aritz", "Villena", 32, "F", "4321564765",2);
        patients.insertElement(patient1.getPriority(), patient1);

        assertEquals("Patient{name='Aritz'lastName='Villena', age='32', gender='F', id='4321564765'", patients.showMax().toString());
    }

    @Test
    public void showMax3(){
        setUp2();

        Patient patient1 = new Patient("Gregorio", "Prieto", 42, "M", "5432234432",3);
        patients.insertElement(patient1.getPriority(), patient1);

        assertEquals("Patient{name='Gregorio'lastName='Prieto', age='42', gender='M', id='5432234432'", patients.showMax().toString());
    }

    // TEST TO EXTRACT MAX

    @Test
    public void extractMax1(){
        setUp3();
        assertEquals("Patient{name='Aicha'lastName='Zamora', age='15', gender='F', id='1879657435'", patients.extractMax().toString());
    }

    @Test
    public void extractMax2(){
        setUp2();
        assertEquals("Patient{name='Ester'lastName='Navas', age='76', gender='M', id='1912567490'", patients.extractMax().toString());
    }

    @Test
    public void extractMax3(){
        setUp1();

        Patient patient1 = new Patient("Felix", "Barba", 75, "M", "1323987456",2);
        patients.insertElement(patient1.getPriority(), patient1);

        assertEquals("Patient{name='Felix'lastName='Barba', age='75', gender='M', id='1323987456'", patients.extractMax().toString());
    }

    // TESTO TO CONT PATIENTS

    @Test
    public void contPatient1(){
        setUp3();
        assertEquals(3, patients.contPatient());
    }

    @Test
    public void contPatient2(){
        setUp2();
        assertEquals(3, patients.contPatient());
    }

    @Test
    public void contPatient3(){
        setUp1();

        Patient patient1 = new Patient("Emma", "Zhu", 24, "F", "5467564756",0);
        patients.insertElement(patient1.getPriority(), patient1);
        Patient patient2 = new Patient("Julian", "Jimenez", 35, "F", "2345543678",1);
        patients.insertElement(patient2.getPriority(), patient2);

        assertEquals(2, patients.contPatient());
    }

    // TESTO TO SHOW PATIENTS

    @Test
    public void showPatients1() {
        setUp2();
        assertEquals("Patient{name='Ester'lastName='Navas', age='76', gender='M', id='1912567490', priority=1}\n" +
                "Patient{name='Saioa'lastName='Matos', age='32', gender='M', id='1987654321', priority=0}\n" +
                "Patient{name='Gines'lastName='Gonzales', age='25', gender='F', id='1234432234', priority=0}\n", patients.showPatients());
    }

    @Test
    public void showPatients2() {
        setUp3();
        assertEquals("Patient{name='Aicha'lastName='Zamora', age='15', gender='F', id='1879657435', priority=3}\n" +
                "Patient{name='Violeta'lastName='Echevarria', age='37', gender='F', id='1486729456', priority=1}\n" +
                "Patient{name='Feliciano'lastName='Godoy', age='61', gender='M', id='1234597689', priority=2}\n", patients.showPatients());
    }

    @Test
    public void showPatients3() {
        setUp1();

        Patient patient1 = new Patient("Irati", "Bastida", 21, "F", "9876543123",0);
        patients.insertElement(patient1.getPriority(), patient1);

        assertEquals("Patient{name='Irati'lastName='Bastida', age='21', gender='F', id='9876543123', priority=0}\n", patients.showPatients());
    }

    // TESTO TO INCREASE KEY

    @Test
    public void increaseKey1() {
        setUp1();

        Patient patient1 = new Patient("Carolina", "Bolaños", 34, "F", "6543786195",1);
        patients.insertElement(patient1.getPriority(), patient1);
        patients.increaseKey(patient1, 4);

        assertEquals("Patient{name='Carolina'lastName='Bolaños', age='34', gender='F', id='6543786195', priority=4}\n", patients.showPatients());

    }

    @Test
    public void increaseKey2() {
        setUp1();

        Patient patient1 = new Patient("Carme", "Arroyo", 35, "F", "5367824529",1);
        patients.insertElement(patient1.getPriority(), patient1);
        patients.increaseKey(patient1, 5);

        assertEquals("Patient{name='Carme'lastName='Arroyo', age='35', gender='F', id='5367824529', priority=5}\n", patients.showPatients());

    }

    @Test
    public void increaseKey3() {
        setUp1();

        Patient patient1 = new Patient("Jess", "Bermudez", 44, "M", "7345829456",1);
        patients.insertElement(patient1.getPriority(), patient1);
        patients.increaseKey(patient1, 6);

        assertEquals("Patient{name='Jess'lastName='Bermudez', age='44', gender='M', id='7345829456', priority=6}\n", patients.showPatients());

    }

    // TEST TO DELETE ELEMENT

    @Test
    public void deleteElement1() {
        setUp1();

        Patient patient1 = new Patient("Marisol", "Garriga", 22, "F", "2345567567",1);
        patients.insertElement(patient1.getPriority(), patient1);
        patients.deleteElement(patient1);

        assertEquals("", patients.showPatients());
    }

    @Test
    public void deleteElement2() {
        setUp1();

        Patient patient1 = new Patient("Marisol", "Garriga", 22, "F", "2345567567",1);
        patients.insertElement(patient1.getPriority(), patient1);
        patients.deleteElement(patient1);
        Patient patient2 = new Patient("Florentino", "Espin", 25, "M", "5467846754",2);
        patients.insertElement(patient2.getPriority(), patient2);

        assertEquals("Patient{name='Florentino'lastName='Espin', age='25', gender='M', id='5467846754', priority=2}\n", patients.showPatients());
    }

    @Test
    public void deleteElement3() {
        setUp1();

        Patient patient1 = new Patient("Marisol", "Garriga", 22, "F", "2345567567",1);
        patients.insertElement(patient1.getPriority(), patient1);
        Patient patient2 = new Patient("Florentino", "Espin", 25, "M", "5467846754",2);
        patients.insertElement(patient2.getPriority(), patient2);
        patients.deleteElement(patient2);
        Patient patient3 = new Patient("Marco-Antonio", "Sastre", 65, "M", "9876234746",2);
        patients.insertElement(patient3.getPriority(), patient3);

        assertEquals("Patient{name='Marco-Antonio'lastName='Sastre', age='65', gender='M', id='9876234746', priority=2}\n" +
                "Patient{name='Marisol'lastName='Garriga', age='22', gender='F', id='2345567567', priority=1}\n", patients.showPatients());
    }
}