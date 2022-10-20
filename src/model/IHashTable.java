package model;

public interface IHashTable<K> {

    public void insert(K key, Patient patient) throws Exception;
    public Patient search(K key);
    public void delete(K key);

}