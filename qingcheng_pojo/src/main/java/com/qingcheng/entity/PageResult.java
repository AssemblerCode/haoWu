package com.qingcheng.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
/**
 * 该类是将结果集进行分页并且返回给浏览器用的
 */
public class PageResult<T> implements Serializable {
    private long total;//总记录数
    private List<T> result;//用来存放查询结果集

    public PageResult(long total, List<T> result) {
        this.total = total;
        this.result = result;
    }

    public PageResult() {
    }
}
