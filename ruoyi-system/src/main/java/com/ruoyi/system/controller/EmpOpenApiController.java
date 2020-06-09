package com.ruoyi.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.EmpLaunched;
import com.ruoyi.system.domain.EmpQuerypackage;
import com.ruoyi.system.domain.EmpSubscribe;
import com.ruoyi.system.domain.EmpUnsubscribe;
import com.ruoyi.system.service.IEmpLaunchedService;
import com.ruoyi.system.service.IEmpQuerypackageService;
import com.ruoyi.system.service.IEmpSubscribeService;
import com.ruoyi.system.service.IEmpUnsubscribeService;
import com.ruoyi.system.service.impl.AiMusicOpenApiService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;


@Api("晟泰科接口emp api")
@RestController
@RequestMapping("/aimusic/services")
public class EmpOpenApiController extends BaseController {

    private AiMusicOpenApiService aiMusicOpenApiService = new AiMusicOpenApiService();

    @Autowired
    private IEmpLaunchedService empLaunchedService;

    @Autowired
    private IEmpSubscribeService iEmpSubscribeService;

    @Autowired
    private IEmpUnsubscribeService iEmpUnsubscribeService;

    @Autowired
    private IEmpQuerypackageService iEmpQuerypackageService;

    @ApiOperation("emp 发起订购")
    @PostMapping("/emplaunched")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mdn", value = "手机号", required = true, paramType = "String"),
            @ApiImplicitParam(name = "package_id", value = "套餐id", required = true, paramType = "String")
    })
    public AjaxResult empLaunched(String mdn,String package_id) {

        JSONObject jo = new JSONObject();
        EmpLaunched empLaunched = new EmpLaunched();
        empLaunched.setMdn(mdn);
        empLaunched.setPackageId(package_id);
        empLaunched.setLauCreateTime(dateFormat(new Date()));

        try{
           jo = aiMusicOpenApiService.emplanunched(mdn,package_id);
        }catch (Exception e){
            e.printStackTrace();
            return AjaxResult.error("接口无响应");
        }

        JSONObject ja = jo.getJSONObject("EmpPackageResp");
        if (ja == null ){
            ja = new JSONObject();
            ja.put("res_code","-1");
            ja.put("res_message","无返回结果");
            empLaunched.setResCode(ja.getString("res_code"));
            empLaunched.setResMessage(ja.getString("res_message"));
            empLaunchedService.insertEmpLaunched(empLaunched);
            return AjaxResult.error("操作失败",ja);
        }

        empLaunched.setResCode(ja.getString("res_code"));
        empLaunched.setResMessage(ja.getString("res_message"));
        empLaunched.setFeeType(ja.getString("fee_type"));
        empLaunchedService.insertEmpLaunched(empLaunched);

        return AjaxResult.success(ja);
    }


    @ApiOperation("emp 订购")
    @PostMapping("/empsubscribe")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mdn", value = "手机号", required = true, paramType = "String"),
            @ApiImplicitParam(name = "package_id", value = "套餐id", required = true, paramType = "String"),
            @ApiImplicitParam(name = "random_key", value = "订购验证码", required = true, paramType = "String")
    })
    public AjaxResult empSubscribe(String mdn,String package_id,String random_key) {

        JSONObject jo = new JSONObject();
        EmpSubscribe empSubscribe = new EmpSubscribe();
        empSubscribe.setMdn(mdn);
        empSubscribe.setPackageId(package_id);
        empSubscribe.setRandomKey(random_key);
        empSubscribe.setSubCreateTime(dateFormat(new Date()));

        try{
            jo = aiMusicOpenApiService.subscribeByEmp(mdn,package_id,random_key);
        }catch (Exception e){
            e.printStackTrace();
            return AjaxResult.error("接口无响应");
        }

        JSONObject ja = ja=jo.getJSONObject("BasicJTResponse");
        if (ja == null ){
            ja = new JSONObject();
            ja.put("res_code","-1");
            ja.put("res_message","无返回结果");
            empSubscribe.setResCode(ja.getString("res_code"));
            empSubscribe.setResMessage(ja.getString("res_message"));
            iEmpSubscribeService.insertEmpSubscribe(empSubscribe);
            return AjaxResult.error("操作失败",ja);
        }

        empSubscribe.setResCode(ja.getString("res_code"));
        empSubscribe.setResMessage(ja.getString("res_message"));
        iEmpSubscribeService.insertEmpSubscribe(empSubscribe);

        return AjaxResult.success(ja);
    }

    @ApiOperation("emp 退订")
    @PostMapping("/empunsubscribe")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mdn", value = "手机号", required = true, paramType = "String"),
            @ApiImplicitParam(name = "package_id", value = "套餐id", required = true, paramType = "String")
    })
    public AjaxResult empUnsubscribe(String mdn,String package_id) {

        JSONObject jo = new JSONObject();
        EmpUnsubscribe empUnsubscribe = new EmpUnsubscribe();
        empUnsubscribe.setMdn(mdn);
        empUnsubscribe.setPackageId(package_id);
        empUnsubscribe.setUnsubCreateTime(dateFormat(new Date()));

        try{
            jo = aiMusicOpenApiService.unsubscribeByEmp(mdn,package_id);
        }catch (Exception e){
            e.printStackTrace();
            return AjaxResult.error("接口无响应");
        }

        JSONObject ja=jo.getJSONObject("BasicJTResponse");
        if (ja == null ){
            ja = new JSONObject();
            ja.put("res_code","-1");
            ja.put("res_message","无返回结果");
            empUnsubscribe.setResCode(ja.getString("res_code"));
            empUnsubscribe.setResMessage(ja.getString("res_message"));
            iEmpUnsubscribeService.insertEmpUnsubscribe(empUnsubscribe);
            return AjaxResult.error("操作失败",ja);
        }

        empUnsubscribe.setResCode(ja.getString("res_code"));
        empUnsubscribe.setResMessage(ja.getString("res_message"));
        iEmpUnsubscribeService.insertEmpUnsubscribe(empUnsubscribe);
        return AjaxResult.success(ja);
    }

    @ApiOperation("emp 订购关系查询")
    @GetMapping("/empquerypackage")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mdn", value = "手机号", required = true, paramType = "String"),
            @ApiImplicitParam(name = "package_id", value = "套餐id", required = true, paramType = "String"),
            @ApiImplicitParam(name = "is_count_down_num", value = "当月下载次数0=不 1=获", required = true, paramType = "String")
    })
    public AjaxResult empQuerypackage(String mdn,String package_id,String is_count_down_num) {

        JSONObject jo = new JSONObject();
        EmpQuerypackage empQuerypackage = new EmpQuerypackage();
        empQuerypackage.setMdn(mdn);
        empQuerypackage.setPackageId(package_id);
        empQuerypackage.setIsCountDownNum(is_count_down_num);
        empQuerypackage.setQueCreateTime(dateFormat(new Date()));

        try{
            jo = aiMusicOpenApiService.queryPackageList(mdn,package_id,is_count_down_num);
        }catch (Exception e){
            e.printStackTrace();
            return AjaxResult.error("接口无响应");
        }

        JSONObject ja=jo.getJSONObject("UserPackageListResp");

        if (ja == null ){
            ja = new JSONObject();
            ja.put("res_code","-1");
            ja.put("res_message","无返回结果");
            empQuerypackage.setResCode(ja.getString("res_code"));
            empQuerypackage.setResMessage(ja.getString("res_message"));
            empQuerypackage.setStatus("0");
            iEmpQuerypackageService.insertEmpQuerypackage(empQuerypackage);
            return AjaxResult.error("操作失败",ja);
        }

        empQuerypackage.setResCode(ja.getString("res_code"));
        empQuerypackage.setResMessage(ja.getString("res_message"));
        empQuerypackage.setResMdn(ja.getString("mdn"));

        JSONObject jb=ja.getJSONObject("user_package_list");
        if (jb == null ){
            empQuerypackage.setStatus("0");
            empQuerypackage.setUserPackageList(ja.toJSONString());
            iEmpQuerypackageService.insertEmpQuerypackage(empQuerypackage);
            return AjaxResult.error("操作失败,user_package_list为空",ja);
        }

        JSONObject jc=jb.getJSONObject("user_package");
        if (jc == null ){
            empQuerypackage.setStatus("0");
            empQuerypackage.setUserPackageList(ja.toJSONString());
            iEmpQuerypackageService.insertEmpQuerypackage(empQuerypackage);
            return AjaxResult.error("操作失败,user_package为空",ja);
        }

        empQuerypackage.setStatus(jc.getString("status"));
        empQuerypackage.setCountDownNum(jc.getString("count_down_num"));
        empQuerypackage.setPackageId(jc.getString("package_id"));
        empQuerypackage.setOrderTime(stringFormatDate(jc.getString("order_time")));
        empQuerypackage.setUnsubscribeTime(stringFormatDate(jc.getString("unsubscribe_time")));
        empQuerypackage.setValidTime(stringFormatDate(jc.getString("valid_time")));
        empQuerypackage.setUserPackageList(jb.toJSONString());

        iEmpQuerypackageService.insertEmpQuerypackage(empQuerypackage);
        return AjaxResult.success(ja);
    }

    public Date dateFormat(Date newDate){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTimeString = formatter.format(newDate);

        try{
            Date resDate = formatter.parse(dateTimeString);
            return resDate;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public Date stringFormatDate(String dateStr){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try{
            Date resDate = formatter.parse(dateStr);
            return resDate;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
