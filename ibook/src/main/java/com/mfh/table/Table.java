package com.mfh.table;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: mfh
 * @Date: 2019-02-25 10:43
 **/
public class Table {
    private List<Row> rows = new ArrayList<>();

    public Table() {
    }

    public Table(List<Row> rows) {
        this.rows = rows;
    }

    public void addRows(Row row) {
        this.rows.add(row);
    }

    public List<Row> getRows() {
        return rows;
    }

    /**
     * 合并单元格
     */
    private void mergerCell() {
        int size = this.rows.size();
        for (int i = 0; i < size; i++) {
            Row row = this.rows.get(i);
            List<Cell> cells = row.getCells();
            for (int j = 0; j < cells.size(); j++) {
                Cell cell = cells.get(j);
                int rowSpan = cell.getRowSpan();
                if (rowSpan > 1 && !cell.isRemoved()) {
                    mark(i, j, rowSpan, rows);
                }
            }
        }
        this.removeMarkedCell();
    }

    /**
     * 标记即将被删除的cell
     * @param rowNum 行号
     * @param cellNum 列号
     * @param rowSpan 跨行书
     * @param rows
     */
    private void mark(int rowNum, int cellNum, int rowSpan, List<Row> rows) {
        List<Row> subRow = rows.subList(rowNum + 1, rowSpan + rowNum);
        for (int i = 0; i < subRow.size(); i++) {
            List<Cell> cells = subRow.get(i).getCells();
            cells.get(cellNum).setRemoved(true);
        }
    }

    /**
     * 删除被标记的cell
     */
    private void removeMarkedCell() {
        for (Row row : this.rows) {
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
}
