package org.example.zhipudemo.common.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 基础查询类
 *
 * @author zero
 * @date 2024/02/29
 */
@Getter
@Setter
@ToString
public class BaseQuery {
    /**
     * 页码
     */
    Long pageNumber = 1L;

    /**
     * 页大小
     */
    Long pageSize = 50L;

    /**
     * 查询词
     */
    String searchKey;
}