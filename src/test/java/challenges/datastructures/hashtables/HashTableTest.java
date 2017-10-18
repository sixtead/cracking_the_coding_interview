package challenges.datastructures.hashtables;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {
    @Test
    void constructor() {
        HashTable ht = new HashTable(10);
    }

    @Test
    void put() {
        HashTable ht = new HashTable(10);
        for(int i = 1; i <= 10; i++) {
            ht.put("item_" + i, i);
        }
        for(int i = 1; i <= 10; i++) {
            ht.contains("item_" + i);
        }
        for(int i = 1; i <= 10; i++) {
            ht.put("item_" + i + "_", i);
        }
        for(int i = 1; i <= 10; i++) {
            ht.contains("item_" + i + "_");
        }
    }

    @Test
    void get() {
        HashTable ht = new HashTable(10);
        for(int i = 1; i <= 10; i++) {
            ht.put("item_" + i, i);
        }
        for(int i = 1; i <= 10; i++) {
            assertEquals(i, ht.get("item_" + i));
        }
    }

    @Test
    void contains() {
        HashTable ht = new HashTable(10);
        for(int i = 1; i <= 10; i++) {
            ht.put("item_" + i, i);
        }
        for(int j = 1; j <= 10; j++) {
            assertTrue(ht.contains("item_" + j));
        }
        for(int k = 1; k <= 10; k++) {
            assertFalse(ht.contains("number_" + k));
        }
    }

}