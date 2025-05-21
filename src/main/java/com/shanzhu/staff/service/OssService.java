package com.shanzhu.staff.service;

import org.springframework.web.multipart.MultipartFile;


public interface OssService {
    String uploadFileAvatar(MultipartFile file);
}
