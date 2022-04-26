package com.rx.service;

import com.rx.entity.User;
import com.rx.vo.ResultVO;

public interface UserService {

    ResultVO getList(Integer pageNum, Integer pageSize, Long id);

    ResultVO add(User user);

    ResultVO update(User user);

    ResultVO delete(Long id);
}
