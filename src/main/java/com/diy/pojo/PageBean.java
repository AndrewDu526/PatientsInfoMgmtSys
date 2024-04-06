package com.diy.pojo;

import java.util.List;

/**
 * it is a class for create ob deposit data that pagination need
 */
public class PageBean<T> {
    // you can use long instead of int
    private int totalCount;

    private List<T> rowsInPage;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getRowsInPage() {
        return rowsInPage;
    }

    public void setRowsInPage(List<T> rowsInPage) {
        this.rowsInPage = rowsInPage;
    }
}
