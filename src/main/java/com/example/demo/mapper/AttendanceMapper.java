package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Attendance;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.vo.AttendanceQueryVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 考勤表 Mapper 接口
 * </p>
 *
 * @author shanzhu
 * @since 2024-07-20
 */
public interface AttendanceMapper extends BaseMapper<Attendance> {

    IPage<Attendance> pageListQuery(Page<Attendance> attendancePage,@Param("attendanceQueryVo") AttendanceQueryVo attendanceQueryVo);
}
