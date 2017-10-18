package challenges.datastructures.hashtables;

import static java.lang.Math.abs;

class HashTable {
    private LinkedHashList[] data;

    HashTable(int size) {
        this.data = new LinkedHashList[size];
    }

    private int indexify(String key) {
        return abs(key.hashCode() % data.length);
    }

    void put(String key, int value) {
        int index = indexify(key);
        if(data[index] == null) {
            data[index] = new LinkedHashList(key, value);
        } else {
            if(data[index].contains(key)) {
                data[index].put(key, value);
            } else {
                data[index].add(key, value);
            }
        }
    }

    int get(String key) {
        int index = indexify(key);
        if(data[index] == null || !contains(key)) throw new NullPointerException();
        return data[index].get(key);
    }

    boolean contains(String key) {
        int index = indexify(key);
        return data[index] != null && data[index].contains(key);
    }
}
