package adapters;

import java.util.*;

public class ListToMap<E> implements List<E> {

    private final Map<Integer, E> map;
    private int key = 0;

    public ListToMap(Map<Integer, E> map) {
        this.map = map;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsValue(o);
    }

    @Override
    public boolean add(E e) {
        return map.put(key++, e) != null;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public E get(int index) {
        return map.get(index);
    }

    @Override
    public void add(int index, E element) {
        Map<Integer, E> otherMap = new HashMap<>();
        int i = 0;

        if (map.isEmpty() || index > key) {
            map.put(key++, element); // SE O INDEX FOR MAIOR QUE O ATRIBUTO key, ELE SÓ ADICIONA NORMAL (PUT()) no final do MAP
            return;
        }

        // exemplo key = 6 e index = 5
        for (Map.Entry<Integer, E> entry: map.entrySet()) {
            if (i > index) { // 0>5 // 1>5 // 2>5 // 3>5 // 4>5 // 5>5 // 6>5 
                otherMap.put(entry.getKey() + 2, entry.getValue()); // quando i>index, adiciona o valor tendo um incremento de 2 na Key
            } else if (i < index) { // 0<5 1<5 2<5 3<5 4<5  5<5
                otherMap.put(entry.getKey(), entry.getValue()); // adiciona os valores do (map) no otherMap padrão, normal, na ordem...
            } else {    // quando chega no 5 ele adiciona o elemento no index correspondendo
                        // adicionando na chave posterior (getkey+1) o valor anterior 
                otherMap.put(entry.getKey(), element);
                otherMap.put(entry.getKey() + 1, entry.getValue());
                key++;
            }
            i++;
        }

        for (Map.Entry<Integer, E> entry: otherMap.entrySet()) {
            map.put(entry.getKey(), entry.getValue()); // faz um "for" do other map para o map (global)
        }
    }

    @Override
    public E remove(int index) {
        return map.remove((Integer) map.keySet().toArray()[index]);
    }

    @Override
    public boolean remove(Object o) {
        return map.values().remove(o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListToMap<?> listToMap = (ListToMap<?>) o;
        return key == listToMap.key &&
                Objects.equals(map, listToMap.map);
    }

    @Override
    public Iterator<E> iterator() { // Values () retorna uma Collection, assim podendo utilizar iterator.
        return map.values().iterator();
    }

    @Override
    public Object[] toArray() {
        return map.values().toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return map.values().toArray(a);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }


}
