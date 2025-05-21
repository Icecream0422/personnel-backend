package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Attendance;
import com.example.demo.entity.vo.AttendanceQueryVo;
import com.example.demo.mapper.AttendanceMapper;
import com.example.demo.service.AttendanceService;
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
