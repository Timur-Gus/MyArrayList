package org.example;

import org.example.arrayInterface.IntegerList;
import org.example.myException.IndexIsTooLarge;
import org.example.myException.ListIsFullException;
import org.example.myException.NullItemException;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListImplTest {
    IntegerList IntegerList;

    @BeforeEach
    public void init() {
        this.IntegerList = new IntegerListImpl(3);
    }
    @Test
    void add() {
        Integer actual = IntegerList.add("Текст");
        assertEquals("Текст", actual);
    }

    @Test
    void testAdd() {
        Integer actual = IntegerList.add(0, "Текст");
        assertEquals("Текст", actual);
    }
    @Test
    void addByIndex() {
        IntegerList.add(0, "Текст");
        assertEquals("Текст", IntegerList.get(0));
    }
    @Test
    void addNull() {

        NullItemException nullItemException = assertThrows(NullItemException.class,
                () ->
                IntegerList.add(null)
                );
    }
    @Test
    void addInFullList() {
        IntegerList.add("Текст");
        IntegerList.add("Текст");
        IntegerList.add("Текст");
        ListIsFullException listIsFullException = assertThrows(ListIsFullException.class,
                () ->
                IntegerList.add("Текст")
                );
    }
    @Test
    void addNullByIndex() {
        NullItemException nullItemException = assertThrows(NullItemException.class,
                () ->
                IntegerList.add(0,null)
                );
    }
    @Test
    void addInFullListByIndex() {
        IntegerList.add("Текст");
        IntegerList.add("Текст");
        IntegerList.add("Текст");
        ListIsFullException listIsFullException = assertThrows(ListIsFullException.class,
                () -> {
                IntegerList.add(0,"Текст");
        });
    }

    @Test
    void addByLargeIndex() {
        IndexIsTooLarge indexIsTooLarge = assertThrows(IndexIsTooLarge.class, () -> {
            IntegerList.add(5, "Text");
        });
    }

    @Test
    void set() {
        assertEquals("Text",IntegerList.set(0, "Text"));
    }

    @Test
    void remove() {
        IntegerList.add("Текст");
        IntegerList.add("Текст2");
        IntegerList.remove(0);
        assertEquals("Текст2", IntegerList.get(0));
    }

    @Test
    void testRemove() {
        IntegerList.add("Текст");
        IntegerList.add("Текст2");
        IntegerList.remove("Текст");
        assertEquals("Текст2", IntegerList.get(0));
    }

    @Test
    void contains() {
        IntegerList.add("Текст");
        assertTrue(IntegerList.contains("Текст"));
    }
    @Test
    void containsFalse() {
        IntegerList.add("Текст");
        assertFalse(IntegerList.contains("Текст2"));
    }

    @Test
    void indexOf() {
        IntegerList.add("Text");
        IntegerList.add("Text2");
        IntegerList.add("Text3");
        assertEquals(1, IntegerList.indexOf("Text2"));
    }

    @Test
    void lastIndexOf() {
        IntegerList.add("Text");
        IntegerList.add("Text2");
        IntegerList.add("Text3");
        assertEquals(1, IntegerList.indexOf("Text2"));
    }

    @Test
    void get() {
        IntegerList.add("Text");
        assertEquals("Text", IntegerList.get(0));
    }

    @Test
    void size() {
        IntegerList.add("Text");
        IntegerList.add("Text");
        IntegerList.add("Text");
        assertEquals(3, IntegerList.size());
    }

    @Test
    void isEmpty() {
        assertTrue(IntegerList.isEmpty());
    }

    @Test
    void clear() {
        IntegerList.add("Text");
        IntegerList.add("Text");
        IntegerList.clear();
        assertTrue(IntegerList.isEmpty());

    }

}