package com.ruoyi.system.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 爱音乐退订对象 emp_unsubscribe
 * 
 * @author ruoyi
 * @date 2020-05-27
 */
public class EmpUnsubscribe extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 退订id */
    private Long unsubId;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String mdn;

    /** 套餐id */
    @Excel(name = "套餐id")
    private String packageId;

    /** 结果代码 */
    @Excel(name = "结果代码")
    private String resCode;

    /** 结果描述 */
    @Excel(name = "结果描述")
    private String resMessage;

    /** 退订时间 */
    @Excel(name = "退订时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date unsubCreateTime;

    public void setUnsubId(Long unsubId) 
    {
        this.unsubId = unsubId;
    }

    public Long getUnsubId() 
    {
        return unsubId;
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
    public void setUnsubCreateTime(Date unsubCreateTime) 
    {
        this.unsubCreateTime = unsubCreateTime;
    }

    public Date getUnsubCreateTime() 
    {
        return unsubCreateTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("unsubId", getUnsubId())
            .append("mdn", getMdn())
            .append("packageId", getPackageId())
            .append("resCode", getResCode())
            .append("resMessage", getResMessage())
            .append("unsubCreateTime", getUnsubCreateTime())
            .toString();
    }
}
