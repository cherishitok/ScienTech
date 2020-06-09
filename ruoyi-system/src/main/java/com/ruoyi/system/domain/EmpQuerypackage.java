package com.ruoyi.system.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 订购关系查询对象 emp_querypackage
 * 
 * @author ruoyi
 * @date 2020-06-01
 */
public class EmpQuerypackage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 查询id */
    private Long queId;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String mdn;

    /** 套餐id */
    @Excel(name = "套餐id")
    private String packageId;

    /** 是否获取下载数 */
    @Excel(name = "是否获取下载数")
    private String isCountDownNum;

    /** 查询时间 */
    @Excel(name = "查询时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date queCreateTime;

    /** 结果代码 */
    @Excel(name = "结果代码")
    private String resCode;

    /** 结果描述 */
    @Excel(name = "结果描述")
    private String resMessage;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String resMdn;

    /** 套餐id */
    @Excel(name = "套餐id")
    private String resPackageId;

    /** 套餐状态 */
    @Excel(name = "套餐状态")
    private String status;

    /** 剩余次数 */
    @Excel(name = "剩余次数")
    private String countDownNum;

    /** 订购时间 */
    @Excel(name = "订购时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orderTime;

    /** 套餐有效期 */
    @Excel(name = "套餐有效期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date validTime;

    /** 退订时间 */
    @Excel(name = "退订时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date unsubscribeTime;

    /** 套餐列表 */
    @Excel(name = "套餐列表")
    private String userPackageList;

    public void setQueId(Long queId) 
    {
        this.queId = queId;
    }

    public Long getQueId() 
    {
        return queId;
    }
    public void setMdn(String mdn) 
    {
        this.mdn = mdn;
    }

    public String getMdn() 
    {
        return mdn;
    }
    public void setPackageId(String packageId) 
    {
        this.packageId = packageId;
    }

    public String getPackageId() 
    {
        return packageId;
    }
    public void setIsCountDownNum(String isCountDownNum) 
    {
        this.isCountDownNum = isCountDownNum;
    }

    public String getIsCountDownNum() 
    {
        return isCountDownNum;
    }
    public void setQueCreateTime(Date queCreateTime) 
    {
        this.queCreateTime = queCreateTime;
    }

    public Date getQueCreateTime() 
    {
        return queCreateTime;
    }
    public void setResCode(String resCode) 
    {
        this.resCode = resCode;
    }

    public String getResCode() 
    {
        return resCode;
    }
    public void setResMessage(String resMessage) 
    {
        this.resMessage = resMessage;
    }

    public String getResMessage() 
    {
        return resMessage;
    }
    public void setResMdn(String resMdn) 
    {
        this.resMdn = resMdn;
    }

    public String getResMdn() 
    {
        return resMdn;
    }
    public void setResPackageId(String resPackageId) 
    {
        this.resPackageId = resPackageId;
    }

    public String getResPackageId() 
    {
        return resPackageId;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setCountDownNum(String countDownNum) 
    {
        this.countDownNum = countDownNum;
    }

    public String getCountDownNum() 
    {
        return countDownNum;
    }
    public void setOrderTime(Date orderTime) 
    {
        this.orderTime = orderTime;
    }

    public Date getOrderTime() 
    {
        return orderTime;
    }
    public void setValidTime(Date validTime) 
    {
        this.validTime = validTime;
    }

    public Date getValidTime() 
    {
        return validTime;
    }
    public void setUnsubscribeTime(Date unsubscribeTime) 
    {
        this.unsubscribeTime = unsubscribeTime;
    }

    public Date getUnsubscribeTime() 
    {
        return unsubscribeTime;
    }
    public void setUserPackageList(String userPackageList) 
    {
        this.userPackageList = userPackageList;
    }

    public String getUserPackageList() 
    {
        return userPackageList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("queId", getQueId())
            .append("mdn", getMdn())
            .append("packageId", getPackageId())
            .append("isCountDownNum", getIsCountDownNum())
            .append("queCreateTime", getQueCreateTime())
            .append("resCode", getResCode())
            .append("resMessage", getResMessage())
            .append("resMdn", getResMdn())
            .append("resPackageId", getResPackageId())
            .append("status", getStatus())
            .append("countDownNum", getCountDownNum())
            .append("orderTime", getOrderTime())
            .append("validTime", getValidTime())
            .append("unsubscribeTime", getUnsubscribeTime())
            .append("userPackageList", getUserPackageList())
            .toString();
    }
}
