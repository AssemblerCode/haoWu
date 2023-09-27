package com.dccf.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dccf.gulimall.common.utils.PageUtils;
import com.dccf.gulimall.product.entity.AttrEntity;

import java.util.Map;

/**
 * 商品属性
 *
 * @author jinwh
 * @email comjinwh@gmail.com
 * @date 2023-09-27 18:11:27
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

