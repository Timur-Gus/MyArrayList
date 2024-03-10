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
        Integer actual = IntegerList.add(156);
        assertEquals(156, actual);
    }

    @Test
    void testAdd() {
        Integer actual = IntegerList.add(0, 156);
        assertEquals(156, actual);
    }
    @Test
    void addByIndex() {
        IntegerList.add(0, 156);
        assertEquals(156, IntegerList.get(0));
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
        IntegerList.add(156);
        IntegerList.add(156);
        IntegerList.add(156);
        ListIsFullException listIsFullException = assertThrows(ListIsFullException.class,
                () ->
                IntegerList.add(156)
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
        IntegerList.add(156);
        IntegerList.add(156);
        IntegerList.add(156);
        ListIsFullException listIsFullException = assertThrows(ListIsFullException.class,
                () -> {
                IntegerList.add(0,156);
        });
    }

    @Test
    void addByLargeIndex() {
        IndexIsTooLarge indexIsTooLarge = assertThrows(IndexIsTooLarge.class, () -> {
            IntegerList.add(5, 156);
        });
    }

    @Test
    void set() {
        assertEquals(156,IntegerList.set(0, 156));
    }

    @Test
    void remove() {
        IntegerList.add(156);
        IntegerList.add(7584);
        IntegerList.remove(0);
        assertEquals(7584, IntegerList.get(0));
    }

    @Test
    void testRemove() {
        IntegerList.add(156);
        IntegerList.add(7584);
        IntegerList.remove(156);
        assertEquals(7584, IntegerList.get(0));
    }

    @Test
    void contains() {
        IntegerList.add(156);
        assertTrue(IntegerList.contains(156));
    }
    @Test
    void containsFalse() {
        IntegerList.add(156);
        assertFalse(IntegerList.contains(7584));
    }

    @Test
    void indexOf() {
        IntegerList.add(156);
        IntegerList.add(7584);
        IntegerList.add(85944);
        assertEquals(1, IntegerList.indexOf(7584));
    }

    @Test
    void lastIndexOf() {
        IntegerList.add(156);
        IntegerList.add(7584);
        IntegerList.add(85944);
        assertEquals(1, IntegerList.indexOf(7584));
    }

    @Test
    void get() {
        IntegerList.add(156);
        assertEquals(156, IntegerList.get(0));
    }

    @Test
    void size() {
        IntegerList.add(156);
        IntegerList.add(156);
        IntegerList.add(156);
        assertEquals(3, IntegerList.size());
    }

    @Test
    void isEmpty() {
        assertTrue(IntegerList.isEmpty());
    }

    @Test
    void clear() {
        IntegerList.add(156);
        IntegerList.add(156);
        IntegerList.add(156);
        IntegerList.clear();
        assertTrue(IntegerList.isEmpty());

    }

}