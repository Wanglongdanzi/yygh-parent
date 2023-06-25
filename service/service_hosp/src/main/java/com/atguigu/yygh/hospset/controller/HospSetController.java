package com.atguigu.yygh.hosp.controller;

import com.atguigu.yygh.hosp.service.HospSetService;
import com.atguigu.yygh.model.hosp.HospitalSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * @author Wldz
 * @version 1.0.0
 * @description TODO
 * @date 23-6-25 19:25
 */
@RestController
@RequestMapping("/admin/hospSet")
public class HospSetController {
    @Autowired
    private HospSetService hospSetService;

    @GetMapping({"id"})
    public HospitalSet findById(Serializable id){
        HospitalSet hospitalSet = hospSetService.getById(id);
        return hospitalSet;
    }

}

