package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Clerk;
import com.example.demo.entity.ClerkThrough;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.entity.vo.ClerkQueryVo;
import com.example.demo.mapper.ClerkMapper;
import com.example.demo.utils.MD5;
import com.example.demo.service.ClerkService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.service.ClerkThroughService;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 职员表 服务实现类
 * </p>
 *
 * @author shanzhu
 * @since 2024-07-20
 */
@Service
public class ClerkServiceImpl extends ServiceImpl<ClerkMapper, Clerk> implements ClerkService {
    @Autowired
    private ClerkThroughService clerkThroughService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    //员工分页查询
    @Override
    public IPage<Clerk> pageListQuery(Page<Clerk> clerkPage, ClerkQueryVo clerkQueryVo) {
        IPage<Clerk> clerkIPage = baseMapper.pageListQuery(clerkPage,clerkQueryVo);
        return clerkIPage;
    }
    //入职
    @Override
    @Transactional
    public boolean addClerk(Clerk clerk) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username",clerk.getPhoneNumber());
        int count = userService.count(userQueryWrapper);
        if (count != 0) {
            return false;
        }
        //用户表添加
        User user = new User();
        user.setUsername(clerk.getPhoneNumber());
        String password = "123456";
        String encrypt = MD5.encrypt(password);
        user.setPassword(encrypt);
        user.setName(clerk.getName());
        user.setAvatar(clerk.getPhoto());
        userService.save(user);
        //职工表添加
        clerk.setUserId(user.getId());
        baseMapper.insert(clerk);
        //权限表添加
        Role role = new Role();
        role.setUserid(user.getId());
        role.setName("职员");
        roleService.save(role);
        //履历表添加
        ClerkThrough clerkThrough = new ClerkThrough();
        clerkThrough.setClerkId(clerk.getId());
        clerkThrough.setDepartmentId(clerk.getDepartmentId());
        clerkThrough.setPosition(clerk.getPosition());
        clerkThroughService.save(clerkThrough);
        return true;
    }
    //修改
    @Override
    @Transactional
    public boolean updateClerk(Clerk clerk) {

        String clerkId = clerk.getId();
        Clerk oldClerk = baseMapper.selectById(clerkId);
        baseMapper.updateById(clerk);
        if (clerk.getPosition().equals(oldClerk.getPosition()) && clerk.getDepartmentId().equals(oldClerk.getDepartmentId())) {
            return true;
        }
        ClerkThrough clerkThrough = new ClerkThrough();
        clerkThrough.setClerkId(clerkId);
        clerkThrough.setDepartmentId(clerk.getDepartmentId());
        clerkThrough.setPosition(clerk.getPosition());
        clerkThroughService.save(clerkThrough);
        return true;
    }
    //离职
    @Override
    @Transactional
    public boolean deleteClerkById(String id) {
        Clerk clerk = baseMapper.selectById(id);
        String userId = clerk.getUserId();
        QueryWrapper<Role> roleQueryWrapper = new QueryWrapper<>();
        roleQueryWrapper.eq("userid",userId);
        roleService.remove(roleQueryWrapper);
        userService.removeById(userId);
        baseMapper.deleteById(id);
        return true;
    }
}
