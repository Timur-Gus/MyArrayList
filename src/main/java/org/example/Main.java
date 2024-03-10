package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Integer[] integerList = new Integer[100000];
        Random random = new Random();
        for (int i = 0; i < integerList.length; i++) {
            integerList[i]= random.nextInt(1,100000);
        }
        Integer[] arrayCopy1 = integerList;
        Integer[] arrayCopy2 = integerList;

        long start = System.currentTimeMillis();
        IntegerListImpl.sortInsertion(integerList);
        System.out.println(System.currentTimeMillis() - start);

        long start2 = System.currentTimeMillis();
        IntegerListImpl.sortSelection(integerList);
        System.out.println(System.currentTimeMillis() - start2);

        long start3 = System.currentTimeMillis();
        IntegerListImpl.sortBubble(integerList);
        System.out.println(System.currentTimeMillis() - start3);
    }
}