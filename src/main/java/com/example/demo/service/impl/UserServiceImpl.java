package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.User;
import com.example.demo.entity.vo.UserVo;
import com.example.demo.mapper.UserMapper;
import com.example.demo.utils.JwtUtils;
import com.example.demo.utils.MD5;
import com.example.demo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author shanzhu
 * @since 2024-07-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public String login(UserVo userVo) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        if (userVo.getUsername() != null) {
            userQueryWrapper.eq("username",userVo.getUsername());
            User user = baseMapper.selectOne(userQueryWrapper);
            if (user == null){
                return null;
            } else {
                if (user.getPassword().equals(MD5.encrypt(userVo.getPassword()))) {
                    String token = JwtUtils.getJwtToken(user.getId(), user.getUsername());
                    return token;
                } else {
                    return null;
                }
            }
        } else {
            return null;
        }
    }
}
