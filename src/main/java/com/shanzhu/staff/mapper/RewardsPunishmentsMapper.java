package com.shanzhu.staff.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanzhu.staff.entity.RewardsPunishments;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shanzhu.staff.entity.vo.RPQueryVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 奖惩表 Mapper 接口
 * </p>
 *
 * @author shanzhu
 * @since 2024-07-20
 */
public interface RewardsPunishmentsMapper extends BaseMapper<RewardsPunishments> {

    IPage<RewardsPunishments> pageListQuery(Page<RewardsPunishments> clerkPage, @Param("rPQueryVo")RPQueryVo rpQueryVo);
}
