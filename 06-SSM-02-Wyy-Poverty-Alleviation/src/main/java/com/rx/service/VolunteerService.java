package com.rx.service;

import com.rx.entity.VolunteerRecruitment;
import com.rx.vo.ResultVO;
import org.springframework.stereotype.Service;

import java.util.Date;
public interface VolunteerService {
    ResultVO click(Long id, Date lastClickTime);

    ResultVO getList(Integer pageNum, Integer pageSize, Long id);

    ResultVO add(VolunteerRecruitment volunteer);

    ResultVO update(VolunteerRecruitment volunteer);

    ResultVO delete(Long id);
}
