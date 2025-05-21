package com.shanzhu.staff.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanzhu.staff.entity.Attendance;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shanzhu.staff.entity.vo.AttendanceQueryVo;

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
