package com.ruoyi.system.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 爱音乐订购对象 emp_subscribe
 * 
 * @author ruoyi
 * @date 2020-05-26
 */
public class EmpSubscribe extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订购id */
    private Long subId;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String mdn;

    /** 套餐id */
    @Excel(name = "套餐id")
    private String packageId;

    /** 验证码 */
    @Excel(name = "验证码")
    private String randomKey;

    /** 节点参数 */
    @Excel(name = "节点参数")
    private String subColumn;

    /** 订购时间 */
    @Excel(name = "订购时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date subCreateTime;

    /** 执行结果 */
    @Excel(name = "执行结果")
    private String resCode;

    /** 结果描述 */
    @Excel(name = "结果描述")
    private String resMessage;

    /** 返回时间 */
    @Excel(name = "返回时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date resCreateTime;

    public void setSubId(Long subId) 
    {
        this.subId = subId;
    }

    public Long getSubId() 
    {
        return subId;
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
    public void setRandomKey(String randomKey) 
    {
        this.randomKey = randomKey;
    }

    public String getRandomKey() 
    {
        return randomKey;
    }
    public void setSubColumn(String subColumn) 
    {
        this.subColumn = subColumn;
    }

    public String getSubColumn() 
    {
        return subColumn;
    }
    public void setSubCreateTime(Date subCreateTime) 
    {
        this.subCreateTime = subCreateTime;
    }

    public Date getSubCreateTime() 
    {
        return subCreateTime;
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
    public void setResCreateTime(Date resCreateTime) 
    {
        this.resCreateTime = resCreateTime;
    }

    public Date getResCreateTime() 
    {
        return resCreateTime;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("subId", getSubId())
            .append("mdn", getMdn())
            .append("packageId", getPackageId())
            .append("randomKey", getRandomKey())
            .append("subColumn", getSubColumn())
            .append("subCreateTime", getSubCreateTime())
            .append("resCode", getResCode())
            .append("resMessage", getResMessage())
            .append("resCreateTime", getResCreateTime())
            .toString();
    }
}
