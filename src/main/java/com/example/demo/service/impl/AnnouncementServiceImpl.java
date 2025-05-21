package com.example.demo.service.impl;

import com.example.demo.entity.Announcement;
import com.example.demo.mapper.AnnouncementMapper;
import com.example.demo.service.AnnouncementService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 公告表 服务实现类
 * </p>
 *
 * @author shanzhu
 * @since 2024-07-20
 */
@Service
public class AnnouncementServiceImpl extends ServiceImpl<AnnouncementMapper, Announcement> implements AnnouncementService {

}
