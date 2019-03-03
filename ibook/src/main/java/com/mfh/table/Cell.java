package com.mfh.table;

/**
 * @Author: mfh
 * @Date: 2019-02-25 10:30
 **/
public class Cell {
    private Object value;
    private String field;
    private int rowNum = -1;
    private int colNum = -1;
    private int rowSpan = 1;
    private int colSpan = 1;
    private boolean removed = false;

    public Cell() {
    }

    public Cell(Object value) {
        this.value = value;
    }

    public Cell(String field, Object value) {
        this.field = field;
        this.value = value;
    }

    public Cell(int rowNum, int colNum, Object value) {
        this.rowNum = rowNum;
        this.colNum = colNum;
        this.value = value;
    }

    public Cell(int rowNum, int colNum, String field, Object value) {
        this.rowNum = rowNum;
        this.colNum = colNum;
        this.field = field;
        this.value = value;
    }

    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public int getColNum() {
        return colNum;
    }

    public void setColNum(int colNum) {
        this.colNum = colNum;
    }

    public int getRowSpan() {
        return rowSpan;
    }

    public void setRowSpan(int rowSpan) {
        this.rowSpan = rowSpan;
    }

    public int getColSpan() {
        return colSpan;
    }

    public void setColSpan(int colSpan) {
        this.colSpan = colSpan;
    }

    @Override
    public String toString() {
        return "第 " + this.rowNum + " 行，第 " + this.colNum + " 个单元格，属性名：" + this.field + ", 值：" + this.value;
    }
}
