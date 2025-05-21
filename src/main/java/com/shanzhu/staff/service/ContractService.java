package com.shanzhu.staff.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanzhu.staff.entity.Contract;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shanzhu.staff.entity.vo.ContractQueryVo;

/**
 * <p>
 * 合同表 服务类
 * </p>
 *
 * @author shanzhu
 * @since 2024-07-20
 */
public interface ContractService extends IService<Contract> {

    IPage<Contract> pageListQuery(Page<Contract> clerkPage, ContractQueryVo contractQueryVo);
}
