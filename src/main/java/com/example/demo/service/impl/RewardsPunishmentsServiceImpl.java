package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.RewardsPunishments;
import com.example.demo.entity.vo.RPQueryVo;
import com.example.demo.mapper.RewardsPunishmentsMapper;
import com.example.demo.service.RewardsPunishmentsService;
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
