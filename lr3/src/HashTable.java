import java.util.*;

public class HashTable<K, T> {
    private ArrayList<LinkedList<HashNode<K, T>>> nodes;
    private int size;
    private int capasity;

    public HashTable() {
        this.nodes = new ArrayList<>();
        this.capasity = 16;
        this.size = 0;
        for (int i = 0; i < capasity; i++) {
            nodes.add(new LinkedList<>());
        }
    }

    public int size() {
        return this.size;
    }

    public boolean is_empty() {
        return (this.size == 0);
    }

    private int hashCode(K key) {
        return Objects.hashCode(key);
    }

    private int getIndexBucket(K key) {
        int hashcode = hashCode(key);
        int index = hashcode % this.capasity;
        index = index < 0 ? index * -1 : index;
        return index;
    }

    private void changeCapacity() {
        if (size + 10 == capasity) {
            capasity += 10;
        }
    }

    public void put(K key, T value) {
        int index = getIndexBucket(key);
        LinkedList<HashNode<K, T>> node = nodes.get(index);
        if (node.size() == 1) {
            if (node.getFirst().key.equals(key)) {
                node.getFirst().value = value;
            } else {
                node.add(new HashNode<>(key, value));
                size++;
                changeCapacity();
            }
        } else {
            node.add(new HashNode<>(key, value));
            size++;
            changeCapacity();
        }
    }

    public T get(K key) {
        int index = getIndexBucket(key);
        LinkedList<HashNode<K, T>> node = nodes.get(index);
        for (HashNode<K, T> el : node) {
            if (el.key.equals(key)) {
                return el.value;
            }
        }
        return null;
    }

    public void remote(K key) {
        int index = getIndexBucket(key);
        if (nodes.get(index) != null) {
            nodes.set(index, null);
            size--;
        } else {
            return;
        }
    }

    // ArrayList<LinkedList<HashNode<K, T>>> nodes
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        for (LinkedList<HashNode<K, T>> list : nodes) {
            if (list != null) {
                for (HashNode<K, T> node : list) {
                    if (node != null) {
                        keys.add(node.key);
                    }
                }
            }
        }
        return keys;
    }
}
