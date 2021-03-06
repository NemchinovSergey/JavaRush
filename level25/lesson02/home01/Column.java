package com.javarush.test.level25.lesson02.home01;

import java.util.LinkedList;
import java.util.List;

public enum Column implements Columnable {
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");

    private String columnName;

    private static int[] realOrder;

    private Column(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[индекс в энуме] = порядок отображения; -1, если колонка не отображается.
     *
     * @param newOrder новая последовательность колонок, в которой они будут отображаться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */
    public static void configureColumns(Column... newOrder) {
        realOrder = new int[values().length];
        for (Column column : values()) {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++) {
                if (column == newOrder[i]) {
                    if (isFound) {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }

    /**
     * Вычисляет и возвращает список отображаемых колонок в сконфигурированом порядке (см. метод configureColumns)
     * Используется поле realOrder.
     *
     * @return список колонок
     */
    public static List<Column> getVisibleColumns()
    {
        List<Column> result = new LinkedList<>();

        for (Column column : Column.values()) {
            int number = column.ordinal();
            for (int i = 0; i < realOrder.length; i++)
            {
                if (number == realOrder[i]) {
                    result.add(Column.values()[i]);
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public String getColumnName()
    {
        return columnName;
    }

    @Override
    public boolean isShown()
    {
        return realOrder[ordinal()] != -1;
    }

    @Override
    public void hide()
    {
        int order = realOrder[ordinal()];
        if (order < 0) return;
        realOrder[ordinal()] = -1;
        for (int i = 0; i < realOrder.length; i++)
        {
            if (realOrder[i] > order) {
                realOrder[i] = realOrder[i]-1;
            }
        }
    }
}
