package com.mfh.table;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: mfh
 * @Date: 2019-02-25 10:37
 **/
public class Row {
    private int num;
    private List<Cell> cells = new ArrayList<>();

    public Row() {
    }

    public Row(int num) {
        this.num = num;
    }

    public Row(int num, List<Cell> cells) {
        this.num = num;
        this.cells = cells;
    }

    public void addCell(Cell cell) {
        this.setRowNumAndColNum(cell);
        this.cells.add(cell);
    }

    public void insertCell(int index, Cell cell) {
        checkIndex(index);
        System.out.println("第 " + index + " 列插入属性为【" + cell.getField() + "】 值为【" + cell.getValue() + "】的单元格");
        this.setColNum(index, cell);
        this.cells.add(index, cell);
        this.plusColNum(index);
    }

    public void removeCell(int index) {
        System.out.println("删除第 " + index + " 列单元格");
        checkIndex(index);
        this.cells.remove(index);
        minusColNum(index);
    }

    public void replaceCell(int index, Cell cell) {
        checkIndex(index);
        this.insertCell(index, cell);
        this.removeCell(index + 1);
    }

    private void plusColNum(int index) {
        for (int i = index + 1; i < this.cells.size(); i++) {
            Cell tmp = this.cells.get(i);
            int colNum = tmp.getColNum();
            if (colNum != -1) {
                tmp.setColNum(colNum + 1);
            }
        }
    }

    private void minusColNum(int index) {
        for (int i = index; i < this.cells.size(); i++) {
            Cell tmp = this.cells.get(i);
            int colNum = tmp.getColNum();
            if (colNum != -1) {
                tmp.setColNum(colNum - 1);
            }
        }
    }

    private void setRowNumAndColNum(Cell cell) {
        cell.setRowNum(this.num);
        cell.setColNum(this.cells.size());
    }

    private void setColNum(int colNum, Cell cell) {
        cell.setRowNum(this.num);
        cell.setColNum(colNum);
    }

    public void checkIndex(int index) {
        if (index > this.cells.size() || index < 0) {
            throw new IllegalArgumentException("当前集合长度：" + this.cells.size() + ", 被操作的索引值：" + index + "，被操作的索引值应大于零且小于等于当前集合长度");
        }
    }
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < this.cells.size(); i++) {
            sb.append("第 " + num + " 行，" + "第 " + i + " 个" + "单元格，行号：" + cells.get(i).getRowNum() +" 列号：" + cells.get(i).getColNum() + "，属性名：" + cells.get(i).getField() + "，值：" + cells.get(i).getValue() + "" +
                    "，跨行：" + cells.get(i).getRowSpan() +"，跨列：" + cells.get(i).getColSpan() + "\n");
        }
        return sb.toString();
    }

    public List<Cell> getCells() {
        return cells;
    }
}
