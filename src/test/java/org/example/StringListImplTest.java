package org.example;

import org.example.arrayStringInterface.StringList;
import org.example.myException.ElementNotFoundException;
import org.example.myException.IndexIsTooLarge;
import org.example.myException.ListIsFullException;
import org.example.myException.NullItemException;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {
    StringList stringList;

    @BeforeEach
    public void init() {
        this.stringList = new StringListImpl(3);
    }
    @Test
    void add() {
        String actual = stringList.add("Текст");
        assertEquals("Текст", actual);
    }

    @Test
    void testAdd() {
        String actual = stringList.add(0, "Текст");
        assertEquals("Текст", actual);
    }
    @Test
    void addByIndex() {
        stringList.add(0, "Текст");
        assertEquals("Текст", stringList.get(0));
    }
    @Test
    void addNull() {

        NullItemException nullItemException = assertThrows(NullItemException.class,
                () ->
                stringList.add(null)
                );
    }
    @Test
    void addInFullList() {
        stringList.add("Текст");
        stringList.add("Текст");
        stringList.add("Текст");
        ListIsFullException listIsFullException = assertThrows(ListIsFullException.class,
                () ->
                stringList.add("Текст")
                );
    }
    @Test
    void addNullByIndex() {
        NullItemException nullItemException = assertThrows(NullItemException.class,
                () ->
                stringList.add(0,null)
                );
    }
    @Test
    void addInFullListByIndex() {
        stringList.add("Текст");
        stringList.add("Текст");
        stringList.add("Текст");
        ListIsFullException listIsFullException = assertThrows(ListIsFullException.class,
                () -> {
                stringList.add(0,"Текст");
        });
    }

    @Test
    void addByLargeIndex() {
        IndexIsTooLarge indexIsTooLarge = assertThrows(IndexIsTooLarge.class, () -> {
            stringList.add(5, "Text");
        });
    }

    @Test
    void set() {
        assertEquals("Text",stringList.set(0, "Text"));
    }

    @Test
    void remove() {
        stringList.add("Текст");
        stringList.add("Текст2");
        stringList.remove(0);
        assertEquals("Текст2", stringList.get(0));
    }

    @Test
    void testRemove() {
        stringList.add("Текст");
        stringList.add("Текст2");
        stringList.remove("Текст");
        assertEquals("Текст2", stringList.get(0));
    }

    @Test
    void contains() {
        stringList.add("Текст");
        assertTrue(stringList.contains("Текст"));
    }
    @Test
    void containsFalse() {
        stringList.add("Текст");
        assertFalse(stringList.contains("Текст2"));
    }

    @Test
    void indexOf() {
        stringList.add("Text");
        stringList.add("Text2");
        stringList.add("Text3");
        assertEquals(1, stringList.indexOf("Text2"));
    }

    @Test
    void lastIndexOf() {
        stringList.add("Text");
        stringList.add("Text2");
        stringList.add("Text3");
        assertEquals(1, stringList.indexOf("Text2"));
    }

    @Test
    void get() {
        stringList.add("Text");
        assertEquals("Text", stringList.get(0));
    }

    @Test
    void size() {
        stringList.add("Text");
        stringList.add("Text");
        stringList.add("Text");
        assertEquals(3, stringList.size());
    }

    @Test
    void isEmpty() {
        assertTrue(stringList.isEmpty());
    }

    @Test
    void clear() {
        stringList.add("Text");
        stringList.add("Text");
        stringList.clear();
        assertTrue(stringList.isEmpty());

    }

}