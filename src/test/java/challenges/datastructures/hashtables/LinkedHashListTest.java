package challenges.datastructures.hashtables;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedHashListTest {
    @Test
    void add() {
        LinkedHashList lhl = new LinkedHashList();
        assertEquals(null, lhl.getKey());
        assertTrue(lhl.isEmpty());
        lhl.add("one", 1);
        assertEquals("one", lhl.getKey());
        assertFalse(lhl.isEmpty());
        assertEquals(1, lhl.size);
        lhl.add("two", 1);
        assertEquals("two", lhl.next.getKey());
        assertFalse(lhl.isEmpty());
        assertEquals(2, lhl.size);
    }

    @Test
    void put() {
        LinkedHashList lhl = new LinkedHashList();
        lhl.put("one", 1);
        assertFalse(lhl.contains("one"));
        lhl.add("one", 1);
        assertTrue(lhl.contains("one"));
        assertEquals(1, lhl.get());
        lhl.put("one", 2);
        assertEquals(2, lhl.get());
    }

    @Test
    void get() {
        LinkedHashList lhl = new LinkedHashList();
        assertThrows(NullPointerException.class, () -> lhl.get("one"));
        lhl.add("one", 1);
        lhl.add("two", 2);
        assertEquals(1, lhl.get("one"));
        assertEquals(2, lhl.get("two"));
    }

    @Test
    void contains() {
        LinkedHashList lhl = new LinkedHashList();
        assertFalse(lhl.contains("one"));
        lhl.add("one", 1);
        lhl.add("two", 2);
        assertTrue(lhl.contains("one"));
        assertTrue(lhl.contains("two"));
    }

}