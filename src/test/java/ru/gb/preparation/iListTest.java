package ru.gb.preparation;

import org.junit.jupiter.api.Test;
import ru.gb.preparation.hw_1.ArrList;
import ru.gb.preparation.hw_1.LinList;
import ru.gb.preparation.hw_1.iList;

import static org.junit.jupiter.api.Assertions.*;

public class iListTest {

    @Test
    public void testArrList() {
        ArrList<String> list = new ArrList<>();
        testIList(list);
        assertEquals(160, list.getCapacity());
        exceptionTest(list);
    }


    @Test
    public void testLinList() {
        LinList<String> list = new LinList<>();
        testIList(list);

        exceptionTest(list);
    }

    private void exceptionTest(iList<String> list) {
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, null));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(list.size(), null));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(list.size()));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(list.size()));
    }

    private void testIList(iList<String> list) {
        // common adding
        list.add("cat");
        assertEquals("cat ", list.toString());

        // adding at index
        list.add(0, "dog");
        assertEquals("dog cat ", list.toString());

        // check indexOf()
        assertEquals(0, list.indexOf("dog"));

        // check contains()
        assertTrue(list.contains("dog"));
        assertFalse(list.contains("book"));

        // remove element
        list.remove("dog");
        assertEquals("cat ", list.toString());
        assertFalse(list.remove("dog"));

        // remove at index
        assertEquals("cat", list.remove(0));
        assertEquals("", list.toString());

        // add to increase capacity
        for (int i = 0; i < 100; i++) {
            list.add("fly");
        }
        assertEquals(100, list.size());
    }
}

