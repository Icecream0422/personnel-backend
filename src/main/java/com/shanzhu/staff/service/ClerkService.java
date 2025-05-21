package com.shanzhu.staff.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanzhu.staff.entity.Clerk;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shanzhu.staff.entity.vo.ClerkQueryVo;

/**
 * <p>
 * 职员表 服务类
 * </p>
 *
 * @author shanzhu
 * @since 2024-07-20
 */
public interface ClerkService extends IService<Clerk> {
    //员工分页查询
    IPage<Clerk> pageListQuery(Page<Clerk> clerkPage, ClerkQueryVo clerkQueryVo);

    boolean addClerk(Clerk clerk);

    boolean updateClerk(Clerk clerk);

    boolean deleteClerkById(String id);
}
