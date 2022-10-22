package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class STackTest {

    private STack<Patient> patients;
    private NodeStack<Patient> top;

    private void setUp1(){
        patients = new STack<>();
        top = null;
    }

    private void setUp2(){
        patients = new STack<>();
        patients.push(new Patient("d","m",1,"m","22",1));
        patients.push(new Patient("z","a",13,"f","234",3));
        patients.push(new Patient("Ppablo","arias",45,"m","11902",2));
        patients.push(new Patient("Maria","Ramos",67,"f","1824",1));
    }

    private void setUp3(){
        patients = new STack<>();
        patients.push(new Patient("e","t",15,"m","67",1));
    }

    @Test
    public void peekTest1(){
        setUp3();
        Patient patient1=new Patient("Alex","Zamora", 23, "m", "91099312", 3);
        patients.push(patient1);
        assertEquals(patients.peek().getPatient(),patient1);
    }

    @Test
    public void peekTest2(){
        setUp1();
        assertEquals(patients.peek(),null);
    }

    @Test
    public void peekTest3(){
        setUp2();
        Patient patient3 = new Patient("Alex","Zamora", 67, "m", "91099312", 3);
        patients.push(patient3);
        assertEquals(patients.peek().getPatient(),patient3);
    }

    @Test
    public void pushTest1(){
        setUp1();
        Patient patient3 = new Patient("Alex","Zamora", 67, "m", "91099312", 3);
        patients.push(patient3);
        assertEquals(patients.peek().getPatient(),patient3);
    }

    @Test
    public void pushTest2(){
        setUp1();
        Patient patient4 = new Patient("Daniel", "Montezuma", 18,"M", "A00382231", 2);
        Patient patient5 = new Patient("Samuel", "Meneses", 18,"M", "A00382231", 3);

        patients.push(patient5);
        assertEquals(patients.peek().getPatient(),patient5);
    }

    @Test
    public void  pushTest3(){
        setUp3();
        Patient ultiimo = new Patient("Diego", "Mueses", 18, "M", "203448328478", 3);
        patients.push(ultiimo);
        assertEquals(patients.peek().getPatient(),ultiimo);
    }

    @Test
    public void popTest1(){
        setUp1();
        assertEquals(patients.pop(),null);
    }

    @Test
    public void popTest2(){
        setUp2();
        Patient patient3 = new Patient("Alex","Zamora", 67, "m", "91099312", 3);
        patients.push(patient3);
        assertEquals(patients.pop().getPatient(),patient3);
    }

    @Test
    public void popTest3(){
        setUp3();
        Patient patienttt =new Patient("Sergio","Amaya", 16, "M", "3942", 3);
        patients.push(patienttt);
        assertEquals(patients.pop().getPatient(),patienttt);
    }

    @Test
    public void isEmptyTest1() {
        setUp1();
        assertEquals(patients.isEmpty(),true);
    }

    @Test
    public void isEmptyTest2() {
        setUp1();
        Patient patienttt =new Patient("Sergio","Amaya", 16, "M", "3942", 3);
        patients.push(patienttt);
        assertEquals(patients.isEmpty(),false);
    }

    @Test
    public void isEmptyTest3(){
        setUp2();
        assertEquals(patients.isEmpty(),false);
    }

    @Test
    public void searchTest1(){
        setUp1();
        assertEquals(patients.search(new Patient("Sergio","Amaya", 16, "M", "3942", 3)),false);
    }
    
    @Test
    public void searchTest2(){
        setUp1();
        Patient patienttt =new Patient("Sergio","Amaya", 16, "M", "3942", 3);
        patients.push(patienttt);
        assertEquals(patients.search(patienttt),true);
    }

    @Test
    public void searchTest3(){
        setUp2();
        assertEquals(patients.search(new Patient("Sergio","Amaya", 16, "M", "3942", 3)), false);
    }

}