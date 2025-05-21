package com.example.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Attendance;
import com.example.demo.entity.vo.AttendanceQueryVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 考勤表 服务类
 * </p>
 *
 * @author shanzhu
 * @since 2024-07-20
 */
public interface AttendanceService extends IService<Attendance> {

    IPage<Attendance> pageListQuery(Page<Attendance> attendancePage, AttendanceQueryVo attendanceQueryVo);
}
