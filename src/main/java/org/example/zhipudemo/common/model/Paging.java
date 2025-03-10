package org.example.zhipudemo.common.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;
import java.util.Collections;

/**
 * 分页
 *
 * @author ZERO
 * @date 2024/2/29
 */
@Getter
@ToString
public class Paging<T> {

    /**
     * 页码
     */
    private final Long pageNumber;

    /**
     * 页大小
     */
    private final Long pageSize;

    /**
     * 记录总数
     */
    private final Long total;

    /**
     * 记录数
     */
    private final Collection<T> records;


    public Paging(BaseQuery query, Long total, Collection<T> records) {
        this.pageSize = query.getPageSize();
        this.pageNumber = query.getPageNumber();
        this.total = total;
        this.records = records;
    }

    public Paging(BaseQuery query) {
        this.pageSize = query.getPageSize();
        this.pageNumber = query.getPageNumber();
        this.total = 0L;
        this.records = Collections.emptyList();
    }
}