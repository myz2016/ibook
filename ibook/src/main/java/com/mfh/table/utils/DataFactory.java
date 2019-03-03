package com.mfh.table.utils;

import com.mfh.table.Cell;
import com.mfh.table.Row;
import com.mfh.table.Table;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * @Author: mfh
 * @Date: 2019-03-01 13:55
 **/
public class DataFactory {
    public Table buildTable() {
        Table table = new Table(buildRows());
        return table;
    }

    private List<Row> buildRows() {
        List<Row> rows = new ArrayList<>();
        return rows;
    }

    public static List<Row> rows() {
        List<Row> rows = new ArrayList<>();
        Random random = new Random();
        List<String> departmentNames = departmentNames();
        List<String> otherNames = otherNames();
        int rownums = 0;
        for (int k = 0; k < departmentNames.size(); k++) {

            for (int i = 0; i < otherNames.size(); i++) {
                Row row = new Row(rownums);
                row.addCell(buildDepartmentCell(departmentNames.get(k)));
//                row.addCell(new Cell(otherNames.get(i)));
                row.addCell(buildOtherNameCell(otherNames.get(i)));
                for (int j = 0; j < 6; j++) {
                    row.addCell(new Cell(random.nextInt(1000)));
                }
                rows.add(row);
                rownums++;
            }

        }
        return rows;
    }

    /**
     *
     * @param rows
     */
    public static void shuffle(List<Row> rows) {
        for (int i = 0; i < rows.size(); i++) {
            Row row = rows.get(i);
            List<Cell> cells = row.getCells();
            for (int j = 0; j < cells.size(); j++) {
                Cell cell = cells.get(j);
                int rowSpan = cell.getRowSpan();
                if (rowSpan > 1 && !cell.isRemoved()) {
                    doRemove(i, j, rowSpan, rows);
                }
            }
        }
    }

    private static void doRemove(int rowNum, int cellNum, int rowSpan, List<Row> rows) {
        List<Row> processedRow = rows.subList(rowNum + 1, rowSpan + rowNum);
        for (int i = 0; i < processedRow.size(); i++) {
            List<Cell> cells = processedRow.get(i).getCells();
            cells.get(cellNum).setRemoved(true);
        }
    }

    @Test
    public void fun() {
        List<Row> rows = rows();
        shuffle(rows);
        System.out.println(rows);
        processRemove(rows);
        System.out.println(rows);
    }

    public static void processRemove(List<Row> rows) {
        for (Row row : rows) {
            List<Cell> cells = row.getCells();
            Iterator<Cell> iterator = cells.iterator();
            while (iterator.hasNext()) {
                Cell next = iterator.next();
                if (next.isRemoved()) {
                    iterator.remove();
                }
            }
        }
    }


    public static Cell buildDepartmentCell(String value) {
        Cell cell = new Cell(value);
        if ("职能部室".equals(value)) {
            cell.setRowSpan(2);
        } else {

            cell.setRowSpan(1);
        }
        return cell;
    }

    public static Cell buildOtherNameCell(String value) {
        Cell cell = new Cell(value);
        cell.setRowSpan(2);
        return cell;
    }

    private static List<String> departmentNames() {
        List<String> list = new ArrayList<>();
        list.add("职能部室");
        list.add("小微金融事业部");
        return list;
    }

    private static List<String> otherNames() {
        List<String> list = new ArrayList<>();
        list.add("用印数量");
        list.add("当月占比");
//        list.add("合同打印份数");
//        list.add("合同总份数");
        return list;
    }

    public static List<Row> billRow() {
        Row one = new Row();
        qq(one);
        pp(one);

        Row two = new Row();
        qq(two);
        Cell threeCell = new Cell(324);
        Cell fourCell = new Cell(131);
        fourCell.setRowSpan(2);
        Cell fiveCell = new Cell(235);
        Cell sixCell = new Cell(1516);
        Cell sevenCell = new Cell(7564);
        sevenCell.setRowSpan(2);
        two.addCell(threeCell);
        two.addCell(fourCell);
        two.addCell(fiveCell);
        two.addCell(sixCell);
        two.addCell(sevenCell);




        Row three = new Row();
        qq(three);
        Cell a = new Cell(324);
        Cell b = new Cell(131);
        b.setRowSpan(2);
        Cell v = new Cell(235);
        Cell g = new Cell(1516);
        g.setRowSpan(2);
        Cell r = new Cell(7564);
        r.setRowSpan(2);
        three.addCell(a);
        three.addCell(b);
        three.addCell(v);
        three.addCell(g);
        three.addCell(r);

        Row four = new Row();
        qq(four);
        Cell cell = new Cell(123);
        Cell cell1 = new Cell(123);
        Cell cell2 = new Cell(123);
        Cell cell3 = new Cell(123);
        cell3.setRowSpan(2);
        Cell cell4 = new Cell(123);

        four.addCell(cell);
        four.addCell(cell1);
        four.addCell(cell2);
        four.addCell(cell3);
        four.addCell(cell4);


        List<Row> rows = new ArrayList<>();
        rows.add(one);
        rows.add(two);
        rows.add(three);
        rows.add(four);
        return rows;
    }
    private static void qq(Row one) {
        Cell oneCell = new Cell("职能部室");
        oneCell.setRowSpan(2);
        Cell twoCell = new Cell("用印数量");
        twoCell.setRowSpan(2);
        one.addCell(oneCell);
        one.addCell(twoCell);
    }

    private static void pp(Row row) {
        for (int i = 0; i < 5; i++) {
            row.addCell(new Cell(i));
        }
    }
}
