package com.rx.service;

import com.rx.vo.ResultVO;
import org.springframework.web.multipart.MultipartFile;

import java.awt.font.MultipleMaster;

public interface FileUploadService {
    ResultVO fileUpload(MultipartFile file, String type);
}
