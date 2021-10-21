package adapters;
import java.util.*;

public class MapToList<K, V> implements Map<K, V> {

    private final List<V> values;
    private final List<K> keys = new ArrayList<>();

    public MapToList(List<V> list) {
        this.values = list;
    }

    @Override
    public int size() {
        return values.size();
    }

    @Override
    public boolean isEmpty() {
        return values.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return keys.contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return values.contains(value);
    }

    @Override
    public V get(Object key) {
        int index = keys.indexOf(key);
        return values.get(index);
    }

    @Override
    public V put(K key, V value) {
        keys.add(key);

        int index = keys.indexOf(key);
        values.add(index, value);
        return value;
    }

    @Override
    public V remove(Object key){
        int index = keys.indexOf(key);
        if (index != -1) { // lista nao vazia
            keys.remove(key);
            return values.remove(index);
        }
        return null; // nao consegui criar exception
    }

    @Override
    public void clear() {
        keys.clear();
        values.clear();
    }

    @Override
    public Collection<V> values() {
        return values;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapToList<?, ?> mapToList = (MapToList<?, ?>) o;
        return Objects.equals(values, mapToList.values) &&
                Objects.equals(keys, mapToList.keys);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values, keys);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        throw new UnsupportedOperationException(); 
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException();
    }
}
