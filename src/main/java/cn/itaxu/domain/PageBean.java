package cn.itaxu.domain;

import java.util.List;

/**
 * @Description: cn.itaxu.domain
 * @author: Axu
 * @date:2022/11/14 15:55
 */
public class PageBean<T> {
    // 当前页数据
    private List<T> rows;
    // 总记录
    private int totalCount;

    public PageBean() {
    }

    public PageBean(List<T> rows, int totalCount) {
        this.rows = rows;
        this.totalCount = totalCount;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "rows=" + rows +
                ", totalCount=" + totalCount +
                '}';
    }
}
