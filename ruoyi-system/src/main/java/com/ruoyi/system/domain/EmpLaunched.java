package com.ruoyi.system.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 爱音乐发起订购对象 emp_launched
 * 
 * @author ruoyi
 * @date 2020-05-26
 */
public class EmpLaunched extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 发起订购id */
    private Long lauId;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String mdn;

    /** 套餐id */
    @Excel(name = "套餐id")
    private String packageId;

    /** 节点参数 */
    @Excel(name = "节点参数")
    private String lauColumn;

    /** imsi */
    @Excel(name = "imsi")
    private String imsi;

    /** 设备ID */
    @Excel(name = "设备ID")
    private String deviceNo;

    /** 发起订购时间 */
    @Excel(name = "发起订购时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lauCreateTime;

    /** 结果编码 */
    @Excel(name = "结果编码")
    private String resCode;

    /** 结果描述 */
    @Excel(name = "结果描述")
    private String resMessage;

    /** 计费类型 */
    @Excel(name = "计费类型")
    private String feeType;

    /** 接口响应时间 */
    @Excel(name = "接口响应时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date resCreateTime;

    public void setLauId(Long lauId) 
    {
        this.lauId = lauId;
    }

    public Long getLauId() 
    {
        return lauId;
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
    public void setLauColumn(String lauColumn) 
    {
        this.lauColumn = lauColumn;
    }

    public String getLauColumn() 
    {
        return lauColumn;
    }
    public void setImsi(String imsi) 
    {
        this.imsi = imsi;
    }

    public String getImsi() 
    {
        return imsi;
    }
    public void setDeviceNo(String deviceNo) 
    {
        this.deviceNo = deviceNo;
    }

    public String getDeviceNo() 
    {
        return deviceNo;
    }
    public void setLauCreateTime(Date lauCreateTime) 
    {
        this.lauCreateTime = lauCreateTime;
    }

    public Date getLauCreateTime() 
    {
        return lauCreateTime;
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
    public void setFeeType(String feeType) 
    {
        this.feeType = feeType;
    }

    public String getFeeType() 
    {
        return feeType;
    }
    public void setResCreateTime(Date resCreateTime) 
    {
        this.resCreateTime = resCreateTime;
    }

    public Date getResCreateTime() 
    {
        return resCreateTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("lauId", getLauId())
            .append("mdn", getMdn())
            .append("packageId", getPackageId())
            .append("lauColumn", getLauColumn())
            .append("imsi", getImsi())
            .append("deviceNo", getDeviceNo())
            .append("lauCreateTime", getLauCreateTime())
            .append("resCode", getResCode())
            .append("resMessage", getResMessage())
            .append("feeType", getFeeType())
            .append("resCreateTime", getResCreateTime())
            .toString();
    }
}
