package com.javarush.test.level18.lesson03.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String fileName = console.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        int maxByte = 0;
        while (fileInputStream.available() > 0) {
            int readedByte = fileInputStream.read();
            if (readedByte > maxByte) {
                maxByte = readedByte;
            }
        }
        System.out.println(maxByte);
        fileInputStream.close();
    }
}
