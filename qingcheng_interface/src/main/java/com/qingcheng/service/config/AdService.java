package com.qingcheng.service.config;

import com.qingcheng.entity.PageResult;
import com.qingcheng.pojo.config.Ad;

import java.util.List;
import java.util.Map;

/**
 * ad业务逻辑层
 */
public interface AdService {


    public List<Ad> findAll();


    public PageResult<Ad> findPage(int page, int size);


    public List<Ad> findList(Map<String, Object> searchMap);


    public PageResult<Ad> findPage(Map<String, Object> searchMap, int page, int size);


    public Ad findById(Integer id);

    public void add(Ad ad);


    public void update(Ad ad);


    public void delete(Integer id);

}
