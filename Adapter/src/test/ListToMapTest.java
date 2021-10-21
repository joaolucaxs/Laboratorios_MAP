package test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import adapters.ListToMap;

import java.util.List;
import java.util.HashMap;
import java.util.Iterator;


public class ListToMapTest {
    private static List<String> list;

    @Test
    public void testListAdd() {
        list = new ListToMap<>(new HashMap<>());
        list.add("João");
        assertEquals(1, list.size());
    }

    @Test
    public void testListGet() {
        list = new ListToMap<>(new HashMap<>());
        list.add("Maria");
        assertEquals("Maria", list.get(0));
    }

    @Test
    public void testListSize() {
        list = new ListToMap<>(new HashMap<>());
        list.add("Barbara");
        assertEquals(1, list.size());
    }

    @Test
    public void testListRemove() {
        list = new ListToMap<>(new HashMap<>());
        list.add("Barbara");
        list.remove("Barbara");
        assertEquals(0, list.size());
    }

    @Test
    public void testListContains() {
        list = new ListToMap<>(new HashMap<>());
        list.add("Maria");
        assertTrue(list.contains("Maria"));
    }

    @Test
    public void testListClear() {
        list = new ListToMap<>(new HashMap<>());
        list.add("Barbara");
        list.add("Maria");
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testListIsEmpty() {
        list = new ListToMap<>(new HashMap<>());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testListEquals() {
        List<String> list1 = new ListToMap<>(new HashMap<>());
        list1.add("Gabriel");
        list1.add("Maria");

        
        List<String> list2 = new ListToMap<>(new HashMap<>());
        list2.add("Gabriel");
        list2.add("Maria");

        assertTrue(list1.equals(list2));
    }

    @Test
    public void testListToArray() {
        List<String> list1 = new ListToMap<>(new HashMap<>());
        list1.add("Gabriel");
        list1.add("Maria");

        
        List<String> list2 = new ListToMap<>(new HashMap<>());
        list2.add("Gabriel");
        list2.add("Maria");

        assertArrayEquals(list1.toArray(), list2.toArray());
    }

    @Test
    public void testListIterator() {
        List<String> list1 = new ListToMap<>(new HashMap<>());
        list1.add("Gabriel");
        list1.add("Maria");

        List<String> list2 = new ListToMap<>(new HashMap<>());

        Iterator<String> itr = list1.iterator();
        while(itr.hasNext()) {
            list2.add(itr.next());
        }

        assertArrayEquals(list1.toArray(), list2.toArray());
    }

}
