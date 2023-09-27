package com.dccf.gulimall.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dccf.gulimall.product.entity.CategoryEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author jinwh
 * @email comjinwh@gmail.com
 * @date 2023-09-27 18:11:27
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
