package com.rx.service;

import com.rx.entity.Carousel;
import com.rx.vo.ResultVO;

public interface CarouselService {
    ResultVO getList(Integer pageNum, Integer pageSize, Integer id);

    ResultVO add(Carousel carousel);

    ResultVO update(Carousel carousel);

    ResultVO delete(Integer id);

    ResultVO changeStatus(Integer id);
}
