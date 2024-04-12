package org.klozevitz.lesson_08.model;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Header {
    public static void main(String[] args) {
        List<String> nameHead = Arrays.stream(Notepad.class.getDeclaredFields())
                .map(Field::getName)
                .collect(Collectors.toList());

        for (String name : nameHead) {
            System.out.println(name);
        }
    }
}
