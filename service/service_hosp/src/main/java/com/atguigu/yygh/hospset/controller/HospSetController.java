package com.atguigu.yygh.hospset.controller;

import com.atguigu.yygh.hospset.service.HospSetService;
import com.atguigu.yygh.model.hosp.HospitalSet;


import com.atguigu.yygh.commons.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * @author Wldz
 * @version 1.0.0
 * @description TODO
 * @date 23-6-25 19:25
 */
@CrossOrigin
@RestController
@RequestMapping("/admin/hospSet")
public class HospSetController {
    @Autowired
    private HospSetService hospSetService;

    @GetMapping("{id}")
    public HospitalSet findById(@PathVariable Serializable id){
        HospitalSet hospitalSet = hospSetService.getById(id);
        return hospitalSet;
    }

    @GetMapping
    public List<HospitalSet> findAll(){
        List<HospitalSet> hospitalSets = hospSetService.list();
        return hospitalSets;
    }

    @DeleteMapping("{id}")
    public R deleteById(@PathVariable Serializable id){
        boolean isDeleted = hospSetService.removeById(id);
        HashMap<String, Object> map = new HashMap<>();
        map.put("info:id",id);
        map.put("info:method","delete");
        return isDeleted?R.ok().message("删除成功").data(map):R.err().message("删除失败").data(map);
    }

}

