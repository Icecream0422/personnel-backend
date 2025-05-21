package com.shanzhu.staff.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanzhu.staff.entity.Attendance;
import com.shanzhu.staff.entity.vo.AttendanceQueryVo;
import com.shanzhu.staff.mapper.AttendanceMapper;
import com.shanzhu.staff.service.AttendanceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 考勤表 服务实现类
 * </p>
 *
 * @author shanzhu
 * @since 2024-07-20
 */
@Service
public class AttendanceServiceImpl extends ServiceImpl<AttendanceMapper, Attendance> implements AttendanceService {

    @Override
    public IPage<Attendance> pageListQuery(Page<Attendance> attendancePage, AttendanceQueryVo attendanceQueryVo) {
        IPage<Attendance> attendanceIPage = baseMapper.pageListQuery(attendancePage,attendanceQueryVo);
        return attendanceIPage;
    }
}
