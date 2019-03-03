package com.mfh.table.utils;

import com.mfh.table.Cell;
import com.mfh.table.Row;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: mfh
 * @Date: 2019-03-01 13:32
 **/
public class TransUtil {
    public static  <T> List<Row> list2Row(List<T> list) {
        List<Row> rows = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Row row = new Row(i + 1);
            List<String> fields = getFields(list.get(0).getClass());
            /**
             * cell个数
             */
            int cellCount = fields.size();
            for (int j = 0; j < cellCount; j++) {
//                row.addCell(new Cell(i + 1, j + 1, fields.get(j), ReflectionUtils.invokeGetMethod(list.get(i), fields.get(j))));
                row.addCell(new Cell(fields.get(j), ReflectionUtils.invokeGetMethod(list.get(i), fields.get(j))));
            }
            rows.add(row);
        }
        return rows;
    }

    public static List<Row> array2Row(String[][] array) {
        List<Row> rows = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            Row row = new Row(i + 1);
            for (int j = 0; j < array[i].length; j++) {
//                row.addCell(new Cell(i + 1, j + 1, array[i][j]));
                row.addCell(new Cell(array[i][j]));
            }
            rows.add(row);
        }
        return rows;
    }

    public static String[][] row2Col(String[][] array) {
        /**
         * 数据条数
         */
        int rowCount = array[0].length;
        /**
         * 属性数量
         */
        int colCount = array.length;
        String[][] arr = new String[rowCount][colCount];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = array[j][i];
            }
        }
        return arr;
    }

    public static <T> String[][] list2Array(List<T> statisticVos) {
        if (statisticVos != null && !statisticVos.isEmpty()) {
            List<String> fields = getFields(statisticVos.get(0).getClass());
            /**
             * 属性个数
             */
            int fieldSize = fields.size();
            /**
             * 数据条数
             */
            int dataCount = statisticVos.size();
            String[][] array = new String[dataCount][fieldSize];
            for (int i = 0; i < statisticVos.size(); i++) {
                T fo = statisticVos.get(i);
                for (int j = 0; j < fieldSize; j++) {
                    array[i][j] = String.valueOf(ReflectionUtils.invokeGetMethod(fo, fields.get(j)));
                }
            }
            return array;
        }
        return new String[0][];
    }

    public static <T> List<T> array2List(String[][] strArray, Class<T> clazz) {
        List<T> list = new ArrayList<>();
        List<String> fields = getFields(clazz);
        for (int i = 0; i < strArray.length; i++) {
            T value = null;
            try {
                value = clazz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            for (int j = 0; j < strArray[i].length; j++) {
                ReflectionUtils.invokeSetMethodWithStringTypeParams(value, fields.get(j), strArray[i][j]);
            }
            list.add(value);
        }
        return list;
    }
    private static List<String> getFields(Class clazz) {
        List<String> fields = new ArrayList<String>();
        addFieldsToListNotIncludeExcludeField(clazz, fields);
        addFieldsToListNotIncludeExcludeField(clazz.getSuperclass(), fields);
        return fields;
    }

    private static void addFieldsToListNotIncludeExcludeField(Class clazz, List<String> fields) {
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            fields.add(declaredField.getName());
        }
    }

    public static <T> Row buildRow(T t) {
        Row row = new Row();
        List<String> fields = getFields(t.getClass());
        for (int i = 0; i < fields.size(); i++) {
            Cell cell = new Cell(fields.get(i), ReflectionUtils.invokeGetMethod(t, fields.get(i)));
            row.addCell(cell);
        }
        return row;
    }
}
