package test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import adapters.MapToList;

import java.util.ArrayList;
import java.util.Map;


public class MapToListTest {

    private static Map<String, String> map;

    @Test
    public void testMapPut() {
        map = new MapToList<>(new ArrayList<>());
        map.put("1", "João");
        map.put("2", "Josenelle");
        assertEquals(2, map.size());
    }

    @Test
    public void testMapSize() {
     map = new MapToList<>(new ArrayList<>());
        map.put("2", "Josenelle");
        assertEquals(1, map.size());
    }

    @Test
    public void testMapGet() {
        map = new MapToList<>(new ArrayList<>());
        map.put("1", "João");
        map.put("2", "Josenelle");
        assertEquals("Josenelle", map.get("2"));
    }

    @Test
    public void testMapIsEmpty() {
        map = new MapToList<>(new ArrayList<>());
        assertTrue(map.isEmpty());
    }

    @Test
    public void testMapRemove() {
        map = new MapToList<>(new ArrayList<>());
        map.put("1", "João");
        map.put("2", "Josenelle");
        map.remove("1");
        assertEquals(1, map.size());
    }

    @Test
    public void testMapClear() {
         map = new MapToList<>(new ArrayList<>());
        map.put("1", "João");
        map.put("2", "Josenelle");
        map.clear();
        assertEquals(0, map.size());
    }

    @Test
    public void testMapContainsKey() {
         map = new MapToList<>(new ArrayList<>());
         map.put("1", "João");
         map.put("2", "Josenelle");
         assertTrue(map.containsKey("2"));
    }

    @Test
    public void testMapContainsValue() {
        map = new MapToList<>(new ArrayList<>());
        map.put("1", "João");
         map.put("2", "Josenelle");
        assertTrue(map.containsValue("Josenelle"));
    }

    @Test
    public void testMapValues() {
        Map<String, String> map1 = new MapToList<>(new ArrayList<>());
        map1.put("1", "João");
        map1.put("2", "Josenelle");

        Map<String, String> map2 = new MapToList<>(new ArrayList<>());
        map2.put("1", "João");
        map2.put("2", "Josenelle");
        assertArrayEquals(map1.values().toArray(), map2.values().toArray());
    }

    @Test
    public void testMapEquals() {
        Map<String, String> map1 = new MapToList<>(new ArrayList<>());
        map1.put("1", "João");
        map1.put("2", "Josenelle");

        Map<String, String> map2 = new MapToList<>(new ArrayList<>());
        map2.put("1", "João");
        map2.put("2", "Josenelle");
        assertTrue(map1.equals(map2));
    }
}
