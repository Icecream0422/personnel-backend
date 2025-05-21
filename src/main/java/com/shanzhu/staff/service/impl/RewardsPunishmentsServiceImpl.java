package com.shanzhu.staff.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanzhu.staff.entity.RewardsPunishments;
import com.shanzhu.staff.entity.vo.RPQueryVo;
import com.shanzhu.staff.mapper.RewardsPunishmentsMapper;
import com.shanzhu.staff.service.RewardsPunishmentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 奖惩表 服务实现类
 * </p>
 *
 * @author shanzhu
 * @since 2024-07-20
 */
@Service
public class RewardsPunishmentsServiceImpl extends ServiceImpl<RewardsPunishmentsMapper, RewardsPunishments> implements RewardsPunishmentsService {

    @Override
    public IPage<RewardsPunishments> pageListQuery(Page<RewardsPunishments> clerkPage, RPQueryVo rpQueryVo) {
        IPage<RewardsPunishments> rewardsPunishmentsIPage = baseMapper.pageListQuery(clerkPage,rpQueryVo);
        return rewardsPunishmentsIPage;
    }
}
