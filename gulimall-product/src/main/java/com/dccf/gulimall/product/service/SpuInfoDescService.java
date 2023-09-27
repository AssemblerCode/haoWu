package com.dccf.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dccf.gulimall.common.utils.PageUtils;
import com.dccf.gulimall.product.entity.SpuInfoDescEntity;

import java.util.Map;

/**
 * spu信息介绍
 *
 * @author jinwh
 * @email comjinwh@gmail.com
 * @date 2023-09-27 18:11:26
 */
public interface SpuInfoDescService extends IService<SpuInfoDescEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

