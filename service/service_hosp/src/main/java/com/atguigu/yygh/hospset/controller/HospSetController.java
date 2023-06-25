package com.atguigu.yygh.hospset.controller;

import com.atguigu.yygh.commons.exchandler.exc.NullValueException;
import com.atguigu.yygh.hospset.service.HospSetService;
import com.atguigu.yygh.model.hosp.HospitalSet;


import com.atguigu.yygh.commons.result.R;
import com.atguigu.yygh.vo.hosp.HospitalSetQueryVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mysql.cj.util.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author Wldz
 * @version 1.0.0
 * @description TODO
 * @date 23-6-25 19:25
 */
@Api("医院设置接口")
@CrossOrigin
@RestController
@RequestMapping("/admin/hospSet")
public class HospSetController {
    @Autowired
    private HospSetService hospSetService;

    /**
     * @description: 根据id查询医院设置
     * @author: Wldz
     * @param: [id]
     * @return: com.atguigu.yygh.commons.result.R
     **/
    @ApiOperation("根据id查询医院设置接口")
    @GetMapping("get/{id}")
    public R findById(@ApiParam(name = "id",value = "医院设置对象ID",required = true) @PathVariable Long id){
        HospitalSet hospitalSet = hospSetService.getById(id);
        return R.suc().message("查询成功").data("item",hospitalSet);
    }

    /**
     * @description: 查询所有医院设置
     * @author: Wldz
     * @param: []
     * @return: com.atguigu.yygh.commons.result.R
     **/
    @ApiOperation("查询所有医院设置接口")
    @GetMapping("get")
    public R findAll(){
        List<HospitalSet> hospitalSets = hospSetService.list();
        return R.suc().message("查询成功").data("list",hospitalSets);
    }

    /**
     * @description: 医院设置分页查询
     * @author: Wldz
     * @param: [pageNum, pageSize, hospitalSetQueryVo]
     * @return: com.atguigu.yygh.commons.result.R
     **/
    @ApiOperation("医院设置分页查询接口")
    @GetMapping("page/{pageNum}/{pageSize}")
    public R findPage(@ApiParam(name = "pageNum",value = "分页参数(当前页码)",required = true) @PathVariable Integer pageNum,
                      @ApiParam(name = "pageSize",value = "分页参数(页尺寸)",required = true) @PathVariable Integer pageSize,
                      @ApiParam(name = "hospitalSetQueryVo",value = "查询条件",required = true) @RequestBody HospitalSetQueryVo hospitalSetQueryVo){
        //1.分页参数构建分页对象
        Page<HospitalSet> hospitalSetPage = new Page<>(pageNum,pageSize);

        //2.分页查询条件封装
        QueryWrapper<HospitalSet> hospitalSetQueryWrapper = new QueryWrapper<>();
        String hoscode = hospitalSetQueryVo.getHoscode();
        String hosname = hospitalSetQueryVo.getHosname();

        if(!StringUtils.isNullOrEmpty(hoscode)){
            hospitalSetQueryWrapper.eq("hoscode",hoscode);
        }
        if (!StringUtils.isNullOrEmpty(hosname)){
            hospitalSetQueryWrapper.like("hosname",hosname);
        }

        //3.分页及返回值封装
        Page<HospitalSet> page = hospSetService.page(hospitalSetPage, hospitalSetQueryWrapper);

        //total 总记录数,rows == records 当前页结果集
        long total = page.getTotal();
        List<HospitalSet> records = page.getRecords();

        return R.suc().message("分页查询成功").data("total",total).data("rows",records);
    }

    /**
     * @description: 根据id逻辑删除医院设置
     * @author: Wldz
     * @param: [id]
     * @return: com.atguigu.yygh.commons.result.R
     **/
    @ApiOperation("根据id(逻辑)删除医院设置接口")
    @DeleteMapping("delete/{id}")
    public R deleteById(@ApiParam(name = "id",value = "医院设置对象ID",required = true) @PathVariable Long id){
        boolean deleted = hospSetService.removeById(id);
        return deleted?R.suc().message("删除成功"):R.fail().message("删除失败");
    }
    /**
     * @description: 根据ids逻辑删除医院设置
     * @author: Wldz
     * @param: [idList]
     * @return: com.atguigu.yygh.commons.result.R
     **/
    @ApiOperation("根据ids(逻辑)删除医院设置接口")
    @DeleteMapping("batchDelete")
    public R bathcDelete(@ApiParam(name = "idList",value = "医院设置批量删除ID列表",required = true)@RequestBody List<Long> idList){
        boolean deleted = hospSetService.removeByIds(idList);
        return deleted?R.suc().message("批量删除成功"):R.fail().message("批量删除失败");
    }



    /**
     * @description: 新增医院设置
     * @author: Wldz
     * @param: [hospitalSet]
     * @return: com.atguigu.yygh.commons.result.R
     **/
    @ApiOperation("开通(新增)医院设置接口")
    @PostMapping("save")
    public R save(@ApiParam(name = "hospitalSet",value = "医院设置对象",required = true)@RequestBody HospitalSet hospitalSet){
        if(hospitalSet==null){
            throw new NullValueException(40001,"自定义异常:医院设置为空值");
        }
        //设置状态 1可用,0不可用(默认为0,开通表示可用需设为1)
        hospitalSet.setStatus(1);
        boolean saved = hospSetService.save(hospitalSet);
        return saved?R.suc().message("开通成功"):R.fail().message("开通失败");
    }

    /**
     * @description: 根据id修改医院设置,修改信息和ID封装至医院设置对象
     * @author: Wldz
     * @param: [id]
     * @return: com.atguigu.yygh.commons.result.R
     **/
    @ApiOperation("根据id修改医院设置接口")
    @PutMapping("update")
        public R updateById(@ApiParam(name = "hospitalSet",value = "医院设置对象",required = true)@RequestBody HospitalSet hospitalSet){
        boolean updated = hospSetService.updateById(hospitalSet);
        return updated?R.suc().message("修改成功"):R.fail().message("修改失败");
    }

    /**
     * @description: 根据id修改医院设置状态值
     * @author: Wldz
     * @param: [id, status]
     * @return: com.atguigu.yygh.commons.result.R
     **/
    @ApiOperation("根据id锁定/解锁(修改)医院设置接口")
    @PutMapping("lock/{id}/{status}")
    public R lockById(@ApiParam(name = "id",value = "医院设置对象ID",required = true)@PathVariable Long id,
                      @ApiParam(name = "status",value = "状态status",required = true)@PathVariable Integer status){
        if(status!=0&&status!=1){
            return R.exc_err().message("医院设置状态值不合法(0,1)");
        }
        Integer originStatus = hospSetService.getById(id).getStatus();
        if(originStatus.equals(status)){
            return R.fail().message("请勿重复操作");
        }
        HospitalSet hospitalSet = hospSetService.getById(id);
        if(hospitalSet==null){
            return R.fail().message("无效医院设置ID");
        }

        hospitalSet.setStatus(status);
        //hospitalSet.setUpdateTime(new Date());

        boolean updated = hospSetService.updateById(hospitalSet);

        return updated?R.suc().message("解锁/加锁成功"):R.fail().message("解锁/加锁失败");
    }

}

