package com.shanzhu.staff.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shanzhu.staff.entity.Clerk;
import com.shanzhu.staff.entity.ClerkThrough;
import com.shanzhu.staff.entity.Department;
import com.shanzhu.staff.service.ClerkService;
import com.shanzhu.staff.service.ClerkThroughService;
import com.shanzhu.staff.service.DepartmentService;
import com.shanzhu.staff.utils.JwtUtils;
import com.shanzhu.staff.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 员工经历表 前端控制器
 * </p>
 *
 * @author shanzhu
 * @since 2024-07-20
 */
@RestController
@RequestMapping("/staff/clerk_through")
@CrossOrigin
public class ClerkThroughController {
    @Autowired
    private ClerkService clerkService;
    @Autowired
    private ClerkThroughService clerkThroughService;
    @Autowired
    private DepartmentService departmentService;
    //查询自身
    @PostMapping
    public R getClerkThrough(@RequestHeader("X-Token") String token) {
        String id = JwtUtils.getMemberIdByToken(token);
        QueryWrapper<Clerk> clerkQueryWrapper = new QueryWrapper<>();
        clerkQueryWrapper.eq("user_id",id);
        Clerk clerk = clerkService.getOne(clerkQueryWrapper);
        if (StringUtils.isEmpty(clerk)){
            return R.ok();
        }
        String clerkId = clerk.getId();
        QueryWrapper<ClerkThrough> clerkThroughQueryWrapper = new QueryWrapper<>();
        clerkThroughQueryWrapper.eq("clerk_id",clerkId);
        clerkThroughQueryWrapper.orderByDesc("gmt_create");
        List<ClerkThrough> throughList = clerkThroughService.list(clerkThroughQueryWrapper);
        for (ClerkThrough clerkThrough:throughList) {
            String departmentId = clerkThrough.getDepartmentId();
            Department department = departmentService.getById(departmentId);
            if (!StringUtils.isEmpty(department)){
                clerkThrough.setDepartmentId(department.getName());
            }
        }
        return R.ok().data("throughList",throughList);
    }
    //根据员工id查询员工个人经历
    @GetMapping("{id}")
    public R getClerkThroughByClerkId(@PathVariable String id){
        QueryWrapper<ClerkThrough> clerkThroughQueryWrapper = new QueryWrapper<>();
        clerkThroughQueryWrapper.eq("clerk_id",id);
        clerkThroughQueryWrapper.orderByDesc("gmt_create");
        List<ClerkThrough> throughList = clerkThroughService.list(clerkThroughQueryWrapper);
        if (!StringUtils.isEmpty(throughList)) {
            for (ClerkThrough clerkThrough : throughList) {
                String departmentId = clerkThrough.getDepartmentId();
                Department department = departmentService.getById(departmentId);
                clerkThrough.setDepartmentId(department.getName());
            }
        }
        return R.ok().data("throughList",throughList);
    }
}

