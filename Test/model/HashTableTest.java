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

    // TEST TO INSERT ELEMENT

    @Test
    public void insertElement1() {
        setUp1();

        Patient patient1 = new Patient("Clemente", "Mora", 18, "F", "1564783923",1);

        hashTable.insert(patient1.getId(), patient1);

        assertEquals(patient1, hashTable.search("1564783923"));
    }

    @Test
    public void insertElement2() {
        setUp1();

        Patient patient1 = new Patient("Guillem", "Varela", 54, "M", "4321543345",2);

        hashTable.insert(patient1.getId(), patient1);

        assertEquals(patient1, hashTable.search("4321543345"));
    }

    @Test
    public void insertElement3() {
        setUp1();

        Patient patient1 = new Patient("Dylan", "Gilabert", 41, "M", "5912387645",0);

        hashTable.insert(patient1.getId(), patient1);

        assertEquals(patient1, hashTable.search("5912387645"));
    }

    // TEST TO SEARCH ELEMENT

    @Test
    public void searchElement1() {
        setUp2();
        assertEquals("Patient{name='Gines'lastName='Gonzales', age='25', gender='F', id='1234432234'", hashTable.search("1234432234").toString());
    }

    @Test
    public void searchElement2() {
        setUp2();
        assertEquals("Patient{name='Saioa'lastName='Matos', age='32', gender='M', id='1987654321'", hashTable.search("1987654321").toString());
    }

    @Test
    public void searchElement3() {
        setUp2();
        assertEquals("Patient{name='Ester'lastName='Navas', age='76', gender='M', id='1912567490'", hashTable.search("1912567490").toString());
    }

    // TEST TO DELETE ELEMENT

    @Test
    public void deleteElement1() {
        setUp2();
        hashTable.delete("1234432234");
        assertEquals(null, hashTable.search("1234432234"));
    }

    @Test
    public void deleteElement2() {
        setUp2();
        hashTable.delete("1987654321");
        assertEquals(null, hashTable.search("1987654321"));
    }

    @Test
    public void deleteElement3() {
        setUp2();
        hashTable.delete("1912567490");
        assertEquals(null, hashTable.search("1912567490"));
    }

    // TEST TO HASHKEY

    @Test
    public void hashKey1() {
        setUp2();
        assertEquals(1, hashTable.hashKey("1234432234"));
    }

    @Test
    public void hashKey2() {
        setUp2();
        assertEquals(0, hashTable.hashKey("1987654321"));
    }

    @Test
    public void hashKey3() {
        setUp2();
        assertEquals(4, hashTable.hashKey("1912567490"));
    }
}