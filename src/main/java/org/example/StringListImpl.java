package org.example;

import org.example.arrayStringInterface.StringList;
import org.example.myException.IndexIsTooLarge;
import org.example.myException.ListIsFullException;
import org.example.myException.NullItemException;

import java.util.Arrays;

public class StringListImpl implements StringList {
    private final String[] listString;
    private int size;

    public StringListImpl() {
        listString = new String[10];
    }
    public StringListImpl(int size) {
        listString = new String[size];
    }


    @Override
    public String add(String item) {
        validateSize();
        validateItem(item);
        listString[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        validateSize();
        validateItem(item);
        validateIndex(index);
        if (index == size) {
            listString[size++] = item;
            return item;
        }
        System.arraycopy(listString, index, listString, index + 1, size - index);
        listString[size++] = item;
        size++;
        return item;

    }

    @Override
    public String set(int index, String item) {
        validateIndex(index);
        validateItem(item);
        listString[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        validateItem(item);
        int index = indexOf(item);

        return remove(index);
    }

    @Override
    public String remove(int index) {
        validateIndex(index);

        String item = listString[index];

        if (index != size) {
            System.arraycopy(listString, index + 1, listString, index, size - index);
        }

        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (listString[i].equals(item)) {
                return i;
            }
    }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (listString[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return listString[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(listString, size);
    }

    private void validateItem(String item) {
        if (item == null) {
            throw new NullItemException();
        }
    }

    private void validateSize() {
        if (size == listString.length) {
            throw new ListIsFullException();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexIsTooLarge();
        }
    }
}
