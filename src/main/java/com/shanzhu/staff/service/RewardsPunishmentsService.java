package com.shanzhu.staff.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanzhu.staff.entity.RewardsPunishments;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shanzhu.staff.entity.vo.RPQueryVo;

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
