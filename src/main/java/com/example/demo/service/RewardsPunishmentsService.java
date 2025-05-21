package com.example.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.RewardsPunishments;
import com.example.demo.entity.vo.RPQueryVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 奖惩表 服务类
 * </p>
 *
 * @author shanzhu
 * @since 2024-07-20
 */
public interface RewardsPunishmentsService extends IService<RewardsPunishments> {

    IPage<RewardsPunishments> pageListQuery(Page<RewardsPunishments> clerkPage, RPQueryVo rpQueryVo);
}
