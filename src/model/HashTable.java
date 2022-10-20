package model;

public class HashTable<K> implements IHashTable<K> {

    private int sizeList;
    private NodeHash<K>[] listNodeHash;

    public HashTable(int sizeList) {
        this.sizeList = sizeList;
        listNodeHash = new NodeHash[sizeList];
    }

    public int hashKey(Object key) {
        return Math.abs(key.hashCode()) % sizeList;
    }

    @Override
    public void insert(K key, Patient patient) {
        int keyToInsert = hashKey(key);
        NodeHash<K> listNode = listNodeHash[keyToInsert];

        if(listNode == null) listNodeHash[keyToInsert] = new NodeHash<>(key, patient);
        else {
            while (listNode != null) {
                if(listNode.getKey().equals(key)) {
                    break;
                }
                listNode = listNode.getNext();
            }
            NodeHash<K> lastNode = new NodeHash<>(key,patient);
            listNodeHash[keyToInsert].setPrev(lastNode);
            listNodeHash[keyToInsert] = lastNode;
        }

    }

    @Override
    public void delete(K key) {
        int keyToDelete = hashKey(key);
        NodeHash<K> nodeToDelete = listNodeHash[keyToDelete];
        while (nodeToDelete != null) {
            if(nodeToDelete.getKey().equals(key)){
                NodeHash<K> prevNodeHash = nodeToDelete.getPrev();
                NodeHash<K> nextNodeHash = nodeToDelete.getNext();
                if(prevNodeHash != null && nextNodeHash != null) {
                    prevNodeHash.setNext(nextNodeHash);
                    nextNodeHash.setPrev(prevNodeHash);
                } else {
                    listNodeHash[keyToDelete] = null;
                    return;
                }
            }
            nodeToDelete = nodeToDelete.getNext();
        }
    }

    @Override
    public Patient search(K key) {
        Patient value= null;
        int keyToSearch = hashKey(key);
        NodeHash<K> nodeToSearch = listNodeHash[keyToSearch];
        while (nodeToSearch != null) {
            if(nodeToSearch.getKey().equals(key)){
                value = nodeToSearch.getPatient();
            }
            nodeToSearch = nodeToSearch.getNext();
        }
        return value;
    }

}
