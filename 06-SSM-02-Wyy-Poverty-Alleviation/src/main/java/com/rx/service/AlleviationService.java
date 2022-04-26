package com.rx.service;

import com.rx.entity.Alleviation;
import com.rx.vo.ResultVO;

import java.util.Date;
public interface AlleviationService {
    ResultVO click(Long id, Date lastClickTime);

    ResultVO getList(Integer pageNum, Integer pageSize, Long id);

    ResultVO add(Alleviation alleviation);

    ResultVO update(Alleviation alleviation);

    ResultVO delete(Long id);
}
