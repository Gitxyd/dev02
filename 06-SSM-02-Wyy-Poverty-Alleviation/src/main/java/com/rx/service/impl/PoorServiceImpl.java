package com.rx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rx.dao.PoorMapper;
import com.rx.entity.PoorWithBLOBs;
import com.rx.service.PoorService;
import com.rx.vo.DataVO;
import com.rx.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PoorServiceImpl implements PoorService {
    @Autowired
    private PoorMapper poorMapper;

    @Override
    public ResultVO getList(Integer pageNum, Integer pageSize, Long id) {
        //返回给前端的结果
        ResultVO resultVO;

        //分页相关的参数
        DataVO<PoorWithBLOBs> dataVO;

        //结果中data对应的用户数组
        List<PoorWithBLOBs> poor;

        //说明传递了id，那就是findById
        if (id != null){
            poor = new ArrayList<>();

            //查询
            PoorWithBLOBs poorWithBLOBs = poorMapper.selectByPrimaryKey(id);


            if (poorWithBLOBs == null){
                dataVO = new DataVO<>(0L, poor, pageNum, pageSize);

                resultVO = new ResultVO(4000, "没有这个贫困户!", false, dataVO);
            }else {
                //如果是查询单个，那么点击量应该加1
                click(poorWithBLOBs.getId(),null);

                //更新点击的次数
                poorWithBLOBs.setClickNum(poorWithBLOBs.getClickNum() + 1);

                // 查到了用户扔到集合中
                poor.add(poorWithBLOBs);


                dataVO = new DataVO<>(1L, poor, pageNum, pageSize);

                resultVO = new ResultVO(200, "查到了该贫困户!", true, dataVO);
            }
        } else {
            //开启分页
            PageHelper.startPage(pageNum , pageSize);

            poor = poorMapper.selectByExampleWithBLOBs(null);

            //如果数据库是空的，一个人都没查到
            if (poor.size() == 0){
                dataVO = new DataVO<>(0L, poor, pageNum, pageSize);

                resultVO = new ResultVO(4100, "没有贫困户了！!", false, dataVO);
                //查到了
            }else{
                //封装pageInfo，为了获取总数据量
                PageInfo<PoorWithBLOBs> pageInfo = new PageInfo<>(poor);

                dataVO = new DataVO<>(pageInfo.getTotal(),poor,pageNum,pageSize);

                resultVO = new ResultVO(1100, "贫困户信息查询成功!", true, dataVO);
            }
        }
        return resultVO;
    }

    @Override
    public ResultVO add(PoorWithBLOBs poor) {
        ResultVO vo;

        //判断是否存在创建时间，没有就自己加上
        if (poor.getCreateTime() == null){
            poor.setCreateTime(new Date());
        }
        int affectedRows = poorMapper.insert(poor);
        if (affectedRows > 0){
            vo = new ResultVO(1000,"添加贫困者成功!!!",true,poor);
        }else{
            vo = new ResultVO(5000,"添加贫困者失败!!!",false,null);
        }

        return vo;
    }

    @Override
    public ResultVO update(PoorWithBLOBs poor) {
        ResultVO vo;

        int affectedRows = poorMapper.updateByPrimaryKeySelective(poor);

        if (affectedRows > 0){
            //修改完成之后，在重新查询一次，保证返回给前端的是最新最全的数据
            poor = poorMapper.selectByPrimaryKey(poor.getId());
            vo = new ResultVO(1000,"修改贫困户信息成功!!!",true,poor);
        }else{
            vo = new ResultVO(5000,"修改贫困户信息失败!!!",false,null);
        }

        return vo;
    }

    @Override
    public ResultVO delete(Long id) {
        ResultVO vo;

        int affectedRows = poorMapper.deleteByPrimaryKey(id);

        if (affectedRows > 0){
            vo = new ResultVO(1000,"删除用户成功!!!",true,null);
        }else{
            vo = new ResultVO(5000,"删除用户失败!!!",false,null);
        }

        return vo;
    }

    @Override
    public ResultVO click(Long id, Date lastClickTime) {
        if (lastClickTime == null){
            lastClickTime = new Date();
        }

        Integer affectedRows = poorMapper.click(id , lastClickTime);

        ResultVO vo;

        if (affectedRows > 0){
            vo = new ResultVO(1000,"点击量加1成功!!!",true,null);
        }else{
            vo = new ResultVO(5000,"点击量加1失败!!!",false,null);
        }

        return vo;
    }
}
