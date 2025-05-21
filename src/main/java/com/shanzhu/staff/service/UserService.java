package com.shanzhu.staff.service;

import com.shanzhu.staff.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shanzhu.staff.entity.vo.UserVo;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author shanzhu
 * @since 2024-07-20
 */
public interface UserService extends IService<User> {
    //如果验证成功 返回tokrn 否则返回null或者异常
    String login(UserVo userVo);
}
