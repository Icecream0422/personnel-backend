package com.example.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Contract;
import com.example.demo.entity.vo.ContractQueryVo;
import com.baomidou.mybatisplus.extension.service.IService;

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
