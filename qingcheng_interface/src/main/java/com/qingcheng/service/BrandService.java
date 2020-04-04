package com.qingcheng.service;

import com.qingcheng.entity.PageResult;
import com.qingcheng.pojo.Brand;

import java.util.List;
import java.util.Map;

public interface BrandService {
    /**
     * 查询全部商品
     * @return
     */
    List<Brand> findAll();

    /**
     * 用来做分页查询用的
     * @param page 表示当前页码
     * @param size 表示一页有多少条记录
     * @return
     */
    PageResult<Brand> findPage(int page,int size);

    /**
     * 该接口的作用就是根据品牌名称和品牌首字母查询品牌对象用的
     * @param searchMap key表示品牌名称，value表示首字母
     * @return
     */
    List<Brand> findList(Map<String,String> searchMap);

    /**
     * 该接口就是用来根据品牌名称和品牌首字母查询品牌对象用的。只不过加了分页条件而已
     * @param searchMap key表示品牌名称，value表示首字母
     * @return
     */
    PageResult<Brand> findPage(int page,int size,Map<String,String> searchMap);

    /**
     * 根据id去查询品牌
     * @param id 品牌id
     * @return
     */
    Brand findById(String id);

    /**
     * 新增一个品牌
     * @param brand
     */
    void add(Brand brand);

    /**
     * 修改一个品牌
     * @param brand
     */
    void update(Brand brand);

    /**
     * 删除一个品牌
     * @param id
     */
    void del(String id);
}
