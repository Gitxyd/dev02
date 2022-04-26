package com.rx.service;

import com.rx.entity.TbMusic;
import com.rx.entity.TbSheet;

import java.util.List;
import java.util.Map;

public interface TbSheetService {
    List<TbSheet> findAll();

    List<TbMusic> findSongsBySheet(String sheetName);

    Map<String, Object> insertSheet(TbSheet sheetName);
}
