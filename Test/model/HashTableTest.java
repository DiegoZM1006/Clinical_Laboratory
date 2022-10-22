package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    private HashTable<String> hashTable;

    private void setUp1() {
        hashTable = new HashTable<String>(10);
    }

    private void setUp2() {
        hashTable = new HashTable<String>(5);
        hashTable.insert("1234432234", new Patient("Gines", "Gonzales", 25, "F", "1234432234",0));
        hashTable.insert("1987654321", new Patient("Saioa", "Matos", 32, "M", "1987654321",1));
        hashTable.insert("1912567490", new Patient("Ester", "Navas", 76, "M", "1912567490",2));
    }

    @Test
    public void insertElement() {
        setUp1();

        Patient patient1 = new Patient("Gines", "Gonzales", 25, "F", "1234432234",0);

        hashTable.insert(patient1.getId(), patient1);

        assertEquals(patient1, hashTable.search("1234432234"));
        assertEquals(null, hashTable.search("9823567834"));
    }

    @Test
    public void searchElement() {
        setUp1();

        Patient patientGines = new Patient("Gines", "Gonzales", 25, "F", "1234432234",0);
        Patient patientSaiao = new Patient("Saioa", "Matos", 32, "M", "1987654321",1);
        Patient patientEster = new Patient("Ester", "Navas", 76, "M", "1912567490",2);

        hashTable.insert(patientGines.getId(), patientGines);
        hashTable.insert(patientSaiao.getId(), patientSaiao);
        hashTable.insert(patientEster.getId(), patientEster);

        assertEquals(patientGines, hashTable.search("1234432234"));
        assertEquals(patientSaiao, hashTable.search("1987654321"));
        assertEquals(patientEster, hashTable.search("1912567490"));
    }

    @Test
    public void deleteElement() {
        setUp2();
        hashTable.delete("1987654321");
        assertEquals(null, hashTable.search("1987654321"));
    }

}