package com.rx.controller;

import com.rx.entity.Carousel;
import com.rx.service.CarouselService;
import com.rx.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("carousel")
public class CarouselController {
    @Autowired
    private CarouselService carouselService;
    @GetMapping("getlist")
    public ResultVO getlist(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize",defaultValue = "3") Integer pageSize,
                            Integer id){
        return carouselService.getList(pageNum,pageSize,id);
    }

    @PostMapping("add")
    public ResultVO add(@RequestBody Carousel carousel) {
        return carouselService.add(carousel);
    }

    @PostMapping("update")
    public ResultVO update(@RequestBody Carousel carousel){
        return carouselService.update(carousel);
    }

    @GetMapping("delete")
    public ResultVO delete(@RequestParam Integer id) {
        return carouselService.delete(id);
    }

    @PostMapping("state")
    public  ResultVO changeStatus(@RequestParam Integer id){
    return carouselService.changeStatus(id);
    }
}
