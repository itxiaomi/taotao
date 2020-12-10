package com.itheima.bean;

import java.io.Serializable;
import java.util.List;

/*
 *  @创建时间:  2020/12/10 9:23
 *  @描述：    TODO
 */
public class TaoResult<T> implements Serializable {

    private long  total; // 总的记录数
    private List<T> rows; // 设置这一页的数据集合

    public TaoResult() {
    }

    public TaoResult(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "TaoResult{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
