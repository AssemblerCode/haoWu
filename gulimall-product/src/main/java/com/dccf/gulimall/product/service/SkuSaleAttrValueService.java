package com.dccf.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dccf.gulimall.common.utils.PageUtils;
import com.dccf.gulimall.product.entity.SkuSaleAttrValueEntity;

import java.util.Map;

/**
 * sku销售属性&值
 *
 * @author jinwh
 * @email comjinwh@gmail.com
 * @date 2023-09-27 18:11:27
 */
public interface SkuSaleAttrValueService extends IService<SkuSaleAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

