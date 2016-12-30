package com.javarush.test.level06.lesson08.task03;

/* Класс Util
Реализовать статический метод double getDistance(x1, y1, x2, y2). Он должен вычислять расстояние между точками.
Используй метод double Math.sqrt(double a), который вычисляет квадратный корень переданного параметра
*/

public class Util
{
    public static double getDistance(int x1, int y1, int x2, int y2)
    {
        int a = Math.abs(x1 - x2);
        int b = Math.abs(y1 - y2);
        double c = Math.sqrt(a*a + b*b);
        return c;
    }

    public static void main(String[] args)
    {
        System.out.println(getDistance(3, 1, 6, 3));
    }
}