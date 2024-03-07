package org.example;


import org.example.arrayStringInterface.StringList;

public class Main {
    public static void main(String[] args) {
        StringList stringList = new StringListImpl();
        stringList.add("SDfs");
        stringList.add("SDfs");
        stringList.add("SDfs");
        stringList.add("SDfs");

        System.out.println(stringList.set(2, "sdad"));

    }
}