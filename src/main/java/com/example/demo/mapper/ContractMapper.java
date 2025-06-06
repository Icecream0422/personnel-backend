package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Contract;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.vo.ContractQueryVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 合同表 Mapper 接口
 * </p>
 *
 * @author shanzhu
 * @since 2024-07-20
 */
public interface ContractMapper extends BaseMapper<Contract> {

    IPage<Contract> pageListQuery(Page<Contract> clerkPage,@Param("contractQueryVo")ContractQueryVo contractQueryVo);
}
