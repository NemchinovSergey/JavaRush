package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) return;
        int id = Integer.parseInt(args[0]);

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String fileName = console.readLine();

        BufferedReader file = new BufferedReader(new FileReader(fileName));

        String line;
        while ((line = file.readLine()) != null) {
            String[] items = line.split(" ");
            if (Integer.parseInt(items[0]) == id) {
                System.out.println(line);
                break;
            }
        }

        file.close();
        console.close();
    }
}
