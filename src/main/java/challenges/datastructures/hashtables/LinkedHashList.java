package challenges.datastructures.hashtables;

import java.util.Objects;

class LinkedHashList {
    private String key;
    private int value;
    LinkedHashList next;
    int size;

    LinkedHashList() {}

    LinkedHashList(String key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.size = 1;
    }

    boolean isEmpty() {
        return size == 0;
    }

    String getKey() {
        return key;
    }

    int get() {
        return value;
    }

    int get(String key) throws NullPointerException {
        if(!contains(key)) throw new NullPointerException();
        if(Objects.equals(this.key, key)) return value;
        return next.get(key);
    }

    void add(String key, int value) {
        if(isEmpty()) {
            this.key = key;
            this.value = value;
            this.size = 1;
        } else {
            while(next != null) {
                next = next.next;
            }
            size++;
            next = new LinkedHashList(key, value);
        }
    }

    void put(String key, int value) {
        if(Objects.equals(this.key, key)) {
            this.value = value;
        } else if(next != null){
            next.put(key, value);
        }
    }

    boolean contains(String key) {
        if(Objects.equals(this.key, key)) {
            return true;
        } else if(next != null) {
            return next.contains(key);
        }
        return false;
    }
}
