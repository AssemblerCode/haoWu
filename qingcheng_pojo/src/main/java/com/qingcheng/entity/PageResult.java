package com.qingcheng.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页结果
 * @param <T>
 */
@Data
public class PageResult<T> implements Serializable {

    private Long total;//返回记录数
    private List<T> result;//结果

    public PageResult(Long total, List<T> result) {
        this.total = total;
        this.result = result;
    }

    public PageResult() {
    }


}
