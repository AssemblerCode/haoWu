package com.qingcheng.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.StringUtil;
import com.qingcheng.dao.BrandMapper;
import com.qingcheng.entity.PageResult;
import com.qingcheng.pojo.goods.Brand;
import com.qingcheng.service.goods.BrandService;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    @Override
    public PageResult<Brand> findPage(int page, int size) {

        PageHelper.startPage(page, size);
//        Page<Brand> pageResult=(Page<Brand>)brandMapper.selectAll();
        Page<Brand> pageResult = (Page<Brand>) findAll();
        return new PageResult<Brand>(pageResult.getTotal(), pageResult.getResult());
    }

    @Override
    public List<Brand> findList(Map<String, String> searchMap) {
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();

        if (!searchMap.isEmpty() || searchMap != null) {
            if (searchMap.get("name") != null && !"".equalsIgnoreCase(searchMap.get("name"))) {
                criteria.andLike("name", "%" + searchMap.get("name") + "%");
            }
            if (searchMap.get("letter") != null && !"".equalsIgnoreCase(searchMap.get("letter"))) {
                criteria.andEqualTo("letter", searchMap.get("letter"));
            }
        }

        return brandMapper.selectByExample(example);
    }

    @Override
    public PageResult<Brand> findPage(int page, int size, Map<String, String> searchMap) {
        PageHelper.startPage(page, size);
        List<Brand> list = findList(searchMap);
        System.out.println("list=="+list.size());
        Page<Brand> pageResult=(Page<Brand>) list;
        return new PageResult<Brand>(pageResult.getTotal(),pageResult.getResult());

    }

    @Override
    public Brand findById(String id) {
        Brand brand = new Brand();
        if (!StringUtil.isNotEmpty(id)) {
            return null;
        }
        brand.setId(Integer.valueOf(id));
//        return brandMapper.selectByPrimaryKey(Integer.valueOf(id));
        return brandMapper.selectOne(brand);
    }

    @Override
    public void add(Brand brand) {
        brandMapper.insertSelective(brand);//带有selective的方法会忽略null
    }

    @Override
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);//带有selective的方法会忽略null
    }

    @Override
    public void del(String id) {
        brandMapper.deleteByPrimaryKey(Integer.valueOf(id));
    }

}
