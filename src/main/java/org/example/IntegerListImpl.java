package org.example;

import org.example.arrayInterface.IntegerList;
import org.example.myException.IndexIsTooLarge;
import org.example.myException.ListIsFullException;
import org.example.myException.NullItemException;

import java.util.Arrays;
import java.util.Objects;

public class IntegerListImpl implements IntegerList {
    private final Integer[] listInteger;
    private int size;

    public IntegerListImpl() {
        listInteger = new Integer[100000];
    }
    public IntegerListImpl(int size) {
        listInteger = new Integer[size];
    }


    @Override
    public Integer add(Integer item) {
        validateSize();
        validateItem(item);
        listInteger[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validateSize();
        validateItem(item);
        validateIndex(index);
        if (index == size) {
            listInteger[size++] = item;
            return item;
        }
        System.arraycopy(listInteger, index, listInteger, index + 1, size - index);
        listInteger[size++] = item;
        size++;
        return item;

    }

    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        listInteger[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validateItem(item);
        int index = indexOf(item);

        return remove(index);
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);

        Integer item = listInteger[index];

        if (index != size) {
            System.arraycopy(listInteger, index + 1, listInteger, index, size - index);
        }

        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        Integer[] listCopy = toArray();
        sortBubble(listCopy);
        return binarySearch(listCopy, item);
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (listInteger[i].equals(item)) {
                return i;
            }
    }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (listInteger[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return listInteger[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
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
    public Integer[] toArray() {
        return Arrays.copyOf(listInteger, size);
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new NullItemException();
        }
    }

    private void validateSize() {
        if (size == listInteger.length) {
            throw new ListIsFullException();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexIsTooLarge();
        }
    }

     public static void sortInsertion(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    private boolean binarySearch(Integer[] arr, Integer item) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;
            if (Objects.equals(item, arr[mid])) {
                return true;
            }
            if (item < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }

        }
        return false;
    }
    public static void sortBubble(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }
    public static void sortSelection(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }
    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }
}
