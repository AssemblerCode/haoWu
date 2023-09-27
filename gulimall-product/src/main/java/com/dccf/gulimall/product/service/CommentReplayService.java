package com.dccf.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dccf.gulimall.common.utils.PageUtils;
import com.dccf.gulimall.product.entity.CommentReplayEntity;

import java.util.Map;

/**
 * 商品评价回复关系
 *
 * @author jinwh
 * @email comjinwh@gmail.com
 * @date 2023-09-27 18:11:27
 */
public interface CommentReplayService extends IService<CommentReplayEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

